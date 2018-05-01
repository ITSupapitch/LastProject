/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;


import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author LAB207_36
 */
public class RegisAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       
        RegisActionForm rgForm = (RegisActionForm) form;
        String username = rgForm.getUsername();
         String  password = rgForm.getPassword();

         String  firstname = rgForm.getFirstname();
         String lastname = rgForm.getLastname();
         String phone = rgForm.getPhone();
         String gender = rgForm.getGender();
         String account_type = rgForm.getAccount_type();

         String ban = rgForm.getBan();
         String  soi = rgForm.getSoi();
         String  district = rgForm.getDistrict();
         String area = rgForm.getArea();
         String county = rgForm.getCountry();
         String code = rgForm.getCode();
         int account_id = 0;


        try {
            ServletContext context = getServlet().getServletContext();
            Connection conn = (Connection) context.getAttribute("connection");

            Statement stmt = conn.createStatement();

            String sql_account = "INSERT INTO account (username, password, firstname, lastname, phone, account_type) VALUES('"+username+"','"+password+"','"+firstname+"','"+lastname+"','"+phone+"','"+account_type+"')" ;
            stmt.executeUpdate(sql_account);  
            
            String sql_accountID = "SELECT  account_id FROM account WHERE username = '"+username+"'" + "AND password = '"+password+"'" ;
            ResultSet rs = stmt.executeQuery(sql_accountID);
            
            while(rs.next()){
                account_id = rs.getInt("account_id");
            }
            
             String sql_address = "INSERT INTO customer (account_id  , ban, soi, district , area , county , code,gender) VALUES('"+account_id +"', '"+ban+"','"+soi+"','"+district+"','"+area+"','"+county+"','"+code+"','"+gender+"')" ;
            stmt.executeUpdate(sql_address);  
            return mapping.findForward(SUCCESS);

        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        return null;
    }
}
