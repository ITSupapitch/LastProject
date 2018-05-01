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
        <link rel="stylesheet" type="text/css" href="css/viewPay_monthly.css">
<link rel="stylesheet" type="text/css" href="css/pay.css">
    </head>
    <body>
            <!-- select type of payment -->
            
    <center>  <h1>MONTHLY EXPENSE</h1></center><br>

        <!-- table of customer info. -->
         <sql:query var="myMonth" dataSource="test" >
            select month from monthly_expense where i_id = "<%= session.getAttribute("i_id") %>" 
        </sql:query> 

            <!-- Select month for view -->
        <form action="viewMonth" method="POST">
            
           <center><h2 style="float:left;">  Select Month : </h2><select name="month"> <c:forEach var="month" items="${myMonth.rows}">
                      <option value="${month.month}" >  ${month.month}   </option></center>
                </c:forEach> </select>
               <br> <input type="submit" value="Select" />
        </form>
                
            
         <sql:query var="myPlace" dataSource="test" >
            select area_id ,area_type 
            from area
            join inden_area
            using (area_id)
            join indenture
            using (i_id)
            where i_id = "<%= session.getAttribute("i_id") %>"
         </sql:query> <br><br>
        <div class="content1 w3-container">
            <table class="cusinfo">
                <tr>
                    <th> ID </th>
                    <th> USERNAME </th>
                    <th> AREA NO. </th>
                    <th> ZONE </th>

                </tr>
                <c:forEach var="place" items="${myPlace.rows}">
                <tr height="60px">
                   
                    
                    <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<%out.println(session.getAttribute("id_user"));%></td>
                    <td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<%out.println(session.getAttribute("username"));%></td>
                    <td>&nbsp&nbsp&nbsp&nbsp${place.area_id}</td>
                    <td>&nbsp&nbsp&nbsp&nbsp${place.area_type }</td>
                </tr>
                </c:forEach> 
            </table>
        </div>

            <!-- table of payment -->
            
            <div>
            <table class="paytable">
                <tr>
                    <th> EXPENSES </th>
                    <th> AMOUNT </th>

                </tr>
                <tr>
                    <td>Water Supply</td>
                    <td> <%out.println(session.getAttribute("water"));%> </td>

                </tr>
                <tr>
                    <td>Electricity Charge</td>
                    <td> <%out.println(session.getAttribute("fire"));%> </td>

                </tr>
                <tr>
                    <td>Rental Fee</td>
                     <td> <%out.println(session.getAttribute("price_area"));%> </td>

                </tr>
                <tr class="total_c">
                    <th>TOTAL</th>
                    <td> <%out.println(session.getAttribute("total_month"));%> </td>
                </tr>
            </table>
        </div>

        
    </body>
</html>