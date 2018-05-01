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
import model.Contract;
import model.MonthExpense;
import model.forDate;

/**
 *
 * @author Suttida Sat
 */
@WebServlet(name = "showBoxForFillBill", urlPatterns = {"/showBoxForFillBill"})
public class showBoxForFillBill extends HttpServlet {

  private Connection conn;

    public void init() {
        conn = (Connection) getServletContext().getAttribute("connection");
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            int account_id = Integer.parseInt(request.getParameter("account_id"));
            HttpSession session = request.getSession(true);
            session.setAttribute("select_cus_for_bill", account_id);
            
            forDate date = new forDate();
            date.setMonth();
            int int_m = date.getMonth();
            date.setStr_monthForbill(int_m);
            String month = date.getStr_monthForbill();
            
            /// ชื่อ นามสกุลลูกค้าไปแสดงหน้ากรอกรายเดือนด้วย
            Account account = new Account();
            account.setConn(conn);
            account.setAccount_id(account_id);
            account.setFirstname(account_id);
            account.setLastname(account_id);

            request.setAttribute("account_bill", account);
            
            ///เอาเงินที่กรอกแล้วไปแสดงด้วย ถ้ายังไม่มีก้อไม่ต้องแสดง
            
            //เอาเลขสัญญาลูกค้ามาก่อน
            Contract cont = new Contract(conn);
            int i_id = cont.getContractID(account_id);
            
            
            MonthExpense chk = new MonthExpense();
            chk.setConn(conn);
            chk.setInvoice_id(i_id,month);
            int invoice_id = chk.getInvoice_id();
            chk.setFire(invoice_id);
            chk.setWater(invoice_id);
            request.setAttribute("Bill", chk);
            
//            out.print(month);
            RequestDispatcher dp = request.getRequestDispatcher("FilltheBill_emp.jsp");
                dp.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(showBoxForFillBill.class.getName()).log(Level.SEVERE, null, ex);
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
