package ericqtran.whatstheday;

/**
 * Created by Eric on 8/11/2015.
 */
public class Date
{

    private String day;
    private String month;
    private String year;
    public static final int[] daysOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};

    public Date(String theDay, String theMonth, String theYear)
    {
        this.day = theDay;
        this.month = theMonth;
        this.year = theYear;
    }

    public Date()
    {

    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Date parseDate(String input)
    {

        String[] tokens = input.split("/");
        String theMonth = tokens[0];
        String theDay = tokens[1];
        String theYear = tokens[2];

        Date result = new Date(theDay, theMonth, theYear);

        return result;
    }

    public static boolean isLeapYear(int theYear)
    {
        boolean result;
        if(theYear % 4 != 0)
        {
            result = false;
        }
        else if (theYear % 100 !=0)
        {
            result = true;
        }
        else if (theYear % 400 != 0)
        {
            result = false;
        }
        else result = true;
        return result;
    }

    public int dayOfTheWeekCalc(Date theDate)
    {
        int day = Integer.parseInt(theDate.getDay());
        int month = Integer.parseInt(theDate.getMonth());
        int year = Integer.parseInt(theDate.getYear());
        int result;
        int yearsSince = year - 1900;

        result = (yearsSince *365) + (yearsSince/4);


        if(isLeapYear(year) == true && month < 3)
        {
            result = result - 1;
        }

        for(int i = 1; i < month; i++)
        {
            result = result + daysOfMonth[i-1];
        }
        result = result + day;
        result = result % 7;

        return result;
    }
}
