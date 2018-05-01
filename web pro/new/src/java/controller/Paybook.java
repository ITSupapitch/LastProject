/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
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
import javax.servlet.http.Part;
import model.Payment;

/**
 *
 * @author Suttida Sat
 */
@WebServlet(name = "Paybook", urlPatterns = {"/Paybook"})
public class Paybook extends HttpServlet {

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
            int i_id = (int) session.getAttribute("i_id");
            
            String bank = request.getParameter("bank");
            String date = request.getParameter("trans_date");
            String time = request.getParameter("trans_time");
//            Part filepart = request.getPart("trans_image");
            String pic_s = request.getParameter("trans_image");
            
            
//            InputStream inp = filepart.getInputStream();
            
            Payment pay = new Payment();
            pay.setConn(conn);
//            pay.setFilePart(inp);
            
//            pay.setPicInput(inp);
            pay.setBank(bank);
            pay.setDate_time(date+" "+time);
                        pay.setPaymentIDForpic(i_id);
            pay.setPic();

//            out.println(pay.getDate_time());
//            out.println(date+" "+time);

            pay.addPayBook();
            
            response.sendRedirect("successPayment.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(Paybook.class.getName()).log(Level.SEVERE, null, ex);
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
