<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>BOX SHOP</title>
</head>
<body>
<a name="head"></a>
<!-- header-section-starts -->
<div class="header">
    <div class="header-top">
        <div class="container">

            <div class="header-left">
                <ul>
                    <li style="margin-right: 10px;">
                        <sec:authorize access="isAuthenticated()">
                            <form:form action="/logout" method="post">
                            <button class="btn">logout</button>
                             </form:form>
                        </sec:authorize>
                    </li>
                    <li><sec:authorize access="hasRole('ROLE_USER')">
                    <i class="user"></i>
                    <a href="/profile">Your Profile</a>
                        </sec:authorize>
                    </li>
                    <li>
                        <sec:authorize access="!isAuthenticated()">
                            <i class="user"></i>
                            <a href="/loginpage">Login</a>
                        </sec:authorize>
                    </li>
                    <li>
                        <sec:authorize access="!isAuthenticated()">
                            <a href="/registration">Sign Up</a>
                        </sec:authorize>
                    </li>
                    <li>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <i class="user"></i>
                            <a href="/admin">Admin Account</a>
                        </sec:authorize>
                    </li>


                </ul>
                <div class="cart box_1">

                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
    <div class="container" style="height: 65px">
        <div class="head-top">
            <div class="logo">
                <a href="/"><img src="/resources/images/logo.png" alt=""></a>
            </div>
            <div class=" h_menu4">
                <ul class="memenu skyblue">
                    <li class="active grid"><a class="color9" href="/">Home</a></li>
                    <li><a class="color4" href="/blog">Blog</a></li>
                    <li><a class="color6" href="/contactPage">Contact Us</a></li>
                </ul>
            </div>

            <div class="clearfix"> </div>
        </div>
    </div>


</div>
