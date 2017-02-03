<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="product">
    <div class="container">
        <div class=" rsidebar span_1_of_left">
            <div class="of-left">
                <h2><a href="/admin"><<<<</a></h2>
                <h4>Add Delivery:</h4>

<form:form action="saveDelivery" method="post">
    <input name="deliveryName" placeholder="delivery name"/> <br>

    <p><input type="submit" value="add delivery"></p>
</form:form>
<c:forEach var="del" items="${deliveries}">
    ${del.name}
    <a href="deleteDelivery/${del.id}">delete</a>
    <br>
</c:forEach>
            </div></div></div>