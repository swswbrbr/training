<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "service.AirService" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>미세먼지정보</title>
</head>
<body>
	<form action="./air.jsp" method="get">
		<select name="sidoName">
			<option value="서울">서울</option>
			<option value="부산">부산</option>
			<option value="대구">대구</option>
			<option value="인천">인천</option>
			<option value="광주">광주</option>
			<option value="대전">대전</option>
			<option value="울산">울산</option>
			<option value="경기">경기</option>
			<option value="강원">강원</option>
			<option value="충북">충북</option>
			<option value="충남">충남</option>
			<option value="전북">전북</option>
			<option value="전남">전남</option>
			<option value="경북">경북</option>
			<option value="경남">경남</option>
			<option value="제주">제주</option>
			<option value="세종">세종</option>
		</select>
		<input type="submit" value="검색"></input>
	</form>
</body>
</html>