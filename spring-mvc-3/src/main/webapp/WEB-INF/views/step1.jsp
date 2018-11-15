<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h3>step1.jsp</h3>
	<p>name = ${member.name }</p>
	<p>address = ${member.address }</p>
	
	<form action="step2" method="post">
		<table>
			<tr>
				<th>Name</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th></th>
				<td><button type="submit">Next</button></td>
			</tr>
		</table>
	</form>
</body>
</html>
