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
import model.Contract;
import model.IndenArea;
import model.Payment;
import model.Place;
import model.forDate;

/**
 *
 * @author asus
 */
@WebServlet(name = "BookingRentConfirmServlet", urlPatterns = {"/BookingRentConfirmServlet"})
public class BookingRentConfirmServlet extends HttpServlet {

    private Connection conn;

    public void init() {
        conn = (Connection) getServletContext().getAttribute("connection");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            String type_contract_name = (String) session.getAttribute("type_contract_name");
                
            if (type_contract_name.equals("Rent")) {

                Payment payment = (Payment) session.getAttribute("rentPayment");
                payment.setConn(conn);
                payment.addPayment();
//        
                Place place = (Place) session.getAttribute("rentPlace");
                place.setConn(conn);
                place.updateStatusPlace();

                Contract contract = (Contract) session.getAttribute("rentContract");
                contract.setConn(conn);
                contract.setPayment_id(payment.getPaymentID());
                contract.addContract();

                IndenArea indenArea = new IndenArea(conn);
                indenArea.setArea_id(place.getPlaceID());
                indenArea.setPrice(place.getPrice());
                indenArea.setContrct_id(contract.getContractID());
                indenArea.addIndenArea();
            } else if (type_contract_name.equals("Book")) {
                
                Payment payment = (Payment) session.getAttribute("payment");
                payment.setConn(conn);
                payment.addPayment();
//        
                Place place = (Place) session.getAttribute("place");
                place.setConn(conn);
                place.updateStatusPlace();

                Contract contract = (Contract) session.getAttribute("contract");
                contract.setConn(conn);
                contract.setPayment_id(payment.getPaymentID());
                contract.addContract();

                IndenArea indenArea = new IndenArea(conn);
                indenArea.setArea_id(place.getPlaceID());
                indenArea.setPrice(place.getPrice());
                indenArea.setContrct_id(contract.getContractID());
                indenArea.addIndenArea();
            }

            forDate dat = new forDate();
            dat.setDay();
            dat.setMonth();
            dat.setStr_monthForComp();
            dat.setYear();
            dat.setStr_dayForComp();
            dat.setStr_date();

            String now = dat.getStr_date();
            int id_user = (int) session.getAttribute("id_user");
            Contract contract = new Contract(conn);

            int i_id = contract.getContractID(id_user, now);
            session.setAttribute("i_id", i_id);
//            
            response.sendRedirect("successPayment.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(BookingRentConfirmServlet.class.getName()).log(Level.SEVERE, null, ex);
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
