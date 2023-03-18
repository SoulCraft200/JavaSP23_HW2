import java.time.LocalDate;

import java.time.DayOfWeek;

public class SaleDate {
    private int year;
    private int month;
    private int day;

    private LocalDate date;

    public SaleDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        date = LocalDate.of(year, month, day);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public DayOfWeek dayOfWeek() {
        return date.getDayOfWeek();
    }

    public static String getMonthName(int num) {
        String name = switch (num) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "Invalid number of month";
        };
        return name;
    }
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}
