<%-- 
    Document   : agreement_rent
    Created on : Apr 29, 2018, 3:43:07 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include  file="cus_header.html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<!DOCTYPE html>
<html>
    <head>
        <title>AGREEMENT PAGE</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Prompt" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/agree.css">
    </head>
    <body>
  <div>
            <br>
            <center><h1> RENTAL AGREEMENT </h1></center><br>

            <%-- Using Scriptlet--%>

            <% model.Account account = (model.Account) session.getAttribute("account_info");%>
            <% model.Place place = (model.Place) session.getAttribute("rentPlace");%>
            <% model.Contract contract = (model.Contract) session.getAttribute("rentContract");%>
            <% model.Payment payment = (model.Payment) session.getAttribute("rentPayment");%>
            <% model.Announce announce = (model.Announce) session.getAttribute("rentAnnounce_details");%>

            <form action="BookingRentConfirmServlet" method="POST">
                <div class="sign">
                    <br>
                    <center>Full Name <input type="text" name="fname" value="" readonly="readonly" disabled="disabled" placeholder="<%= account.getFullname()%>"/><br>


                        Category <input type="text" name="category" value="" readonly="readonly" disabled="disabled" placeholder="<%=place.getType()%>" /><br>
                        Place number <input type="text" name="number" value="" readonly="readonly" disabled="disabled"  placeholder="<%=place.getPlace_name()%>"/><br>

                        Cost per Place <input type="text" name="cost" value="" readonly="readonly" disabled="disabled" placeholder="<%=place.getPrice()%>" /><br>
                        Total amount to pay Advance 3 months <input type="text" name="cost" value="" readonly="readonly" disabled="disabled" placeholder="<%=payment.getPriceRent()%>"/><br>
                        Rent Date <input type="text" name="rentdate" value="" readonly="readonly" disabled="disabled" placeholder="<%= contract.getStartDate()%>"/><br>
                        Expired Date <input type="text" name="expd" value="" readonly="readonly" disabled="disabled" placeholder="<%= contract.getEndDate()%>"/></center>


                    <center><textarea rows="30" cols="100" type="text" target = "oldterm" name="oldterm" value="" readonly="readonly" /><%= announce.getInformation()%>
                        </textarea>
                        </textarea></center>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    Agree <input type="checkbox" name="agree" required="required"  />
                    <br><center><input type="submit" value="Confirm" /></center>
                </div>
            </form>
        </div> 

    </body>
</html>
