<%-- 
    Document   : viewPaymentRecord_emp
    Created on : Apr 27, 2018, 9:50:14 PM
    Author     : asus
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@include  file="emp_header.html" %>
<html>
    <title> PAYMENT RECORD PAGE </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href="https://fonts.googleapis.com/css?family=Prompt" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/profile.css">
    <body>

        &nbsp;<br><br><br><h1><center>PAYMENT RECORD</center></h1><br> 
 <%
            int view_account_id = (Integer) request.getAttribute("view_account_id");

            Connection conn;
            conn = (Connection) getServletContext().getAttribute("connection");

            Statement stmt = conn.createStatement();
            String sql = "SELECT * From customer join indenture using (account_id) join monthly_expense using (i_id) where account_id =" + view_account_id;
            ResultSet rs = stmt.executeQuery(sql);

        %>

        <!-- table part -->

    <br><center><table border="1">
            <thead>
                <tr>
                    <th target="cus_id">Month</th>
                    <th>AMOUNT</th>
                    <th>STATUS</th>
                </tr>
            </thead>
            <tbody>
                <%                   while (rs.next()) {
                        out.print("<tr>");
                        out.print("<td>");
                        out.print(rs.getString("month"));
                        out.print("</td>");

                        out.print("<td>");
                        out.print(rs.getString("total"));
                        out.print("</td>");

                        out.print("<td>");

                        String status = "";
                        if (rs.getString("slip") != null) {
                            status = "Complete";
                        } else {
                            status = "Incomplete";
                        }

                        out.print(status);
                        out.print("</td>");
                        out.print("</tr>");
                    }
                %>
            </tbody>
        </table></center>

    <!-- back button -->
    <br><center>

        <a href="empSelectCusPayment.jsp"> <input type="submit" target="back" value="BACK"></a></center>
</body>
</html>
