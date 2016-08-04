package com.lyashuk.helper;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by User on 27.07.2016.
 */
public class TimeCreator {
    public static String getTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String minutes = Integer.toString(calendar.get(Calendar.MINUTE));
        String seconds = Integer.toString(calendar.get(Calendar.SECOND));
        return minutes + ":" + seconds;
    }
}
