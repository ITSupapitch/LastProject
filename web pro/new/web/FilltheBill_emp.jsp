<%-- 
    Document   : FilltheBill_emp
    Created on : Apr 28, 2018, 11:31:43 AM
    Author     : Suttida Sat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@include  file="emp_header.html" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Prompt" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/fill.css">
    </head>
    <body>
        <!-- Navbar (sit on top) -->
        <div class="w3-top">
            <div class="w3-bar w3-white w3-card" id="myNavbar">
<img src="pic/logo.png" width="35" height="30"/> </a>
                <!-- Right-sided navbar links -->
                <div class="w3-right w3-hide-small">
                    <a href="logout" class="w3-bar-item w3-button"><i class="fa fa-user-circle"></i>  LOGOUT</a>

                  

 <%-- Using Scriptlet--%>
            <% model.Account account = (model.Account) request.getAttribute("account_bill");%>
            <% model.MonthExpense chk = (model.MonthExpense) request.getAttribute("Bill");%>
                </div>
            </div>
        </div>
        <div>
            <br><br>
            <center>
                <h1>FILL THE COST</h1>
            </center><br>
            <form action="fillBill_emp" method="POST">
                <div class="sign">
                    <table border="1" width="50" cellpadding="30">
            <thead>
                <tr>
                    <th>Account ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Electric bill</th>
                    <th>Water bill</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="text" name="acc_id_cus" value="" readonly="readonly" disabled="disabled" placeholder= "<%= account.getAccount_id()%>"/></td>
                    <td><input type="text" name="fname1" value="" readonly="readonly" disabled="disabled" placeholder= "<%= account.getFirstname()%>"/></td>
                    <td><input type="text" name="lname1" value="" readonly="readonly" disabled="disabled" placeholder= "<%= account.getLastname()%>"/></td>
                    <td><input type="text" name="e1" value="" placeholder= "<%= chk.getFire()%>" /> </td>
                    <td><input type="text" name="w1" value="" placeholder= "<%= chk.getWater()%>"/> </td>
                </tr>
            </tbody>
        </table>
                </div>
                <br>
                <center><input type="submit" value="Confirm" name="Confirm" /></center>
            </form>  
            
          
        </div>
    </body>
</html>
