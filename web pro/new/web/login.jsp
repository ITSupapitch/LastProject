<%-- 
    Document   : login
    Created on : Apr 21, 2018, 5:34:24 PM
    Author     : Suttida Sat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<title>Login Page</title>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
     
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<link rel="stylesheet" type="text/css" href="css/util_login.css">
    </head>
        <body style="background-color: #d3e0cd;">
         
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form" action="loginServlet" method="POST">
					<span class="login100-form-title p-b-43">
						LOGIN
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="name">
						<span class="focus-input100"></span>
						<span class="label-input100">USERNAME</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<input class="input100" type="password" name="pass">
						<span class="focus-input100"></span>
						<span class="label-input100">PASSWORD</span>
					</div>
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							LOGIN
						</button>
		
                                            <span class="txt2"><a href="register.jsp">
                                                                            SIGN UP		</a>				
                                                </span>
					</div>

				</form>

				<div class="login100-more" style="background-image: url('pic/mall_login.jpg');">
				</div>
			</div>
		</div>
	</div>
	
    </font>
    
    </body>
</html>

