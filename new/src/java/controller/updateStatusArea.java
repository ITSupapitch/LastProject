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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.forDate;
import model.statusArea;

/**
 *
 * @author Suttida Sat
 */
@WebServlet(name = "updateStatusArea", urlPatterns = {"/updateStatusArea"})
public class updateStatusArea extends HttpServlet {

    private Connection conn;

    public void init() {
        conn = (Connection) getServletContext().getAttribute("connection");
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            ///get date now
            HttpSession session = request.getSession(true);
            forDate chk = new forDate();
            chk.setDay();
            chk.setMonth();
            chk.setStr_monthForComp();
            chk.setYear();
            chk.setStr_dayForComp();
            chk.setStr_date();
            
            String now = chk.getStr_date();
            
           session.setAttribute("date_now", now);
            
//            out.print(now);
            ////statusArea
            
            statusArea upd = new statusArea();
            upd.setConn(conn);
            upd.setStatus_area(now);
            
            
            RequestDispatcher dp = request.getRequestDispatcher("home.html");
                dp.forward(request, response);
        
    }   catch (SQLException ex) {
            Logger.getLogger(updateStatusArea.class.getName()).log(Level.SEVERE, null, ex);
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
