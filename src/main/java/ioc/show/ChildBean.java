package ioc.show;

public class ChildBean {
    private FatherBean father;

    public ChildBean(FatherBean father) {
        this.father = father;
        System.out.println("创建childBean");
    }

    public void say() {
        System.out.println("我是儿子！！！，一定好好学java");
    }
}
