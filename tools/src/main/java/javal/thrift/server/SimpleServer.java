package javal.thrift.server;

public class SimpleServer {
    public static void main(String[] args) {
        Thread thread = new Thread(new RpcServer());
        thread.start();
        try {
            Thread.sleep(3600000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
