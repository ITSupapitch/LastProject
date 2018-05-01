<%-- 
    Document   : infoCustomer_boss
    Created on : Apr 27, 2018, 3:13:10 PM
    Author     : Suttida Sat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="boss_header.html" %>
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

        <br><br><br><h1><center> CUSTOMER INFORMATION.</center></h1><br> 

        <!-- information part -->
        <%-- Using Scriptlet--%>
        <% model.Account account = (model.Account) request.getAttribute("cus_account_info");%>
        <% model.Address address = (model.Address) request.getAttribute("cus_address_info");%>
        <% model.Contract contract = (model.Contract) request.getAttribute("cus_contract_info");%>
        <% model.Place place = (model.Place) request.getAttribute("cus_place_info");%>
    <br><center>
        <table border="1">
            <tbody>
                <tr>
                    <th>Customer ID.</th>
                    <td><%= account.getAccount_id()%></td>
                </tr>
                <tr>
                    <th>Name</th>
                    <td><%= account.getFullname()%></td>
                </tr>
                <tr>
                    <th>Gender</th>
                    <td><%= account.getGender()%></td>
                </tr>
                <tr>
                    <th>Phone Number</th>
                    <td><%= account.getPhone()%></td>
                </tr>
                <tr>
                    <th>Address</th>
                    <td><%= address.address_info()%></td>
                </tr>
                <tr>
                    <th>Contract Number</th>
                    <td><%= contract.getContractID()%></td>
                </tr>
                <tr>
                    <th>Type of Contract</th>
                    <td><%= contract.getType()%></td>
                </tr>
                <tr>
                    <th>Start Date</th>
                    <td><%= contract.getStartDate()%></td>
                </tr>
                <tr>
                    <th>End Date</th>
                    <td><%= contract.getEndDate()%></td>
                </tr>
                <tr>
                    <th>Area ID.</th>
                    <td><%= place.getPlace_name()%></td>
                </tr>
                <tr>
                    <th>Zone</th>
                    <td><%= place.getType()%></td>
                </tr>
            </tbody>
        </table>

    </center>

    <!-- back button -->
    <br><center>

        <a href="selectInfoCustomer_boss.jsp"><input type="submit" target="back" value="BACK"></a></center>

</body>
</html>
