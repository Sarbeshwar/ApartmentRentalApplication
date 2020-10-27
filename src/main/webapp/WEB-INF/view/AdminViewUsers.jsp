<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Hello!! Admin. Want Some Changes??</h1>
<table>
		<thead>
			<tr>
				<th> Number </th>
				<th> Name </th>
				<th> Status </th>
				<th> dob</th>
				<th> username </th>
				<th> password </th>
				<th> Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="p">
				<tr>
					<td>${p.number}</td>
					<td>${p.name}</td>
					<td>${p.status}</td>
					<td>${p.dob}</td>
					<td>${p.username}</td>
					<td>${p.password}</td>
					<td><a href="editUser/${p.number}">Edit</a> <a href="deleteUser/${p.number}">Delete</a></td>
				</tr> 
			</c:forEach>
		</tbody>
	</table>

</body>
</html>