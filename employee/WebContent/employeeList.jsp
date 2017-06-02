<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "service.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf8");
	String employeeName = request.getParameter("employeeName");
	String employeeGender = request.getParameter("employeeGender");
	String[] skillName = request.getParameterValues("skillName");
	System.out.println(employeeName+" <-- employeeName getParam");
	System.out.println(employeeGender+" <-- employeeGender getParam");
	System.out.println(skillName+" <-- skillName getParam");

	EmployeeService employeeservice = new EmployeeService();
	ArrayList<Employee> list = employeeservice.selectEmployee(employeeName, employeeGender, skillName);
%>
	<table>
		<thead>
			<th>ID</th>
			<th>NAME</th>
			<th>GENDER</th>
			<th>SKILL</th>
		</thead>

<%	
	for(Employee e : list){
%>
	<tbody>
		<td><%= e.getEmployeeNo() %></td>
		<td><%= e.getEmployeeName() %></td>
		<td><%= e.getEmployeeGender() %></td>
<%
	for(int i=0; i<e.getSkill().size(); i++){
%>				
		<td><%= e.getSkill().get(i).getSkillName() %></td>
<%
	}
	}
%>
	</tbody>
	</table>
</body>
</html>