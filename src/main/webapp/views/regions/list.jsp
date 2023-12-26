<%@page import="com.winter.app.regions.RegionDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.winter.app.regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//java 구역- 스크립틀릿
	RegionDAO regionDAO = new RegionDAO();
	List<RegionDTO> ar = regionDAO.getList();
%>    
<!--  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Regions List
	<h1>Regions List</h1>
	<table>
		<thead>
			<tr>
				<th>REGION_ID</th>
				<th>REGION_NAME</th>
			</tr>
		</thead>
		
		<tbody>
		<% for(RegionDTO regionDTO:ar){%>
			<tr>
				<td><%= regionDTO.getRegion_id() %> </td>
				<td><a href="./detail.jsp?region_id=<%= regionDTO.getRegion_id()%>"><%= regionDTO.getRegion_name() %></a></td>
			</tr>
		<%}%>
		</tbody>
		
	</table>
	
	<a href="./add.jsp">대륙추가</a>

</body>
</html>