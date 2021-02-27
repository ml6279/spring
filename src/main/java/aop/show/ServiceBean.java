package aop.show;

public class ServiceBean implements Say {
    @Override
    public void say() {
        System.out.println("我是核心业务");
    }

    @Override
    public void other() {
        System.out.println("我是核心业务的其它方法");
    }
}
