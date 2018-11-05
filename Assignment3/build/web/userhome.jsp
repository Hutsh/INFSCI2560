<%-- 
    Document   : userhome
    Created on : Nov 3, 2018, 6:27:43 PM
    Author     : hutsh
--%>


<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>My Home page</title>
    <jsp:useBean id="ub" class="mbs.myBean" scope="session" />

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
    <h1 class="mt-5">Welcome, <jsp:getProperty name="ub" property="name" /></h1>
    <div class="card">
        <h5 class="card-header">My Information</h5>
        <div class="card-body">
            <h5 class="card-title alert alert-primary">Name</h5>
            <p class="card-text ml-5"><jsp:getProperty name="ub" property="name" /></p>
            <h5 class="card-title alert alert-primary">Address</h5>
            <p class="card-text ml-5"><jsp:getProperty name="ub" property="address" /></p>
            <h5 class="card-title alert alert-primary">Phone Number</h5>
            <p class="card-text ml-5 "><jsp:getProperty name="ub" property="phone" /></p>
            
            <form method ="post" action = "editMyInfo">
                <a href="editInfo.jsp" class="btn btn-primary">Edit My Information</a>
            </form>
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
