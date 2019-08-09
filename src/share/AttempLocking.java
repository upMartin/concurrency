package share;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2019/7/29.
 */
public class AttempLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed(){
        boolean captured = lock.tryLock();
        try{
            System.out.println("tryLock():"+captured);
        }finally {
            if(captured){
                lock.unlock();
            }
        }
    }

    public void timed(){
        boolean captured = false;
        try{
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        }catch (Exception e){
            throw new RuntimeException();
        }

        try{
            System.out.println("tryLock(2,TimeUnit.SECONDS):"+captured);
        }finally {
            if(captured){
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttempLocking al = new AttempLocking();
        al.untimed();
        al.timed();
        Thread.yield();
        new Thread(){
            {
                setDaemon(true);
            }
            @Override
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        al.untimed();
        al.timed();
    }

}
