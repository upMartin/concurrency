package concurrency;

/**
 * Created by Administrator on 2019/7/26.
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for(int i=0; i<5; i++){
            Thread t = new Thread(new LiftOff());
            t.start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
