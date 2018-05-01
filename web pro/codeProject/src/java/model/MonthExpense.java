/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;

/**
 *
 * @author Suttida Sat
 */
public class MonthExpense {
    
    private float water ;
   private  float fire ;
   private  float price_area;
   private float total;
   private  int id;

    private Connection conn;
    public MonthExpense() {
    }

    public float getWater() {
        return water;
    }

    public void setWater(float water) {
        this.water = water;
    }

    public float getFire() {
        return fire;
    }

    public void setFire(float fire) {
        this.fire = fire;
    }

    public float getPrice_area() {
        return price_area;
    }

    public void setPrice_area(float price_area) {
        this.price_area = price_area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    

    
}
