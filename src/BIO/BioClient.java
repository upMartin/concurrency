package BIO;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2019/7/26.
 */
public class BioClient {
    public static void main(String[] args) {
        BufferedReader br=null;
        PrintWriter pw=null;
        try{
            Socket socket = new Socket("127.0.0.1",8888);
            br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream(),true);
            pw.println("陈玉凯");
            System.out.println("发送一个陈玉凯过去");
            String result = br.readLine();
            System.out.println(result);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
