<%-- 
    Document   : index
    Created on : Sep 22, 2009, 3:21:07 PM
    Author     : spring
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Sign in</title>

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css" />
        <link href="style.css" rel="stylesheet">
    </head>
    <body>

    <body class="text-center">
        <form class="form-signin" method = "post" action="loginServlet" id="loginfrm">
            <input type="hidden" name="log" />
            <h1 class="h3 mb-3 font-weight-normal">Please Login</h1>

            <input type="text" name="name" id="inputEmail" class="form-control" placeholder="Username" required autofocus>

            <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>

            <button name="Login"  class="btn-lg btn-primary btn-block" type="submit">Log in</button>
            <button type="button" class="btn-lg btn-success btn-block" onclick="location.href = 'signUp.jsp';">Sign Up</button>
        </form>
    </body>
</html>
