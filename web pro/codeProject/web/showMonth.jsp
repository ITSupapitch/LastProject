<%-- 
    Document   : showMonth
    Created on : Apr 16, 2018, 4:45:09 PM
    Author     : Suttida Sat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>SHOW MONTH!</h1>
        
            <%
                                     out.println(session.getAttribute("water"));
             out.println(session.getAttribute("fire"));
             out.println(session.getAttribute("price_area"));
             out.println(session.getAttribute("total"));
                    %>
        
    </body>
</html>
