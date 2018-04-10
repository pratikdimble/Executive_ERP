<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page import = "java.io.*,java.util.*" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
</head>
<body background="img/back.jpg" >

<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="firstpage.jsp">Home</a>
    <a href="displayproduct.jsp">Back</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
	<form action="./controller" method="POST">
	<font color="RED"><b>
	<pre>
	<c:choose>
	 	 <c:when test="${!empty listprodDTOs}">
 	   <c:forEach var="dto"  items="${listprodDTOs}">
 	   	Product ID	 :: <input type="text" name="pid" value="${dto.pid}" readonly="readonly"><br>
   		Product Name	 :: <input type="text" name="name" value="${dto.name}" required="required" readonly="readonly"/><br>
   		Product Type	 :: <input type="text" name="type" value="${dto.type}" required="required" readonly="readonly"/><br>
   		Company Name   	 :: <input type="text" name="company" value="${dto.company}" required="required"/><br>
   		Product Cost 	 :: <input type="text" name="cost" value="${dto.cost}" required="required"/><br>
   		Product Quantity :: <input type="text" name="quantity" value="${dto.quantity}" required="required"/><br>
   		Product Warranty :: <input type="text" name="warranty" value="${dto.warranty}" required="required"/><br>
  		 <input type="submit" name="operation" value="Save" onClick="conf()"/>&nbsp&nbsp<a href="displayproduct.jsp"><input type="button" value="CANCEL" onClick="exit()"/></a>	 
  	    </c:forEach>
  </c:when>

  <c:otherwise>
          <%
         // New location to be redirected
     response.sendRedirect("http://localhost:1010/12_24_Servlet_ServletWrappers/displayproduct.jsp");
      %>
      
  </c:otherwise>
</c:choose>	   
	</font></b></pre>
</form>
<script type="text/javascript">
function conf()
{
var con=confirm("Do you want to Save the Changes???");
}
function exit()
{
var con=confirm("Do you want to Exit???");
}
</script>
</body>
</html>