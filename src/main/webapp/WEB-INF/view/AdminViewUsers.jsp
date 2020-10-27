<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>ADMIN-VIEW-USERS</title>
<link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css"
	rel="stylesheet">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

	<header class="text-gray-700 body-font">
		<div
			class="container mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center">
			<a
				class="flex title-font font-medium items-center text-gray-900 mb-4 md:mb-0">
				<svg fill="none" stroke="currentColor" stroke-linecap="round"
					stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24">
                  </svg> <span class="ml-3 text-xl">Admin View Users</span>
			</a>
			<nav
				class="md:ml-auto flex flex-wrap items-center text-base justify-center">
				<a class="mr-5 hover:text-gray-900"
					href="/AppartmentRental/AdminViewUsers">ViewAllUsers</a> <a
					class="mr-5 hover:text-gray-900"
					href="/AppartmentRental/AdminViewProperties">ViewAllProperties</a>
					<a class="mr-5 hover:text-gray-900" href="/AppartmentRental/">Home</a>

			</nav>
		</div>
	</header>

	<table class="table">
	<caption>TABLE</caption>
		<thead>
			<tr>
				<th id="number">Number</th>
				<th id="name">Name</th>
				<th id="status">Status</th>
				<th id="dob">dob</th>
				<th id="username">username</th>
				<th id="password">password</th>
				<th id="action">Action</th>
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
					<td><a href="editUser/${p.number}">Edit</a> <a
						href="deleteUser/${p.number}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	<footer class="text-gray-700 body-font">
		<div
			class="container px-5 py-8 mx-auto flex items-center sm:flex-row flex-col">
			<a
				class="flex title-font font-medium items-center md:justify-start justify-center text-gray-900">
				<svg fill="none" stroke="currentColor" stroke-linecap="round"
					stroke-linejoin="round" stroke-width="2" viewBox="0 0 24 24">
              </svg> <span class="ml-3 text-xl">Property4Rent</span>
				<p
					class="text-sm text-gray-500 sm:ml-4 sm:pl-4 sm:border-l-2 sm:border-gray-200 sm:py-2 sm:mt-0 mt-4">�TEAM-3-VIRTUSA</p>
			</a> <span
				class="inline-flex sm:ml-auto sm:mt-0 mt-4 justify-center sm:justify-start">
				<a class="text-gray-500"> <svg fill="currentColor"
						stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
						class="w-5 h-5" viewBox="0 0 24 24">
                <path
							d="M18 2h-3a5 5 0 00-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 011-1h3z"></path>
              </svg>
			</a> <a class="ml-3 text-gray-500"> <svg fill="currentColor"
						stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
						class="w-5 h-5" viewBox="0 0 24 24">
                <path
							d="M23 3a10.9 10.9 0 01-3.14 1.53 4.48 4.48 0 00-7.86 3v1A10.66 10.66 0 013 4s-4 9 5 13a11.64 11.64 0 01-7 2c9 5 20 0 20-11.5a4.5 4.5 0 00-.08-.83A7.72 7.72 0 0023 3z"></path>
              </svg>
			</a> <a class="ml-3 text-gray-500"> <svg fill="none"
						stroke="currentColor" stroke-linecap="round"
						stroke-linejoin="round" stroke-width="2" class="w-5 h-5"
						viewBox="0 0 24 24">
                <rect width="20" height="20" x="2" y="2" rx="5" ry="5"></rect>
                <path
							d="M16 11.37A4 4 0 1112.63 8 4 4 0 0116 11.37zm1.5-4.87h.01"></path>
              </svg>
			</a> <a class="ml-3 text-gray-500"> <svg fill="currentColor"
						stroke="currentColor" stroke-linecap="round"
						stroke-linejoin="round" stroke-width="0" class="w-5 h-5"
						viewBox="0 0 24 24">
                <path stroke="none"
							d="M16 8a6 6 0 016 6v7h-4v-7a2 2 0 00-2-2 2 2 0 00-2 2v7h-4v-7a6 6 0 016-6zM2 9h4v12H2z"></path>
                <circle cx="4" cy="4" r="2" stroke="none"></circle>
              </svg>
			</a>
			</span>
		</div>
	</footer>
</body>
</html>