<%-- 
    Document   : dashboard
    Created on : Apr 23, 2018, 10:35:23 AM
    Author     : Suttida Sat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<%@include  file="boss_header.html" %>
<html>
    <head>
        <title>DASHBOARDS PAGE</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link href="https://fonts.googleapis.com/css?family=Prompt" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/dashboard.css">
    <body>



    <br><br><br>  <center><h1>AREA DASHBOARD</h1></center>
    <form action="ViewDashBoardServlet" method="POST">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="area" name="btn" /> <input type="submit" value="Annual Dashboard" name="btn"/>
    </form>
    <br><br>


   
<center> Summarize Of Current Shop Type <br>
        <sql:query var="myArea" dataSource="test" >
            select area_type , count(area_id) 'Number'
            from area
            join inden_area
            using (area_id )
            join indenture
            using (i_id)
            join payment
            using (payment_id )
            where type_contract_id = 2
            and status = 'disabled'
            and slip is not null
            group by area_type;

        </sql:query> 

        <table  border="1" align="center"> 
            <thead>
                <tr>
                    <th>Area_type</th>
                    <th>Number</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="each_area" items="${myArea.rows}">
                    <tr>

                        <td>${each_area.area_type}</td>

                        <td> 
                            ${each_area.Number} 
                        </td>

                    </tr> 
                </c:forEach> 

                <sql:query var="myArea" dataSource="test" >
                    select count(area_id) 'Number'
                    from area
                    where status = 'enable';


                </sql:query> 

                <c:forEach var="each_area" items="${myArea.rows}">
                    <tr>

                        <td>Empty</td>

                        <td> 
                            ${each_area.Number} 
                        </td>

                    </tr> 
                </c:forEach> 
            </tbody>
        </table>
             <br><br><br><br>
<p>Rental Statistics</p>


      <!--    Graph Pictures2 Rental Statistics-->
        <sql:query var="myArea" dataSource="test" >
            select area_type , count(area_id) 'Number'
            from area
            join inden_area
            using (area_id )
            join indenture
            using (i_id)
            join payment
            using (payment_id )
            where type_contract_id = 2
            group by area_type;

        </sql:query> 

        <table  border="1" align="center"> 
            <thead>
                <tr>
                    <th>Area_type</th>
                    <th>Number</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="each_area" items="${myArea.rows}">
                    <tr>

                        <td>${each_area.area_type}</td>

                        <td> 
                            ${each_area.Number} 
                        </td>

                    </tr> 
                </c:forEach> 

            </tbody>
        </table>
 <br><br><br><br>
<p>Booking Statistics</p>
     <!--    Graph Pictures2 Booking Statistics-->
        <sql:query var="myArea" dataSource="test" >
            select area_type , count(area_id) 'Number'
            from area
            join inden_area
            using (area_id )
            join indenture
            using (i_id)
            join payment
            using (payment_id )
            where type_contract_id = 1
            group by area_type;

        </sql:query> 

        <table  border="1" align="center"> 
            <thead>
                <tr>
                    <th>Area_type</th>
                    <th>Number</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="each_area" items="${myArea.rows}">
                    <tr>

                        <td>${each_area.area_type}</td>

                        <td> 
                            ${each_area.Number} 
                        </td>

                    </tr> 
                </c:forEach> 

            </tbody>
        </table>

</center>    

</body>
</html>
