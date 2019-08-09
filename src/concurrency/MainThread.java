package concurrency;

/**
 * Created by Administrator on 2019/7/26.
 */
public class MainThread {
    public static void main(String[] args) {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }

}
