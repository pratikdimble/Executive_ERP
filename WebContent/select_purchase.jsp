<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
 <%@ page import="java.sql.*"%> 
 <!DOCTYPE html>
<html>
<head>
<title>Populate Quotation Table With Cost::Quotation</title>
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
</style>
</head>

<body  >
<form action="./purchase" method="POST">
<% 
String str=request.getParameter("q");
String thisSupp = (String) session.getAttribute("supplier");
String prodname=null,company=null;
//i=Integer.parseInt(str); 
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
	
	stmt=connection.prepareStatement("select * from erp_purchase where suppname like ?"); 	
			stmt.setString(1,str+"%");
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
      <td><input type="radio" disabled name="choice" id="choice" value=<%=rs.getInt("enqid")%>><%=rs.getInt("enqid")%></input></td>
   	   	<td><input style="color:red" type="text"   value="<%=rs.getString("prodName")%>" readonly/></td>
   		 <td><input style="color:red" type="text"  value="<%=rs.getString("prodType")%>" readonly/></td>
   		 <td><input style="color:red" type="text"  value="<%=rs.getString("company")%>" readonly/></td>
   		 <td><input style="color:red" type="text"  required value="<%=rs.getInt("quantity")%>"/></td>
   		  <td>  <input style="color:red" type="text" id="prodcost"  value="<%=rs.getFloat("prodcost")%>" readonly/></td>
   		 </h1>
   		</tr>
   		<% 
} //while
%>


 </table>
 <div class="w3_agileits_main_grid w3l_main_grid">
<span class="agileits_grid"></span>
								<label>Enquiry ID </label>
 <select  name="enqid" id="enqid" style="width: 143px; height: 40px" onchange="getPrCost(this.value);showProdN(this.value);showProdT(this.value);showProdC(this.value);showProdQ(this.value);showProdP(this.value);" onclick="document.getElementById('productdata').style.display='block';document.getElementById('prodamt').style.display='block';">
<!-- 		  -->
				<option disabled selected="selected" value="none">Select ID</option>
	<%
	stmt=connection.prepareStatement("select * from erp_purchase where suppname like ?"); 	
			stmt.setString(1,str+"%");
				rs= stmt.executeQuery(); 
		while(rs.next())
			{
	%>
			<option  value=<%=rs.getInt("enqid")%>><%=rs.getInt("enqid")%></option>
		<% 
		}
		%> </select>
</div>
<div class="w3_agileits_main_grid w3l_main_grid" id="pdata1">
 			<input style="color:red" type="hidden"  name="prodname"   readonly/>
<div class="clear"></div>
						</div>
						 <div class="w3_agileits_main_grid w3l_main_grid" id="pdata2">
   		 <input style="color:red" type="hidden" name="prodtype"   readonly/>
<div class="clear"></div>
						</div>
						 <div class="w3_agileits_main_grid w3l_main_grid" id="pdata3">
   		 <input style="color:red" type="hidden" name="company"   readonly/>
<div class="clear"></div>
						</div>
						 <div class="w3_agileits_main_grid w3l_main_grid" id="pdata4">
   		 <input style="color:red" type="hidden"  name="quantity" />
<div class="clear"></div>
						</div>
						 <div class="w3_agileits_main_grid w3l_main_grid" id="pdata5">
   		    <input style="color:red" type="hidden"   name="prodcost"  readonly/>
<div class="clear"></div>
						</div>
		
		<div class="w3_agileits_main_grid w3l_main_grid" id="prodamt"  style="display: none">
	<span class="agileits_grid"></span>
	<font color="white">
		<label>Net Amount </label>
			<input id="totalamt"  type="text"   readonly style="width: 130px;">Rs.
	</font></div><br/>
<div class="w3_agileits_main_grid w3l_main_grid" id="productdata"  style="display: none">
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
		<input type="text" name="grossamount" id=grossamount   style="width: 130px;">Rs.
				</font>
</div>

		</form>
      </body>
 </html>   
    
   
