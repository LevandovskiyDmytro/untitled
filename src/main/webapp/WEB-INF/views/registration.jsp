<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link href="/resources/css/loginpage.css" rel='stylesheet' type='text/css' media="all" />

<br>
<br>
<div class="container" style="height: 500px">
<div class="login">
	<h2 style="text-align: center"> Sign Up Here</h2>
<form:form modelAttribute="user" action="saveUser" method="post">
<div>
	<label for="Name">${usernameException}</label>
	<form:input path="name" type="text" placeholder="Login"/>
</div>
	<div>
		${emailException}
	<form:input path="email" type="email" placeholder="Email" />
	</div>
	<div>
		${passwordException}
			<form:input path="password" type="password" placeholder="Password" />
	</div>
		${phoneException}
	<form:input path="phone" type="text" placeholder="Phone" />
	<div>
		<button type="submit" class="btn btn-primary btn-block btn-large">Submit</button>
	</div>
</form:form>
	<br>
	<br>
	<br>
	<br>
</div>
</div>