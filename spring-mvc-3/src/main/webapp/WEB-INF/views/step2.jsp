<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h3>step2.jsp</h3>
	<p>${member }</p>
	
	<form action="step3" method="post">
		<h5 class="error">${fail }</h5>
		<table>
			<tr>
				<th>Address</th>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<th></th>
				<td><button type="submit">Send</button></td>
			</tr>
		</table>
	</form>
	<hr />
	<form:form action="step3" method="post" commandName="member">
		<!--
			commandName="member" : 사용자가 작성한 데이터를 보관하는 객체
			BindingResult 설정없음 자동으로 인식 : 데이터를 검증한 결과(에러정보)를 보관하는 객체
		-->
		<form:errors path="*" cssClass="error" element="h5" />
		<table>
			<tr>
				<th>Address</th>
				<td>
					<form:input type="text" path="address" /><br /> 
					<form:errors path="address" cssClass="error" element="p" />
				</td>
			</tr>
			<tr>
				<th></th>
				<td><form:button type="submit">Send</form:button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>