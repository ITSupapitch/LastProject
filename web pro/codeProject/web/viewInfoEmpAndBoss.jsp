<%-- 
    Document   : viewInfoEmp
    Created on : Apr 21, 2018, 5:08:44 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Profile Emp & Boss</title>
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
                padding-right: 10px;
            }

            @media all and (min-width: 768px) {
                .nav {text-align:left;-webkit-flex: 1 auto;flex:1 auto;-webkit-order:1;order:1;}
                .article {-webkit-flex:5 0px;flex:5 0px;-webkit-order:2;order:2;}
                footer {-webkit-order:3;order:3;}
            }

        </style>
    </head>
    <body>
        <!-- Here end the navbar -->

        <%-- Using Scriptlet--%>
        <% model.Account account = (model.Account) request.getAttribute("account_info");%>

        <div class="flex-container">
            <h1>ข้อมูลส่วนตัว</h1>
        </div><br>
        <div class="row">
            <!-- Here starts the navbar -->
            <div class="col-md-3">
                <ul class="nav nav-pills nav-stacked">
                    <li class="active"><a href="infoEmp">ข้อมูลส่วนตัว</a></li>
                    <li><a href="#">กรอกค่าใช้จ่ายรายเดือน</a></li>
                    <li><a href="#">...</a></li>
                    <li><a href="#">...</a></li>
                    <li><a href="#">...</a></li>  
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
                   <p><%= account.getFullname()%><p>
                </div>
            </div><br><br>

            <div class="col-sm-2">
                <div class="font-heading">
                    <p><b>ชื่อผู้ใช้งาน</b></p>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="font-context">
                     <p><%= account.getUsername()%><p>
                </div>
            </div><br><br>

            <div class="col-sm-2">
                <div class="font-heading">
                    <p><b>ตำแหน่ง</b></p>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="font-context">
                    <p><%= account.getAccount_type()%><p>
                </div>
            </div><br><br>

            <div class="col-sm-2">
                <div class="font-heading">
                    <p><b>เบอร์โทรศัพท์</b></p>
                </div>
            </div>
            <div class="col-sm-5">
                <div class="font-context">
                    <p><%= account.getPhone()%><p>
                </div>
            </div><br><br>

        </div>

    </body>

</html>
