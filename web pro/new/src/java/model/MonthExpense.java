/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Suttida Sat
 */
public class MonthExpense {
    
    private float water ;
   private  float fire ;
   private  float price_area;
   private float total;
   private  int invoice_id;
   private String month;
   private String date_time ;
   private String bank ;
   private boolean CkeckMonth;

    private Connection conn;
    public MonthExpense() {
    }

    public float getWater() {
        return water;
    }

    public void setWater(float invoice) throws SQLException {
        
            Statement stmt = conn.createStatement();
            String sql_water = "SELECT price  FROM detail WHERE invoice_id   ='"+invoice+"'" + "AND type_id = 2";
            ResultSet rs = stmt.executeQuery(sql_water);
            while(rs.next()){
                this.water = rs.getFloat("price");
            }
    }

    public float getFire() {
        return fire;
    }

    public void setFire(float invoice) throws SQLException {
            Statement stmt = conn.createStatement();
            String sql_fire = "SELECT price  FROM detail WHERE invoice_id   ='"+invoice+"'" + "AND type_id = 3";
            ResultSet rs = stmt.executeQuery(sql_fire);
            while(rs.next()){
                
                this.fire = rs.getFloat("price");
            }
    }

    public float getPrice_area() {
        return price_area;
    }

    public void setPrice_area(float i_id) throws SQLException {
            Statement stmt = conn.createStatement();
            String sql_area = "SELECT price FROM inden_area WHERE i_id = '"+i_id+"'";
            ResultSet rs = stmt.executeQuery(sql_area);
            int price = 0;
            while(rs.next()){
                price += rs.getFloat("price");
                this.price_area = price;
    }
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int i_id,String month) throws SQLException {
        
        Statement stmt = conn.createStatement();
            String sql = "SELECT invoice_id  FROM monthly_expense WHERE i_id  ='"+i_id+"'"+"AND month ='"+month+"'" ;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                this.invoice_id = rs.getInt("invoice_id");
            }
            
    }

    public void setInvoice_id(int i_id) throws SQLException {
        
        Statement stmt = conn.createStatement();
            String sql = "SELECT invoice_id  FROM monthly_expense WHERE i_id  ='"+i_id+"'"+"AND month ='"+month+"'" ;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                this.invoice_id = rs.getInt("invoice_id");
            }
            
    }

    public float getTotal() {
        return price_area+water+fire;
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

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public boolean isCkeckMonth() {
        return CkeckMonth;
    }

    public void setCkeckMonth(boolean CkeckMonth) {
        this.CkeckMonth = CkeckMonth;
    }
  public void AddPayMonth() throws SQLException {
      Statement stmt = conn.createStatement();
            String sql = "UPDATE monthly_expense  SET slip = '" + "pic.jpg" + "'  , bank = '"+bank+"'  ,date_time_pay = '"
                    +date_time+"' WHERE invoice_id = '"+invoice_id+"'" ;
           stmt.executeUpdate(sql);
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
   

    
}
