<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Pet Shelter</title>
	</head>
	<body>
	<div>
		<h1>Inventory Management</h1>
		<h2><a href="/pets">View All</a></h2>
	</div>
	<div>
		<table border="1">
        	<caption>All Pets in Shelter</caption>
        
			<tr>
				<td>Name</td>
				<td>Type</td>
				<td>Age</td>
				<td>Breed</td>
				<td>Description</td>
				<td>Shots</td>
				<td>Good with Kids</td>
				<td>Interest</td>
			</tr>
			<c:forEach var="pet" items="${pets}">
				<tr>
		            <td><c:out value="${pet.name}" /></td>
		            <td><c:out value="${pet.type}" /></td>
		            <td><c:out value="${pet.age}" /></td>
		            <td><c:out value="${pet.breed}" /></td>
		            <td><c:out value="${pet.description}" /></td>
		            <td><c:out value="${pet.hasShots()}" /></td>
		            <td><c:out value="${pet.goodWithKids}" /></td>
		            <td><c:out value="${pet.hasInterest()}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</body>
</html>