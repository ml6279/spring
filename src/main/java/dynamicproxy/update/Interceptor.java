package dynamicproxy.update;

public interface Interceptor {

    public void before();   //执行前做什么事情

    public void after();    //执行后做什么事情
}
