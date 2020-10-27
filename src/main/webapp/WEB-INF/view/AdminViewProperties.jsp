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
				<th> Id </th>
				<th> Furnished_Status </th>
				<th> Lister_Name </th>
				<th> Location</th>
				<th> Number_of_Rooms </th>
				<th> Type_of_Accomodity </th>
				<th> Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${properties}" var="p">
				<tr>
					<td>${p.id}</td>
					<td>${p.furnished_status}</td>
					<td>${p.lister_name}</td>
					<td>${p.location}</td>
					<td>${p.no_of_rooms}</td>
					<td>${p.type_of_accommodation}</td>
					<td><a href="editProperty/${p.id}">Edit</a> <a href="deleteProperty/${p.id}">Delete</a></td>
				</tr> 
			</c:forEach>
		</tbody>
	</table>
</body>
</html>