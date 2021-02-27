package beans;

public class ScopeBean {
    public ScopeBean() {
        System.out.println("创建ScopeBean对象");
    }

    public void say() {
        System.out.println("我被调用者使用");
    }
}
