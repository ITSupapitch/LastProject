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
import model.Agreement;
import model.Contract;
import model.forDate;

/**
 *
 * @author Suttida Sat
 */
@WebServlet(name = "chk_agm_book", urlPatterns = {"/chk_agm_book"})
public class chk_agm_book extends HttpServlet {

   private Connection conn;

    public void init() {
        conn = (Connection) getServletContext().getAttribute("connection");
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                        
            forDate chk = new forDate();
            chk.setDay();
            chk.setMonth();
            chk.setStr_monthForComp();
            chk.setYear();
            chk.setStr_dayForComp();
            chk.setDay();
            chk.setStr_date();

            
            String now = chk.getStr_date();
            HttpSession session = request.getSession(true);
            
             int i_id = (int) session.getAttribute("i_id");

            if(i_id == 0){
                response.sendRedirect("booking.jsp");
            }
               else{
            
            Contract cont = new Contract();
            cont.setConn(conn);
            cont.setChkBookOrRent(i_id);
            int chkCont = cont.getChkBookOrRent();
            if(chkCont == 1){
                                RequestDispatcher dp = request.getRequestDispatcher("view_agm_book");
                dp.forward(request, response);
            }
             if(chkCont == 2){
                                RequestDispatcher dp = request.getRequestDispatcher("view_agm_rent");
                dp.forward(request, response);
                            }


            }


            
        } catch (SQLException ex) { 
           Logger.getLogger(chk_agm_book.class.getName()).log(Level.SEVERE, null, ex);
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
