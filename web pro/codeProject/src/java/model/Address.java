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
 * @author Suttida Sat
 */
public class Address {

    private String ban;
    private String soi;
    private String district;
    private String area;
    private String county;
    private String code;
    private String gender;
        private String address_info;

    private Connection conn;

     public String address_info(){
        address_info = ban + " " + soi + " " + district + " " + area + " " +
                county + " " + code ;
        return address_info;
    }
     
    public Address() {
    }

    public String getBan() {
        return ban;
    }

    public void setBan(String ban) {
        this.ban = ban;
    }

    public String getSoi() {
        return soi;
    }

    public void setSoi(String soi) {
        soi = checkNullValue(soi);
        this.soi = soi;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void addAddress(String ban, String soi, String district, String area, String county, String code, int account_id, String gender) {
        try {
            Statement stmt = conn.createStatement();
            String sql_account = "INSERT INTO customer (account_id  , ban, soi, district , area , county , code,gender) VALUES('" + account_id + "', '" + ban + "','" + soi + "','" + district + "','" + area + "','" + county + "','" + code + "','" + gender + "')";
            stmt.executeUpdate(sql_account);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public Address(Connection conn) {
        this.conn = conn;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    //check null value when shema can null
    private String checkNullValue(String txt) {
        if (txt.equals("null") || txt.equals("-")) {
            txt = " ";
        }
        return txt;
    }

}
