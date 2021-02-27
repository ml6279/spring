package ioc.show;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class IocShow {
    private static List<NodeStruct> nodeStructs = new ArrayList<>();
    private static Map<String, Object> ioc = new HashMap<>();

    private static URL getURL(String filename) {
        return ClassLoader.getSystemClassLoader().getResource(filename);
    }

    public static Document load(String filename) {
        Document document = null;
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(getURL(filename)); // 读取XML文件,获得document对象
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return document;
    }

    public static void readNodes(Document doc, String beanId) {
        Element root = doc.getRootElement();
        for (Iterator i = root.elementIterator("bean"); i.hasNext(); ) {
            Element el = (Element) i.next();
            NodeStruct node = new NodeStruct();
            node.className = el.attribute("class").getValue();
            node.id = el.attribute("id").getValue();
            for (Iterator j = el.elementIterator(); j.hasNext(); ) {
                Element elj = (Element) j.next();
                if (elj.getQName().getName().equals("constructor-arg")) {
                    node.constructorArg = new ConstructorArgStruct();
                    node.constructorArg.ref = elj.attribute("ref").getValue();
                }
                if (elj.getQName().getName().equals("property")) {
                    node.property = new PropertyStruct();
                    node.property.name = elj.attribute("name").getValue();
                    node.property.value = elj.attribute("value").getValue();
                }
            }
            nodeStructs.add(node);
        }
    }

    public static Object createObject(String className) {//使用无参构造方法建立对象
        try {
            return Class.forName(className).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Object createObject(String className, Object ref) {//使用一个参数构造方法建立对象
        try {
            Class clz = Class.forName(className);
            return clz.getConstructor(ref.getClass()).newInstance(ref);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void executeSetter(Object obj, NodeStruct node) {//执行set方法
        String name = node.property.name.substring(0, 1).toUpperCase() +
                node.property.name.substring(1);
        try {
            Method m = obj.getClass().getDeclaredMethod("set" + name, int.class);
            m.invoke(obj, Integer.parseInt(node.property.value));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createBean() {//创建javaBean
        NodeStruct father = nodeStructs.get(1);
        Object fatherObj = createObject(father.className);
        executeSetter(fatherObj, father);
        ioc.put(father.id, fatherObj);
        NodeStruct child = nodeStructs.get(0);
        Object childObj = createObject(child.className, fatherObj);
        ioc.put(child.id, childObj);
    }

    public static Object getBean(String name) {
        return ioc.get(name);
    }

    public static <T> T getBean(String name, Class<?> clz) {
        return (T) ioc.get(name);
    }

    public static void main(String[] args) {
        readNodes(IocShow.load("iocshow.xml"), "child");
        createBean();
        FatherBean fatherBean = (FatherBean) getBean("father");
        fatherBean.say();
        ChildBean childBean = getBean("child", ChildBean.class);
        childBean.say();
    }

    static class ConstructorArgStruct {
        String ref;
    }

    static class PropertyStruct {
        String name;
        String value;
    }

    static class NodeStruct {
        String id;
        String className;
        ConstructorArgStruct constructorArg;
        PropertyStruct property;
    }
}
