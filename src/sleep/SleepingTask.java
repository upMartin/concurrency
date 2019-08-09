package sleep;

import concurrency.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/7/26.
 */
public class SleepingTask extends LiftOff{
    public void run(){
        try{
            while(countDown-- > 0){
                System.out.println(status());
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }catch (InterruptedException e){
            System.err.println("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++)
            exec.execute(new SleepingTask());
        exec.shutdown();
    }
}
