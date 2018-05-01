/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.sql.Statement;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Agreement;

import model.Account;
import model.DateExample;
import model.Payment;

/**
 *
 * @author Suttida Sat
 */
@WebServlet(name = "Payrent", urlPatterns = {"/Payrent"})
public class Payrent extends HttpServlet {


    private Connection conn;

    public void init() {
        conn = (Connection) getServletContext().getAttribute("connection");
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            HttpSession session = request.getSession(true);
            int i_id = (int) session.getAttribute("i_id");
            
            String bank = request.getParameter("bank");
            String date = request.getParameter("trans_date");
            String time = request.getParameter("trans_time");
            float amount = Float.parseFloat(request.getParameter("amount"));
//            Part filepart = request.getPart("trans_image");
            
//            InputStream inp = filepart.getInputStream();


            Payment pay = new Payment();
            pay.setConn(conn);
//            pay.setFilePart(inp);
            
//            pay.setPicInput(inp);
            pay.setBank(bank);
            pay.setDate_time(date+" "+time);
//            out.println(pay.getDate_time());
//            out.println(date+" "+time);
            pay.setPaymentIDForpic(i_id);
            pay.setPic();
            pay.addPayRent();
            Account account = (Account) session.getAttribute("account_info");
             int account_id = account.getAccount_id();
            Statement stmt = conn.createStatement();
            String sql1 = "select max(i_id)\n" +
"                    from indenture\n" +
"                    join payment\n" +
"using(payment_id)\n" +
"                   where account_id = " +account_id+"\n" +
"                    and type_contract_id = 2";
            ResultSet rs1 = stmt.executeQuery(sql1);
            rs1.next();
            
            DateExample dt = new DateExample();
            dt.rentPayDate();
            Date start_date = java.sql.Date.valueOf(dt.getDue_date());
            Date end_date = java.sql.Date.valueOf( dt.getNext_date());
            String sql2 = "UPDATE indenture \n" +
"SET start_date = '"+start_date+"' , end_date = '"+ end_date+"'\n" +
"WHERE i_id = " + rs1.getInt("max(i_id)");
            stmt.executeUpdate(sql2);
            
            
//            Agreement agm = new Agreement();
//            agm.setConn(conn);
//
//            agm.setEnd_date(i_id);
//            agm.setE_date(i_id);
//            
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Date currentDate = new Date();
//        String nowstr = dateFormat.format(currentDate);
//
//        // convert date to calendar
//        Calendar n = Calendar.getInstance();
//        n.setTime(currentDate);
//
//        String e_date = dateFormat.format(agm.getE_date());
//        Calendar c = Calendar.getInstance();
//        c.setTime(agm.getE_date());
//
//        c.add(Calendar.YEAR, 1);
//        pay.upEnddate(i_id, e_date);
            
            response.sendRedirect("successPayment.jsp");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Payrent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
