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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class Announce {
    
    private String announceType;
    private String information;
    
    
    private String name_type;
    private int con_id;
    private String content;

    public String getName_type() {
        return name_type;
    }

    public void setName_type(String name_type) {
        this.name_type = name_type;
    }

    public int getCon_id() {
        return con_id;
    }

    private void setCon_id(int con_id) {
        this.con_id = con_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
   
    private Connection conn;

    public Announce() {
    }
    
    public String getAnnounceType() {
        return announceType;
    }

    public void setAnnounceType(String announceType) {
        this.announceType = announceType;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String name_type) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT  * FROM announce where con_id = "
                    + "(Select max(con_id) From announce join payment_detail using (type_contract_id) where name_type = '" + name_type+"')";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            
            this.information = rs.getString("content");
            setCon_id(rs.getInt("con_id"));
        } catch (SQLException ex) {
            Logger.getLogger(Announce.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    

    
    public void updateAnnounce(int edit_con_type, String txt){
        try {
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO announce (content, type_contract_id) VALUES('"+txt+"'," + edit_con_type+ ")";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Announce.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // create connection
    public Announce(Connection conn){
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

 

}
