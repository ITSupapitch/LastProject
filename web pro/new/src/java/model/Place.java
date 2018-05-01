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
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Suttida Sat
 */
public class Place {

    private Connection conn;

    private int placeID;
    private String place_name;
    private String type;
    private String status;
    private float price;
    private float priceBook = 0;
    private float priceRent = 0;

    public float getPriceBook() {
        return priceBook;
    }

    public void setPriceBook(float priceBook) {
        float priceBook2 = priceBook * (30 / 100);
        this.priceBook = priceBook2;
    }

    public float getPriceRent() {
        return priceRent;
    }

    public void setPriceRent(float priceRent) {
        this.priceRent = priceRent;
    }
    private HashMap<Integer, String> place;
    String cur_status = "";

    public Place() {
    }

    public Place(Connection conn) {
        this.conn = conn;
    }

    public int getPlaceID() {
        return placeID;
    }
//    public int getPlaceID(int i_id) {
//       
//        return placeID;
//    }

    // add by jugjig check setPlaceID(int i_id)  
    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public HashMap<Integer, String> getPlace() {
        return place;
    }

    public void setPlace(int i_id) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql_place = "SELECT area_id  FROM inden_area WHERE i_id   ='" + i_id + "'";
        ResultSet rs = stmt.executeQuery(sql_place);

        List<Integer> place_id = null;
        while (rs.next()) {
            place_id.add(rs.getInt("area_id "));
        }

        HashMap newmap = new HashMap();
        for (int i = 0; i < place_id.size(); i++) {
            String sql_type = "SELECT area_type FROM inden_area WHERE i_id   ='" + place_id.get(i) + "'";
            ResultSet rs2 = stmt.executeQuery(sql_type);
            while (rs2.next()) {
                this.place = (HashMap<Integer, String>) newmap.put(place_id.get(i), rs2.getString("area_type"));
            }
        }
    }

    public void addPlace() {

    }

    public void updateStatusPlace() throws SQLException {

        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM area WHERE area_id = " + placeID;
        ResultSet rs1 = stmt.executeQuery(sql);
        rs1.next();

        if (rs1.getString("status").equals("enable")) {
            cur_status = "disabled";
            String sql_book_payment = "UPDATE area SET status= '" + cur_status + "' WHERE area_id = " + placeID;
            stmt.executeUpdate(sql_book_payment);
        }

    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }



}
