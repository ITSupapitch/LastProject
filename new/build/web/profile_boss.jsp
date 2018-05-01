<%-- 
    Document   : profile_boss
    Created on : Apr 23, 2018, 12:05:55 AM
    Author     : Suttida Sat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="boss_header.html" %>
<!DOCTYPE html>
<html>
    <head>
        <title>PROFILE</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Prompt" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/profile.css">

    </head>
    <body>

        <div>
            <br><br>
            <center>
                <h1> PROFILE</h1>
            </center><br>


            <%-- Using Scriptlet--%>
            <% model.Account account = (model.Account) session.getAttribute("account_info");%>
            <div class="sign">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Full Name <input type="text" name="fname" value="" readonly="readonly" disabled="disabled" placeholder= "<%= account.getFullname()%>"/> <br>

                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;UserName <input type="text" name="username" value="" readonly="readonly" disabled="disabled" placeholder = "<%= account.getUsername()%>"/><br>

                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Phone Number <input type="text" name="tell" value="" readonly="readonly" disabled="disabled" placeholder = "<%= account.getPhone()%>"/><br>


            </div>

        </div>
    </body>
</html>
