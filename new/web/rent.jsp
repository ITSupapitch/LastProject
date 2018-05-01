<%-- 
    Document   : rent
    Created on : Apr 29, 2018, 4:32:17 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include  file="cus_header.html" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %> 
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Prompt" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/booking.css">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                var limit = 1;

                $('input.single-checkbox').on('change', function (evt) {
                    if ($(this).siblings(':checked').length >= limit) {
                        this.checked = false;
                    }
                });
            });
        </script>
    </head>
    <body>

        <div>
            <br><br>
            <center><h1><b>RENT</b></h1></center><br>
            <form action="ProcessSelectionAreaRent" method="POST">
                <div class="booking">
                    <center><h2><b>1st Floor</b></h2></center>
                    <img src="pic/floor1.jpg" alt="1f" height="800" width="600" class="center"><br>


                    <h3><b>Clothes Zone</b></h3>
                    <sql:query var="myArea" dataSource="test" >
                        SELECT * FROM area 
                        where area_type = 'clothes';
                    </sql:query> 

                    <c:forEach var="each_area" items="${myArea.rows}">


                        <input class="single-checkbox" type="checkbox" name="area_id" value="${each_area.area_id}" ${each_area.status}/>${each_area.area_name}
                    </c:forEach> 




                    <h3><b>Electronics Zone</b></h3>
                    <sql:query var="myArea" dataSource="test" >
                        SELECT * FROM area 
                        where area_type = 'electronics';
                    </sql:query> 

                    <c:forEach var="each_area" items="${myArea.rows}">


                        <input  class="single-checkbox" type="checkbox"  name="area_id" value="${each_area.area_id}" ${each_area.status}/>${each_area.area_name}
                    </c:forEach> 

                    <br><br><br>
                    <center><h2><b>2nd Floor</b></h2></center>
                    <img src="pic/floor2.jpg" alt="1f" height="800" width="600" class="center"><br>


                    <h3><b>Appliance Zone</b></h3>
                    <sql:query var="myArea" dataSource="test" >
                        SELECT * FROM area 
                        where area_type = 'appliance';
                    </sql:query> 

                    <c:forEach var="each_area" items="${myArea.rows}">


                        <input  class="single-checkbox" type="checkbox" name="area_id"  value="${each_area.area_id}" ${each_area.status}/>${each_area.area_name}
                    </c:forEach> 


                    <h3><b>Food Zone</b></h3>
                    <sql:query var="myArea" dataSource="test" >
                        SELECT * FROM area 
                        where area_type = 'food';
                    </sql:query> 

                    <c:forEach var="each_area" items="${myArea.rows}">


                        <input  class="single-checkbox" type="checkbox"  name="area_id" value="${each_area.area_id}" ${each_area.status}/>${each_area.area_name}
                    </c:forEach> 

                    <br>
                    <br>
                    <center><input type="submit" value="SUBMIT" /></center>
                </div>
            </form>
        </div>
    </body>
</html>
