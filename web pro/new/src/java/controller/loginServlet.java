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
import model.Login;
import model.forDate;

/**
 *
 * @author Suttida Sat
 */
@WebServlet(urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

    private Connection conn;

    public void init() {
        conn = (Connection) getServletContext().getAttribute("connection");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /// encode character can read thai 
            request.setCharacterEncoding("UTF-8");

            HttpSession session = request.getSession(true);

            String username = request.getParameter("name");
            String psw = request.getParameter("pass");
            int id_user = 0;

//           out.println(username + " " + psw);
            Login user = new Login();
            user.setConn(conn);
            boolean chk = user.checkLogin(username, psw);

            ///get firstname lastname
            Account account = new Account();
            account.setConn(conn);

            account.setAccount_id(username, psw);
            id_user = account.getAccount_id();

            account.setAccount_type(id_user);
            String account_type = account.getAccount_type();

            
                        forDate dat = new forDate();
            dat.setDay();
            dat.setMonth();
            dat.setStr_monthForComp();
            dat.setYear();
            dat.setStr_dayForComp();
            dat.setStr_date();
            
            String now = dat.getStr_date();
            
            Contract contract = new Contract(conn);

            int i_id = contract.getContractID(id_user,now);
            session.setAttribute("i_id", i_id);

//            account.setFirstname(id_user);
//            String fname = account.getFirstname();
//            
//            account.setLastname(id_user);
//            String lname = account.getLastname();
//            
            session.setAttribute("id_user", id_user);
            session.setAttribute("username", username);
            session.setAttribute("account_type", account_type);
//             session.setAttribute("fname", fname);
//             session.setAttribute("lname", lname);

            if (chk) {
                
 

                if (account_type.equals("customer")) {
                    Statement stmt = conn.createStatement();
                    String sql1 = "SELECT * From account WHERE account_id = " + id_user;
                    ResultSet rs1 = stmt.executeQuery(sql1);
                    rs1.next();

                    account.setAccount_id(id_user);
                    account.setUsername(rs1.getString("username"));
                    account.setFullname(rs1.getString("firstname"), rs1.getString("lastname"));
                    account.setPhone(rs1.getString("phone"));

                    String sql2 = "SELECT * From customer WHERE account_id = " + id_user;
                    ResultSet rs2 = stmt.executeQuery(sql2);
                    rs2.next();

                    account.setGender(rs2.getString("gender"));
                    session.setAttribute("account_info", account);

                    Address address = new Address();
                    address.setBan(rs2.getString("ban"));
                    address.setDistrict(rs2.getString("district"));
                    address.setArea(rs2.getString("area"));
                    address.setCounty(rs2.getString("county"));
                    address.setCode(rs2.getString("code"));

                    if (rs2.getString("soi") == null) {
                        address.setSoi(" ");
                    } else {
                        address.setSoi(rs2.getString("soi"));
                    }

                    session.setAttribute("address_info", address);
                } else {
                    Statement stmt = conn.createStatement();
                    String sql1 = "SELECT * From account WHERE account_id = " + id_user;
                    ResultSet rs1 = stmt.executeQuery(sql1);
                    rs1.next();

                    account.setAccount_id(id_user);
                    account.setUsername(rs1.getString("username"));
                    account.setFullname(rs1.getString("firstname"), rs1.getString("lastname"));
                    account.setPhone(rs1.getString("phone"));
                    account.setAccount_type(rs1.getString("account_type"));
                    session.setAttribute("account_info", account);

                }

                request.setAttribute("account_type", account_type);
                if(account_type.equals("customer")){
                                   response.sendRedirect("home2.jsp");
                }
 
                if(account_type.equals("boss")){
                                        response.sendRedirect("profile_boss.jsp");
                }

                if(account_type.equals("employee")){
                                     response.sendRedirect("profile_emp.jsp");
                }
   

            } else {

                RequestDispatcher rs = request.getRequestDispatcher("loginFail.html");
                rs.include(request, response);

            }

        } catch (SQLException ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
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
