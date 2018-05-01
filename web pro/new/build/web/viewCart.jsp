<%-- 
    Document   : ViewCart
    Created on : Apr 28, 2018, 11:46:41 AM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>Selected Area in Cart</h1>

        <jsp:useBean class="model.AreaCart" scope="session" id="areaCart" />
        <c:forEach var="place" items="${areaCart.places}">
            ${place.placeID}&nbsp;
        </c:forEach> <br>

        <c:forEach var="place" items="${areaCart.places}">
            ${place.place_name}&nbsp;

        </c:forEach>



    </center>
</body>
</html>
