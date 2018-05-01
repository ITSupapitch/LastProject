/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author asus
 */
public class Payment {

    public Payment() {

    }
    // start aew
    private float price;
    private String date_time;
    private int payment_id_book;
    private int payment_id_Rent;
    private String bank;
    private int paymentIDForpic;

//    private InputStream picInput;
    private String pic;
    // end aew

    public int getPaymentIDForpic() {
        return paymentIDForpic;
    }

    public void setPaymentIDForpic(int i_id) throws SQLException {
                Statement stmt = conn.createStatement();
        String sql_payment = "SELECT payment_id   FROM indenture join payment using(payment_id) WHERE i_id = '" + i_id + "' AND type_contract_id = 1";
        ResultSet rs = stmt.executeQuery(sql_payment);
        while (rs.next()) {
            this.paymentIDForpic = rs.getInt("payment_id");
        }
    }
    
    

    public String getPic() {
        return pic;
    }

    public void setPic() {
        this.pic = "C:/Users/user/Documents/git/web pro/new/slip" + paymentIDForpic+" .jpg";
    }



    private Connection conn;

    // start aew
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

//    public InputStream getPicInput() {
//        return picInput;
//    }
//
//    public void setPicInput(InputStream picInput) {
//        this.picInput = picInput;
//    }

    public int getPayment_id_book() throws SQLException {

        return payment_id_book;
    }

    public void setPayment_id_book(int i_id) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql_payment_book = "SELECT payment_id   FROM indenture join payment using(payment_id) WHERE i_id = '" + i_id + "' AND type_contract_id = 1";
        ResultSet rs = stmt.executeQuery(sql_payment_book);
        while (rs.next()) {
            this.payment_id_book = rs.getInt("payment_id");
        }
    }

    public int getPayment_id_Rent() {
        return payment_id_Rent;
    }

    public void setPayment_id_Rent(int i_id) throws SQLException {
        Statement stmt = conn.createStatement();
        String sql_payment_rent = "SELECT payment_id   FROM indenture join payment using(payment_id) WHERE i_id = '" + i_id + "' AND type_contract_id = 2";
        ResultSet rs = stmt.executeQuery(sql_payment_rent);
        while (rs.next()) {
            this.payment_id_Rent = rs.getInt("payment_id");
        }
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void addPayRent() throws SQLException {
        Statement stmt = conn.createStatement();
        String upslip_rent = "UPDATE payment  SET slip = '" + pic + "' , bank = '" + bank + "' , tranfer_date_time = '" + date_time + "' WHERE payment_id  = '" + payment_id_Rent + "'";
        stmt.executeUpdate(upslip_rent);

    }

    public void addPayBook() throws SQLException {
        Statement stmt = conn.createStatement();
        String upslip_book = "UPDATE payment  SET slip = '" + pic + "' , bank = '" + bank + "' , tranfer_date_time = '" + date_time + "' WHERE payment_id  = '" + paymentIDForpic + "'";
        stmt.executeUpdate(upslip_book);

    }

    public void upEnddate(int i_id , String end_date) throws SQLException {
            Statement stmt = conn.createStatement();
        String upEndDate = "UPDATE indenture  SET end_date   '"+ end_date+"' WHERE i_id   = '" + i_id + "'";
        stmt.executeUpdate(upEndDate);
    }

    // end aew
    // // start jj
    private int paymentID;
    private float priceBook;
    private float priceRent;
    private int type_contract_id;
    private String slip;
    private String transfer_date_time;
    // start jj

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public float getPriceBook() {
        return priceBook;
    }

    public void setPriceBook(float priceBook) {
        priceBook = priceBook * 30 / 100;
        this.priceBook = priceBook;
    }

    public float getPriceRent() {
        return priceRent;
    }

    public void setPriceRent(float priceRent) {
        priceRent *= 3;
        this.priceRent = priceRent;
    }

    public int getType_contract_id() {
        return type_contract_id;
    }

    public void setType_contract_id(int type_contract_id) {
        this.type_contract_id = type_contract_id;
    }

    public String getSlip() {
        return slip;
    }

    public void setSlip(String slip) {
        this.slip = slip;
    }

    public String getTransfer_date_time() {
        return transfer_date_time;
    }

    public void setTransfer_date_time(String transfer_date_time) {
        this.transfer_date_time = transfer_date_time;
    }

    public void addPayment() throws SQLException {

        Statement stmt = conn.createStatement();

        if (type_contract_id == 1) {
            String sql_book_payment = "INSERT INTO payment (price_book, price_rent, type_contract_id) VALUES( '" + priceBook + "', 0,1)";
            stmt.executeUpdate(sql_book_payment);

            String sql_find_payment_id = "SELECT  *  FROM payment WHERE payment_id  = (\n"
                    + "    select max(payment_id) from payment\n"
                    + "    where type_contract_id = 1\n"
                    + ");";
            ResultSet rs = stmt.executeQuery(sql_find_payment_id);
            rs.next();
            setPaymentID(rs.getInt("payment_id"));
        } else if (type_contract_id == 2) {
            String sql_Rent_payment = "INSERT INTO payment (price_book, price_rent, type_contract_id) VALUES( 0, '" + priceRent + "',2)";
            stmt.executeUpdate(sql_Rent_payment);

            String sql_find_payment_id = "SELECT  *  FROM payment WHERE payment_id  = (\n"
                    + "    select max(payment_id) from payment\n"
                    + "    where type_contract_id = 2\n"
                    + ");";
            ResultSet rs = stmt.executeQuery(sql_find_payment_id);
            rs.next();
            setPaymentID(rs.getInt("payment_id"));
        }


    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
   public void setFilePart(InputStream img) throws FileNotFoundException, IOException {
       File Part = new File("C:\\Users\\user\\Documents\\git\\web pro\\img");
       FileOutputStream  ops = new FileOutputStream(Part);
       
       byte[] buffer = new byte[1024];
       while(img.read(buffer) > 0)
           ops.write(buffer);
    }


}
