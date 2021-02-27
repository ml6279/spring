package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class JDKProxyTest {
    public static void main(String[] args) {
        JDKProxyTest jdk = new JDKProxyTest();
        PersonDao personDao = new PersonDaoImpl();
        Transaction transaction = new Transaction();
        MyInterceptor myInterceptor = new MyInterceptor(personDao, transaction);
        //产生代理对象
        PersonDao proxy = (PersonDao) jdk.getInstance(myInterceptor.getTarget(), myInterceptor);
        proxy.savePerson();
        proxy.updatePerson();
        System.out.println(proxy.getClass().getName());

    }

    public Object getInstance(Object target, InvocationHandler h) {//h:MyInterceptor
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), h);
    }
}
