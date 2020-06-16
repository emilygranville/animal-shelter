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
			<c:if test="${pet != null}">
				<h2>Edit Pet Info</h2>
				<form action="update" method="post">
					<input type="hidden" name="id" value="<c:out value="${pet.id}" />" />
					          
					<label>
						Name
						<input type="text" name="name" value="<c:out value="${pet.name}" />" />
					</label>
					<label>
						Type
						<input type="text" name="type" value="<c:out value="${pet.type}" />" />
					</label>
					<label>
						Age
						<input type="text" name="age" value="<c:out value="${pet.age}" />" />
					</label>
					<label>
						Breed
						<input type="text" name="breed" value="<c:out value="${pet.breed}" />" />
					</label>
					<label>
						Description
						<input type="text" name="description" value="<c:out value="${pet.description}" />" />
					</label>
					<label>
						Shots
						<select name="shots">
							<c:set var="selected" value="selected='selected'"/>
							<c:set var="notSelected" value=""/>
							<option value="true" ${pet.hasShots() ? selected : notSelected}>True</option>
							<option value="false">False</option>
						</select>
					</label>
					<label>
						Kid Friendly
						<select name="goodWithKids">
							<c:set var="selected" value="selected='selected'"/>
							<c:set var="notSelected" value=""/>
							<option value="true" ${pet.isGoodWithKids() ? selected : notSelected}>True</option>
							<option value="false">False</option>
						</select>
					</label>
					<label>
						Interest
						<select name="interest">
							<c:set var="selected" value="selected='selected'"/>
							<c:set var="notSelected" value=""/>
							<option value="true" ${pet.hasInterest() ? selected : notSelected}>True</option>
							<option value="false">False</option>
						</select>
					</label>
					<c:if test="${pet.hasInterest()}">
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
					</c:if>
					<input type="submit" value="Save" name="submit" />
					<input type="submit" value="Delete" name="submit" />
				</form>
      		</c:if>
			<c:if test="${pet == null}">
				<h2>Add Pet</h2>
				<form action="insert" method="post">
					<input type="hidden" name="id" />
					          
					<label>
						Name
						<input type="text" name="name"/>
					</label>
					<label>
						Type
						<input type="text" name="type"/>
					</label>
					<label>
						Age
						<input type="text" name="age"/>
					</label>
					<label>
						Breed
						<input type="text" name="breed"/>
					</label>
					<label>
						Description
						<input type="text" name="description"/>
					</label>
					<label>
						Shots
						<select name="shots">
							<option value="true">True</option>
							<option value="false">False</option>
						</select>
					</label>
					<label>
						Kid Friendly
						<select name="goodWithKids">
							<option value="true">True</option>
							<option value="false">False</option>
						</select>
					</label>
					<label>
					Interest
					<select name="interest">
						<option value="true">True</option>
						<option value="false">False</option>
					</select>
					</label>
					<input type="submit" value="Add" name="submit" />
				</form>
			</c:if>
    	</div>
	</body>
</html>