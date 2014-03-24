package com.suanla.ziwei.lunar;

/**
 * Created by psuen on 3/22/14.
 */
import com.google.common.base.Objects;

public class LunarCalendar
{
    private int year;

    private int month;

    private int date;

    public LunarCalendar()
    {
    }

    public LunarCalendar(int year, int month, int date)
    {
        this.year = year;
        this.month = month;
        this.date = date;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getMonth()
    {
        return month;
    }

    public void setMonth(int month)
    {
        this.month = month;
    }

    public int getDate()
    {
        return date;
    }

    public void setDate(int date)
    {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return Objects.toStringHelper(this).add("Year", year).add("Month", month).add("Date", date).toString();
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(year, month, date);
    }

    @Override
    public boolean equals(final Object obj)
    {
        boolean result = false;
        if (obj != null && obj instanceof LunarCalendar)
        {
            LunarCalendar other = (LunarCalendar) obj;
            result = Objects.equal(this.year, other.year) && Objects.equal(this.month, other.month) && Objects.equal(this.date, other.date);
        }
        return result;
    }
}
