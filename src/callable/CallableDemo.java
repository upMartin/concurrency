package callable;

import concurrency.LiftOff;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Administrator on 2019/7/26.
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i=0;i<10;i++)
            results.add(exec.submit(new TaskWithResult(i)));
        for (Future<String> fs : results){
            try{
                System.out.println(fs.get());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                exec.shutdown();
            }
        }
    }
}
