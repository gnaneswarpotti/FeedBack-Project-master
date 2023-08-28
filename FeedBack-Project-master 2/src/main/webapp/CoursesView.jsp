<%@page import="java.util.List"%>
<%@page import="com.ty.dto.Courses"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
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
  <li><a  href ="CoursesHome.jsp" >Back</a></li>
</ul>
	<%
			List<Courses> list = (List<Courses>)request.getAttribute("view");
		%>
		<table border="3" cellpadding=10>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Fees</th>
				<th>Duration</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
				
		<%
		for (Courses courses : list) {
		%>
			<tr>
				<th><%=courses.getId()%></th>
				<th><%=courses.getCourseName()%></th>
				<th><%=courses.getFees()%></th>
				<th><%=courses.getDuration()%></th>
				<th> <a href="editcourses?id=<%=courses.getId()%>">Edit</a> </th>
				<th> <a href="deletecourses?id=<%=courses.getId()%>">Delete</a> </th>
			</tr>
		<%
		}
		%>
		
		</table>
</body>
</html>