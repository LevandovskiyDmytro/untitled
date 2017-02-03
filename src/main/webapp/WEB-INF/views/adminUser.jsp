<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="/resources/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
<html>
<head>

</head>
<body>
<div class="container" style="height: 520px;">
<table class="highlight" >
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Password</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <c:forEach var="userDTO" items="${userDTOs}">
    <tbody>
    <tr>
        <td>${userDTO.id}</td>
        <td>${userDTO.name}</td>
        <td>${userDTO.phone}</td>
        <td>${userDTO.email}</td>
        <td>●●●●●●●●●●</td>
        <td><a class="btn-floating btn waves-effect waves-light green" href="updateUser/${userDTO.id}"><i class="material-icons">mode_edit</i></a></td>
        <td><a class="btn-floating btn waves-effect waves-light red" href="deleteUser/${userDTO.id}"><i class="material-icons">delete</i></a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</div>
