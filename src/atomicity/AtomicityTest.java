package atomicity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2019/7/29.
 */
public class AtomicityTest implements Runnable{
    private int i=0;
    public int getValue(){
        return i;
    }
    public synchronized void evenIncrement(){
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true){
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while(true){
            int val = new AtomicityTest().getValue();
            if(val%2!=0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
