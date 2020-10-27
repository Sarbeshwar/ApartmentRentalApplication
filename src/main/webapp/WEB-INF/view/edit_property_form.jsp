<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Fill Property Details</h1> <br>

<form action="../editPropertyDetails" method="post">
	
	Id :  <input type="text" id="id" name="id" value="${property.id}"><br>
	Furnished_status :  <input type="text" id="furnished_status" name="furnished_status" value="${property.furnished_status}"><br>
	Lister_Name :  <input type="text" id="lister_name" name="lister_name" value="${property.lister_name}"><br>
	Location : <input type="text" id="location" name="location" value="${property.location}"><br>
	Number_of_rooms : <input type="text" id="no_of_rooms" name="no_of_rooms" value="${property.no_of_rooms}"><br>
	Type_of_Accomodity : <input type="text" id="type_of_accomodity" name="type_of_accommodation" value="${property.type_of_accommodation}"><br>
	<button type="submit">submit</button>
	
</form>

</body>
</html>