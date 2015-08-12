package ericqtran.whatstheday;

/**
 * Created by Eric on 8/11/2015.
 */
public class Date
{

    private int day;
    private int month;
    private int year;

    public Date(int theDay, int theMonth, int theYear)
    {
        this.day = theDay;
        this.month = theMonth;
        this.year = theYear;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
