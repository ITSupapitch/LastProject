<%-- 
    Document   : selectCusForFillBill
    Created on : Apr 28, 2018, 11:40:26 AM
    Author     : Suttida Sat
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

        &nbsp;<br><br><br><h1><center>Select customer for fill monthly expanse</center></h1><br> 

        <!-- table part -->
        <sql:query var="myCustomer" dataSource="test" >
            select account_id, firstname,lastname
 from account 
 join indenture 
using (account_id)
join payment
using (payment_id)
where type_contract_id = 2 and slip is not null and end_date > "<%= session.getAttribute("date_now") %>";
        </sql:query> 
        <form action="showBoxForFillBill" method="POST">   
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
            <center><input type="submit" value="FILL BILL" /></center></form>
    </body>
</html>
