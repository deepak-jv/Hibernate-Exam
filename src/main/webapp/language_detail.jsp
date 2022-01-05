<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.java.countryManagement.model.Country"%>
<%@page import="com.java.countryManagement.model.Language"%>
<%@page import="com.java.countryManagement.dao.CountryDao"%>
<%@page import="com.java.countryManagement.dao.LanguageDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Country Details</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</head>
<body>



	

	<br>
	<div style='background-color:blue;margin-left:2px;margin-right:2px'>
		<h2 style="color: white; text-align: center">Language Details</h2>
	</div>
	<hr>

	<table class="table table-bordered table-hover table-dark"
		style="margin: 2px;margin-bottom:10px">
		<thead>
			<tr>
				<th>Language Id</th>
				<th>Language Name</th>
				<th>Country</th>
				

			</tr>
		</thead>

		<tbody>

			<tr>

				<%
				int id = Integer.parseInt(request.getParameter("id"));
				LanguageDao lang_dao = new LanguageDao();
				Language language = lang_dao.getById(id);
				%>

				<td><%=language.getId()%></td>
				<td><%=language.getName()%></td>
			
				<%
				List<Country> country = language.getCountry();
				for (Country c : country) {
					out.println("<td>" + c.getName() + "</td>");
				}
				%>

			</tr>
			<tr>
			<td> <a class="btn btn-primary" href="home.jsp">back</a> </td>
			</tr>

		</tbody>

	</table>


</body>
</html>