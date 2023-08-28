<%@page import="com.ty.dto.Faculties"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style >
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}
</style>
</head>
<body>
<ul>
  <li><a  href ="FacultiesHome.jsp" >Back</a></li>
</ul>
		<%
			List<Faculties> list = (List<Faculties>)request.getAttribute("viewFaculties");
		%>
		<table border="3" cellpadding=10>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
				<th>Password</th>
				<th>Salary</th>
				<th>Skills</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
				
		<%
		for (Faculties faculties : list) {
		%>
			<tr>
				<th><%=faculties.getId()%></th>
				<th><%=faculties.getName()%></th>
				<th><%=faculties.getEmail()%></th>
				<th><%=faculties.getPhone()%></th>
				<th><%=faculties.getPassword()%></th>
				<th><%=faculties.getSalary()%></th>
				<th><%=faculties.getSkills()%></th>
				<th> <a href="editfacultie?id=<%=faculties.getId()%>">Edit</a> </th>
				<th> <a href="deletefaculties?id=<%=faculties.getId()%>">Delete</a> </th>
			</tr>
		<%
		}
		%>
		
		</table>
</body>
</html>