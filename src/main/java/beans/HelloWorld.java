package beans;

public class HelloWorld {
    private String name;

    public HelloWorld() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("注入值: " + name);
        this.name = name;
    }
}
