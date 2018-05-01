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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Announce;
import model.Contract;
import model.DateExample;
import model.Payment;
import model.Place;

/**
 *
 * @author asus
 */
@WebServlet(name = "ProcessSelectionArea", urlPatterns = {"/ProcessSelectionArea"})
public class ProcessSelectionArea extends HttpServlet {

    Connection conn;

    public void init() {
        conn = (Connection) getServletContext().getAttribute("connection");
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();
            String S_area_id = request.getParameter("area_id");
            int area_id = Integer.parseInt(S_area_id);
         

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM area where area_id = " + area_id;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();

            Place place = new Place();
            place.setConn(conn);
            place.setPlaceID(area_id);
            place.setPlace_name(rs.getString("area_name"));
            place.setType(rs.getString("area_type"));
            place.setPrice(rs.getFloat("price"));
            place.setStatus(rs.getString("status"));
            session.setAttribute("place", place);
            
            DateExample dt = new DateExample();
            dt.bookDate();

            Date start_date = Date.valueOf(dt.getDue_date());
            Date end_date = Date.valueOf(dt.getNext_date());
  
            Account account = (Account) session.getAttribute("account_info");
            
            Contract contract = new Contract();
            contract.setStartDate(start_date);
            contract.setEndDate(end_date);
            contract.setAccount_id(account.getAccount_id());
            session.setAttribute("contract", contract);
            
            Payment payment = new Payment();
            payment.setConn(conn);
            payment.setPriceBook(rs.getFloat("price"));
            payment.setType_contract_id(1);
            session.setAttribute("payment", payment);

            //find announce
            Announce announce = new Announce();
            announce.setConn(conn);
            announce.setInformation("Book");
            session.setAttribute("announce_details", announce);
            
            session.setAttribute("type_contract_name", "Book");
            RequestDispatcher pg = request.getRequestDispatcher("agreement_book.jsp");
            pg.forward(request, response);
            
  
        }catch (SQLException ex) {
            Logger.getLogger(ProcessSelectionArea.class.getName()).log(Level.SEVERE, null, ex);
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
