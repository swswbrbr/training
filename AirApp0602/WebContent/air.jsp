<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "service.*" %>
<%@ page import = "java.util.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style>
		table {
		    border-collapse: collapse;
		    text-align: center;
		}
	</style>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String sidoName = request.getParameter("sidoName");
	System.out.println(sidoName+" <--air.jsp");
	AirService airService = new AirService();
	List<Item> list = airService.getItemList(sidoName);
%>
	<table border="1" border-collapse="bordercollapse">
		<thead>
			<tr>
				<th>dataTime</th>
				<th>stationName</th>
				<th>so2Value</th>
				<th>coValue</th>
				<th>o3Value</th>
				<th>pm10Value</th>
				<th>pm25Value</th>
				<th>미세먼지</th>
			</tr>
		</thead>
		<tbody>
<%

	for(Item item : list){
		String str = "";
		if((item.getPm10Value()).equals("-")){
			str = "-";
		}else{
		int temp = Integer.parseInt(item.getPm10Value());
		if(temp < 31){
			str = "좋음";
		}else if(temp < 81){
			str = "보통";
		}else if(temp < 121){
			str = "나쁨";
		}else if(temp > 121){
			str="매우나쁨";
		}else{
			str="-";
		}
		}
%>
		<tr>
			<td><%= item.getDataTime() %></td>
			<td><%= item.getStationName() %></td>
			<td><%= item.getSo2Value() %></td>
			<td><%= item.getCoValue() %></td>
			<td><%= item.getO3Value() %></td>
			<td><%= item.getPm10Value() %></td>
			<td><%= item.getPm25Value() %></td>
			<td><%= str %></td>
		</tr>
<%
		}
%>
		</tbody>
</table>
</body>
</html>