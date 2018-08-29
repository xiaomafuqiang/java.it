package main;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * simpleDateFormat
 * constructor(pattern): 解析转化模式都是一致
 * */
class SimpleDateFormats {

    // SimpleDateFormat fmt;

    public void decode() throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat();
        Date date = new Date();

        // 默认解析
        String st1 = fmt.format(date);
        System.out.println(st1);

        // 解析
        Date dateFmt = fmt.parse(st1);
        System.out.println(dateFmt);
    }

    public void encode() throws ParseException {
        // 按照制定模式解析显示
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date();

        // 默认解析
        String st1 = fmt.format(date);
        System.out.println(st1);

        // 解析
        Date dateFmt = fmt.parse(st1);
        System.out.println(dateFmt);
    }

}

/*×
* Calendars
* */
class Calendars {

    public void run() {
        Calendar cld = Calendar.getInstance();
        int year = cld.get(Calendar.YEAR);
        int month = cld.get(Calendar.MONTH);
        int day = cld.get(Calendar.DAY_OF_MONTH);
        System.out.println(Calendar.DATE == Calendar.DAY_OF_MONTH);
        cld.set(Calendar.YEAR, 2099);
        System.out.println(cld.get(1));
    }
}

public class Dates {
    public static void main(String[] args) {
        Calendars cds = new Calendars();
        cds.run();
    }
}
