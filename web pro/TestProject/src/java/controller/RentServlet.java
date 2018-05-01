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
@WebServlet(name = "RentServlet", urlPatterns = {"/RentServlet"})
public class RentServlet extends HttpServlet {

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
            /*Create session*/
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");

            /*Create Statement*/
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM rentarea WHERE username ='" + username+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            /* Check condition*/
            if(rs.next()){
                if(rs.getString("username").equals(username)){
                    session.setAttribute("rentType", rs.getString("type"));
                    session.setAttribute("rentQuantity", rs.getString("type"));
                    session.setAttribute("rentPanel", rs.getString("panel"));
                    session.setAttribute("rentPrice", rs.getString("price"));
                    session.setAttribute("rentStart_date", rs.getString("start_date"));
                    session.setAttribute("rentEnd_date", rs.getString("end_date"));
                }
            }
            
             /*Forward Page to infoUser.jsp */
             response.sendRedirect("rentView.jsp");
            
        } catch (SQLException ex) {
            Logger.getLogger(RentServlet.class.getName()).log(Level.SEVERE, null, ex);
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
