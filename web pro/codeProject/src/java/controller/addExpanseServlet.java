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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Login;
import model.MonthExpense;

/**
 *
 * @author Suttida Sat
 */
@WebServlet(name = "addExpanseServlet", urlPatterns = {"/addExpanseServlet"})
public class addExpanseServlet extends HttpServlet {
    
    
    private Connection conn;
    
    public void init(){
        conn = (Connection) getServletContext().getAttribute("connection");
    }

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            request.setCharacterEncoding("UTF-8");
            
            float water = Float.parseFloat(request.getParameter("water"));
             float fire = Float.parseFloat(request.getParameter("fire"));
           
             int i_id = 0;
             int invoice_id = 0;
             
            String month = "april";
             
            HttpSession session = request.getSession(true);
             int account_id =  (int) session.getAttribute("account_id");
             Statement stmt = conn.createStatement();
             
             ///  1.  select i_id  from  indenture for add to i_id in monthly_expense table
             
            String query1 = "SELECT i_id FROM indenture WHERE account_id  ='"+account_id+"'";
            ResultSet rs1 = stmt.executeQuery(query1);
            while (rs1.next()){
                i_id = rs1.getInt("i_id");
                  }
            
            /// 2  cal all price of area that your rent
            
            float price_area = 0;
            String query_area = "SELECT price FROM inden_area WHERE i_id   ='"+i_id+"'";
            ResultSet rs_area = stmt.executeQuery(query_area);
            while (rs_area.next()){
                price_area += rs_area.getFloat("price");
                  }
            
            float total = water+fire+price_area;
            
            /// Check เผื่อมีข้อมูลอยู่แล้ว
            String query_check = "SELECT month FROM monthly_expense WHERE i_id   ='"+i_id+"'"+"AND month = '"+month+"'";
            ResultSet chk_month = stmt.executeQuery(query_check);

            /// if chk_month not empty
                if (chk_month.next()){
                    /// ถ้าเคยมีข้อมูลแล้วก็อัพเดทเอา
                    String updateWater = "UPDATE detail SET price = '"+water+"'" + "WHERE type_id = 2" ;
                    stmt.executeUpdate(updateWater);
                    
                    String updateFire = "UPDATE detail SET price = '"+fire+"'" + "WHERE type_id = 3" ;
                    stmt.executeUpdate(updateFire);
                    
                    ///update total
                    String updateTotal = "UPDATE monthly_expense SET total = '"+total+"'" + "WHERE i_id   ='"+i_id+"'";
                    stmt.executeUpdate(updateTotal);

                }else{
                    ///add
                     /// 3. add  i_id & total & month in monthly_expense table
            
            String in_sert = "INSERT INTO monthly_expense (total , month , i_id) VALUES('"+total+"' , '"+month+"','"+i_id+"')" ;
            stmt.executeUpdate(in_sert);
            
            ///4. select invoice_id   from  monthly_expense for add to invoice_id  in detail table
            String query_invoice_id = "SELECT invoice_id , month FROM monthly_expense WHERE i_id  = '"+i_id+"'";
            ResultSet rs2 = stmt.executeQuery(query_invoice_id);
            while (rs2.next()){
                if(rs2.getString("month").equals(month))
                          invoice_id = rs2.getInt("invoice_id");
                  }
            
            /// 5. add invoice_id & water & fire  in detail table
            
            String insert_water = "INSERT INTO detail (price , invoice_id , type_id ) VALUES('"+water+"' , '"+invoice_id+"',2)" ;
            stmt.executeUpdate(insert_water);
            
            String insert_fire = "INSERT INTO detail (price , invoice_id , type_id ) VALUES('"+fire+"' , '"+invoice_id+"',3)" ;
            stmt.executeUpdate(insert_fire);
                }

            
            RequestDispatcher obj = request.getRequestDispatcher("select_customer.jsp");
            obj.forward(request, response);
            
            MonthExpense add = new MonthExpense() ;
            add.setConn(conn);
            
        } catch (SQLException ex) {
            Logger.getLogger(addExpanseServlet.class.getName()).log(Level.SEVERE, null, ex);
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
