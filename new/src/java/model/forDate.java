/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author Suttida Sat
 */
public class forDate {
    
    int year;
    int month;
    private String Str_month;
    String month_chk;
    int day;
    String str_date;
        String str_day;
    

    public forDate() {
    }
    


    public int getYear() {
        return year;
    }

    public void setYear() {
        Calendar now = Calendar.getInstance();
        
        this.year = now.get(Calendar.YEAR)-543;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth() {
        Calendar now = Calendar.getInstance();
        
        this.month = now.get(Calendar.MONTH) + 1;
    }

    public int getDay() {
        return day;
    }

    public void setDay() {
        Calendar now = Calendar.getInstance();
        this.day = now.get(Calendar.DATE);
    }



     

    public String getStr_monthForbill() {
        return Str_month;
    }

    public void setStr_monthForbill(int int_m) {
        String[] month_lst ={"January", "February", "March", "April"
             , "May" , "June" ,"July" ,"August" ,"September" , "October" ,"November" , "December"};
        
        this.Str_month =   month_lst[int_m - 2] ;
    }
    
    
        public void setStr_monthForComp() {
        String[] month_lst ={"01", "02", "03", "04"
             , "05" , "06" ,"07" ,"08" ,"09" , "10" ,"11" , "12"};
        
        this.Str_month =   month_lst[month-1];
    }

                public void setStr_dayForComp() {
                    if(day < 10){
                                String[] day_lst ={"01", "02", "03", "04", "05" , "06" ,"07" ,"08" ,"09"};
                                this.str_day = day_lst[day];
                    }

    }
    public String getStr_date() {
        return str_date;
    }

    public void setStr_date( ) {

        this.str_date = year+"-"+Str_month+"-"+day;
    }

    public String getMonth_chk() {
        return month_chk;
    }

    public void setMonth_chk(String month_chk) {
        this.month_chk = month_chk;
    }

    public String getStr_day() {
        return str_day;
    }

    public void setStr_day(String str_day) {
        this.str_day = str_day;
    }

    public String getStr_month() {
        return Str_month;
    }

    public void setStr_month(String Str_month) {
        this.Str_month = Str_month;
    }

    
}
