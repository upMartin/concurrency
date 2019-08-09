package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2019/7/26.
 */
public class CachedThreadPool {
    public static void main(String[] args) {
       /* ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++)
            exec.execute(new LiftOff());
        System.out.println("Waiting for LiftOff");
        exec.shutdown();*/
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
