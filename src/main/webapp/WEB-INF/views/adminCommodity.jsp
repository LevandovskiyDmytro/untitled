
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="/resources/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>

    <a class="waves-effect waves-light btn" href="/admin" style="margin: 15px">Admin</a>
<div class="container" style="height: 1200px;" >
    <table class="highlight">
        <thead>
        <tr>
            <th>Model</th>
            <th>Price</th>
            <th>Delete</th>
        </tr>
        </thead>

        <c:forEach var="commodity" items="${commodities}">
        <tbody>
        <tr>
            <td>${commodity.model}</td>
            <%--<td>${commodity.type}</td>--%>
            <%--<td>${commodity.brand}</td>--%>
            <%--<td>${commodity.model}</td>--%>
            <td>${commodity.price}</td>
            <td><a class="btn-floating btn waves-effect waves-light red" href="/deleteCommodity/${commodity.id}">
                <i class="material-icons">delete</i></a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
<form:form modelAttribute="commodity" action="./saveCommodity?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
    <div class="row">
    <div class="input-field col s12">
        ${commodityException}
        <form:input path="model" type="text" placeholder="Model"/>
    </div></div>
    <%--<div class="input-field col s12">--%>
    <%--<form:input path="type"  type="text" placeholder="Type" />--%>
    <%--</div>--%>
    <%--<div class="input-field col s12">--%>
    <%--<form:input path="brand"  type="text" placeholder="Brand" />--%>
    <%--</div>--%>
    <%--<div class="input-field col s12">--%>
    <%--<form:input path="model"  type="text" placeholder="Model" />--%>
    <%--</div>--%>
    <div class="row">
    <div class="input-field col s12">
            ${commodityException}
    <form:input path="price" type="text" placeholder="Price" />
    </div></div>
    <div class="row">
    <div class="file-field input-field">
        <div class="btn">
            <span>File</span>
            <input type="file" name="commodityImage">
        </div>
        <div class="file-path-wrapper">
            <input class="file-path validate" type="text">
        </div>
    </div></div>

    <div class="row center" style="padding: 10px 10px 10px 10px">
    <button class="btn waves-effect waves-light" style="padding-top: 4px">
        Save
        <i class="material-icons right" style="padding: 5px">send</i>
    </button>
    </div>
</form:form>
</div>