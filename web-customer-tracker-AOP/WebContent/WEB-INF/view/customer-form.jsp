
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
 <title>List Customers</title>
 <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css " />
</head>
<body>
<div>
	<div>
		<h2>CRM-customer relationship manager</h2>
	
	</div>
</div>

<div>
	<h3>Save Customer</h3>
	<form:form action="saveCustomer" modelAttribute="customer" method="post">
	
	
	
		<form:hidden path="id" />
		
		<table>
		<tbody>
		<tr>
		<td><label>First name:</label></td>
		<td><form:input path="firstName" /></td>
		</tr>
		
		<tr>
		<td><label>Last name:</label></td>
		<td><form:input path="lastName" /></td>
		</tr>
		
		<tr>
		<td><label>Email:</label></td>
		<td><form:input path="email" /></td>
		</tr>
		
		<tr>
		<td><label></label></td>
		<td><input type="submit" value="Save" class="save"/></td>
		</tr>
		
		</tbody>
		
		
		</table>
	
	
	</form:form>
	
	<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
</div>

</body>
</html>