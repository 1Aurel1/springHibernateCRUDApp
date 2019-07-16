<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Customer</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/add-customer-style.css" />
</head>
<body>
	<div id="wapper">
		<div id="header">
		<h2>
			CRM - Customer Relationship Manager
		</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>New Customer</h3>
		<f:form action="saveCustomer" modelAttribute="customer" method="post">
			
			<!-- Associate data with customer id -->
			<f:hidden path="id"/>
			
			<table>
				<tbody>
					<tr>
						<td> <label>Frist Name: </label> </td>
						<td> <f:input path="firstName"/>
					</tr>
					<tr>
						<td> <label>Last Name: </label> </td>
						<td> <f:input path="lastName"/>
					</tr>
					<tr>
						<td> <label>Email: </label> </td>
						<td> <f:input path="email"/>
					</tr>
					<tr> 
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		</f:form>
		<div style="clear; both;" ></div>
		<p>
			<a href="${pageContext.request.contextPath }/customer/list" >Back</a>
		</p>
	</div>
</body>
</html>