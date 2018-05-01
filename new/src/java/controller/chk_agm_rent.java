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
import model.forDate;

/**
 *
 * @author Suttida Sat
 */
@WebServlet(name = "chk_agm_rent", urlPatterns = {"/chk_agm_rent"})
public class chk_agm_rent extends HttpServlet {

   private Connection conn;

    public void init() {
        conn = (Connection) getServletContext().getAttribute("connection");
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
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
                response.sendRedirect("rent.jsp");
            }
                else{
            
            Agreement agm = new Agreement();
            agm.setConn(conn);
            
            agm.setPayment_id_book(i_id);
             agm.setEnd_date(i_id);


            if(agm.getEnd_date().compareTo(now) < 0 || agm.getPayment_id_book() == 0)  { ///  if ไม่มีสัญญาจอง
                      Agreement chk_rent = new Agreement();  /// เช็คต่อว่ามีเช่ารึป่าว
                chk_rent.setConn(conn);
                chk_rent.setPayment_id_Rent(i_id);

                chk_rent.setPayment_id_Rent(i_id);
                chk_rent.setEnd_date(i_id);

                
                if (chk_rent.getEnd_date().compareTo(now) < 0 || chk_rent.getPayment_id_Rent() == 0) {
                    response.sendRedirect("rent.jsp");
                } else {
                    response.sendRedirect("view_agm_rent");
                }
                }
            else{ /// มีสัญญาจอง
                response.sendRedirect("view_agm_book");
            }
            }

            
        } catch (SQLException ex) {
           Logger.getLogger(chk_agm_rent.class.getName()).log(Level.SEVERE, null, ex);
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
