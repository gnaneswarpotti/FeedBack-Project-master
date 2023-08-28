<%@page import="java.util.List"%>
<%@page import="com.ty.dto.FeedBack"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
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
<body>
<ul>
  <li><a  href ="FeedBackHome.jsp" >Back</a></li>
</ul>
	<%
			List<FeedBack> list = (List<FeedBack>)request.getAttribute("view");
		%>
		<table border="3" cellpadding=10>
			<tr>
				<th>Id</th>
				<th>Participators Name</th>
				<th>Faculties Name</th>
				<th>Courses Name</th>
				<th>Rattings</th>
				<th>Description</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
				
		<%
		for (FeedBack feedBack : list) {
		%>
			<tr>
				<th><%=feedBack.getId()%></th>
				<th><%=feedBack.getParticepateName()%></th>
				<th><%=feedBack.getFacultyName()%></th>
				<th><%=feedBack.getCourseName()%></th>
				<th><%=feedBack.getRatings()%></th>
				<th><%=feedBack.getDescription()%></th>
				<th> <a href="edit?id=<%=feedBack.getId()%>">Edit</a> </th>
				<th> <a href="deletefeedback?id=<%=feedBack.getId()%>">Delete</a> </th>
			</tr>
		<%
		}
		%>
		
		</table>
</body>
</html>