<%@page import="com.ty.Service.TrainningProgramsService"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.dto.TrainningPrograms"%>
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
  <li><a  href ="CoOrdinateWorksHome.jsp" >Back</a></li>
</ul>
	<%
			List<TrainningPrograms> list = (List<TrainningPrograms>)request.getAttribute("editvalue");
		%>
		<table border="3" cellpadding=10>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Faculties Name</th>
				<th>Starting Date</th>
				<th>Ending Date</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
				
		<%
		for (TrainningPrograms trainningPrograms : list) {
		%>
			<tr>
				<th><%=trainningPrograms.getId()%></th>
				<th><%=trainningPrograms.getName()%></th>
				<th><%=trainningPrograms.getFacultiesNames()%></th>
				<th><%=trainningPrograms.getStartingDate()%></th>
				<th><%=trainningPrograms.getEndingDate()%></th>
				<th> <a href="edittrinning?id=<%=trainningPrograms.getId()%>">Edit</a> </th>
				<th> <a href="deletetrainning?id=<%=trainningPrograms.getId()%>">Delete</a> </th>
			</tr>
		<%
		}
		%>
		
		</table>
</body>
</html>