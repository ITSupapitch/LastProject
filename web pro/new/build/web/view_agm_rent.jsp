<%-- 
    Document   : view_agm_rent
    Created on : Apr 29, 2018, 4:51:20 AM
    Author     : Suttida Sat
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Date"%>
<%@page import="model.DateExample"%>
<%@page import="model.Agreement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@include  file="cus_header.html" %>
<!DOCTYPE html>
<html>
    <head>
        <title>AGREEMENT PAGE</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Prompt" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/agree.css">
    </head>
    <body>
        <%-- Using Scriptlet--%>
        <% model.Account acc = (model.Account) request.getAttribute("fullname");%>
        <% model.Agreement agm = (model.Agreement) session.getAttribute("Agreement");%>
        <br>
    <center><h1> RENT AGREEMENT </h1></center><br>

    <div class="sign">
        <br>
        <center>
            Name <input type="text" name="lname" value="" readonly="readonly" disabled="disabled" placeholder="<%out.println(session.getAttribute("fullname"));%>"/><br>
            Place number <input type="text" name="category" value="" readonly="readonly" disabled="disabled" placeholder="<%= agm.getPlace_number()%>"/><br>
            Category <input type="text" name="amount" value="" readonly="readonly" disabled="disabled" placeholder="<%= agm.getPlace_type()%>"/><br>
            Cost <input type="text" name="cost" value="" readonly="readonly" disabled="disabled" placeholder="<%= agm.getCost()%>"/><br>
            Total of rent cost<input type="text" name="rentdate" value="" readonly="readonly" disabled="disabled" placeholder="<%= agm.getTotal_rent()%>"/><br>
            Rent Date <input type="text" name="rentdate" value="" readonly="readonly" disabled="disabled" placeholder="<%= agm.getStart_date()%>"/><br>
            Expired Date <input type="text" name="expd" value="" readonly="readonly" disabled="disabled" placeholder="<%= agm.getEnd_date()%>"/><br>
            Status Payment <input type="text" name="expd" value="" readonly="readonly" disabled="disabled" placeholder="<%= agm.getStatus_payment_rent()%>"/></center>


    </div>

</div>
<form action="view_agm_rent.jsp" method="POST">
    <center> <input type="submit" value="Renew a contract" name="btnRenew"/></center>
</form>
<%-- 
<%
    String check = request.getParameter("btnRenew");

    if (check != null) {
        Connection conn;
        conn = (Connection) getServletContext().getAttribute("connection");

        int i_id = (int) request.getSession().getAttribute("i_id");

        Agreement agmt = new Agreement();
        agmt.setConn(conn);
        agmt.setPayment_id_Rent(i_id);
        agmt.setE_date(i_id);
        Date e = agmt.getE_date();
        ///get date now
        DateExample dat = new DateExample();
        boolean chk = dat.chkFor_renew(e);

        if (chk) {
            RequestDispatcher dp = request.getRequestDispatcher("renew_cont");
            dp.forward(request, response);
        } else {
            out.println("<center>" + "Sorry is not time to renew" + "</center>");
        }
    }
%>
--%>

</body>
</html>
