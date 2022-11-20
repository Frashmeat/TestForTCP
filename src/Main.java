import com.LJK.Server.Server_TCP;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        new Server_TCP().thread.start();

    }
}