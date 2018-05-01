<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>register</title>
    </head>
    <body>
        <%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
        <%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
        <%@page contentType="text/html"%>

        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title><bean:message key="title.message"/> </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/regis.css">
    </head>

    <body style="background-image: url(pic/mall2.jpg)">
        
        <html:form action="register" styleId="form">
        <div>
            <h1 class="topic"> SIGN UP !</h1><br>
                
                
                <label for="fname">FIRST NAME </label>&nbsp;&nbsp;	
                <html:text property="firstname" />
                
                &nbsp;&nbsp;&nbsp;
                <label for="lname">LAST NAME </label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                      &nbsp;&nbsp;&nbsp;&nbsp;<html:text property="lastname" />

                <br> <label for="username">USERNAME </label>&nbsp;&nbsp;&nbsp;&nbsp;
                <html:text property="username" />

                <br><label for="password">PASSWORD </label>&nbsp;&nbsp;
                <html:password property="password"  />
                
                &nbsp;&nbsp;&nbsp;
                <label for="confirm_password">CONFIRM PASSWORD </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  <html:password property="confirm_pw" />

                  <br><label for="u_gender">GENDER </label>&nbsp;&nbsp;
                   <html:select property="gender" >
                <html:option value="male">MALE</html:option>
                <html:option value="female">FEMALE</html:option>
            </html:select>

                    
                <br> <label for="tel">PHONE NUMBER </label>&nbsp;&nbsp;
                 <html:text property="phone" />
                 
                <br> <label for="h_num">NO. </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <html:text property="ban" />
                &nbsp;&nbsp;&nbsp;       
                
                <label for="h_soi">ALLEY </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <html:text property="soi"/>

                <br> <label for="h_district">DISTRICT </label>&nbsp;&nbsp;
                <html:text property="district"/>
                &nbsp;&nbsp;&nbsp;              
                
                <label for="h_area">CITY </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <html:text property="area" />

                <br> <label for="h_county">PROVINCE </label>&nbsp;&nbsp;
                <html:text property="country"  />
                &nbsp;&nbsp;&nbsp;           
                
                
                <label for="h_zipcode">ZIP CODE </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<html:text property="code" />
                
                <br><br><br><br><br>
                <center><html:submit value="SUBMIT" /></center>
                <h2> <html:errors /></h2>
            </html:form>
        </div>
    </body>
</html>
