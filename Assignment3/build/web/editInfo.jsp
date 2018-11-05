<%-- 
    Document   : editInfo
    Created on : Nov 4, 2018, 2:32:58 PM
    Author     : hutsh
--%>


<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <jsp:useBean id="ub" class="mbs.myBean" scope="session" />
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
    <h1 class="mt-5">Edit Information</h1>
    <div class="card">
        <h5 class="card-header">My Information</h5>
        <div class="card-body">



            <form class="form-signup" method="post" action="editMyInfo" id="update-form">
                <input type="hidden" name="log"/>
                <input type="hidden" name="id" value="<jsp:getProperty name="ub" property="id" />" />

                <label for="name">Username</label>
                <input type="text" name="name" id="name" class="form-control mb-3" value="<jsp:getProperty name="ub" property="name" />" readonly>

                <label for="address">Address</label>
                <input type="text" name="address" id="address" class="form-control mb-3" value="<jsp:getProperty name="ub" property="address" />" required>

                <label for="phone">Phone Number</label>
                <input type="text" name="phone" id="phone" class="form-control mb-3" value="<jsp:getProperty name="ub" property="phone" />" required>

                <label for="password">Password</label>
                <input type="password" name="password" id="password" class="form-control mb-3" placeholder="Keep empty if not update password" required>

                <label for="password2">Confirm password</label>
                <input type="password" name="password2" id="password2" class="form-control mb-3" placeholder="Keep empty if not update password" required>
                <small id="passwordHelp" class="text-danger d-none">* Password confirmation doesn't match Password.</small>

                <button type="button" class="mt-5 btn-lg btn-success btn-block" onclick="checkInput();">Update</button>
            </form>



        </div>
    </div>
</main>

<footer class="footer">
    <div class="container">
        <span class="text-muted">Assignment3 | TianshuoHu | INFSCI2560</span>
    </div>
</footer>


<script>
    function checkInput() {
        p1 = document.getElementById('password');
        p2 = document.getElementById('password2');
        pinfo = document.getElementById('passwordHelp');

        if(p1.value == p2.value){
            pinfo.classList.add("d-none");
            p2.classList.remove("is-invalid");
            document.getElementById('update-form').submit();
        }else{
            p2.classList.add("is-invalid");
            pinfo.classList.remove("d-none");
        }
    }
</script>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="https://getbootstrap.com/docs/4.0/assets/js/vendor/popper.min.js"></script>
<script src="https://getbootstrap.com/docs/4.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
