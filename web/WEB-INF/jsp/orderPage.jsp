<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <style><%@include file="/WEB-INF/css/style.css"%></style>
</head>
<body>
<div>
    <h2>Hello ${userLogin}!</h2>
    <br>
    <p>Make you order<p>
    <form method="post" action="orderServlet">
        <select name="selected">
            <c:forEach var="product" items="${priceList}">
                <option value="${product.key}">${product.key} (${product.value}$)</option>
            </c:forEach>
        </select>
        <input type="submit" value="Add item">
     </form>

     <form method="post" action="billServlet">
             <input class="input" type="submit" value="Submit">
     </form>

    <p>You have already chosen:</p>

            <c:forEach var="pickedProduct" items="${pickedProducts}">
                 <p> ${pickedProduct.getTitle()} ${pickedProduct.getPrice()} </p>

     </c:forEach>
</div>
</body>
</html>