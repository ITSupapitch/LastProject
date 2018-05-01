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
import model.Address;
import model.Contract;
import model.Place;

/**
 *
 * @author asus
 */
@WebServlet(name = "CusListDetailsServlet", urlPatterns = {"/CusListDetailsServlet"})
public class CusListDetailsServlet extends HttpServlet {

    private Connection conn;

    public void init() {
        conn = (Connection) getServletContext().getAttribute("connection");
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String cus_account_id = request.getParameter("account_id");
            int view_account_id = Integer.parseInt(cus_account_id);

            // check user click
            Statement stmt = conn.createStatement();

            // start sql1 account & address
            String sql1 = "SELECT * From account join customer using (account_id) where account_id =" + view_account_id;
            ResultSet rs1 = stmt.executeQuery(sql1);
            rs1.next();

            Account account = new Account();
            account.setAccount_id(view_account_id);
            account.setFullname(rs1.getString("firstname"), rs1.getString("lastname"));
            account.setPhone(rs1.getString("phone"));
            account.setGender(rs1.getString("gender"));
            request.setAttribute("cus_account_info", account);

            Address address = new Address();
            address.setBan(rs1.getString("ban"));
            address.setSoi(rs1.getString("soi"));
            address.setDistrict(rs1.getString("district"));
            address.setArea(rs1.getString("area"));
            address.setCounty(rs1.getString("county"));
            address.setCode(rs1.getString("code"));
            request.setAttribute("cus_address_info", address);
            //end sql 1

            //stat sql2 find indenture
            String sql2 = "SELECT * From customer join indenture using (account_id)  where i_id = \n" +
"(\n" +
"select max(i_id)\n" +
"from indenture\n" +
"where account_id = "  + view_account_id +"\n" +
")";
            ResultSet rs2 = stmt.executeQuery(sql2);
            rs2.next();

            int i_id = rs2.getInt("i_id");

            Contract contract = new Contract();
            contract.setContractID(rs2.getInt("i_id"));
            contract.setStartDate(rs2.getDate("start_date"));
            contract.setEndDate(rs2.getDate("end_date"));
            // end sql2 

          //start sql3 find place at this indenture
            String sql3 = "SELECT * From indenture join inden_area using (i_id)"
                    + "join area using (area_id) where i_id = " + i_id;
            ResultSet rs3 = stmt.executeQuery(sql3);
            rs3.next();


            Place place = new Place();
            place.setPlaceID(rs3.getInt("area_id"));
            place.setPlace_name(rs3.getString("area_name"));
            place.setType(rs3.getString("area_type"));
            request.setAttribute("cus_place_info", place);
            // end sql3

            // start sql4 find type of contract at current time
            String sql4 = "SELECT * From indenture join payment using (payment_id) "
                    + "join payment_detail using (type_contract_id) where i_id = "
                    + "(select max(i_id) from indenture where account_id = " + view_account_id + ")";
            ResultSet rs4 = stmt.executeQuery(sql4);
            rs4.next();

            contract.setType(rs4.getString("name_type"));
            request.setAttribute("cus_contract_info", contract);
            // end sql4

            HttpSession session = request.getSession();
            String account_type = (String) session.getAttribute("account_type");
            
            if (account_type.equals("employee")) {

                RequestDispatcher dp = request.getRequestDispatcher("infoCustomer_emp.jsp");
                dp.forward(request, response);
            } else { //else if account_type is boss
                RequestDispatcher dp = request.getRequestDispatcher("infoCustomer_boss.jsp");
                dp.forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CusListDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
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
