<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>New Store</title>
    <link href="/resources/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <script src="/resources/js/jquery.min.js"></script>
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link rel="stylesheet" href="/resources/fonts/font-awesome/css/font-awesome.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="New Store"/>
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--fonts-->
    <link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'><!--//fonts-->
    <!-- start menu -->
    <link href="/resources/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="/resources/js/memenu.js"></script>
    <script>$(document).ready(function(){$(".memenu").memenu();});</script>
    <script src="/resources/js/cart.js"> </script>
    <script src="/resources/js/materialize.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="/resources/js/materialize.js"></script>

    <meta charset="utf-8">
    <title><tiles:getAsString name="title"/></title>
</head>
<body>
<header>
    <tiles:insertAttribute name="header" />
</header>
    <tiles:insertAttribute name="body" />
<footer>
    <tiles:insertAttribute name="footer" />
</footer>
</body>
</html>