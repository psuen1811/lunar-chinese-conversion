package com.suanla.ziwei.ziwei;

import org.joda.time.DateTime;

import java.util.ArrayList;

/**
 * Created by psuen on 3/24/14.
 */
public class ZiweiService {
    private Palaces palaces;
    private DateTime birthdate;
    private DateTime lunarBirthdate;
    private int year, month, day, hour;
    private String sex;
    private String element; //
    private String boardStyles;
    private int yearsOld;

    public Palaces getPalaces() {
        return palaces;
    }

    public void setPalaces(Palaces palaces) {
        this.palaces = palaces;
    }

    public DateTime getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(DateTime birthdate) {
        this.birthdate = birthdate;
    }

    public DateTime getLunarBirthdate() {
        return lunarBirthdate;
    }

    public void setLunarBirthdate(DateTime lunarBirthdate) {
        this.lunarBirthdate = lunarBirthdate;
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

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getBoardStyles() {
        return boardStyles;
    }

    public void setBoardStyles(String boardStyles) {
        this.boardStyles = boardStyles;
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }
}
