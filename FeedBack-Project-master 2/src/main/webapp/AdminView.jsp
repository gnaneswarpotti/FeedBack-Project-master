<%@page import="com.ty.dto.Admin"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
			List<Admin> list = (List<Admin>)request.getAttribute("view");
		%>
		<table border="3" cellpadding=10>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
				
		<%
		for (Admin admin : list) {
		%>
			<tr>
				<th><%=admin.getId()%></th>
				<th><%=admin.getName()%></th>
				<th><%=admin.getEmail()%></th>
				<th><%=admin.getPhone()%></th>
				<th> <a href="editadmin?id=<%=admin.getId()%>">Edit</a> </th>
				<th> <a href="deleteadmin?id=<%=admin.getId()%>">Delete</a> </th>
			</tr>
		<%
		}
		%>
		
		</table>
</body>
</html>