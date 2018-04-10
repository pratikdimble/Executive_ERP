<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
 <%@ page import="java.sql.*"%> 
  <%@ include file="JavaScript.jsp" %>
 <!DOCTYPE html>
<html>
<head>
<title>Populate Quotation Table With Cost:: Order</title>
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
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}

#myTable {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#myTable td, #myTable th {
    border: 1px solid #ddd;
    padding: 8px;
}

#myTable tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#myTable th {
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
String str=request.getParameter("q");
String thisSupp = (String) session.getAttribute("supplier");
String prodname=null,company=null;
int  i=Integer.parseInt(str); //quotation id
int id=0,quantity=0;
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
	PreparedStatement stmt=null,idst=null,cost=null,scost=null,sidst=null;
	ResultSet rs=null,idrs=null,costrs=null,rs1=null,scostrs=null,sidrs=null,rs2=null,rs3=null; 
	
	stmt=connection.prepareStatement("select * from erp_PURCHASEQUOTATION where id="+i); 	
				rs= stmt.executeQuery(); 

rs= stmt.executeQuery();
%> 

<div class="w3_agileits_main_grid w3l_main_grid" id="mytabledata" >
	<span class="agileits_grid">
		<table id="tabledata">
   <tr>
	<th>Enquiry ID</th>
   <th>Product Name</th>
   <th>Product Type</th>
   <th>Company</th>
   <th>Quantity</th>
   <th>Product Cost</th>

  </tr>
     <% 
while(rs.next())
{ 
%>
     <tr >
     <h1 style="color:red">
      <td><input type="radio" disabled name="choice" id="choice" value=<%=rs.getInt("id")%>><%=rs.getInt("id")%></input></td>
   	   <td>
   	   <select  name="prodname" id="prodname" style="width: 143px; height: 40px" onchange="showType(this.value);showProdComp(this.value);">
				<option  selected="selected" value="<%=rs.getString("prodName")%>"><%=rs.getString("prodName")%></option>
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
   		 		<input style="color:red" type="text" id="prodtype" value="<%=rs.getString("prodType")%>" />
   		 	</div>
   		 </td>
   		 <td>
   		 <div id="company">
   			 <select  name="company" id="comp" style="width: 143px; height: 40px">
				<option  selected="selected" value="<%=rs.getString("company")%>"><%=rs.getString("company")%></option>
		 	</select>
		 </div>
		 </td>
   		 <td><input style="color:red" type="text" id="quantity" required value="<%=rs.getInt("quantity")%>"/></td>
   		  <td>  <input style="color:red" type="text" id="prodcost" name="prodcost" required value="<%=rs.getFloat("prodcost")%>" onkeyup="calNetAmt();"/></td>
   		 </h1>
   		</tr>
   		<% 
} //while
%>


 </table>
 </span>
 </div>
 <div class="w3_agileits_main_grid w3l_main_grid">
<span class="agileits_grid"></span>
								<label>Quotation ID </label>
 <select  name="enqid" id="enqid" style="width: 143px; height: 40px" onchange="getPrCost(this.value);">
<!-- 		  -->
				<option disabled selected="selected" value="none">Select ID</option>
	<%
	stmt=connection.prepareStatement("select * from erp_PURCHASEQUOTATION where id="+i); 	
				rs= stmt.executeQuery(); 
		while(rs.next())
			{
	%>
			<option  value=<%=rs.getInt("id")%>><%=rs.getInt("id")%></option>
		<%
		}
		%> </select>
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

		<input onclick="showDBTable();" type="button" value="Add" style="height: 40px; width: 152px"/>
<!-- <div class="w3_agileits_main_grid w3l_main_grid" id="myTable" > -->
<!-- 	<span class="agileits_grid"> -->
<table id="myTable">
<tr>
	<th>Enquiry ID</th>
   <th>Product Name</th>
   <th>Product Type</th>
   <th>Company</th>
   <th>Quantity</th>
   <th>Product Cost</th>
	<th>Grand Amount</th>
<!-- 	<th>Operation</th> -->
  </tr>
</table>
<input onclick="removeRow();calTotalAmt();" type="button" value="Remove"/>
<input id="val"  type="hidden" value="0" style="width: 130px;"/>
<!-- </span></div> -->
<div class="w3_agileits_main_grid w3l_main_grid" >
	<span class="agileits_grid"></span>
	<font color="white">
		<label>Total Amount </label>
			<input id="totalamount"  type="text" value="0" style="width: 130px;">Rs.
	</font></div>
		</form>
		
      </body>
 </html>   
    
   
