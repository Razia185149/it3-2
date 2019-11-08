<%@ page import="java.util.ArrayList" %>
<%@ page import="entitites.Appointment" %>
<%@ page language="java"
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
%>
<!DOCTYPE html>
<html lang="en"><!DOCTYPE html>
<html lang="en">
<head>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
    <title>Appointments</title>
</head>
<body>
Modtaget data:
<%
    String cpr= request.getParameter("cpr");
    out.println(cpr);
    String password= request.getParameter("password");
    out.println(password);


%>  <br>
<div id="header">
    <div id="name-text">Mit Sundhed.dk</div>
</div>
<div id="container">
    <div id="welcome-message">Welcome, <%
        out.println(request.getParameter("cpr"));

    %>!</div>

    <div id="appointments">
        <%
            ArrayList<Appointment> allApps=(ArrayList<Appointment>) request.getAttribute("allAppointments");
            for (Appointment app: allApps) {


        %>
        <div id="single-appointment">
            <form action="/delete/" id="appointment-form">
                <input type="hidden" value="${app.id}" name="id">
                <input type="submit" value="Aflyse tid" id="cancel-btn">
                <div id="first">
                    Tid:
                    <input type="text" value="${app.varighed}" id="time-input" name="time">
                </div>
                <div id="second">
                    Dato:
                    <input type="text" value="${app.dato}" id="date-input" name="date">
                </div>
                <div id="third">
                    Addresse:
                    <textarea rows="7" cols="70" value="${app.sygehusID}" id="address-input" name="address">


                    </textarea>

                </div>
            </form>
        </div>
        <%}%>
    </div>


    <div id="confirm-message">
        <form action="#">
            <div id="question">Din tid er blevet aflyst. Ønsker du at bestille en nye tid? </div>
           <div id="buttons">
               <input type="submit" class="answer-btn" value="Ja">
               <input type="submit" class="answer-btn" value="Nej">
           </div>
        </form>
    </div>

</div>

</body>
</html>