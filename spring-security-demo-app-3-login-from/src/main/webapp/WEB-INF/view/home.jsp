<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	
	Welcome to the luv2code company home page!
	
	<p>
		User : <security:authentication property="principal.username" />
		<br><br>
		Roles(s) : <security:authentication property="principal.authorities" />
	</p>
	
	<security:authorize access="hasRole('MANAGER')">
	
	<p>
		<a href="${pageContext.request.contextPath }/leaders">Leadership Meeting</a>
	</p>
	
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
	
	<p>
		<a href="${pageContext.request.contextPath }/systems">IT Systems Meeting</a>
	</p>
	
	</security:authorize>


	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
</body>

</html>