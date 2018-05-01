/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class register {

      private Connection conn;
    private int id;
    private String fname;
    private String lname;
    private String password;
    private int phone;
    private String gender;
    private String ban;
    private String soi;
    private String district;
    private String area;
    private String country;
    private String code;
    private String type;
   
    public register() {
    }

    public int getId() {
        return id;
    }

     public void addAccount(String fname,String lname,String id,String password,String phone , String type){
        try {
            
             Statement stmt = conn.createStatement();
            String sql_account = "INSERT INTO account (username, password, firstname, lastname, phone, account_type) VALUES('"+id+"','"+password+"','"+fname+"','"+lname+"','"+phone+"','"+type+"')" ;
            stmt.executeUpdate(sql_account);            
         
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
   
     public void addCustomer(String gender,String ban,String soi,String district,String area,String county,String code){
        try {
            
             Statement stmt = conn.createStatement();
            String sql_customer  = "INSERT INTO customer (gender,ban,soi,district, area,county,code) VALUES('"+gender+"','"+ban+"','"+soi+"','"+district+"','"+area+"','"+county+"','" +code+"')";
            stmt.executeUpdate(sql_customer);
         
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     }
    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
