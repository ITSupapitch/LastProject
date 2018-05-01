/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Suttida Sat
 */
public class Agreement {

    private String start_date;
    private String end_date;
     private int payment_id_book;
    private int payment_id_Rent;
    private String place_number;
    private String place_type;
    private String status_payment;
    private String status_payment_rent;
    private Connection conn;
    private String cost;
    private float total_book;
    private float total_rent;
    private Date e_date;
    public Agreement() {
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(int i_id) throws SQLException {
         Statement stmt = conn.createStatement();
            String sql_startDate = "SELECT start_date   FROM indenture WHERE i_id = '"+i_id+"'";
            ResultSet rs = stmt.executeQuery(sql_startDate);
            while(rs.next()){
                this.start_date = rs.getString("start_date");
            }
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(int  i_id) throws SQLException {
         Statement stmt = conn.createStatement();
            String sql_endDate = "SELECT end_date   FROM indenture WHERE i_id = '"+i_id+"'";
            ResultSet rs = stmt.executeQuery(sql_endDate);
            while(rs.next()){
                this.end_date = rs.getString("end_date");
            }
        
    }

    public Date getE_date() {
        return e_date;
    }

    public void setE_date(int i_id) throws SQLException {
        Statement stmt = conn.createStatement();
            String sql_endDate = "SELECT end_date   FROM indenture WHERE i_id = '"+i_id+"'";
            ResultSet rs = stmt.executeQuery(sql_endDate);
            while(rs.next()){
                this.e_date = rs.getDate("end_date");
            }
    }
    
    

    public String isStatus_payment() {
        return status_payment;
    }

    public void setStatus_payment() throws SQLException {
         Statement stmt = conn.createStatement();
            String sql_slip = "SELECT bank  FROM payment WHERE payment_id = '"+payment_id_book+"'";
            ResultSet rs = stmt.executeQuery(sql_slip);

            while(rs.next()){
                if(rs.getString("bank") == null){
                  this.status_payment = "Uncomplete";
            }
            else{
                this.status_payment = "Complete";
            }
            }

    }

    public String getStatus_payment_rent() {
        return status_payment_rent;
    }

    public void setStatus_payment_rent( ) throws SQLException {
         Statement stmt = conn.createStatement();
            String sql_slip = "SELECT bank  FROM payment WHERE payment_id = '"+payment_id_Rent+"'";
            ResultSet rs = stmt.executeQuery(sql_slip);
            while(rs.next()){
                if(rs.getString("bank") == null){
                  this.status_payment_rent = "Uncomplete";
            }
            else{
                this.status_payment_rent = "Complete";
            }
            }

    }

    public String getCost() {
        return cost;
    }

    public void setCost(int i_id) throws SQLException {
        Statement stmt = conn.createStatement();
            String sql_slip = "SELECT price  FROM inden_area WHERE i_id = '"+i_id+"'";
            ResultSet rs = stmt.executeQuery(sql_slip);
            String str_cost = "";
            while(rs.next()){
                str_cost += String.valueOf(rs.getFloat("price")) + "  ";
                        this.cost = str_cost;
            }

    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public int getPayment_id_book() {
        return payment_id_book;
    }

    public void setPayment_id_book(int i_id) throws SQLException {
        Statement stmt = conn.createStatement();
            String sql_payment_book = "SELECT payment_id   FROM indenture join payment using(payment_id) WHERE i_id = '"+i_id+"' AND type_contract_id = 1";
            ResultSet rs = stmt.executeQuery(sql_payment_book);
            while(rs.next()){
                this.payment_id_book = rs.getInt("payment_id");
            }
    }

    public int getPayment_id_Rent() {
        return payment_id_Rent;
    }

    public void setPayment_id_Rent(int i_id) throws SQLException {
        Statement stmt = conn.createStatement();
            String sql_payment_rent = "SELECT payment_id   FROM indenture join payment using(payment_id) WHERE i_id = '"+i_id+"' AND type_contract_id = 2";
            ResultSet rs = stmt.executeQuery(sql_payment_rent);
            while(rs.next()){
                this.payment_id_Rent = rs.getInt("payment_id");
            }
    }

    public String getPlace_number() {
        return place_number;
    }

    public void setPlace_number(int i_id) throws SQLException {
        Statement stmt = conn.createStatement();
            String sql_p_num = "SELECT area_name FROM area JOIN inden_area USING (area_id) WHERE i_id = '"+i_id+"'";
            ResultSet rs = stmt.executeQuery(sql_p_num);
            String name = "";
            while(rs.next()){
                name += rs.getString("area_name") + "  ";
                this.place_number = name;
            }
        
        
    }

    public String getPlace_type() {
        return place_type;
    }

    public void setPlace_type(int i_id) throws SQLException {
         Statement stmt = conn.createStatement();
            String sql_p_type = "SELECT area_type  FROM area JOIN inden_area USING (area_id) WHERE i_id = '"+i_id+"'";
            ResultSet rs = stmt.executeQuery(sql_p_type);
            String type = "";
            while(rs.next()){
                type += rs.getString("area_type") + "  ";
                this.place_type = type;
            }
    }



    public float getTotal_book() throws SQLException {
         return total_book;
    }

    public void setTotal_book(int i_id) throws SQLException {
       Statement stmt = conn.createStatement();
            String sql_p_type = "SELECT price  FROM inden_area WHERE i_id = '"+i_id+"'";
            ResultSet rs = stmt.executeQuery(sql_p_type);

            while(rs.next()){
                this.total_book += rs.getFloat("price") * 30/100;
            }
    }

    public float getTotal_rent() {
        return total_rent;
    }

    public void setTotal_rent(int i_id) throws SQLException {
        Statement stmt = conn.createStatement();
            String sql_p_type = "SELECT price  FROM inden_area WHERE i_id = '"+i_id+"'";
            ResultSet rs = stmt.executeQuery(sql_p_type);

            while(rs.next()){
                this.total_rent += rs.getFloat("price")*3;
            }
    }

    public String getStatus_payment() {
        return status_payment;
    }

    public void setStatus_payment(String status_payment) {
        this.status_payment = status_payment;
    }
    
    
    
}
