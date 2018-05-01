<%-- 
    Document   : selectBooks
    Created on : Mar 23, 2018, 9:38:47 AM
    Author     : LAB207_35

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select Customer
        </title>
    </head>
    <body>


        <sql:query var="myCus" dataSource="test" >
        select DISTINCT *
        from account  a
        join indenture i
        on (a.account_id = i.account_id)
        where a. account_type = "customer" 
        </sql:query> 
 
  <h1>Select Customer
  เลือกชื่อลูกค้าที่ต้องการดู</h1><br>
  
        <form action="selectCustomerServlet" method="POST">
 
        <table border="1" align="center"> 
            <thead>
                <tr>
                    <th></th>
                        <th>customer_id</th>
                        <th>First name</th>
                        <th>Last name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="each_cus" items="${myCus.rows}">
                <tr>
                    
                <td><input type="radio"  name="account_id" value="${each_cus.account_id}" /></td>
                <td>${each_cus.account_id} </td>
                <td>${each_cus.firstname} </td>
                <td>${each_cus.lastname } </td>
             </tr> 
             </c:forEach> 
             
            </tbody>
        </table>
            <input type="submit" value="ok" />
       </form>
    </center>
    </body>
</html>
