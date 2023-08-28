<%@page import="com.ty.dto.CoOrdinate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Add icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

.input-container {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  width: 100%;
  margin-bottom: 15px;
}

.icon {
  padding: 10px;
  background: dodgerblue;
  color: white;
  min-width: 50px;
  text-align: center;
}

.input-field {
  width: 100%;
  padding: 10px;
  outline: none;
}

.input-field:focus {
  border: 2px solid dodgerblue;
}

/* Set a style for the submit button */
.btn {
  background-color: dodgerblue;
  color: white;
  padding: 15px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.btn:hover {
  opacity: 1;
}
</style>
</head>
<body>
<%CoOrdinate coOrdinate = (CoOrdinate)request.getAttribute("editvalue") ;%>
<form action="updatecoordinate" style="max-width:500px;margin:auto">
  <div class="input-container">
    <i class="fa fa-user icon"></i>
    <input class="input-field" type="text"  value="<%=coOrdinate.getId() %>" name="id">
  </div>
  
    <div class="input-container">
    <i class="fa fa-user icon"></i>
    <input class="input-field" type="text"  value="<%=coOrdinate.getName()  %>" name="name">
  </div>

  <div class="input-container">
    <i class="fa fa-envelope icon"></i>
    <input class="input-field" type="text"  value="<%=coOrdinate.getEmail()%>" name="email">
  </div>
  
  <div class="input-container">
    <i class="fa fa-key icon"></i>
    <input class="input-field" type="password"  value="<%=coOrdinate.getPassword() %>" name="password">
  </div>
  
  <div class="input-container">
    <i class="fa fa-phone icon"></i>
    <input class="input-field" type="tel"  value="<%=coOrdinate.getPhone()%>" name="phone">
  </div>

  <button type="submit" class="btn">Register</button>
</form>

</body>
</html>