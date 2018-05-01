/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Address;
import model.Login;


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
            HttpSession session = request.getSession(true);
          
            String fname = request.getParameter("firstname");
            String lname = request.getParameter("lastname");
            String id = request.getParameter("username");
            String password = request.getParameter("password");
            String confirm_password = request.getParameter("confirm_pw");  
            String phone = request.getParameter("telnumber");
            
            String gender = request.getParameter("user_gender");
            String ban = request.getParameter("house_number");
            String soi = request.getParameter("house_soi");
            String district = request.getParameter("house_district");
            String area = request.getParameter("house_area");
            String county = request.getParameter("house_country");
            String code = request.getParameter("house_zipcode");
              String type = "customer"; 
              
              int account_id = 0;
              
              if(!password.equals(confirm_password)){
                  out.println("Wrong Password");
//                  response.sendRedirect("register.html");
                  RequestDispatcher dp = request.getRequestDispatcher("register.html");
                    dp.include(request, response);
              }
              
              else{
                  
                        Account account = new Account();
                        Address address = new Address();

                        account.setConn(conn);
                        address.setConn(conn);
                        
                        account.addAccount(id, password,fname, lname, phone,type,gender);
                        ///get account_id from quary account
                        account_id = account.getAccount_id(id, password);
                        address.addAddress(ban, soi, district, area, county, code, account_id,gender);
                        
                  RequestDispatcher dp = request.getRequestDispatcher("home.html");
                    dp.forward(request, response); 
              }
//else{
//              
//               Statement stmt = conn.createStatement();
//            String sql_account = "INSERT INTO account (username, password, firstname, lastname, phone, account_type) VALUES('"+id+"','"+password+"','"+fname+"','"+lname+"','"+phone+"','"+type+"')" ;
//            stmt.executeUpdate(sql_account);     
//            
//            String sql = "SELECT account_id FROM account WHERE username ='"+id+"'";
//            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()){
//                account_id = rs.getInt("account_id");
//                  }
//               
//            String sql_customer  = "INSERT INTO customer (account_id,gender,ban,soi,district, area,county,code) VALUES('"+account_id+"',  '"+gender+"','"+ban+"','"+soi+"','"+district+"','"+area+"','"+county+"','" +code+"')";
//            stmt.executeUpdate(sql_customer);


           
           
              
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
