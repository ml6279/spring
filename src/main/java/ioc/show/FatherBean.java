package ioc.show;

public class FatherBean {
    private int age;

    public FatherBean() {
        System.out.println("创建fatherBean");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void say() {
        System.out.println("我是爹！！！" + this.age + "岁，养你不容易");
    }
}
