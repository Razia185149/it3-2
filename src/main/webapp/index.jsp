<%@ page language="java"
contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
    <title>Log in</title>
</head>
<body>
  <div id="header">
    <div id="name-text">Mit Sundhed.dk </div>
  </div>

  <div id="container">
    <form action="/login/" id="login-form" method="post">
       <div id="form-inputs">
           <div>
               CPR:
               <input type="text" name="cpr">
           </div>
           <div>
               Password:
               <input type="text" name="password">
           </div>
           <div id="login-btn">
               <input type="submit" value="Login">
           </div>
       </div>
    </form>
  </div>
</body>
</html>