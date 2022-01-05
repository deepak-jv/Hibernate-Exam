<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.java.countryManagement.model.Country"%>
<%@page import="com.java.countryManagement.model.Sport"%>
<%@page import="com.java.countryManagement.dao.LanguageDao"%>
<%@page import="com.java.countryManagement.dao.CountryDao"%>
<%@page import=" org.hibernate.Criteria"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</head>
<body style="background:lightblue">

<div style="text-align:center">
	<h1> Company Project</h1>
	
	</div>
	<div class="row" style="margin-top: 10px; margin-bottom: 10px">
		<div class="col-md-1"></div>

		<div class="col-md-5" style="margin: 5px; border: 2px solid black">
			<br>
			<div style='background-color: black'>
				<h3 style='color: white; text-align: center'>Country</h3>
				<div>

					<table class="table table-bordered table-hover table-dark"
						style="margin: 2px; margin-bottom: 10px">
						<thead>
							<tr>
								<th>Country Id</th>
								<th>Country Name</th>

							</tr>
						</thead>

						<tbody>
							<%
							CountryDao country_dao = new CountryDao();
							Criteria criteria = country_dao.getCriteria();
							List<Object[]> country = criteria.list();
							for (Object[] c : country) {
							%>
							<tr>


								<td><%=c[0]%></td>
								<td><%=c[1]%></td>

								<%
								}
								%>

							</tr>

						</tbody>

					</table>









				</div>
			</div>
			<hr>
			<form action='country' method="post">
				<table>

					<tr>
						<th>Country Id :</th>
						<td><input type="number" name="id"
							placeholder="Enter country id" required="required"></td>
					</tr>

				</table>
				<br> <br> <input style="margin-bottom: 5px"
					class="btn btn-success" type="submit" value="Submit"><br>
			</form>
		</div>

		<%--  Language div --%>

		<div class="col-md-5" style="margin: 5px; border: 2px solid black">
			<br>
			<div style='background-color: black'>
				<h3 style='color: white; text-align: center'>Language</h3>
				<div>

					<table class="table table-bordered table-hover table-dark"
						style="margin: 2px; margin-bottom: 10px">
						<thead>
							<tr>
								<th>Language Id</th>
								<th>Language Name</th>

							</tr>
						</thead>

						<tbody>
							<tr>
								<%
							LanguageDao lang_dao = new LanguageDao();
							Criteria criteria1 = lang_dao.getCriteria();
							List<Object[]> language = criteria1.list();
							for (Object[] l : language) {
							%>
							<tr>


								<td><%=l[0]%></td>
								<td><%=l[1]%></td>

								<%
								}
								%>

							</tr>

						</tbody>

					</table>









				</div>
			</div>
			<hr>
			<form action='language' method="post">
				<table>

					<tr>
						<th>Language Id :</th>
						<td><input type="number" name="id"
							placeholder="Enter language id" required="required"></td>
					</tr>

				</table>
				<br> <br> <input style="margin-bottom: 5px"
					class="btn btn-success" type="submit" value="Submit"><br>
			</form>
		</div>

		<div class="col-md-1"></div>
	</div>
</body>
</html>