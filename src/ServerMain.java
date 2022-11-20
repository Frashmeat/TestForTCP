import com.LJK.Server.Server_TCP;

public class ServerMain {
    public static void main(String[] args) {
        System.out.println("Hello");

        new Server_TCP().thread.start();
        //客服生成和链接


    }
}