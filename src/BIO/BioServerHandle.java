package BIO;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Administrator on 2019/7/26.
 */
public class BioServerHandle implements Runnable{
    private Socket socket;

    public BioServerHandle(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        PrintWriter pw = null;
        try{
            br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            pw = new PrintWriter(this.socket.getOutputStream(),true);
            while (true){
                String body = br.readLine();
                if(body==null){
                    break;
                }
                System.out.println("the order is"+body);
                String currentTime =
                        "陈玉凯".equals(body)? new Date(System.currentTimeMillis()).toString():"No Query";
                pw.println(currentTime);
            }
        }catch (IOException e){
            try {
                br.close();
                pw.close();
                socket.close();
            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }
}
