import annspring.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void testDao() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Dao dao = ctx.getBean("dao", Dao.class); //"dao":就是Dao的类名,名字小写
        dao.commit();
    }

    public static void testService() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Service service = ctx.getBean("service", Service.class);
        service.service();
    }

    public static void testControllerImpl() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
        ControllerImpl controller = ctx.getBean("controller", ControllerImpl.class);
        controller.web();
    }

    public static void testControllerImpl1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
        ControllerImpl1 controller1 = ctx.getBean("controllerImpl1", ControllerImpl1.class);
        controller1.web();
    }

    public static void testControllerLazy() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
        // ControllerLazy lazy = ctx.getBean("controllerLazy",ControllerLazy.class);
        //   lazy.web();
    }

    public static void testOther() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
        Other other = ctx.getBean("other", Other.class);

    }

    public static void testStaticDemo() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext1.xml");
        StaticDemo other = ctx.getBean("staticDemo", StaticDemo.class);
        other.test();
    }

    public static void main(String[] args) {
        //testDao();
        //testService();
        //testControllerImpl();
        //testControllerImpl1();
        //testControllerLazy();
        //testOther();
        testStaticDemo();

    }
}
