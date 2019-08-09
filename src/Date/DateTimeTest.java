package Date;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;


/**
 * Created by Administrator on 2019/8/1.
 */
public class DateTimeTest {
    public static void main(String[] args) {
        // Java 8
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear());
        System.out.println(dt.getMonthValue());     // 1 - 12
        System.out.println(dt.getDayOfMonth());
        System.out.println(dt.getHour());
        System.out.println(dt.getMinute());
        System.out.println(dt.getSecond());
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println(format.format(date));
    }
}
