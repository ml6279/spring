package cglibproxy;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyInterceptor implements MethodInterceptor {
    private Object target;
    private Transaction transaction;

    public MyInterceptor(Object target, Transaction transaction) {
        this.target = target;
        this.transaction = transaction;
    }

    public Object getTarget() {
        return target;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        this.transaction.beginTransaction();
        method.invoke(this.target, objects);
        this.transaction.commit();
        return null;
    }
}
