<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CONTACT LIST</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>CONTACT LIST</h1>
	</div>
	<div class="container">
		<table class="table">
			<tr><td>NAME</td><td>NUMBER</td><td>ADDRESS</td><td>EMAIL</td><td>ROLE</td><td>EDIT</td><td>DELETE</td></tr>
			
			<c:forEach var="contact" items="${contactList}">
				<tr>
					<td>${contact.name}</td>
					<td>${contact.number }</td>
					<td>${contact.address}</td>
					<td>${contact.email}</td>
					<td>${contact.role}</td>
					<td><a href="<c:url value="/edit/${contact.id}"/>">Edit</a></td>
					<td><a href="<c:url value="/delete/${contact.id}"/>">DELETE</a></td>
				</tr>	
			</c:forEach>
			
			
			<%-- <tr><td>NAME:</td><td><form:input path="name" /></td></tr>
			<tr><td>NUMBER:</td><td><form:input path="number" /></td></tr>
			<tr><td>ADDRESS:</td><td><form:input path="address" /></td></tr>
			<tr><td>EMAIL:</td><td><form:input path="email" /></td></tr>
			<tr><td>ROLE:</td><td><form:select path="role" items="${contact.roles}"/></td></tr> --%>
		</table>
	</div>
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>	
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>		
</body>
</html>