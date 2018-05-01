<%-- 
    Document   : empSelectCusPayment
    Created on : Apr 27, 2018, 9:08:42 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@include  file="emp_header.html" %>
<!DOCTYPE html>
<html>
    <title> CUSTOMER INFORMATION PAGE </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link href="https://fonts.googleapis.com/css?family=Prompt" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/profile.css">

    <body>

        &nbsp;<br><br><br><h1><center>CUSTOMER Payment Record</center></h1><br> 

        <!-- table part -->
        <sql:query var="myCustomer" dataSource="test" >
            select * from customer join account using(account_id) join indenture using (account_id) group by account_id order by i_id;
        </sql:query> 
        <form action="CusHistoryPaymentDetails" method="POST">   
            <br><center><table border="1">
                    <thead>
                        <tr>
                            <th target="cus_id">Select</th>
                            <th>NAME.</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="each_customer" items="${myCustomer.rows}">
                            <tr>
                                <td><input type="radio"  name="account_id" value="${each_customer.account_id}"/></td>
                                <td> ${each_customer.firstname} ${each_customer.lastname} </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table></center>

            <!-- BUTTON PART -->
            <br>
            <center><input type="submit" value="VIEW RECORD" /></center></form>
    </body>
</html>
