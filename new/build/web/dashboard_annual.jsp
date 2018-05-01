<%-- 
    Document   : dashboard_annual
    Created on : Apr 27, 2018, 12:05:28 AM
    Author     : asus
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<%@include  file="boss_header.html" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ANNUAL DASHBOARD PAGE</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Prompt" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/dashboard.css">

    </head>
    <body>

<br><br><br>  <center><h1>ANNUAL DASHBOARD</h1></center>

<form action="ViewDashBoardServlet" method="POST">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="area" name="btn" /> <input type="submit" value="Annual Dashboard" name="btn"/>
</form>
        <br><br>

        <!--    Graph Pictures1 rent/book real price -->

        <sql:query var="myMoney" dataSource="test" >
            select month(tranfer_date_time) 'month',  sum(price_book) 'book_price' , sum(price_rent) 'rent_price',sum(price_book)+ sum(price_rent) 'total'
            from payment
            join indenture
            using (payment_id)
            join monthly_expense
            using (i_id )
            join inden_area
            using (i_id)
            where tranfer_date_time like '<% String year1 = request.getParameter("year");%>%'
            group by  month(tranfer_date_time);
        </sql:query> 


        <table  border="1" align="center"> 
            <thead>
                <tr>
                    <th>Month</th>
                    <th>Book price per Month</th>
                    <th>Rent price per Month</th>
                    <th>Total per Month</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="each_month" items="${myMoney.rows}">
                    <tr>

                        <td>${each_month.month}</td>

                        <td> 
                            ${each_month.book_price} 
                        </td>

                        <td>${each_month.rent_price}</td>

                        <td> 
                            ${each_month.total} 
                        </td>

                    </tr> 
                </c:forEach> 

                <sql:query var="myMoney" dataSource="test" >
                    select  sum(price_book) 'book_price' , sum(price_rent) 'rent_price',sum(price_book)+ sum(price_rent) 'total'
                    from payment
                    join indenture
                    using (payment_id)
                    join monthly_expense
                    using (i_id )
                    join inden_area
                    using (i_id)
                    where tranfer_date_time like '<% String year2 = request.getParameter("year");%>%'
                </sql:query>

                <c:forEach var="each_month" items="${myMoney.rows}">
                    <tr>

                        <td>TOTAL</td>

                        <td> 
                            ${each_month.book_price} 
                        </td>

                        <td>${each_month.rent_price}</td>

                        <td> 
                            ${each_month.total} 
                        </td>

                    </tr> 
                </c:forEach> 
            </tbody>
        </table>

            
            <br><br><br>
        <!--    Graph Pictures1 rent/book monthly expense -->

        <sql:query var="myMoney" dataSource="test" >
            SELECT month(date_time_pay) 'month', sum(total) 'total' FROM monthly_expense
            where slip is not null
            and date_time_pay like '<% String year3 = request.getParameter("year");%>%'
            group by month(date_time_pay)
        </sql:query> 


        <table  border="1" align="center"> 
            <thead>
                <tr>
                    <th>Month</th>
                    <th>Total per Month</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="each_month" items="${myMoney.rows}">
                    <tr>

                        <td>${each_month.month}</td>

                        <td> 
                            ${each_month.total} 
                        </td>

                    </tr> 
                </c:forEach> 

                <sql:query var="myMoney" dataSource="test" >
                    SELECT sum(total) 'total' FROM monthly_expense
                    where slip is not null
                    and date_time_pay like '<% String year4 = request.getParameter("year");%>%'

                </sql:query> 

                <c:forEach var="each_month" items="${myMoney.rows}">
                    <tr>

                        <td>TOTAL</td>

                        <td> 
                            ${each_month.total} 
                        </td>

                    </tr> 
                </c:forEach> 
            </tbody>
        </table>

    </body>
</html>
