/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asus
 */
@WebServlet(name = "PaymentServlet", urlPatterns = {"/PaymentServlet"})
public class PaymentServlet extends HttpServlet {

     private Connection conn;
    public void init(){
        conn = (Connection) getServletContext().getAttribute("connection");
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            /*create Statement*/
            Statement stmt = conn.createStatement();
            
            /* Get seesion*/
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            
            /*Get parameter from payment.html*/
            String typePayment = request.getParameter("typePayment");
            String bank = request.getParameter("bank");
            String trans_date = request.getParameter("trans_date");
            String trans_time = request.getParameter("trans_time");
            String amountS = request.getParameter("amount");
            String trans_image = request.getParameter("trans_image");
            
            Float amount = Float.parseFloat(amountS);

            /*ExecuteQuery*/
            String sql = "SELECT * FROM payment WHERE username = '" + username + "' ORDER by paymentID desc;";
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next()){
                if(rs.getString("username").equals(username)){
                    
                    int count = rs.getInt("paymentID");
                    out.println("count out = " + count);
                    count+=1;
                    out.println("count out = " + count);
                    String sql2 = "INSERT INTO payment VALUES (" + count + 
                                    ",'" +username + "','"+ typePayment+"','"+bank+"','"+
                                    trans_date+ "','"+ trans_time + "'," + amount+ ",'"+ trans_image+"');";
                    stmt.executeUpdate(sql2);
               
                }
                
            }else{
                String sql2 = "INSERT INTO payment VALUES (" + 1 + 
                                    ",'" +username + "','"+ typePayment+"','"+bank+"','"+
                                    trans_date+ "','"+ trans_time + "'," + amount+ ",'"+ trans_image+"');";
                    stmt.executeUpdate(sql2);
            }

            response.sendRedirect("successPayment.html");
        } catch (SQLException ex) {
             Logger.getLogger(PaymentServlet.class.getName()).log(Level.SEVERE, null, ex);
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
