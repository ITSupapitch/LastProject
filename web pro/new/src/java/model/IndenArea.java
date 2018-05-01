/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author asus
 */
public class IndenArea {

    private int area_id;
    private int contrct_id;
    private float price;
    private Connection conn;
    public IndenArea() {
    }

    

    public void addIndenArea() throws SQLException {

        Statement stmt = conn.createStatement();
        String sql_inden_area = "INSERT INTO inden_area (area_id, i_id, price) VALUES( " + area_id + ", " + contrct_id + ","+price+ ")";
        stmt.executeUpdate(sql_inden_area);

    }

    public int getArea_id() {
        return area_id;
    }

    public void setArea_id(int area_id) {
        this.area_id = area_id;
    }

    public int getContrct_id() {
        return contrct_id;
    }

    public void setContrct_id(int contrct_id) {
        this.contrct_id = contrct_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public IndenArea(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }



   

}
