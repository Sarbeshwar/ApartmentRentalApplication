<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Fill Product Details</h1> <br>

<form action="../editUserDetails" method="post">
	
	Number :  <input type="text" id="number" name="number" value="${user.number}"><br>
	Name :  <input type="text" id="name" name="name" value="${user.name}"><br>
	Status :  <input type="text" id="status" name="status" value="${user.status}"><br>
	Dob : <input type="text" id="dob" name="dob" value="${user.dob}"><br>
	UserName : <input type="text" id="username" name="username" value="${user.username}"><br>
	Password : <input type="text" id="password" name="password" value="${user.password}"><br>
	<button type="submit">submit</button>
	
</form>

</body>
</html>