<%@page import="com.winter.app.regions.RegionDTO"%>
<%@page import="com.winter.app.regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//RegionDTO regionDTO = (RegionDTO)request.getAttribute("dto");
	//request.getSession().getServletContext();
	
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Region Detail</h1>
	<h3>${requestScope.dto.region_id}</h3>
	<h3>${requestScope.dto.region_name}</h3>
	<input id="rId" type="hidden" value="">
	<button id="btn" >수정</button>
	<a href="./update.jsp?region_id=${requestScope.dto.region_id}">수정폼 이동</a>
	
	<script type="text/javascript">
		let btn = document.getElementById("btn");
		let v = document.getElementById("rId");
		
		btn.addEventListener("click", function() {
			alert(v.value);
			
			location.href="./update.jsp?region_id="+v.value;
		});
		
	</script>
</body>
</html>