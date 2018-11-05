<%-- 
    Document   : index
    Created on : Sep 22, 2009, 3:21:07 PM
    Author     : spring
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>My Home page</title>

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.0/examples/sticky-footer-navbar/sticky-footer-navbar.css" rel="stylesheet">
</head>

<body>

<header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <a class="navbar-brand" href="/Assignment3">HomePage</a>

    </nav>
</header>

<!-- Begin page content -->
<main role="main" class="container">
    <h1 class="mt-5">Welcome, Administrator</h1>
    <div class="card">
        <h5 class="card-header">All User Information</h5>
        <div class="card-body">
            <%@ page import="java.sql.ResultSet" %>
            <%@ page import ="java.util.ArrayList" %>
            <%  ResultSet rs;

                ArrayList<ArrayList<String>> ull = new ArrayList<ArrayList<String>>();
                ArrayList<String> userinfolist = new ArrayList<String>();
                if (request.getAttribute("allUsers") != null) {
                    ull = (ArrayList) request.getAttribute("allUsers");
                }

                for (ArrayList<String> userlist : ull) {
                    out.println("<div class=\"card mb-3\">");
                    out.println("<h5 class=\"card-header\">" + userlist.get(1) + "  id:" + userlist.get(0) + "</h5>");
                    out.println("<div class=\"card-body\">");
                    out.println("<p class=\"card-text\">Address: " +  userlist.get(2)  +"</p>");
                    out.println("<p class=\"card-text\">Phone: " +  userlist.get(3)  +"</p>");
                    out.println("</div>");
                    out.println("</div>");
                }
            %>
            

            
        </div>
    </div>
</main>

<footer class="footer">
    <div class="container">
        <span class="text-muted">Assignment3 | TianshuoHu | INFSCI2560</span>
    </div>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="https://getbootstrap.com/docs/4.0/assets/js/vendor/popper.min.js"></script>
<script src="https://getbootstrap.com/docs/4.0/dist/js/bootstrap.min.js"></script>
</body>
</html>




