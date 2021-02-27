import beans.collection.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Testcollection {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //List
        /*Person person = ctx.getBean("person3",Person.class);
        System.out.println(person);*/

        //Map
        /*NewPerson newPerson = ctx.getBean("NewPerson",NewPerson.class);
        System.out.println(newPerson);*/

        /*DataSource dataSource = ctx.getBean("dataSource",DataSource.class);
        System.out.println(dataSource);*/

        /*beans.Person person = ctx.getBean("person5", Person.class);
        System.out.println(person);*/

        /*Person person = ctx.getBean("person6",Person.class);
        System.out.println(person);*/

        Person person = ctx.getBean("person7", Person.class);
        System.out.println(person);
    }
}
