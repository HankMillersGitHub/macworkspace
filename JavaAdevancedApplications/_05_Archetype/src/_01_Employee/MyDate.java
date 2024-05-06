package _01_Employee;

// 定义MyDate类
public class MyDate {
    private int year;
    private int month;
    private int day;

    // 构造函数
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // getter和setter方法
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

    // 重写toString方法
    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}