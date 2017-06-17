package com.loan.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by shuttle on 6/8/17.
 */
public class DateUtils {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date getSimpleDateFormater(String date){
        try {
            return DATE_FORMAT.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String formatDateToString(Date date){
        return DATE_FORMAT.format(date);
    }

    public static String formatDateToString(Timestamp timestamp){
        Date date = new Date(timestamp.getTime());
        return DATE_FORMAT.format(date);
    }

    public static Timestamp formatToTimeStamp(Date date){
        return new Timestamp(date.getTime());
    }

    public static Timestamp formatToTimeStamp(String date){
        return new Timestamp(getSimpleDateFormater(date).getTime());
    }

    public static String formatTimeStampToString(Timestamp timestamp){
        return DATE_FORMAT.format(new Date(timestamp.getTime()));
    }

    public static Timestamp getCurrentTimeStamp(){
        return new Timestamp(new Date().getTime());
    }

    public static String getCurrentTimeString(){
        return DATE_FORMAT.format(new Date());
    }


    public static Date formatToDate(Timestamp timestamp){
        Date date = new Date(timestamp.getTime());
        return date;
    }

}
