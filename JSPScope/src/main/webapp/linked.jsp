<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Scope Example</title>

<style>
tr:nth-child(even) {
	background: #aaaaaa;
}
</style>

</head>

<body>
	<h3>Main File: linked.jsp</h3>

	<table>
		<tr>
			<th>Scoped Variable</th>

			<th>Current Value</th>
		</tr>

		<tr>
			<td><b>Page Scope</b> (scopeVarPage)</td>

			<td>${scopeVarPage}</td>
		</tr>

		<tr>
			<td><b>Request Scope</b> (scopeVarRequest)</td>

			<td>${scopeVarRequest}</td>
		</tr>

		<tr>
			<td><b>Session Scope</b> (scopeVarSession)</td>

			<td>${scopeVarSession}</td>
		</tr>

		<tr>
			<td><b>Application Scope</b> (applicationVarPage)</td>

			<td>${scopeVarApplication}</td>
		</tr>
	</table>
	<br />

	<br />



	<br />.

	<br />

	<a href="index.jsp">Go to index page</a>
</body>
</html>