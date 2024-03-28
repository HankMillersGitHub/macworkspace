/**
 * @program: macWorkSpace
 * @ClassName MyDate
 * @description:
 * @author: HankMiller
 * @create: 2024-03-20 21:22
 * @Version 1.0
 **/
public class MyDate
{
private int year;
private int month;
private int day;

    public MyDate() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public String toDateString(){
        return year + "年" + month + "月" + day + "日";
    }
}
