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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AddBill;
import model.Contract;
import model.MonthExpense;
import model.forDate;

/**
 *
 * @author Suttida Sat
 */
@WebServlet(name = "fillBill_emp", urlPatterns = {"/fillBill_emp"})
public class fillBill_emp extends HttpServlet {

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
            int account_id = (int) session.getAttribute("select_cus_for_bill");
            float water = Float.parseFloat(request.getParameter("w1"));
             float fire = Float.parseFloat(request.getParameter("e1"));
            
              forDate date = new forDate();
            date.setMonth();
            int int_m = date.getMonth();
            date.setStr_monthForbill(int_m);
            String month = date.getStr_monthForbill();
             
             //เอาเลขสัญญาลูกค้ามาก่อน
            Contract cont = new Contract(conn);
            int i_id = cont.getContractID(account_id);
            
            
             /// Check เผื่อมีข้อมูลอยู่แล้ว
             
             AddBill add = new AddBill();
             add.setConn(conn);
             add.setCkeckMonth(i_id,month);
             
             add.setPrice_area(i_id);
                 add.setFire(fire);
                 add.setWater(water);
                 add.setTotal();
             
             //ถ้ามีก็อัปเดต
             if(add.isCkeckMonth()){
                 add.setInvoice_id(i_id,month);
                 add.updateTotalMonth();
                 add.updateBillMonth();
             }
             // ไม่มีก็ insert
             else{
              add.addTotalMonth(month,i_id);
              add.setInvoice_id(i_id,month);
              add.addBillMonth();
             }

             
            response.sendRedirect("successFillBill.jsp");
                  
            
        } catch (SQLException ex) {
           Logger.getLogger(fillBill_emp.class.getName()).log(Level.SEVERE, null, ex);
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
