package callable;

import java.util.concurrent.Callable;

/**
 * Created by Administrator on 2019/7/26.
 */
public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult"+id;
    }
}
