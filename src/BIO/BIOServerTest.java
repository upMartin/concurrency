package BIO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2019/7/26.
 */
public class BIOServerTest {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(8888);
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("接受到来自外星的信号");
                new Thread(new BioServerHandle(socket)).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
