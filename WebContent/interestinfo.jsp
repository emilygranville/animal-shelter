<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Animal Shelter</title>
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
			<form action="update" method="post">
				<input type="hidden" name="subaction" value="adoption_request" />
				<label>
					Interest
					<select name="interest">
						<c:set var="selected" value="selected='selected'"/>
						<c:set var="notSelected" value=""/>
						<option value="true" ${pet.hasInterest() ? selected : notSelected}>True</option>
						<option value="false">False</option>
					</select>
				</label>
				<label>
					Interest Name
					<input type="text" name="interestName" value="<c:out value="${pet.getInterestName()}" />" />
				</label>
				<label>
					Interest Phone Number
					<input type="text" name="interestPhoneNum" value="<c:out value="${pet.getInterestPhoneNum()}" />" />
				</label>
				<label>
					Interest Email
					<input type="text" name="interestEmail" value="<c:out value="${pet.getInterestEmail()}" />" />
				</label>
				<input type="hidden" name="id" value="<c:out value="${pet.id}" />" />
				<input type="submit" value="Enter" name="submit" />
			</form>
		</div>
	</body>
</html>