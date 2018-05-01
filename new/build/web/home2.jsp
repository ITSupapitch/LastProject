<%-- 
    Document   : home2
    Created on : Apr 23, 2018, 12:51:19 AM
    Author     : Suttida Sat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <title> HOME PAGE </title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="css/home2.css">
    <script type="text/javascript" src="javascript/home2js.js"></script>
    <style>
        .image_home {
            background-position: center;
            background-size: cover;
            background-image: url("pic/mall_homepage.jpg");
            opacity: 0.8;
            min-height: 90%;
        }
    </style>
    <body>

        <!-- Navbar (sit on top) -->
        <div class="w3-top">
            <div class="w3-bar w3-white w3-card" id="myNavbar">
                <a href="home2.jsp" class="w3-bar-item w3-button w3-wide"><img src="pic/logo.png" width="35" height="30"/> </a>
                <!-- Right-sided navbar links -->
                <div class="w3-right w3-hide-small">

                    <a href="home2.jsp" class="w3-bar-item w3-button"><i class="fa fa-home"></i>  HOME</a>

                    <a href="chk_agm_book" class="w3-bar-item w3-button"><i class="fa fa-tag"></i>  BOOKING</a>

                    <a href="chk_agm_book" class="w3-bar-item w3-button"><i class="fa fa-handshake-o"></i>  RENTAL</a>

                    <a href="sentProfile" class="w3-bar-item w3-button"><i class="fa fa-user-circle"></i> PROFILE</a>
                </div>
            </div>
        </div>

        <!-- Header with full-height image -->
        <header class="image_home w3-display-container" id="home">   
            <h1 class="newgoal_1 w3-text-white"><span class="w3-padding w3-pink w3-opacity-min"><b>NEWGOAL</b></span></h1><h2 class="newgoal_2"><span class="w3-hide-small w3-text-light-grey"><br>Paradise of Shopping.</span></h2>
        </header>

        <!-- About Us -->
        <div class="w3-container-about w3-content w3-center w3-padding-64" style="max-width:800px" id="band">
            <h2 class="w3-wide"> RENTAL SPACE IN <br>THE DEPARTMENT STORE SYSTEM. </h2>
                <p class="w3-justify">" The system is a rental system in the department store that will help you to rent 
                    a space more convenient. <br>There is 5 functions : 1.Profile. 2. Make Booking Agreement 
                    3.Make Rental contract 4. Payment Confirmation 5. Report Monthly Expenses
                    If you interest in booking / renting space in the department store Don't Wait! "</p>
        </div>

        <!-- map floor1 section -->
        <div class="w3-container-map" style="padding:30px 30px">
            <h2 class="w3-wide w3-center">MAP OF THE DEPARTMENT STORE.</h2><br><br>
            <center><img class='floor1' src="pic/1f_home.jpg"  width="350px" height="450px" /> &nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img class='floor2' src="pic/2f_home.jpg"  width="350px" height="450px" />
                <br><br> </center>
        </div>

        <!-- Update Section -->
        <div class="w3-black" id="tour">
            <div class="w3-container-update w3-content w3-padding-64" style="max-width:900px">
                <h2 class="w3-wide w3-center">ANNOUCEMENT.</h2>

                <div class="w3-row-padding w3-padding-32" style="margin:0 -16px">
                    <div class="w3-third w3-margin-bottom">
                        <img src="pic/mall_tn4.jpg" alt="New York" style="width:100%" class="w3-hover-opacity">
                        <div class="w3-container w3-container-up">
                            <p><b>BOOKING/RENTAL CONDITIONS.</b></p>
                            <p class="w3-opacity">MON 26 JUNE 2017</p>
                            <p>...</p>
                            <button class="w3-button w3-black w3-margin-bottom" onclick="document.getElementById('ticketModal').style.display = 'block'">..READ MORE..</button>
                        </div>
                    </div>
                    <div class="w3-third w3-margin-bottom">
                        <img src="pic/mall_tn2.jpg" alt="Paris" style="width:100%" class="w3-hover-opacity">
                        <div class="w3-container w3-container-up">
                            <p><b>BOOKING/RENTAL RATE.</b></p>
                            <p class="w3-opacity ">Fri 30 JUNE 2017</p>
                            <p>...</p>
                            <button class="w3-button w3-black w3-margin-bottom" onclick="document.getElementById('ticketModal').style.display = 'block'">..READ MORE..</button>
                        </div>
                    </div>
                    <div class="w3-third w3-margin-bottom">
                        <img src="pic/mall_tn3.jpg" alt="San Francisco" style="width:100%" class="w3-hover-opacity">
                        <div class="w3-container w3-container-up">
                            <p><b>RENEWAL TERM.</b></p>
                            <p class="w3-opacity">Sun 29 Nov 2016</p>
                            <p>...</p>
                            <button class="w3-button w3-black w3-margin-bottom" onclick="document.getElementById('ticketModal').style.display = 'block'">..READ MORE..</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Ticket PopUp Modal 
        <div id="ticketModal" class="w3-modal">
            <div class="w3-modal-content w3-animate-top w3-card-4">
                <header class="w3-container w3-teal w3-center w3-padding-32"> 
                    <span onclick="document.getElementById('ticketModal').style.display = 'none'" 
                          class="w3-button w3-teal w3-xlarge w3-display-topright">×</span>
                    <h2 class="w3-wide"><i class="fa fa-suitcase w3-margin-right"></i>Tickets</h2>
                </header>
                <div class="w3-container">
                    <p><label><i class="fa fa-shopping-cart"></i> Tickets, $15 per person</label></p>
                    <input class="w3-input w3-border" type="text" placeholder="How many?">
                    <p><label><i class="fa fa-user"></i> Send To</label></p>
                    <input class="w3-input w3-border" type="text" placeholder="Enter email">
                    <button class="w3-button w3-block w3-teal w3-padding-16 w3-section w3-right">PAY <i class="fa fa-check"></i></button>
                    <button class="w3-button w3-red w3-section" onclick="document.getElementById('ticketModal').style.display = 'none'">Close <i class="fa fa-remove"></i></button>
                    <p class="w3-right">Need <a href="#" class="w3-text-blue">help?</a></p>
                </div>
            </div>
        </div>-->

        <!-- Contact Section --->
        <footer>
            <div class="expertise">
                <h3 class="sectionheader">CONTACT US !</h3>
                <div class="expert1">
                    <div class="exwrapper">
                        <div class="col13">
                            <h2>OFFICE.</h2>
                            <p>4th Floor<br><br>Opening hours : Everyday<br>10.00 AM - 10.00 PM
                                <br><br>NEWGOAL : <br>T : +66 2 610 8000
                                <br><br>SmileDevTeam Office :<br>T : +66 2 690 1000</p></div>
                        <div class="col13">
                            <h2>FOLLOW.</h2>
                            <p>Website : NEWGOALTH.com
                            <br>Facebook : NEWGOAL Thailand
                            <br>Instagram : @newgoalth
                            <br>Twitter : @newgoalth<br><br><br><br><br><br><br></p></div>
                        <div class="col13">
                            <h2>REPORT PROBLEM.</h2>
                            <p>e-mail : newgoalsupport@gmail.com
                            </p>Tel : +66 2 690 1001<br><br><br><br><br><br><br><br></div>
                    </div>
                </div> 
        </footer>
    </body>
</html>

