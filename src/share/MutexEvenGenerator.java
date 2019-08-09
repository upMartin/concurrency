package share;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2019/7/29.
 */
public class MutexEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    private Lock lock = new ReentrantLock();
    @Override
    public int next() {
       try {
           lock.lock();
           ++currentEvenValue;
           Thread.yield();
           ++currentEvenValue;
           return currentEvenValue;
       }finally {
           lock.unlock();
       }
    }

    public static void main(String[] args) {
        EventChecker.test(new MutexEvenGenerator());
    }
}
