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

public class Account {
    
    private String username;
    private String  password;
    private String  firstname;
    private String lastname;
    private String fullname;
    private String phone;
    private String gender;
    private String account_type;
    private int account_id; 

    Connection conn;
    public Account() {
    }

    public void addAccount(String username, String password,String firstname,String lastname,String phone,String account_type,String gender){
        try {
            Statement stmt = conn.createStatement();
            String sql_account = "INSERT INTO account (username, password, firstname, lastname, phone, account_type) VALUES('"+username+"','"+password+"','"+firstname+"','"+lastname+"','"+phone+"','"+account_type+"')" ;
            stmt.executeUpdate(sql_account);  
            

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(int id_user) throws SQLException {
             Statement stmt = conn.createStatement();
            String sql_fname = "SELECT  username  FROM account WHERE account_id  = '"+id_user+"'" ;
            ResultSet rs = stmt.executeQuery(sql_fname);
            
            while(rs.next()){
                this.username = rs.getString("username");
            }

    }
     public void setUsername(String username) {
            
                this.username = username ;
            

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(int id_user) throws SQLException {
        
         Statement stmt = conn.createStatement();
            String sql_fname = "SELECT  firstname FROM account WHERE account_id  = '"+id_user+"'" ;
            ResultSet rs = stmt.executeQuery(sql_fname);
            
            while(rs.next()){
                this.firstname = rs.getString("firstname");
            }
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(int id_user) throws SQLException {
        Statement stmt = conn.createStatement();
            String sql_fname = "SELECT  lastname  FROM account WHERE account_id  = '"+id_user+"'" ;
            ResultSet rs = stmt.executeQuery(sql_fname);
            
            while(rs.next()){
                this.lastname = rs.getString("lastname");
            }
    }

    
     public String getFullname() {
    return fullname;
    }

    public void setFullname(String f, String l) {
        this.fullname = f + "    " + l;
    }
    public void setFullname() {
        this.fullname = firstname + "    " + lastname;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }
    
    public Account(Connection conn){
        this.conn = conn;
    }

    public int getAccount_id() {

        return account_id;
    }

    public void setAccount_id(String username, String password) throws SQLException {
        Statement stmt = conn.createStatement();
            String sql_accountID = "SELECT  account_id FROM account WHERE username = '"+username+"'" + "AND password = '"+password+"'" ;
            ResultSet rs = stmt.executeQuery(sql_accountID);
            
            while(rs.next()){
                this.account_id = rs.getInt("account_id");
            }
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void setAccount_type(int id_user) throws SQLException {
         Statement stmt = conn.createStatement();
            String sql_type= "SELECT  account_type  FROM account WHERE account_id  = '"+id_user+"'" ;
            ResultSet rs = stmt.executeQuery(sql_type);
            
            while(rs.next()){
                this.account_type = rs.getString("account_type");
            }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    
}
