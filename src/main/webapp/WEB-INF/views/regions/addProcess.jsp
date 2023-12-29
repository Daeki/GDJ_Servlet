<%@page import="com.winter.app.regions.RegionDTO"%>
<%@page import="com.winter.app.regions.RegionDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	RegionDAO regionDAO = new RegionDAO();
	RegionDTO regionDTO = new RegionDTO();
	String id = request.getParameter("region_id");
	String name = request.getParameter("region_name");
	
	regionDTO.setRegion_id(Integer.parseInt(id));
	regionDTO.setRegion_name(name);
	
	int result = regionDAO.add(regionDTO);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Process</h1>
	
	<script type="text/javascript">
		let result='<%= result%>';
		if(result>0){
			alert('등록 성공');
		}else {
			alert('등록 실패')
		}
		
		window.location.href="./list.jsp";
		
	</script>

</body>
</html>