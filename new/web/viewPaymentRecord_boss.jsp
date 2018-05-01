<%-- 
    Document   : viewPaymentRecord_boss
    Created on : Apr 27, 2018, 6:38:11 PM
    Author     : asus
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
    <title> PAYMENT RECORD PAGE </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/viewPaymentRecord.css">
    <body>
        <!-- Navbar (sit on top) -->
        <div class="w3-top">
            <div class="w3-bar w3-white w3-card" id="myNavbar">
                <a href="home2.jsp" class="w3-bar-item w3-button w3-wide"><img src="pic/logo.png" width="35" height="30"/> </a>
                <!-- Right-sided navbar links -->
                <div class="w3-right w3-hide-small">
                    <a href="home2.jsp" class="w3-bar-item w3-button"><i class="fa fa-home"></i>  HOME</a>
                    <a href="logout" class="w3-bar-item w3-button"><i class="fa fa-user-circle"></i>  LOGOUT</a>

                    <!--side menu -->
                    <nav class="side-menu">
                        <ul>
                            <li><a href="#">PROFILE<span><i class="fa fa-user-circle" style="font-size:30px" ></i></span></a></li>
                            <li><a href="#">DASHBOARD<span><i class="fa fa-pie-chart" style="font-size:30px"></i></span></a></li>
                            <li><a href="#">CUSTOMER INFO.<span><i class="fa fa-id-card-o" style="font-size:30px"></i></span></a></li>
                            <li><a href="#">PAYMENT RECORD<span><i class="fa fa-credit-card" style="font-size:30px"></i></span></a></li>
                            <li><a href="#">EDIT TERM<span><i class="fa fa-edit" style="font-size:30px"></i></span></a></li></ul>
                    </nav>
                </div>
            </div>
        </div>

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
                    <th>Month</th>
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
            
            <a href="bossSelectCusPayment.jsp"> <input type="submit" target="back" value="BACK"></a></center>
</body>

</html>