<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Animal Shelter</title>
	</head>
	<body>
		<div>
			<h1>Inventory Management</h1>
			<div>
				<a href="${pageContext.request.contextPath}/">VIEW ALL</a>
				<a href="${pageContext.request.contextPath}/add">ADD A PET</a> 
			</div>
	    </div>
		<div>
			<form action="update" method="post">
				<label>
					Interest
					<select name="interest">
						<option value="true">true</option>
						<option value="false">false</option>
					</select>
				</label>
				<label>
					Interest Name
					<input type="text" name="interestName" value="<c:out value="${pet.interestName}" />" />
				</label>
				<label>
					Interest Phone Number
					<input type="text" name="interestPhoneNum" value="<c:out value="${pet.interestPhoneNum}" />" />
				</label>
				<label>
					Interest Email
					<input type="text" name="interestEmail" value="<c:out value="${pet.interestEmail}" />" />
				</label>
				<input type="submit" value="Save" name="submit" />
			</form>
		</div>
	</body>
</html>