<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Custom Login Form</title>

<style>
	.failed {
		color:red;
	}


</style>
</head>
<body>
<h1>My Custom Login Form</h1>
	<form:form action="${pageContext.request.contextPath }/authenticateTheUser" method="POST">
	
		<c:if test="${param.error != null }">
			<i class="failed">Sorry! you entered wrong password or id</i>
		</c:if>
		
		<p>
			User name: <input type="text" name="username" />
		</p>
		
		<p>
			Password: <input type="password" name="password" />
		</p>
		
		<input type="submit" value="Login" />
	
	</form:form>
</body>
</html>