/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

/**
 * Web application lifecycle listener.
 *
 * @author asus
 */
public class Init implements ServletContextListener {

    private Connection conn;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            conn = getTest().getConnection();
            sce.getServletContext().setAttribute("connection", conn);
        } catch (SQLException ex) {
            Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            conn.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    private DataSource getTest() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/test");
    }

 

    
}
