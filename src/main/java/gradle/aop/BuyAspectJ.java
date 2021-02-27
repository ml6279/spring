package gradle.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BuyAspectJ {
    @Before("execution(* gradle.IBuy.buy(..))")
    public void haha() {
        System.out.println("男孩女孩都买自己喜欢的东西");
    }
}
