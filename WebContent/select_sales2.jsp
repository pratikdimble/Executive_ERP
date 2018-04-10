<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
 <%@ page import="java.sql.*"%> 
 <!DOCTYPE html>
<html>
<head>
<title>Populate Quotation Table With Cost</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
<form action="./sale" method="POST">
<% 
String str=request.getParameter("q");
String thisCustomer = (String) session.getAttribute("customername");
String prodname=null,company=null,custname=null,provider=null,sername=null;
//i=Integer.parseInt(str); 
int id=0,quantity=0;
float pcost=0,sercost=0,sid=0,ppcost=0;
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
	
	stmt=connection.prepareStatement("select * from erp_sale where custreq LIKE ? and custname like  ?"); 	
			stmt.setString(1,str+"%");
			stmt.setString(2,thisCustomer+"%");
				rs1= stmt.executeQuery(); 
				while(rs1.next())
					{
						prodname= rs1.getString("prodName");
   		 				company= rs1.getString("company");
   		 				custname=rs1.getString("custname");
   		 				sername=rs1.getString("sername");
   		 				provider=rs1.getString("provider");
					} 
					
				/* Find the sale enquiry id  */
	idst=connection.prepareStatement("select id from erp_sale where prodname=? and company=? and custname=? and custreq like ? and custname like  ?"); 
				idst.setString(1, prodname);
				idst.setString(2, company);
				idst.setString(3, custname);
				idst.setString(4,str+"%");
				idst.setString(5,thisCustomer+"%");
				
				idrs= idst.executeQuery(); 
				while(idrs.next())
				{
				 id=idrs.getInt("id");
				}
				
				/* Find the sale enquiry id  */
	sidst=connection.prepareStatement("select id from erp_sale where sername=? and provider=? and custreq like ? and custname like  ?"); 
				sidst.setString(1, sername);
				sidst.setString(2, provider);
				sidst.setString(3,str+"%");
				sidst.setString(4,thisCustomer+"%");
				sidrs= sidst.executeQuery(); 
				while(sidrs.next())
				{
				 sid=sidrs.getInt("id");
				}

/*  check that customer requirement is only product if it is then service cost=0 otherwise get the cost */
					 if(str.equalsIgnoreCase("Product Only"))
					 {
					 /* Find the Product Cost  */
cost=connection.prepareStatement("select cost from erp_productdata where name=(select prodname from erp_sale where id="+id+") and company=(select company from erp_sale where id="+id+")"); 
					 costrs= cost.executeQuery(); 
						while(costrs.next())
							{
							 pcost=costrs.getFloat("cost");
							}
					 sercost=00;
					 }
					 
					  else if(str.equalsIgnoreCase("Service Only"))
					 {
					 pcost=00;
					 /* Find the Product Cost  */
 scost=connection.prepareStatement("select servicecost from erp_servicedata where name=(select name from erp_sale where id="+sid+") and provider=(select provider from erp_sale where id="+sid+")"); 
		 scostrs= scost.executeQuery(); 
						while(scostrs.next())
							{
							 sercost=scostrs.getFloat("servicecost");
							}
					 }
	if(str.equalsIgnoreCase("Product Only"))
	{
			stmt=connection.prepareStatement("select * from erp_sale where custreq LIKE 'Product%' and custname like ?"); 	
			//stmt.setString(1,str+"%");
			stmt.setString(1,thisCustomer+"%");
				 rs2= stmt.executeQuery(); 
				while(rs2.next())
{ 
quantity=rs2.getInt("quantity");
}
rs= stmt.executeQuery();
%> 

<div class="w3_agileits_main_grid w3l_main_grid" id="tabledata" >
	<span class="agileits_grid">
		<table >
   <tr>
	<th>Enquiry ID</th>
   <th>Product Name</th>
   <th>Product Type</th>
   <th>Company</th>
      <th>Quantity</th>
   <th>Cost/Product</th>

  </tr>
     <% 
while(rs.next())
{ 
%>
     <tr >
     <h1 style="color:red">
      <td><input type="radio" disabled name="choice" id="choice" value=<%=rs.getInt("id")%>><%=rs.getInt("id")%></input></td>
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
 <select  name="enqid" id="enqid" style="width: 143px; height: 40px" onchange="getPCost(this.value);showProdData(this.value);showProdDataT(this.value);showProdDataC(this.value);showProdDataQ(this.value);showProdDataP(this.value);" onclick="document.getElementById('productdata').style.display='block';document.getElementById('prodamt').style.display='block';">
<!-- 		  -->
				<option disabled selected="selected" value="none">Select ID</option>
	<%
	stmt=connection.prepareStatement("select * from erp_sale where custreq LIKE 'Product%' and custname like ?"); 	
			//stmt.setString(1,str+"%");
			stmt.setString(1,thisCustomer+"%");
			
				rs= stmt.executeQuery(); 
		while(rs.next())
			{
	%>
			<option  value=<%=rs.getInt("id")%>><%=rs.getInt("id")%></option>
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
						   		<% 
} //if

	else if(str.equalsIgnoreCase("Service Only"))
	{
			stmt=connection.prepareStatement("select * from erp_sale where custreq LIKE 'Service%' and custname like ?"); 	
			//stmt.setString(1,str+"%");
			stmt.setString(1,thisCustomer+"%");
			
				rs= stmt.executeQuery(); 
%> 
<div class="w3_agileits_main_grid w3l_main_grid" id="tabledata" >
	<span class="agileits_grid">
		<table >
   <tr>
	<th>Enquiry ID</th>
   <th>Service Name</th>
   <th>Provider</th>
   <th>Service Cost</th>
  </tr>
     <% 
while(rs.next())
{ 
%>
     <tr >
     <h1 style="color:red">
     <td><input type="radio" disabled name="choice" id="choice" value=<%=rs.getInt("id")%>><%=rs.getInt("id")%></input></td>
   	  	 <td><input style="color:red" type="text"   value="<%=rs.getString("serName")%>" readonly/></td>
   		 <td><input style="color:red" type="text"  value="<%=rs.getString("provider")%>" readonly/></td>
		<td><input style="color:red" type="text"   value="<%=rs.getFloat("sercost")%>" readonly/></td>
   		 </h1>
   		</tr>
   		<% 
} //while
%>
	</span><div class="clear"></div>
						</div>
 </table>
 							<div class="w3_agileits_main_grid w3l_main_grid">
<span class="agileits_grid"></span>
								<label>Enquiry ID </label>
 <select  name="enqid" id="enqid" style="width: 143px; height: 40px" onchange="getCost(this.value);showSerData(this.value);showSerDataP(this.value);showSerDataC(this.value);" onclick="document.getElementById('servicedata').style.display='block';document.getElementById('seramt').style.display='block';">
<!-- 		  -->
				<option disabled selected="selected" value="none">Select ID</option>
	<%
	stmt=connection.prepareStatement("select * from erp_sale where custreq LIKE 'Service%' and custname like ?"); 	
			//stmt.setString(1,str+"%");
			stmt.setString(1,thisCustomer+"%");
			
				rs= stmt.executeQuery(); 
		while(rs.next())
			{
	%>
			<option  value=<%=rs.getInt("id")%>><%=rs.getInt("id")%></option>
		<% 
		}
		%> </select>
</div>
<div class="w3_agileits_main_grid w3l_main_grid" id="sdata1">
 			<input style="color:red" type="hidden"  name="sername"   readonly/>
<div class="clear"></div>
						</div>
						 <div class="w3_agileits_main_grid w3l_main_grid" id="sdata2">
   		 <input style="color:red" type="hidden" name="provider"   readonly/>
<div class="clear"></div>
						</div>
						 <div class="w3_agileits_main_grid w3l_main_grid" id="sdata3">
   		 <input style="color:red" type="hidden" name="sercost"   readonly/>
<div class="clear"></div>
</div>
						   		<% 
} //else--->if

else
	{
			stmt=connection.prepareStatement("select * from erp_sale where custreq LIKE 'Product With%'"); 	
			//stmt.setString(1,str+"%");
				rs= stmt.executeQuery(); 
%> 
<div class="w3_agileits_main_grid w3l_main_grid" id="tabledata" >
	<span class="agileits_grid">
		<table >
   <tr>
	<th>Enquiry ID</th>
   <th>Product Name</th>
   <th>Product Type</th>
   <th>Company</th>
   <th>Cost/Product</th>
   <th>Quantity</th>
   <th>Service Name</th>
   <th>Provider</th>
   <th>Service Cost</th>
  </tr>
     <% 
while(rs.next())
{ 
%>
     <tr >
     <h1 style="color:red">
     <td><input type="radio" name="choice"  onclick="document.getElementById('myid').removeAttribute('disabled'); "><%=rs.getInt("id")%></input></td>
   	   	<td><input style="color:red" type="text" name="prodname"  value="<%=rs.getString("prodName")%>" readonly/></td>
   		 <td><input style="color:red" type="text" name="prodtype"  value="<%=rs.getString("prodType")%>" readonly/></td>
   		 <td><input style="color:red" type="text" name="company"  value="<%=rs.getString("company")%>" readonly/></td>
   		  <td><input style="color:red" type="text" name="prodcost"  value="<%= pcost %>" readonly/></td>
   		 <td><input style="color:red" type="text" name="quantity" required value="<%=rs.getInt("quantity")%>"/></td>
   		 <td><input style="color:red" type="text" name="sername"  value="<%=rs.getString("serName")%>" readonly/></td>
   		 <td><input style="color:red" type="text" name="provider"  value="<%=rs.getString("provider")%>" readonly/></td>
   		 <td><input style="color:red" type="text" name="sercost"  value="<%=sercost%>" readonly/></td>
   		 </h1>
   		</tr>
   		<% 
} //while
%>


 </table>
	</span><div class="clear"></div>
						</div>
						   		<% 
} //else
%>
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

<div class="w3_agileits_main_grid w3l_main_grid" id="seramt"  style="display: none">
	<span class="agileits_grid"></span>
		<label>Net Amount </label>
			<input id="seramt"  type="text"    readonly style="width: 130px;">Rs.
	</div><br/>
<div class="w3_agileits_main_grid w3l_main_grid" id="servicedata"  style="display: none">
	<font color="white">
		<label>Service Tax </label>
			<input type="text" id="sertax" name="sertax" onkeyup="calTax();calDiscount();" style="width: 130px;">%<br/><br/>
		<label>Gross Net Amount </label>
			<input type="text" name="sergrossnet" id="sergrossnet"   style="width: 130px;">Rs.<br/><br/>
		<label>Discount </label>
			<input type="text" name="serdiscount" id="serdiscount" value="0" onkeyup="calDiscount();" style="width: 130px;">Rs.
	<br/><br/>
		<label>Gross Amount </label>
			<input type="text" name="sergrossamount" id=sergrossamount    style="width: 130px;">Rs.
		</font>
	</div>
		</form>
      </body>
 </html>   
    
   
