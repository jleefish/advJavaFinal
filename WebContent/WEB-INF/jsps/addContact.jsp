<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADD CONTACT</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>ADD CONTACT</h1><br/><br/>
	</div>
	<div class="container">
		<c:url var="url" value="/savecontact"/>
		<form:form commandName="contact" method="post" action="${url}">
			<table class="table">
				<tr><td>NAME:</td><td><form:input path="name" /></td></tr>
				<tr><td>NUMBER:</td><td><form:input path="number" /></td></tr>
				<tr><td>ADDRESS:</td><td><form:input path="address" /></td></tr>
				<tr><td>EMAIL:</td><td><form:input path="email" /></td></tr>
				<tr><td>ROLE:</td><td><form:select path="role" items="${contact.roles}"/></td></tr>
			</table>
			<input type="submit" value="create contact"/>
		</form:form>
	</div>
	<br/>
	<div class="container">
		<c:url value="/contactlist" var="url" />
​		<a href="${url}"><strong>Contact List</strong></a>
	</div>
	
	
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>	
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>	
</body>
</html>