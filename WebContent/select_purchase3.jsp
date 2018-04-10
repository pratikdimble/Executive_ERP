<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
 <%@ page import="java.sql.*"%> 
  <%@ include file="JavaScript.jsp" %>
 <!DOCTYPE html>
<html>
<head>
<title>Populate Quotation Table With Cost:: New Order</title>
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
body {
    /* Set "my-sec-counter" to 0 */
    counter-reset: my-sec-counter;
}

h2::after {
    /* Increment "my-sec-counter" by 1 */
    counter-increment: my-sec-counter;
    content: counter(my-sec-counter) ;
}
</style>
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
     padding-top: 12px; 
          padding-bottom: 12px; 
    text-align: left;
    background-color: #4CAF50;
    color: white;
}



#myTablee {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#myTablee td, #myTable th {
    border: 1px solid #ddd;
    padding: 8px;
}

#myTablee tr:nth-child(even){background-color: #f2f2f2;}

#myTablee tr:hover {background-color: #ddd;}

#myTablee th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
</style>
</head>

<body  >
<form action="./purchase" method="POST">
<% 
//String str=request.getParameter("q");
String thisSupp = (String) session.getAttribute("supplier");
String prodname=null,company=null;
//int  i=Integer.parseInt(str); 
int id=0,quantity=0,i=0;
float pcost=0,sid=0,netcost=0;
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
	PreparedStatement idst=null;
	ResultSet idrs=null; 
%> 

<div class="w3_agileits_main_grid w3l_main_grid" id="mytabledata" >
	<span class="agileits_grid">
		<table id="tabledata">
   <tr>
   <th>Product Name</th>
   <th>Product Type</th>
   <th>Company</th>
   <th>Quantity</th>
   <th>Product Cost</th>

  </tr>
     <tr>
     <h1 style="color:red">
   	   <td>
   	   <select  name="prodname" id="prodname" style="width: 143px; height: 40px" onchange="showType(this.value);showProdComp(this.value);">
				<option  selected="selected" value="none" disabled="disabled">Select Product</option>
	<%
	idst=connection.prepareStatement("select * from erp_PRODUCT"); 	
				idrs= idst.executeQuery(); 
		while(idrs.next())
			{
	%>
			<option  value="<%=idrs.getString("name")%>"><%=idrs.getString("name")%></option>
		<%
		}
		%> </select>
   	   </td>
   	   
   		 <td>
   		 	<div id="productType">
   		 		<input style="color:red" type="text" id="prodtype"  />
   		 	</div>
   		 </td>
   		 <td>
   		 <div id="company">
   			 <select  name="company" id="comp" style="width: 143px; height: 40px">
				<option  selected="selected" value="none" disabled="disabled">Select Company</option>
		 	</select>
		 </div>
		 </td>
 <td><input style="color:red" type="text" id="quantity" required value="0"/></td>
   		  <td>  <input style="color:red" type="text" id="prodcost" name="prodcost" required value="0.0" onkeyup="calNetAmt();"/></td>
   		 </h1>
   		</tr>

 </table>
 </span>
 </div>
 
		<div class="w3_agileits_main_grid w3l_main_grid" id="prodamt"  >
	<span class="agileits_grid"></span>
	<font color="white">
		<label>Net Amount </label>
			<input id="totalamt"  type="text"   readonly style="width: 130px;">Rs.
	</font></div><br/>
<div class="w3_agileits_main_grid w3l_main_grid" id="productdata"  >
				<font color="white">
	<label>Service Tax </label>
		<input type="text" id="servicetax" name="servicetax" onkeyup="myFunction();myFun();" style="width: 130px;">%
			<br/><br/>
	<label>Gross Net Amount </label>
		<input type="text" name="grossnet" id="grossnet"  style="width: 130px;">Rs.
			<br/><br/>
	<label>Discount </label>
		<input type="text" name="discount" id="discount" value="0" onkeyup="myFun();" style="width: 130px;">Rs.
			<br/><br/>
	<label>Grand Amount </label>
		<input type="text" name="grossamount" id="grossamount"   style="width: 130px;">Rs.
				</font>
</div>

		<input onclick="showDBTablee();" type="button" value="Add" style="height: 40px; width: 152px"/>
<!-- <div class="w3_agileits_main_grid w3l_main_grid" id="myTable" > -->
<!-- 	<span class="agileits_grid"> -->
<table id="myTablee">
<tr>
	<th>No.</th>
	<th>Clear</th>
   <th>Product Name</th>
   <th>Product Type</th>
   <th>Company</th>
   <th>Quantity</th>
   <th>Product Cost</th>
	<th>Grand Amount</th>
<!-- 	<th>Operation</th> -->
  </tr>
</table>

<input id="ch"  type="hidden" value="0" style="width: 130px;"/>
<input id="val"  type="hidden" value="0" style="width: 130px;"/>
<input type="button" onclick="cl();" value="Click Me">
<div class="w3_agileits_main_grid w3l_main_grid" >
	<span class="agileits_grid"></span>
		<font color="white">
			<label>Total Amount </label>
				<input id="totalamount"  type="text" value="0" style="width: 130px;">Rs.
		</font>
	</div>
		</form>
      </body>
 </html>   
    
   
