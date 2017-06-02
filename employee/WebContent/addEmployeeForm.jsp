<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addEmployeeForm</title>
 	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  	<style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  	</style>
</head>
<body>
	<div class="jumbotron">
	  <div class="container text-center">
	    <h1>Employee Skill Form</h1>      
	    <p>이름, 성별, 해당 기술을 모두 입력해주시기 바랍니다.</p>
	  </div>
	</div>
	
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>                        
	      </button>
	      <a class="navbar-brand" href="./index.jsp">BR17</a>
	    </div>
	    <div class="collapse navbar-collapse" id="myNavbar">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="./addEmployeeForm.jsp">Form</a></li>
	        <li><a href="addEmployeeForm.jsp">입력하기</a></li>
	        <li><a href="employeeList.jsp">전체글보기</a></li>
	        <li><a href="#">Contact</a></li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="#"><span class="glyphicon glyphicon-user"></span>로그인하기</a></li>
	        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span>유료구매</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>
	
	<div class="container">    
		<div class="row">
		<form action="./employeeList.jsp" method="post">
		<div>
			<label for="employeeName">이름</label>
			<input name="employeeName" id="employeeName" type="text">
		</div>
		<div>
			<label>성별</label>
			<input name="employeeGender" class="employeeGender" type="radio" value="남">남
			<input name="employeeGender" class="employeeGender" type="radio" value="여">여
		</div>
		<div>
			<label>기술</label>
			<input name="skillName" class="skillName" type="checkbox" value="JAVA">JAVA
			<input name="skillName" class="skillName" type="checkbox" value="JSP">JSP
			<input name="skillName" class="skillName" type="checkbox" value="HTML">HTML
			<input name="skillName" class="skillName" type="checkbox" value="JAVASCRIPT">JAVASCRIPT
			<input name="skillName" class="skillName" type="checkbox" value="SQL">SQL
		</div>
		<div>
			<input type="submit" value="입력">
		</div>
	</form>
	</div>
	</div>
</body>
</html>