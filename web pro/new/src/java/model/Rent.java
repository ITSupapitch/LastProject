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
public class Rent {
    
    private Connection conn;
    private float price;
    private int contract_type = 2;
    private int payment_id;

    public Rent() {
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int payment_id ) throws SQLException {
        
        Statement stmt = conn.createStatement();
            String sql_price = "SELECT price_rent   FROM payment WHERE payment_id  ='"+payment_id+"'" ;
            ResultSet rs = stmt.executeQuery(sql_price);
            while(rs.next()){
                this.price =rs.getFloat("price_rent");
            }
    }



    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int i_id) throws SQLException {
        
        Statement stmt = conn.createStatement();
            String sql_pID = "SELECT payment_id   FROM indenture WHERE i_id   ='"+i_id+"'";
            ResultSet rs = stmt.executeQuery(sql_pID);
            while(rs.next()){
                this.payment_id =rs.getInt("payment_id");
            }
    }

    public int getContract_type() {
        return contract_type;
    }

    public void setContract_type(int contract_type) {
        this.contract_type = contract_type;
    }
    
    
    
    
}
