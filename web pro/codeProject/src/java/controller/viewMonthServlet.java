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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Suttida Sat
 */
@WebServlet(name = "viewMonthServlet", urlPatterns = {"/viewMonthServlet"})
public class viewMonthServlet extends HttpServlet {

private Connection conn;

public void init(){
    conn = (Connection) getServletContext().getAttribute("connection");
}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
request.setCharacterEncoding("UTF-8");
response.setContentType("text/html; charset=UTF-8");
response.setCharacterEncoding("UTF-8");            
            HttpSession session = request.getSession(true);
            
            float water = 0;
            float fire = 0;
            float total = 0;
            float price_area = 0;
            String month = "april";

             int user_id = (int) session.getAttribute("id_user");
             
             Statement stmt = conn.createStatement();
             String sql = "SELECT total , price , type_id from monthly_expense join detail using(invoice_id) join indenture using(i_id) WHERE account_id = '"+user_id+"'"+
                     "AND slip is null";
             ResultSet rs = stmt.executeQuery(sql);
             
             while(rs.next()){
                 if(rs.getInt("type_id") == 2){
                     water = rs.getFloat("price");
                     session.setAttribute("water", water);
                 }else{
                     fire = rs.getFloat("price");
                     session.setAttribute("fire", fire);
                 }
                 total = rs.getFloat("total");
                 session.setAttribute("total", total);
             }
             price_area = total - (water+fire);
             
             session.setAttribute("price_area", price_area);
             
//             out.println(session.getAttribute("water"));
//             out.println(session.getAttribute("fire"));
//             out.println(session.getAttribute("price_area"));
//             out.println(session.getAttribute("total"));
             
             RequestDispatcher dp = request.getRequestDispatcher("showMonth.jsp");
             dp.forward(request, response);
             
             
        } catch (SQLException ex) {
        Logger.getLogger(viewMonthServlet.class.getName()).log(Level.SEVERE, null, ex);
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
