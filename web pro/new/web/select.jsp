<%-- 
    Document   : viewPay_monthly
    Created on : Apr 22, 2018, 4:26:22 PM
    Author     : Suttida Sat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@include  file="cus_header.html" %>
<!DOCTYPE html>
<html>
    <head>
        <title> View Payment PAGE </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Prompt" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" type="text/css" href="css/pay_select.css">
    </head>
    <body>
         
            <!-- select type of payment -->


       <br><br><br><br><br><br><br>

        

              <!-- Select month for view -->
              <sql:query var="myMonth" dataSource="test" >
            select month from monthly_expense where i_id = "<%= session.getAttribute("i_id") %>"
        </sql:query> 
            
              <c:choose>
        <c:when test="${myMonth.rowCount == 0}">
           <!--/  /* No results */ -->
           <jsp:forward page="donthave.jsp"></jsp:forward>
        </c:when>
        <c:otherwise>
             <!--/* do what ever you want with the results */ -->
             <form action="viewMonth" method="POST">
            
            <center><h2 style="float:left;">  Select Month : </h2><select name="month"> <c:forEach var="month" items="${myMonth.rows}">
                    <option value="${month.month}" >  ${month.month}   </option>
                    </c:forEach> </select> <br><br><input type="submit" value="Select" />
        </form></center>
        </c:otherwise>
    </c:choose>
      
       

    </body>
</html>