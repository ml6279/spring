package dynamicproxy.update;

public class Logger implements Interceptor {
    @Override
    public void before() {
        System.out.println("开始输出日志......");
    }

    @Override
    public void after() {
        System.out.println("日志输出结束......");
    }
}
