package aop.show;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.*;

/**
 * 演示spring aop 实现过程
 */
public class AopShow implements java.lang.reflect.InvocationHandler {
    private static List<AopShow.NodeStruct> nodeStructs = new ArrayList<>();

    private static AopStruct aop;

    private static Map<String, Object> ioc = new HashMap<>();
    private static Map<String, Object> aopioc = new HashMap<>();

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

    public static void readNodes(Document doc) {
        Element root = doc.getRootElement();
        for (Iterator i = root.elementIterator("bean"); i.hasNext(); ) {
            Element el = (Element) i.next();
            AopShow.NodeStruct node = new AopShow.NodeStruct();
            node.className = el.attribute("class").getValue();
            node.id = el.attribute("id").getValue();
            nodeStructs.add(node);
        }
        for (Iterator i = root.elementIterator("aop"); i.hasNext(); ) {
            Element el = (Element) i.next();
            AopShow.AopStruct node = new AopShow.AopStruct();
            Element pointcutEl = el.element("pointcut");
            node.pointcut = new AopShow.Pointcut();
            node.pointcut.expression = pointcutEl.attributeValue("expression");
            node.pointcut.id = pointcutEl.attributeValue("id");
            Element aspectEl = el.element("aspect");
            node.aspect = new AopShow.Aspect();
            node.aspect.id = aspectEl.attributeValue("id");
            node.aspect.ref = aspectEl.attributeValue("ref");
            Element beforeEl = aspectEl.element("before");
            node.aspect.position = new AopShow.Position();
            node.aspect.position.method = beforeEl.attributeValue("method");
            node.aspect.position.pointcutRef = beforeEl.attributeValue("pointcut-ref");
            aop = node;
        }
    }

    public static Object createObject(String className) {
        try {
            return Class.forName(className).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void createBean() {
        NodeStruct service = nodeStructs.get(0);
        Object serviceObj = createObject(service.className);
        ioc.put(service.id, serviceObj);
        NodeStruct log = nodeStructs.get(1);
        Object logObj = createObject(log.className);
        ioc.put(log.id, logObj);
        proxy();
    }

    private static void proxy() {
        AopShow aopShow = new AopShow();
        Object proxy = Proxy.newProxyInstance(ioc.get("service").getClass().getClassLoader(),
                ioc.get("service").getClass().getInterfaces(), aopShow);
        aopioc.put("service", proxy);
    }

    public static Object getBean(String beanName) {
        if (aopioc.containsKey(beanName)) return aopioc.get(beanName);
        return ioc.get(beanName);
    }

    public static void main(String[] args) {
        readNodes(AopShow.load("aopshow.xml"));
        createBean();

        Say say = (Say) getBean("service");
        say.say();
        say.other();

        Say say1 = (Say) getBean("service");
        say1.say();
        say1.other();

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals(aop.pointcut.expression)) {
            if (aop.aspect.position.pointcutRef.equals(aop.pointcut.id)) {
                Method m = ioc.get(aop.aspect.ref).getClass().getDeclaredMethod(aop.aspect.position.method, null);
                m.invoke(ioc.get(aop.aspect.ref), null);
            }
        }
        method.invoke(ioc.get("service"), null);
        return null;
    }

    static class NodeStruct {   //节点
        String id;
        String className;
    }

    static class Pointcut {     //切点
        String expression;
        String id;
    }

    static class Aspect {   //切面
        String ref;
        String id;
        Position position;
    }

    static class Position {     //
        String method;
        String pointcutRef;
    }

    static class AopStruct {    //
        Pointcut pointcut;
        Aspect aspect;
    }
}
