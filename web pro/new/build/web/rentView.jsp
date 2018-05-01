<%-- 
    Document   : rentView
    Created on : Mar 10, 2018, 7:33:57 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Profile User</title>
        <style>
            .flex-container {
                text-align: center;
                padding: 15px;
                flex: 1 100%;
            }
            .font-heading{
                background-color:lightgray;
                padding-top: 3px;
                padding-bottom: 3px;
                padding-left: 10px;
                padding-right: 10px;
            }

            .font-context{
                background-color:whitesmoke;
                padding-top: 3px;
                padding-bottom: 3px;
                padding-left: 10px;
                padding-right: 10px;;
            }

            @media all and (min-width: 768px) {
                .nav {text-align:left;-webkit-flex: 1 auto;flex:1 auto;-webkit-order:1;order:1;}
                .article {-webkit-flex:5 0px;flex:5 0px;-webkit-order:2;order:2;}
                footer {-webkit-order:3;order:3;}
            }
        </style>
    </head>
    <body>
        <div class="flex-container">
            <h1>สัญญาการเช่า</h1>
        </div><br>
        <div class="row">
            
            <!-- Here starts the navbar -->
            <div class="col-md-3">
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="infoUser.jsp">ข้อมูลส่วนตัว</a></li>
                    <li><a href="BookServlet">สัญญาการจอง</a></li>
                    <li class="active"><a href="RentServlet">สัญญาการเช่า</a></li>
                    <li><a href="#">ดูค่าใช้จ่ายรายเดือน</a></li>
                    <li><a href="payment.html">อัพโหลดหลักฐานการชำระเงิน</a></li>  
                </ul>
            </div>
            <!-- Here end the navbar -->

            <div class="col-sm-2">
                <div class="font-heading">
                    <p><b>ชื่อ-นามสกุล</b></p>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="font-context">
                    <%
                        out.println(session.getAttribute("name") + "     " + session.getAttribute("lastname"));
                    %>
                </div>
            </div><br><br>

            <div class="col-sm-2">
                <div class="font-heading">
                    <p><b>ประเภท</b></p>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="font-context">
                    <%
                        out.println(session.getAttribute("rentType"));
                    %>
                </div>
            </div><br><br>

            <div class="col-sm-2">
                <div class="font-heading">
                    <p><b>จำนวน</b></p>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="font-context">
                    <%
                        out.println(session.getAttribute("rentQuantity"));
                    %>
                </div>
            </div><br><br>

            <div class="col-sm-2">
                <div class="font-heading">
                    <p><b>เลขที่แผง</b></p>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="font-context">
                    <%
                        out.println(session.getAttribute("rentPanel"));
                    %>
                </div>
            </div><br><br>

            <div class="col-sm-2">
                <div class="font-heading">
                    <p><b>วันที่เริ่มจอง</b></p>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="font-context">
                    <%
                        out.println(session.getAttribute("rentStart_date"));
                    %>
                </div>
            </div><br><br>

            <div class="col-sm-2">
                <div class="font-heading">
                    <p><b>วันที่สิ้นสุดการจอง</b></p>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="font-context">
                    <%
                        out.println(session.getAttribute("rentEnd_date"));
                    %>
                </div>
            </div><br><br>
        </div>

    </body>
</html>
