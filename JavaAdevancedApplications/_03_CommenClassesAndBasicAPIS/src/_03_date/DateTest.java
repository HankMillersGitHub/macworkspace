package _03_date;

import sun.util.BuddhistCalendar;
import sun.util.resources.LocaleData;

import java.awt.dnd.DropTarget;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAccessor;
import java.util.*;

public class DateTest {
    public static void main(String[] args) {
        /*
        * 使用Calendar获取当前时间，把这个时间设置为你自己的生日，并计算你的百日宴日期
        * */
        Calendar now = Calendar.getInstance();
        Date birthday = now.getTime();
        now.add(Calendar.DAY_OF_YEAR,100);
        Date b100 = now.getTime();
        System.out.println(b100 + "-----" + birthday);

        /*
        * 使用LocalDateTime获取当前时间，把这个时间设置为你的生日，并计算你的百日宴日期
        * */
        LocalDateTime birthday1 = LocalDateTime.now();
        LocalDateTime b1001 = LocalDateTime.now();
        System.out.println(birthday1);
        b1001 = birthday1.plusDays(100);
        System.out.println(b1001);
    }
}
