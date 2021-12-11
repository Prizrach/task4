<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
    <h2>
        Welcome to Online Shop
    </h2>
    <br>
    <div>
    <form method="post" action="orderServlet">
        <input type="text" name="userName" placeholder="Enter your name">
        <p><input type = "checkbox"  class ="agree" name = "acceptTerms" >I agree with the terms of service</p>
        <div>
             <input type="submit" value="Enter">
        </div>
    </form>
    </div>
</body>
</html>