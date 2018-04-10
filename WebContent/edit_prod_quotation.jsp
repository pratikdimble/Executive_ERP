<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
 <%@ page import="java.sql.*"%> 
 <!DOCTYPE html>
<html>
<head>
<title>Edit Product Quotation</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- //for-mobile-apps -->
<!-- <link rel="stylesheet" type="text/css" href="css/menubar.css"/> -->
<!-- //custom-theme -->
<link href="css/sstylee.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/sstylee3.css" rel="stylesheet" type="text/css" media="all" />

<!-- js -->
<script type="text/javascript" src="js/jjquery-2.1.4.min.js"></script>
<!-- //js -->
<!-- font-awesome-icons -->
<!-- //font-awesome-icons -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
  
<style>
#tabledata {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#tabledata td, #tabledata th {
    border: 1px solid #ddd;
    padding: 8px;
}

#tabledata tr:nth-child(even){background-color: #f2f2f2;}

#tabledata tr:hover {background-color: #ddd;}

#tabledata th {
/*     padding-top: 5px; */
/*     padding-bottom: 12px; */
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<body  >
<form action="./sale" NAME="form1" method="POST">
<!-- <FORM NAME="form1" METHOD="POST"> -->
<% 

String prodname=null,company=null,prodType=null,provider=null,sername=null,prod=null;
int id=0,quantity=0;
float pcost=0,sercost=0,sid=0;
try { 
Class.forName("oracle.jdbc.OracleDriver"); 
} catch (ClassNotFoundException e) { 
e.printStackTrace(); 
return; 
} 
Connection connection = null; 
try { 
connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle"); 
} 
catch (SQLException e) { 
e.printStackTrace(); 
return; 
} 
%>
<body>
 <div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">

<%
String thisRole = (String) session.getAttribute("role");
	if(thisRole.equalsIgnoreCase("Sales Manager"))
                 	{
                 		%>
                 	 <a href="salesmanagerfirstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else
                 	{
                 				%>
                 	 <a href="index.jsp">Home</a>
                 	 <% 
                 	} 
                 	
                 	%>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>

<!-- banner -->
	<div class="center-container">
		<div class="main">
			<h1 class="w3layouts_head">Edit Product Quotation</h1>
				<div class="w3layouts_main_grid">
					<%
						int thisId = (Integer)session.getAttribute("id");
						String thisName = (String) session.getAttribute("empname");
						PreparedStatement stmt=null,reqst=null;
	ResultSet rs=null,rs1=null,reqrs=null; 
	/*  check that customer and requst is present in salequotation table or not */
	/* reqst=connection.prepareStatement("select * from erp_salequotation where custname Like ? and custreq LIKE ?"); 
		reqst.setString(1,custName+"%");
			reqst.setString(2,custReq+"%");
			reqrs= reqst.executeQuery(); 
			if(reqrs.next())
			{
		stmt=connection.prepareStatement("select * from erp_salequotation where custname Like ? and custreq LIKE ?"); 	
			stmt.setString(1,custName+"%");
			stmt.setString(2,custReq+"%");
				rs1= stmt.executeQuery(); 
 					rs1.next(); */

						%>
<%-- 						<input style="color:red" type="hidden" name="custreq"  value="<%=custReq%>" readonly/>  --%>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label><font color="red">Employee Details</font></label>
							</span>
						</div>
						<hr><br/>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<font color="white">
								<label>Employee Name</label>
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  <input readonly value="<%= thisName %>" type="text" name="name" style="width: 100px; ">
							<label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspEmployee ID </label>
							&nbsp&nbsp<input type="text" name="eid" value="<%= thisId %>" readonly style="width: 45px; ">
						</font>
						</div>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Designation </label>
								<input type="text" name="dsgn" readonly  value="<%= thisRole %>" style="width: 116px; ">
							</span>
						</div>
								<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label><font color="red">Customer Details</font></label>
							</span>
						</div>
						<hr><br/>
						<c:choose>
  							<c:when test="${!empty listsaleDTOs}">
  								<c:forEach var="dto"  items="${listsaleDTOs}">
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Customer Name </label>
								<input style="color:red" style="width: 130px;" type="text" value="${dto.custName}" readonly/>
							</span>
						</div>
						
						<div class="w3_agileits_main_grid w3l_main_grid" id="addr" >
							<span class="agileits_grid">
								<label>Address </label>
								<input style="color:red" style="width: 130px;" type="text"value="${dto.addr}" readonly/>
							</span><div class="clear"></div>
						</div>
						<div class="w3_agileits_main_grid w3l_main_grid" id="contact" >
							<span class="agileits_grid">
								<label>Contact </label>
								<input style="color:red" style="width: 130px;" type="text"value="${dto.contact}" readonly/>
							</span><div class="clear"></div>
						</div>
		<div class="w3_agileits_main_grid w3l_main_grid" id="custreq">
			<span class="agileits_grid">
				<label>Customer Requirement</label>
				  <input style="color:red"  type="text" name="custreq" value="${dto.custReq}" readonly style="width: 130px;"/>
			</span><div class="clear"></div>
		</div>
						<div class="clear"></div>

	   		
 <div class="w3_agileits_main_grid w3l_main_grid">
	<span class="agileits_grid"> 
		<table id="tabledata">
   <tr>
	<th>Quotation ID</th>
   <th>Product Name</th>
   <th>Product Type</th>
   <th>Company</th>
   <th>Cost/Product</th>
   <th>Quantity</th>
  </tr>
    
     <tr >
     <h1 style="color:red">
     <td><input type="radio" name="choice" value="${dto.id}">${dto.id}</input></td>
     	<td>
     	<select id="prodName" name="pname"  required style="width: 143px; height: 40px" onchange="showpppType(this.value);showpppCompany(this.value);" >
				<option  selected="selected" value="${dto.prodName}">${dto.prodName}</option>
     <% 
      		stmt=connection.prepareStatement("select * from erp_productdata"); 	
				 rs= stmt.executeQuery(); 
				while(rs.next())
				prod = rs.getString("NAME");
{ 
     %>
     <option value=<%=prod%>><%=prod%></option>
<% 
		}
		%>
		 </select>
	</td>
   		 <td>
   		 	 <div  id="productType"  >
				<input  type="text" name="prodtype"  value="${dto.prodType}" style="width: 130px;" >
			</div>
			</td>
   		 <td>
   		  <div id="productCompany">
				  <select   name="company"  required style="width: 143px; height: 40px"  >
				<option selected="selected" value="${dto.company}">${dto.company}</option>
				</select>
			</div>
   		  <td>
<%--    		  <input style="color:red" type="text" id="prodcost"  name="prodcost"  value="${dto.prodCost}" readonly/> --%>
   			<div id="costproduct">
				<input type="text" name="prodcost" value="${dto.prodCost}"  style="width: 130px;">
			</div>
   		  </td>
   		 <td><input style="color:red" type="text" id="quantity" name="quantity" required value="${dto.quantity}"/></td>
   		 </h1>
   		</tr>

		
		<!-- 	
			
			<div class="w3_agileits_main_grid w3l_main_grid" id="productCompany" style="display: none">
			<span class="agileits_grid">
				<label>Product Company</label>
				  <select id="prodCompany"  name="company"  required style="width: 143px; height: 40px" onchange="document.getElementById('tabledata').removeAttribute('style');"  >
				<option disabled selected="selected" value="none">Select Company</option>
				</select>
				</span><div class="clear"></div>
			</div>
					<div class="w3_agileits_main_grid w3l_main_grid" id="costproduct"  style="display: none">
							<span class="agileits_grid">
								<label>Cost Per Product </label>
								<input type="text" name="prodcost" readonly style="width: 130px;">
							</span><div class="clear"></div>
						</div>
			<div class="w3_agileits_main_grid w3l_main_grid" id="quantity" style="display: none" onkeyup="myCost();" onkeypress="myCost();">
				<span class="agileits_grid">
<font color="white">
				<label>Quantity</label>
				<input type="text" id="quant" name="quantity"  required style="width: 130px;" onkeyup="myProdCost();"/>
</span>
			</div> -->
 </table>
 </span>
 </div> 
<!--   <div  id="productType"  >
				<input  type="text" name="prodtype" value="a"   style="width: 130px;" >
			</div> -->
 <div class="w3_agileits_main_grid w3l_main_grid">
	<span class="agileits_grid">
 		<label>Net Amount </label>
<input type="text" name="total" value="${dto.prodAmount}"   readonly style="width: 130px;">Rs.
	</span>
		</div>
		 <div class="w3_agileits_main_grid w3l_main_grid">
	<span class="agileits_grid">
		<label>Service Tax </label>
		<input type="text" value="${dto.prodTax}" readonly  name="servicetax" style="width: 130px;">%
		 	</span>
		</div>
				 <div class="w3_agileits_main_grid w3l_main_grid">
	<span class="agileits_grid">
<label>Gross Net Amount </label>
<input type="text" name="grossnet" value="${dto.prodGross}"   readonly style="width: 130px;">Rs.
		 	</span>
		</div>
		 <div class="w3_agileits_main_grid w3l_main_grid">
	<span class="agileits_grid"><label>Discount </label>
<input type="text" name="discount" value="${dto.prodDiscount}" readonly style="width: 130px;">Rs.
							</span>
		</div>
				 <div class="w3_agileits_main_grid w3l_main_grid">
	<span class="agileits_grid">
							<label>Gross Amount </label>
<input type="text" name="grossamount" value="${dto.prodGrand}" readonly  style="width: 130px;">Rs.

						</span>
		</div>
					</c:forEach>
  		</c:when>
  	</c:choose>
	   	
					
<!-- 							Banner -->
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript">
function showpppType(str){ 
	var xmlhttp; 
		if (window.XMLHttpRequest) 
			{// code for IE7+, Firefox, Chrome, Opera, Safari 
				xmlhttp=new XMLHttpRequest(); 
			} 
		else 
		{// code for IE6, IE5 
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
		} 
			xmlhttp.onreadystatechange=function() 
		{ 
		if (xmlhttp.readyState==4 && xmlhttp.status==200) 
		{ 
			document.getElementById("productType").innerHTML=xmlhttp.responseText; 
		} 
	} 
		xmlhttp.open("POST","ptypeout3.jsp?q="+str,true); 
	xmlhttp.send(); 
} 

function showpppCompany(str){ 
	var xmlhttp; 
		if (window.XMLHttpRequest) 
		{// code for IE7+, Firefox, Chrome, Opera, Safari 
			xmlhttp=new XMLHttpRequest(); 
		} 
		else 
		{// code for IE6, IE5 
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
		} 
		xmlhttp.onreadystatechange=function() 
	{ 
		if (xmlhttp.readyState==4 && xmlhttp.status==200) 
		{ 
			document.getElementById("productCompany").innerHTML=xmlhttp.responseText; 
		} 
	} 
	xmlhttp.open("POST","companyout4.jsp?q="+str,true); 
xmlhttp.send(); 
}
</script>
		</form>
      </body>
 </html>   
    
   
