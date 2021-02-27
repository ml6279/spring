package aopdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

//切面
public class ServiceLogger {
    public void before(JoinPoint jp) {
        System.out.println("前置增加被执行");
        System.out.println("连接点对象: " + jp.getTarget().getClass().getName());
        System.out.println("连接点方法为: " + jp.getStaticPart());
        System.out.println("连接点方法参数: ");
        Object[] arr = jp.getArgs();
        for (Object o : arr) {
            System.out.println("参数: " + o);
        }
        System.out.println("前置增强结束");
    }

    public void after(JoinPoint jp) {
        System.out.println("后置增强最终被执行");
        System.out.println("后置增强最终结束");
    }

    public void afterReturn(Object ret) {
        System.out.println("后置增强被执行");
        System.out.println("后置增强返回值: " + ret);
    }

    public void afterThrow(Exception ex) {
        System.out.println("后置增强被执行,业务方法抛出异常");
        System.out.println("后置异常增强被执行: " + ex);
    }

    public boolean around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕通知: 目标方法执行前织入代码");
        boolean b = (boolean) pjp.proceed(pjp.getArgs());//核心业务代码
        System.out.println("环绕通知: 目标方法执行后织入代码");
        return b;
    }
}
