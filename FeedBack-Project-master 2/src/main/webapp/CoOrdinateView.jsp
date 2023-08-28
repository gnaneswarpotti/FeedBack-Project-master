<%@page import="com.ty.dto.CoOrdinate"%>
<%@page import="java.util.List"%>
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
  <li><a  href ="CoOrdinateHome.jsp" >Back</a></li>
</ul>
		<%
			List<CoOrdinate> list = (List<CoOrdinate>)request.getAttribute("view");
		%>
		<table border="3" cellpadding=10>
			<tr>
				<th>Id</th>
				<th>CoOrdinate Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Phone</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
				
		<%
		for (CoOrdinate coOrdinate : list) {
		%>
			<tr>
				<th><%=coOrdinate.getId()%></th>
				<th><%=coOrdinate.getName()%></th>
				<th><%=coOrdinate.getEmail()%></th>
				<th><%=coOrdinate.getPassword()%></th>
				<th><%=coOrdinate.getPhone()%></th>
				<th> <a href="editcoordinate?id=<%=coOrdinate.getId()%>">Edit</a> </th>
				<th> <a href="deletecoordinate?id=<%=coOrdinate.getId()%>">Delete</a> </th>
			</tr>
		<%
		}
		%>
		
		</table>
</body>
</html>