/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Suttida Sat
 */
public class statusArea {

    List<Integer> id_area;
    private Connection conn;
    public statusArea() {
    }

    public List<Integer> getId_area() {
        return id_area;
    }

    public void setId_area(String now) throws SQLException {
        Statement stmt = conn.createStatement();
            String sql_id_area = "update area set status  = 'enable'\n" +
"where area_id not in (\n" +
"                            SELECT area_id FROM  inden_area JOIN indenture USING (i_id)\n" +
"                            where end_date > '"+now+"'" +
"                               );" ;
            ResultSet rs = stmt.executeQuery(sql_id_area);
            List<Integer> id =  new ArrayList<>();
            while(rs.next()){
                 id.add(rs.getInt("area_id"));
            }
            this.id_area = id;
    }



    
        public void setStatus_area(String now) throws SQLException {
        
                    Statement stmt = conn.createStatement();
            String sql_id_area = "UPDATE area SET status  = 'enable' WHERE area_id NOT IN (\n" +
"                            SELECT area_id FROM  inden_area JOIN indenture USING (i_id)\n" +
"                            WHERE end_date > +'"+now+"');" ;
            stmt.executeUpdate(sql_id_area);
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
}
