<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<div>
		<c:if test="${not empty message}">${message}</c:if>
	</div>

	<div>
		<form method="POST" enctype="multipart/form-data" action="/">
			<table>
				<tr>
					<td>File to upload:</td>
					<td><input type="file" name="file" /></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="submit">Upload</button></td>
				</tr>
			</table>
		</form>
	</div>

	<div>
		<ul>
			<c:forEach var="file" items="${files }">
				<li><a href="${file}">${file}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>