<%@page import="com.ty.dto.FeedBack"%>
<%@page import="com.ty.Service.FeedBackService"%>
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
  background-color: lightblue;
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
<%
FeedBack feedBack1=(FeedBack)request.getAttribute("editsValue");
%>

<form action="updatefeedback" style="max-width:500px;margin:auto">
  <h2>Create FeedBack</h2>
  <div class="input-container">
    <i class="fa fa-idbadge icon"></i>
    <input class="input-field" type="text" value="<%=feedBack1.getId()%>" name="id" readonly="readonly">
  </div>
  
  <div class="input-container">
    <i class="fa fa-book icon"></i>
    <input class="input-field" type="text" placeholder="Courses Name" name="cname" >
  </div>
  
  <div class="input-container">
    <i class="fa fa-user icon"></i>
    <input class="input-field" type="text" placeholder="Facultiy Name" name="fname" >
  </div>
  
  <div class="input-container">
    <i class="fa fa-user icon"></i>
    <input class="input-field" type="text" value="<%=feedBack1.getParticepateName() %>" name="pname" readonly="readonly">
  </div>

  <div class="input-container">
    <i class="fa fa-star icon"></i>
    <select name="ratting"  value="<%=feedBack1.getRatings()%>" >
    	<option value="5-Excellent">5-Excellent
    	<option value="4-Good">4-Good
    	<option value="3-Average">3-Average
    	<option value="2-Below Average">2-Below Average
    	<option value="1-Poor">1-Poor
    </select>
  </div>
  
  <div class="input-container">
    <i class="fa fa-pencil-square icon"></i>
   	<textarea rows="5" cols="20"  value="<%=feedBack1.getDescription()%>"  name="description"></textarea>
  </div>
  <button type="submit" class="btn">Save</button>
</form>

</body>
</html>