<%@page import="com.winter.app.departments.DepartmentDAO"%>
<%@page import="com.winter.app.departments.DepartmentDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DepartmentDAO dao = new DepartmentDAO();
	List<DepartmentDTO> ar = dao.getList();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>Departments List</h1>
	<table>
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서명</th>
				<th>관리자</th>
			</tr>
		</thead>
		
		<tbody>
		<% for(DepartmentDTO departmentDTO:ar){%>
			<tr>
				<td><%= departmentDTO.getDepartment_id() %> </td>
				<td><%= departmentDTO.getDepartment_name() %></td>
				<td><%= departmentDTO.getManager_id() %></td>
			</tr>
		<%}%>
		</tbody>
		
	</table>
</body>
</html>