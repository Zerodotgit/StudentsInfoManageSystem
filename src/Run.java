public class Run {
    public static void main(String[] args) {
        //创建必要对象
        MainSystem mainSystem = new MainSystem();

        System.out.println("系统启动中..."); //日志输出
        mainSystem.start();
    }
}
