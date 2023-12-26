<%@page import="com.winter.app.regions.RegionDTO"%>
<%@page import="com.winter.app.regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	RegionDAO dao = new RegionDAO();
	RegionDTO regionDTO = new RegionDTO();
	String n= request.getParameter("region_id");
	int num = Integer.parseInt(n);//NumberFormat
	regionDTO.setRegion_id(num);
	regionDTO = dao.getDetail(regionDTO);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Region Detail</h1>
	<h3><%= regionDTO.getRegion_name() %></h3>
	<input id="rId" type="hidden" value="<%= regionDTO.getRegion_id()%>">
	<button id="btn" >수정</button>
	<a href="./update.jsp?region_id=<%= regionDTO.getRegion_id()%>">수정폼 이동</a>
	
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