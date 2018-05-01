<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@include  file="cus_header.html" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Prompt" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/pay_monthly.css">
        <title>Profile User</title>
    </head>
    <body style="background-color: #ffffff;">
    <center>
        <h1>PAYMENT</h1><br>
    </center>
    <br>



    <!-- Here starts the navbar -->
    <!-- Navbar (sit on top) -->

    <center>
        <div class="page">
            <center>
                <div class="dropdown bn3" style="float:left;">
                    <button class="dropbtn">Booking/Rental Expense</button>
                    <div class="dropdown-content">
                        <a href="Payment_book.jsp">Booking Expense</a>
                        <a href="Payment_rent.jsp">Rental Expense</a>
                    </div>
                </div>
                <form action="payMonth" method="POST">
                    <button class="select_bn" >Monthly Expense</button>

            </center>
                   <sql:query var="myMonth" dataSource="test" >
            select month from monthly_expense where i_id = "<%= session.getAttribute("i_id") %>"  and bank is null
        </sql:query> 

            <!-- Select month for view -->

        </div>
    </center>
    <div class="row">

            <b>Select Month</b>
<select name="month"> <c:forEach var="month" items="${myMonth.rows}">
                      <option value="${month.month}" >  ${month.month}   </option></center>
                </c:forEach> </select>
               <br> <input type="submit" value="Select" />
            <br><br>

            <b>Bank</b>
            <select name="bank">
                <option>BBL</option>
                <option>KBANK</option>
                <option>SCB</option>
            </select>
            <br><br>

            <b>Date</b>
            <input type="date" name="trans_date">
            <br><br>

            <b>Time</b>
            <input type="time" name="trans_time">
            <br><br>

            <b>Cost</b>
            <input type="text" name="amount" value="" size="10" />
            <br><br>

            <b>Bill</b>
            <br>
            <input type="file" name="trans_image" accept="image/gif, image/jpeg, image/png">
            <br><br>
            <center><input type="submit" value="Upload" /></center>
        </form>
    </div>
</body>
</html>
