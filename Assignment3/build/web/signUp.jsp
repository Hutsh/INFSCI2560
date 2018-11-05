<%-- 
    Document   : signUp
    Created on : Nov 4, 2018, 3:35:15 PM
    Author     : hutsh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Sign Up</title>

        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css"/>
        <link href="style.css" rel="stylesheet">
    </head>
    <body >
        <form class="form-signup" method="post" name="signup-form" id="signup-form" action="userSignUp">
            <input type="hidden" name="log"/>
            <h1 class="h3 mb-3 font-weight-normal text-center">Sign Up</h1>

            <label for="name">Username</label>
            <input type="text" name="name" id="name" class="form-control mb-3" placeholder="Username" required autofocus>

            <label for="address">Address</label>
            <input type="text" name="address" id="address" class="form-control mb-3" placeholder="Please input address" required>

            <label for="phone">Phone Number</label>
            <input type="text" name="phone" id="phone" class="form-control mb-3" placeholder="please input your phone number" required>

            <label for="password">Password</label>
            <input type="password" name="password" id="password" class="form-control mb-3" placeholder="Password" required>

            <label for="password2">Confirm password</label>
            <input type="password" name="password2" id="password2" class="form-control mb-3" placeholder="Confirm password" required>
            <small id="passwordHelp" class="text-danger d-none">* Password confirmation doesn't match Password.</small>

            <button type="button" name="Login" class="mt-5 btn-lg btn-success btn-block" onclick="checkInput();">Sign Up</button>
        </form>

        <script>
            function checkInput() {
                p1 = document.getElementById('password');
                p2 = document.getElementById('password2');
                pinfo = document.getElementById('passwordHelp');

                if(p1.value === p2.value){
                    console.log("match");
                    pinfo.classList.add("d-none");
                    p2.classList.remove("is-invalid");
                    document.getElementById('signup-form').submit();
                }else{
                    console.log("pass not match");
                    p2.classList.add("is-invalid");
                    pinfo.classList.remove("d-none");
                }
            }
        </script>



    </body>
</html>
