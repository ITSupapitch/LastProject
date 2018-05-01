/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.register;

/**
 *
 * @author Suttida Sat
 */

@WebServlet(name = "registerServlet", urlPatterns = {"/registerServlet"})
public class registerServlet extends HttpServlet {

    private Connection conn;
    
    public void init(){
        conn = (Connection) getServletContext().getAttribute("connection");
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
         request.setCharacterEncoding("UTF-8");
          
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String id = request.getParameter("id");
            String password = request.getParameter("password");
            String confirm_password = request.getParameter("confirm_password");  
            String phone = request.getParameter("phone");
            
            String gender = request.getParameter("gender");
            String ban = request.getParameter("ban");
            String soi = request.getParameter("soi");
            String district = request.getParameter("district");
            String area = request.getParameter("area");
            String county = request.getParameter("country");
            String code = request.getParameter("code");
              String type = "customer"; 
              
               Statement stmt = conn.createStatement();
            String sql_account = "INSERT INTO account (username, password, firstname, lastname, phone, account_type) VALUES('"+id+"','"+password+"','"+fname+"','"+lname+"','"+phone+"','"+type+"')" ;
            stmt.executeUpdate(sql_account);     
            String sql_customer  = "INSERT INTO customer (gender,ban,soi,district, area,county,code) VALUES('"+gender+"','"+ban+"','"+soi+"','"+district+"','"+area+"','"+county+"','" +code+"')";
            stmt.executeUpdate(sql_customer);
            ///insert data to account
//               register reg = new register();
//
//               reg.addAccount(fname, lname, id, password, phone,type);
//               reg.addCustomer(gender, ban, soi, district, area, county, code);
           
    
            response.sendRedirect("login.html");
            
        } catch (SQLException ex) {
            Logger.getLogger(registerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }    }

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
