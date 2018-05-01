/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author asus
 */
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExample {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private String due_date;
    private String next_date;
    private String now;
    private String end_date;
    private Date renew_e_date;
    private Date now_date;
    private Connection conn;

    public DateExample() {
       
    }

    public void bookDate() {
        Date currentDate = new Date();
        //due_date = dateFormat.format(currentDate);

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        // manipulate date
//        c.add(Calendar.YEAR, 1);
//        c.add(Calendar.MONTH, 1);
        c.add(Calendar.YEAR, -543);
                due_date = dateFormat.format(c.getTime());
        c.add(Calendar.DATE, 3);
        //same with c.add(Calendar.DAY_OF_MONTH, 1);

//        c.add(Calendar.HOUR, 1);
//        c.add(Calendar.MINUTE, 1);
//        c.add(Calendar.SECOND, 1);

        // convert calendar to date
        Date currentDatePlusOne = c.getTime();


//        System.out.println(dateFormat.format(currentDatePlusOne));
        next_date = dateFormat.format(currentDatePlusOne);
    }
    
    public void rentDate(){
               Date currentDate = new Date();
        //due_date = dateFormat.format(currentDate);

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        // manipulate date
//        c.add(Calendar.YEAR, 1);
//        c.add(Calendar.MONTH, 1);
        c.add(Calendar.YEAR, -543);
                due_date = dateFormat.format(c.getTime());
        // manipulate date
//        c.add(Calendar.YEAR, 1);

        c.add(Calendar.MONTH, 1);
//        c.add(Calendar.DATE, 1); //same with c.add(Calendar.DAY_OF_MONTH, 1);
//        c.add(Calendar.HOUR, 1);
//        c.add(Calendar.MINUTE, 1);
//        c.add(Calendar.SECOND, 1);

        // convert calendar to date
        Date currentDatePlusOne = c.getTime();

//        System.out.println(dateFormat.format(currentDatePlusOne));
        next_date = dateFormat.format(currentDatePlusOne);
    }

    /**
     * @return the due_date
     */
    public String getDue_date() {
        return due_date;
    }

    /**
     * @return the next_date
     */
    public String getNext_date() {
        return next_date;
    }



    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Date getRenew_e_date() {
        return renew_e_date;
    }

    public void setRenew_e_date(Date e_date) {
        
        this.renew_e_date = renew_e_date;
    }


    public boolean chkFor_renew(Date e_date) {
        
        Date currentDate = new Date();
        String nowstr = dateFormat.format(currentDate);

        // convert date to calendar
        Calendar n = Calendar.getInstance();
        n.setTime(currentDate);

        end_date = dateFormat.format(e_date);

        Calendar c = Calendar.getInstance();
        c.setTime(e_date);

        c.add(Calendar.DATE, -30);
        boolean chk = false;
        if(n.getTime().after(e_date) && n.getTime().before(c.getTime())){
              chk = true;
        }
        return chk;
    }
    
    public void rentPayDate() {
               Date currentDate = new Date();
        //due_date = dateFormat.format(currentDate);

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);

        // manipulate date
//        c.add(Calendar.YEAR, 1);
//        c.add(Calendar.MONTH, 1);
        c.add(Calendar.YEAR, -543);
                due_date = dateFormat.format(c.getTime());
        // manipulate date
        c.add(Calendar.YEAR, 1);
//        c.add(Calendar.MONTH, 1);
//        c.add(Calendar.DATE, 1); //same with c.add(Calendar.DAY_OF_MONTH, 1);
//        c.add(Calendar.HOUR, 1);
//        c.add(Calendar.MINUTE, 1);
//        c.add(Calendar.SECOND, 1);

        // convert calendar to date
        Date currentDatePlusOne = c.getTime();

//        System.out.println(dateFormat.format(currentDatePlusOne));
        next_date = dateFormat.format(currentDatePlusOne);
    }

}
