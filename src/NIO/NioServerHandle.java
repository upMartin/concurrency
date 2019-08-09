package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

/**
 * Created by Administrator on 2019/7/26.
 */
public class NioServerHandle implements Runnable{
    private ServerSocketChannel serverSocketChannel;
    private Selector selector;
    private volatile  boolean stop;
    public NioServerHandle(){
        try{
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket()
                    .bind(new InetSocketAddress("127.0.0.1",8989));
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void stop(){
        this.stop = true;
    }

    @Override
    public void run() {
        while (!stop){
            try{
                selector.select(1000);
                Set<SelectionKey> selectedKeys =
                        selector.selectedKeys();
                SelectionKey key = null;

            }catch (IOException e){

            }
        }
    }
}
