package cglibproxy;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;

public class TestCglibProxy {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        Transaction transaction = new Transaction();
        MyInterceptor myInterceptor = new MyInterceptor(personDao, transaction);
        TestCglibProxy test = new TestCglibProxy();
        PersonDao proxy = (PersonDao) test.createProxy(myInterceptor, personDao);
        proxy.savePerson();
    }

    //创建动态代理对象的写法
    public Object createProxy(Callback callback, Object target) {
        Enhancer en = new Enhancer();
        en.setCallback(callback);
        en.setSuperclass(target.getClass());
        return en.create();
    }
}
