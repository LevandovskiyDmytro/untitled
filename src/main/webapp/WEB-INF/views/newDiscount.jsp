<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="disc" items="${discounts}">
    ${disc.name}
    <a href="deleteDiscount/${disc.id}">delete</a>
    <br>
</c:forEach>
<form action="saveDiscount" method="post">
    <input name="discountName" placeholder="discount name"> <br>

    <button>save discount</button>
</form>
</body>
</html>
