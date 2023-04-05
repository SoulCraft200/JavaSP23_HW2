import java.time.LocalDate;

import java.time.DayOfWeek;

/**
 * The type Sale date.
 */
public class SaleDate extends Object{
    private int year;
    private int month;
    private int day;

    private LocalDate date;

    /**
     * Instantiates a new Sale date.
     *
     * @param year  the year
     * @param month the month
     * @param day   the day
     */
    public SaleDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        date = LocalDate.of(year, month, day);
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Gets month.
     *
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Gets day.
     *
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * Sets year.
     *
     * @param year the year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Sets month.
     *
     * @param month the month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Sets day.
     *
     * @param day the day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * Day of week day of week.
     *
     * @return the day of week
     */
    public DayOfWeek dayOfWeek() {
        return date.getDayOfWeek();
    }

    /**
     * Gets month name.
     *
     * @param num the num
     * @return the month name
     */
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
