<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Pet Shelter</title>
		<style type="text/css">
	      <%@ include file="css/css.css" %>
	    </style>
	</head>
	<body>
		<div>
			<h1>Inventory Management</h1>
			<div class="header">
				<a href="${pageContext.request.contextPath}/" class="header-button">VIEW ALL</a>
				<a href="${pageContext.request.contextPath}/add" class="header-button">ADD A PET</a> 
			</div>
		</div>
		<div>
			<table border="1">
				<tr>
					<td>Name</td>
					<td>Type</td>
					<td>Age</td>
					<td>Breed</td>
					<td>Description</td>
					<td>Shots</td>
					<td>Kid Friendly</td>
					<td>Interest</td>
					<td>Actions</td>
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
			            <td>
	        				<a href="${pageContext.request.contextPath}/edit?action=adoption_request&id=${pet.id}" class="button">
						          Update Interest
						    </a>
						    <a href="${pageContext.request.contextPath}/edit?id=${pet.id}" class="button">
						         Edit
						    </a>
	     				</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>