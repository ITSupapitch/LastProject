<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="cus_header.html" %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Prompt" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/pay.css">
        <title>Profile User</title>
    </head>
    <body style="background-color: #ffffff;">
    <center>
        <h1>PAYMENT</h1><br>
    </center>
    <br>



    <!-- Here starts the navbar -->
    <!-- Navbar (sit on top) -->

    <div class="page">
        <center>
            <div class="dropdown bn3" style="float:left;">
                <button class="dropbtn">Booking/Rental Expense</button>
                <div class="dropdown-content">
                    <a href="Payment_book.jsp">Booking Expense</a>
                    <a href="Payment_rent.jsp">Rental Expense</a>
                </div>
            </div>
            <form action="Payment_monthly.jsp" method="POST">
                <button class="select_bn" >Monthly Expense</button>
            </form>
        </center>
    </div>
</body>
</html>
