import beans.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCar {
    public static void main(String[] args) {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*Car car = ctx.getBean("car",Car.class);
        System.out.println(car);*/

        /*Car car1 = ctx.getBean("car2",Car.class);
        System.out.println(car1);*/

        /*Person person = ctx.getBean("person",Person.class);
        System.out.println(person);*/

        /*Person person = ctx.getBean("person2",Person.class);
        System.out.println(person);*/

        /*Person person = ctx.getBean("person6",Person.class);
        System.out.println(person);*/

        /*ScopeBean scopeBean = ctx.getBean("scopeBean",ScopeBean.class);
        ScopeBean scopeBean1 = ctx.getBean("scopeBean",ScopeBean.class);
        System.out.println(scopeBean);
        System.out.println(scopeBean1);*/

        //ScopeBean scopeBean = ctx.getBean("scopeBean1",ScopeBean.class);
        //ScopeBean scopeBean1 = ctx.getBean("scopeBean1",ScopeBean.class);

        //Other

        /*ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Other other = (Other) ctx.getBean("other");
        ctx.close();
*/

        testThree();


    }

    public static void testThree() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller controller = ctx.getBean("threeController", Controller.class);
        controller.controller();
    }


}
