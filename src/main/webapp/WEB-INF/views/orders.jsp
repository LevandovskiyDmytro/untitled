<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="/resources/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
<a class="waves-effect waves-light btn" href="/admin" style="margin: 15px">Admin</a>
<div class="container" style="height: 500px;">
<table class="highlight">
    <thead>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Commodities</th>
        <th></th>
    </tr>
    </thead>
    <c:forEach var="user" items="${users}">
        <c:if test="${user.commodities.size() != 0}">
            <tbody>
            <tr>
                <td>${user.name}</td>

                <td>${user.email}</td>
                <td>
                    <%--principal check it commodity.id












                    --%>
                    <c:forEach var="commodity" items="${user.commodities}">
                        ${commodity.model} ${commodity.price}  <br>
                    </c:forEach>
                </td>
                <td><a class="btn-floating btn waves-effect waves-light red"
                       href="delOrder/${user.id}"><i class="material-icons">delete</i></a></td>
            </tr>
            </tbody>
        </c:if>
    </c:forEach>
</table>

</div>