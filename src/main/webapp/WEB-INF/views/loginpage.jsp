<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<link href="/resources/css/loginpage.css" rel='stylesheet' type='text/css' media="all" />

<div class="container" style="height: 550px">
    <br>
    <br>
<div class="login1">
  <h2>Login</h2>
</div>
<div class="login">
<form:form action="loginprocesing" method="post">
    <input name="username" type="text" placeholder="login"/>
    <input name="password" type="password" required pattern="^[a-zA-Z0-9]+$" min="5" placeholder="password"/>
    <button type="submit" class="btn btn-primary btn-block btn-large">Login</button>
</form:form>
    <br>
    <br>
    <br>
    <br>
</div>
</div>

<script>

    document.getElementById('name').onlick = function(){
        if(document.getElementById('user').value == ''){
            console.log("empty_");
        }
    }

</script>