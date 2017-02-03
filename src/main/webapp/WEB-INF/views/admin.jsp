<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec"%>
<link href="/resources/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<div class="product">
    <div class="container" style="height: 400px;">
<div class=" rsidebar span_1_of_left">
    <div class="of-left">
<sec:authorize access="hasRole('ROLE_ADMIN')&&isAuthenticated()">
<h4>Admin Menu</h4>
<ul class="menu">
                <li><a href="/admin/adminCategory">  Manage Category </a></li>
                <li ><a href="/admin/adminCommodity" > Manage Commodity </a></li>
                <li><a href="/adminDelivery" >  Manage Delivery</a></li>
                <li><a href="/admin/adminUser" >  Manage User </a></li>
                <li><a href="/admin/orders" >  Manage Order </a></li>
    </sec:authorize>
</ul>
    </div></div></div></div>



