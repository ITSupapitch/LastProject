<%-- 
    Document   : editTerm
    Created on : Apr 28, 2018, 8:49:32 AM
    Author     : asus
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="boss_header.html" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TERM.</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Prompt" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/editTerm.css">
    </head>
    <body>


        <br><br><br><h1><center>EDIT TERM.</center></h1><br>
        <!-- Show the previous term -->
        <%
            Connection conn;
            conn = (Connection) getServletContext().getAttribute("connection");

            int announce_con_id = (int) session.getAttribute("annouce_con_id");

            Statement stmt = conn.createStatement();
            String sql = String.format("SELECT * FROM announce WHERE con_id  = " + announce_con_id);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            String text = rs.getString("content");
        %>

        <!-- edit & back button -->
        <br><form action="AddAnnounceServlet" method="POST">


            <center>
                <textarea name="txt" rows="10" cols="100">
                    <%
                        out.print(text);
                    %>
                </textarea>
            </center>
            <br>
            <%
                int edit_con_type = rs.getInt("type_contract_id");
                session.setAttribute("edit_con_type", edit_con_type);
            %>

            <br><input name="btn" target="back" type="submit"  value="CANCEL" style="float:left;"> <input name="btn" target="submit" type="submit" value="SAVE"/>
        </form>
    </body>
</html>

