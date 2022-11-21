import com.lk.TCP.Client.Client_TCP;

import java.io.IOException;
import java.net.InetAddress;

public class ClientMain {
    public static void main(String[] args) throws IOException {
       Client_TCP ct = new Client_TCP(InetAddress.getLocalHost().getHostAddress(),8666);
       ct.Connect();
    }
}
