package net.htmlonline.bean.utils;


import org.apache.commons.beanutils.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static net.htmlonline.util.Utils.print;

public class DateConvert implements Converter {
    @Override
    // string (1890-10-10) to Date class
    public <T> T convert(Class<T> aClass, Object BeanValue) {
        String string = (String) BeanValue; // bean 字段为 T class 时候 会调用此方法
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = format.parse(string);
//            return aClass.cast(date);
            return ((T) date);

        } catch (ParseException e) {
            e.printStackTrace();
            print(e.getMessage());

        }
        return null;
    }
}
