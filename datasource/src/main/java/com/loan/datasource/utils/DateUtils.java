package com.loan.datasource.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shuttle on 6/8/17.
 */
public class DateUtils {

    public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date getSimpleDateFormater(String date){
        try {
            return SDF.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getCurrentSystem(){
        return SDF.format(new Date());
    }

    public static Timestamp formatToTimeStamp(String date){
        return new Timestamp(getSimpleDateFormater(date).getTime());
    }

    public static Date formatToDate(Timestamp timestamp){
        Date date = new Date(timestamp.getTime());
        return date;
    }

}
