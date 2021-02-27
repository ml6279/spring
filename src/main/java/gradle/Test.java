package gradle;

import gradle.ioc.AppConfig;
import gradle.ioc.Boy;
import gradle.ioc.Girl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Boy boy = context.getBean("boy", Boy.class);
        Girl girl = (Girl) context.getBean("girl");
        boy.buy();
        girl.buy();

    }
}
