package aopdemo.aopannotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("AnnotationAop")
@Aspect
public class AnnotationAop {
    @Pointcut(value = "execution(public * aopdemo.service.*.*(..))")
    private void pointcut() {

    }

    @Before(value = "pointcut()")
    public void before(JoinPoint jp) {
        System.out.println("注解方式配置前置型通知");
    }
}
