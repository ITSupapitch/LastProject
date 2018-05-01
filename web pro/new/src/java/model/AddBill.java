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
public class AddBill {
     private float water ;
   private  float fire ;
   private  float price_area;
   private float total;
   private  int invoice_id;
   private String month;
   private boolean CkeckMonth;

    private Connection conn;

    public AddBill() {
    }
    
        public boolean isCkeckMonth() {
        return CkeckMonth;
    }

    public void setCkeckMonth(int i_id , String month) throws SQLException {
        
        Statement stmt = conn.createStatement();
        String query_check = "SELECT invoice_id  FROM monthly_expense WHERE i_id   ='"+i_id+"'"+"AND month = '"+month+"'";
            ResultSet chk_month = stmt.executeQuery(query_check);
            if(chk_month.next())
                    this.CkeckMonth = true;
            else
                this.CkeckMonth = false;
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

    public void setPrice_area(int i_id) throws SQLException {
         Statement stmt = conn.createStatement();
            String sql_area = "SELECT price FROM inden_area WHERE i_id = '"+i_id+"'";
            ResultSet rs = stmt.executeQuery(sql_area);
            int price = 0;
            while(rs.next()){
                price += rs.getFloat("price");
                this.price_area = price;
    }
    }

    public float getTotal() {
        return total;
    }

    public void setTotal() {
        this.total = water+fire+price_area;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int i_id,String month) throws SQLException {
        Statement stmt = conn.createStatement();
        String query_invoice_id = "SELECT invoice_id FROM monthly_expense WHERE i_id  = '"+i_id+"'" + "AND month = '"+month+"'";
            ResultSet rs2 = stmt.executeQuery(query_invoice_id);
            while (rs2.next()){
                          this.invoice_id  = rs2.getInt("invoice_id");
                  }

    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

 
    public void addTotalMonth(String month,int i_id) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql_area = "INSERT INTO monthly_expense (total , month , i_id ) VALUES('"+total+"' ,'"+month+"',+'"+i_id+"')";
        stmt.executeUpdate(sql_area);
        
       
    }
    public void addBillMonth() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql_water = "INSERT INTO detail (price,type_id , invoice_id) VALUES ('"+water+"' , 2 , '"+invoice_id+"')";
        stmt.executeUpdate(sql_water);
        
        String sql_fire = "INSERT INTO detail (price,type_id , invoice_id) VALUES ('"+fire+"' , 3, '"+invoice_id+"')";
        stmt.executeUpdate(sql_fire);
    }
    
    public void updateTotalMonth() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql_total = "UPDATE monthly_expense SET total = '"+total+"' WHERE invoice_id  = '"+invoice_id+"'" ;
        stmt.executeUpdate(sql_total);

}
    public void updateBillMonth() throws SQLException {
        Statement stmt = conn.createStatement();
        String sql_water = "UPDATE detail SET price = '"+water+"' WHERE type_id = 2 AND invoice_id = '"+invoice_id+"'";
        stmt.executeUpdate(sql_water);
        
        String sql_fire = "UPDATE detail SET price = '"+fire+"' WHERE type_id = 3 AND invoice_id = '"+invoice_id+"'";
        stmt.executeUpdate(sql_fire);
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
