/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
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
import model.Account;
import model.Agreement;
import model.Contract;
import model.forDate;

/**
 *
 * @author Suttida Sat
 */
@WebServlet(name = "view_agm_rent", urlPatterns = {"/view_agm_rent"})
public class view_agm_rent extends HttpServlet {

    private Connection conn;

    public void init() {
        conn = (Connection) getServletContext().getAttribute("connection");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            HttpSession session = request.getSession(true);
            int id_user = (int) session.getAttribute("id_user");
            

            ////Account
            
            Account acc = new Account();
            acc.setConn(conn);
            
            acc.setFirstname(id_user);
            acc.setLastname(id_user);
            acc.setFullname();

            session.setAttribute("fullname", acc.getFullname());
            
            
            ///indenture
            
            int i_id = (int) session.getAttribute("i_id");
//            out.println(i_id);
//            
            if(i_id == 0){
                response.sendRedirect("donthave.jsp");
            }else{
                
                Agreement agm = new Agreement();
            agm.setConn(conn);
            agm.setPayment_id_Rent(i_id);

            agm.setPayment_id_Rent(i_id);
            agm.setPlace_number(i_id);
            agm.setPlace_type(i_id);
            agm.setStart_date(i_id);
             agm.setEnd_date(i_id);
             agm.setStatus_payment_rent();
            agm.setCost(i_id);
            agm.setTotal_rent(i_id);
            session.setAttribute("Agreement", agm);
            
            /// เช่าหรือจอง
            Contract cont = new Contract();
            cont.setConn(conn);
            cont.setChkBookOrRent(i_id);
            int chkCont = cont.getChkBookOrRent();
            if(chkCont == 1){
                                RequestDispatcher dp = request.getRequestDispatcher("donthave.jsp");
                dp.forward(request, response);
            }
             if(chkCont == 2){
                                RequestDispatcher dp = request.getRequestDispatcher("view_agm_rent.jsp");
                dp.forward(request, response);
                            }

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(view_agm_book.class.getName()).log(Level.SEVERE, null, ex);
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
