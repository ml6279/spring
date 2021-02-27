package staticproxy;

public class TestStaticproxy {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDaoImpl();
        Transaction transaction = new Transaction();
        PersonDaoProxy personDaoProxy = new PersonDaoProxy(personDao, transaction);
        personDaoProxy.savePerson();
    }
}
