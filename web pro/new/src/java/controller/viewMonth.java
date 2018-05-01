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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Contract;
import model.MonthExpense;

/**
 *
 * @author Suttida Sat
 */
@WebServlet(name = "viewMonth", urlPatterns = {"/viewMonth"})
public class viewMonth extends HttpServlet {

private Connection conn;

public void init(){
    conn = (Connection) getServletContext().getAttribute("connection");
}
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
          HttpSession session = request.getSession(true);
         int id_user =  (int) session.getAttribute("id_user");
         
         String select_month = request.getParameter("month");
//         if(select_month == null){
//             select_month = "FEB";
//         }
          
              // get i_id from indenture

          int i_id = (int) session.getAttribute("i_id");
          
          // เอาเลขใบแจ้งหนี้มาจาก monthly_expense
          MonthExpense month = new MonthExpense();
          month.setConn(conn);
          month.setInvoice_id(i_id,select_month);
     
          int invoice = month.getInvoice_id();
          
          /// เอาค่าน้ำค่าไฟมาจาก detail
          month.setWater(invoice);
          float water = month.getWater();
          
          month.setFire(invoice);
          float fire = month.getFire();
          
          month.setPrice_area(i_id);
          float price_area = month.getPrice_area();
          
          float total = month.getTotal();
          
          session.setAttribute("fire", fire);
          session.setAttribute("water", water);
          session.setAttribute("total_month", total);
          session.setAttribute("price_area", price_area);
          
          response.sendRedirect("viewPay_monthly.jsp");
//out.print(select_month);
          
          
        } catch (SQLException ex) {
        Logger.getLogger(viewMonth.class.getName()).log(Level.SEVERE, null, ex);
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
