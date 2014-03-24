package com.suanla.ziwei;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.suanla.ziwei.lunar.CalendarService;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


/**
 * Created by psuen on 1/30/14.
 */
public class DisplayResult extends Activity {

    // Use Joda Time libraries instead of standard JDK
    DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm");
    DateTime dateTime;

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

        Intent intent = getIntent();
        String date_string = intent.getStringExtra(DateConversionIntent.INTENT_DATE);

        dateTime = dateTimeFormatter.parseDateTime(date_string);

        int yy = dateTime.getYear();
        int mm = dateTime.getMonthOfYear();
        int dd = dateTime.getDayOfMonth();
        int hh = dateTime.getHourOfDay();

        CalendarService calendarService = new CalendarService();
        int lunarYear = calendarService.convertToLunarCalendar(yy, mm, dd).getYear();
        int lunarMonth = calendarService.convertToLunarCalendar(yy, mm, dd).getMonth();
        int lunarDate = calendarService.convertToLunarCalendar(yy, mm, dd).getDate();

        TextView textView = new TextView(this);

        textView.setText("中國時間： 農曆" + lunarYear + calendarService.cyclicalm(lunarYear) + "年" +
                calendarService.getChineseMonth(lunarMonth) + "月" +
                calendarService.getChineseDayString(lunarDate) + "日" +
                calendarService.convertToChineseTime(hh) + "時");
        setContentView(textView);
    }
}
