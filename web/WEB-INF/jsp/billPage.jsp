<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
   <div>
    <h2>Dear ${login}, your order:</h2>
    <br>
    <form method="post" action="billServlet">
    <p>
    <% int index = 0; %>
           <c:forEach var="pickedGood" items="${pickedGoods}">
                  <p><%=index += 1%>) ${pickedGood.getTitle()} (${pickedGood.getPrice()})$</p>
           </c:forEach>
           Total: ${totalPrice}$;
    </p>
   </div>
</body>
</html>