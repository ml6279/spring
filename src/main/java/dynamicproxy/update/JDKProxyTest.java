package dynamicproxy.update;

import dynamicproxy.PersonDao;
import dynamicproxy.PersonDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class JDKProxyTest {
    public static void main(String[] args) {
        Transaction transaction = new Transaction();
        Logger log = new Logger();
        List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(transaction);
        interceptors.add(log);
        MyInterceptor myInterceptor = new MyInterceptor();
        myInterceptor.setInterceptors(interceptors);
        PersonDao personDao = new PersonDaoImpl();
        myInterceptor.setTarget(personDao);
        JDKProxyTest jdk = new JDKProxyTest();
        PersonDao proxy = (PersonDao) jdk.getInstance(myInterceptor.getTarget(), myInterceptor);
        proxy.updatePerson();
    }

    public Object getInstance(Object target, InvocationHandler h) {  //h:MyInterceptor
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), h);
    }
}
