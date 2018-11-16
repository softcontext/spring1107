<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
    .bs-example{
    	margin: 20px;
    }
</style>
</head>
<body>
  <div class="bs-example">
    <h3>Employee's Search</h3>
    <form class="" action="" method="post">
      <table class="table table-hover">
        <tr>
          <th>Name</th>
          <td>
            <input type="text" name="ename" placeholder="직원명을 입력하세요">
          </td>
        </tr>
        <tr>
          <th>Job</th>
          <td>
            <input type="text" name="job">
          </td>
        </tr>
        <tr>
          <th>Salary</th>
          <td>
            <input type="number" name="salMin" min="0">
            ~
            <input type="number" name="salMax" min="0">
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <button type="submit">Search</button>
          </td>
        </tr>
      </table>
    </form>
    <hr>
    <table class="table table-hover">
      <thead>
        <tr>
          <th>No</th>
          <th>Name</th>
          <th>Job</th>
          <th>Salary</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach var="e" items="${emps }">
        <tr>
          <td>${e.empno }</td>
          <td>${e.ename }</td>
          <td>${e.job }</td>
          <td>${e.sal }</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>
