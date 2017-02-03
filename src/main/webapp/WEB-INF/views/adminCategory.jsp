<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="/resources//css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="/resources//css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<script src="/resources//js/jquery.min.js"></script>
<link href="/resources//css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'><!--//fonts-->
<!-- start menu -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="/resources/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>

<a class="waves-effect waves-light btn" href="/admin" style="margin: 15px">Admin</a>

<div class="product">
    <div class="container">
        <div class=" rsidebar span_1_of_left">
            <div class="of-left">

    <h4 style="color: #333333">Add Category:</h4>
    <form:form modelAttribute="category" action="saveCategory" method="post" class="category-container">
        <p><form:input path="name" type="text" placeholder="Category Name "/></p>
        <button class="btn waves-effect waves-ripple">Add</button>
    </form:form>

    <%--<H5>Add subcategory</H5>--%>
        <table class="highlight">
            <br>
            <br>
            <thead>
                <tr>Name</tr>
            </thead>
            <c:forEach var="category" items="${categories}">
                <tbody>
                <tr>
                    <td>${category.name}</td>
                    <td><a class="btn-floating btn waves-effect waves-light red" href="deleteCategory/${category.id}"><i class="mate"></i></a></td>

                <c:forEach var="commodity" items="${category.commodities}">
                    <td>${commodity.name}</td>
                    <td><a class="btn-floating btn waves-effect waves-light red" href="deleteCommodityFromCategory/${commodity.id}">delete commodity</a></td>
                </c:forEach>
                </tr>
                </tbody>
            </c:forEach>


        </table>


        </div>
</div>
    </div>
</div>