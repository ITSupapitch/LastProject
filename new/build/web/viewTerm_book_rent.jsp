<%-- 
    Document   : viewTerm_book.jsp
    Created on : Apr 28, 2018, 8:23:14 AM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="boss_header.html" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TERM.</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Prompt" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/viewTerm.css">
    </head>
    <body>


        <!-- selected button -->
        <br><br><br><h1><center>VIEW TERM.</center></h1><br>           
    <center>
        <div class="btn-group">
            <form action="ViewAnnounceServlet" method="POST">
                <button class="select_bn bn1" value="Rent" name="view_details"> Rental </button>
            
            
                <button  class="select_bn bn2" value="Book" name="view_details" > Booking </button>
            </form>
        </div>
    </center>


    <!-- Show the previous term -->

    <%-- Using Scriptlet--%>
    <% model.Announce announce = (model.Announce) session.getAttribute("announce_details");%>

    <br><br><br><center><textarea rows="50" cols="100" type="text" target = "oldterm" name="oldterm" value="" readonly="readonly" /><%= announce.getInformation()%>
    </textarea>
    </center>

    <!-- edit button -->
    <br><form action="editTerm.jsp" method="POST">
        <input type="submit" value="EDIT" /></form>
</body>
</html>

