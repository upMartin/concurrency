package daemon;

import java.util.concurrent.ThreadFactory;

/**
 * Created by Administrator on 2019/7/26.
 */
public class DaemonThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        return t;
    }
}
