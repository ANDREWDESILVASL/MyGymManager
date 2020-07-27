public class Date {
    //Fields of Date Class
    private int day;
    private int month;
    private int year;

    //Methods of Date Class - Setter
    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //Methods of Date Class - Getter

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public Date(int c_day, int c_month, int c_year){
        day = c_day;
        month = c_month;
        year = c_year;
    }
}
