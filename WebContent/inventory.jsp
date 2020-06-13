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
		<a href="${pageContext.request.contextPath}/">VIEW ALL</a>
		<a href="${pageContext.request.contextPath}/add">ADD A PET</a> 
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
        				<a href="${pageContext.request.contextPath}/update?action=rent&id=
							<c:out value="${pet.id}" />">Add Interest
						</a>
       					<a href="${pageContext.request.contextPath}/edit?id=
	  						<c:out value="${pet.id}" />">Edit
						</a>
     				</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	</body>
</html>