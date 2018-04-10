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
	 String custName=request.getParameter("custname");
   	 String custReq=request.getParameter("custreq");
String prodname=null,company=null,prodType=null,provider=null,sername=null;
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
			<h1 class="w3layouts_head">Sale Quotation</h1>
				<div class="w3layouts_main_grid">
					<%
						int thisId = (Integer)session.getAttribute("id");
						String thisName = (String) session.getAttribute("empname");
						PreparedStatement stmt=null,reqst=null;
	ResultSet rs=null,rs1=null,reqrs=null; 
	/*  check that customer and requst is present in salequotation table or not */
	reqst=connection.prepareStatement("select * from erp_salequotation where custname Like ? and custreq LIKE ?"); 
		reqst.setString(1,custName+"%");
			reqst.setString(2,custReq+"%");
			reqrs= reqst.executeQuery(); 
			if(reqrs.next())
			{
		stmt=connection.prepareStatement("select * from erp_salequotation where custname Like ? and custreq LIKE ?"); 	
			stmt.setString(1,custName+"%");
			stmt.setString(2,custReq+"%");
				rs1= stmt.executeQuery(); 
 					rs1.next();
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
								<label><font color="red">Customer Enquiry</font></label>
							</span>
						</div>
						<hr><br/>
						
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Customer Name </label>
								<input style="color:red" style="width: 130px;" type="text" value="<%=rs1.getString("custName")%>" readonly/>
							</span>
						</div>
						
						<div class="w3_agileits_main_grid w3l_main_grid" id="addr" >
							<span class="agileits_grid">
								<label>Address </label>
								<input style="color:red" style="width: 130px;" type="text"value="<%=rs1.getString("ADDR")%>" readonly/>
							</span><div class="clear"></div>
						</div>
						<div class="w3_agileits_main_grid w3l_main_grid" id="contact" >
							<span class="agileits_grid">
								<label>Contact </label>
								<input style="color:red" style="width: 130px;" type="text"value="<%=rs1.getLong("Contact")%>" readonly/>
							</span><div class="clear"></div>
						</div>
		<div class="w3_agileits_main_grid w3l_main_grid" id="custreq">
			<span class="agileits_grid">
				<label>Customer Requirement</label>
				  <input style="color:red"  type="text" name="custreq" value="<%=rs1.getString("CUSTREQ")%>" readonly style="width: 130px;"/>
			</span><div class="clear"></div>
		</div>
						<div class="clear"></div>
	   		<% 
if(custReq.equalsIgnoreCase("Product Only"))
	{
	rs= stmt.executeQuery(); 
while(rs.next())
{ 
				prodname= rs.getString("prodName");
   		 				company= rs.getString("company");
   		 				prodType=rs.getString("prodType");
   		 				pcost=rs.getFloat("prodcost") ;
   		 				 quantity= rs.getInt("quantity");

%>
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
   <th>Operation</th>
  </tr>
    
     <tr >
     <h1 style="color:red">
     <td><input type="radio" name="choice" value="<%=rs.getInt("id")%>"><%=rs.getInt("id")%></input></td>
   	   	<td><input style="color:red" type="text" name="prodname"  value="<%=rs.getString("prodName")%>" readonly/></td>
   		 <td><input style="color:red" type="text" name="prodtype"  value="<%=rs.getString("prodType")%>" readonly/></td>
   		 <td><input style="color:red" type="text" name="company"  value="<%=rs.getString("company")%>" readonly/></td>
   		  <td><input style="color:red" type="text" id="prodcost"  name="prodcost"  value="<%= rs.getFloat("prodcost") %>" readonly/></td>
   		 <td><input style="color:red" type="text" id="quantity" name="quantity" required value="<%=rs.getInt("quantity")%>"/></td>
   		 <td><input type="submit" name="operation" value="Edit" style="background-color:green;font-weight:bold;color:white;"  >
   		 	<input type="submit" name="operation" value="Remove" style="background-color:red;font-weight:bold;color:white;"  >
   		 </td>
   		 </h1>
   		</tr>
 </table>
 </span>
 </div> 
 
 <div class="w3_agileits_main_grid w3l_main_grid">
	<span class="agileits_grid">
 		<label>Net Amount </label>
<input type="text" name="total" value=" <%=rs.getFloat("prodamount") %>"   readonly style="width: 130px;">Rs.
	</span>
		</div>
		 <div class="w3_agileits_main_grid w3l_main_grid">
	<span class="agileits_grid">
		<label>Service Tax </label>
		<input type="text" value=" <%=rs.getFloat("prodtax") %>" readonly  name="servicetax" style="width: 130px;">%
		 	</span>
		</div>
				 <div class="w3_agileits_main_grid w3l_main_grid">
	<span class="agileits_grid">
<label>Gross Net Amount </label>
<input type="text" name="grossnet" value=" <%=rs.getFloat("prodgross") %>"   readonly style="width: 130px;">Rs.
		 	</span>
		</div>
		 <div class="w3_agileits_main_grid w3l_main_grid">
	<span class="agileits_grid"><label>Discount </label>
<input type="text" name="discount" value=" <%=rs.getFloat("proddiscount") %>" readonly style="width: 130px;">Rs.
							</span>
		</div>
				 <div class="w3_agileits_main_grid w3l_main_grid">
	<span class="agileits_grid">
							<label>Gross Amount </label>
<input type="text" name="grossamount" value=" <%=rs.getFloat("prodgrand") %>" readonly  style="width: 130px;">Rs.

						</span>
		</div>
	   		<% 
 } //while

} //if

	else if(custReq.equalsIgnoreCase("Service Only"))
	{
	 rs= stmt.executeQuery(); 
while(rs.next())
{ 
				sername= rs.getString("sername");
   		 		provider= rs.getString("provider");
   		 		sercost=rs.getFloat("sercost") ;
		  
	%>
<div class="w3_agileits_main_grid w3l_main_grid" >
	<span class="agileits_grid">
		<table id="tabledata">
    <tr>
	<th>Quotation  ID</th>
   <th>Service Name</th>
   <th>Provider</th>
   <th>Service Cost</th>
   <th>Operation</th>
  </tr>

     <tr >
     <h1 style="color:red">
     <td><input type="radio" name="choice" value="<%=rs.getInt("id")%>"><%=rs.getInt("id")%></input></td>
   	  	 <td><input style="color:red" type="text" name="sername"  value="<%=rs.getString("serName")%>" readonly/></td>
   		 <td><input style="color:red" type="text" name="provider"  value="<%=rs.getString("provider")%>" readonly/></td>
   		 <td><input style="color:red" type="text" name="sercost"  value="<%=rs.getFloat("sercost")%>" readonly/></td>
   		 <td><input type="submit" name="operation" value="Edit" style="background-color:green;font-weight:bold;color:white;"  >
   		 	<input type="submit" name="operation" value="Remove" style="background-color:red;font-weight:bold;color:white;"  >
   		 </td>
   		 </h1>
   		</tr>
 </table>
  </span>
 </div> 
 <div class="w3_agileits_main_grid w3l_main_grid">
	<span class="agileits_grid">
 		<label>Net Amount </label>
<input type="text" name="total" value=" <%=rs.getFloat("seramount") %>"   readonly style="width: 130px;">Rs.
	</span>
		</div>
		 <div class="w3_agileits_main_grid w3l_main_grid">
	<span class="agileits_grid">
		<label>Service Tax </label>
		<input type="text" value=" <%=rs.getFloat("sertax") %>" readonly  name="servicetax" style="width: 130px;">%
		 	</span>
		</div>
				 <div class="w3_agileits_main_grid w3l_main_grid">
	<span class="agileits_grid">
<label>Gross Net Amount </label>
<input type="text" name="grossnet" value=" <%=rs.getFloat("sergross") %>"   readonly style="width: 130px;">Rs.
		 	</span>
		</div>
		 <div class="w3_agileits_main_grid w3l_main_grid">
	<span class="agileits_grid"><label>Discount </label>
<input type="text" name="discount" value=" <%=rs.getFloat("serdiscount") %>" readonly style="width: 130px;">Rs.
							</span>
		</div>
				 <div class="w3_agileits_main_grid w3l_main_grid">
	<span class="agileits_grid">
							<label>Gross Amount </label>
<input type="text" name="grossamount" value=" <%=rs.getFloat("sergrand") %>" readonly  style="width: 130px;">Rs.
						</span>
		</div>
		
		<%				
	   		 
 		} //while
 }//else--if
 }//if----main
 else
 {
 %>
							<h1> No Data Found</h1>
 <%
 }
 
 
/* else
	{
			stmt=connection.prepareStatement("select * from erp_sale where custreq LIKE 'Product With%'"); 	
			//stmt.setString(1,str+"%");
				rs= stmt.executeQuery(); 
 */%> 
<%-- <div class="w3_agileits_main_grid w3l_main_grid" id="tabledata" >
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

						<div class="w3_agileits_main_grid w3l_main_grid" id="servicedata"  style="display: none">
							<font color="white">
								<label>Net Amount </label>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input id="seramt"  type="text" name="seramt" value="<%=sercost %>"   readonly style="width: 130px;">
								<br/><br/>	
									<label>Service Tax </label>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" id="sertax" name="sertax" onkeyup="calTax();calDiscount();" style="width: 130px;">%
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<label>Gross Net Amount </label>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="sergrossnet" id="sergrossnet"  value="<%=sercost %>" style="width: 130px;">
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<label>Discount </label>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="serdiscount" id="serdiscount" value="0" onkeyup="calDiscount();" style="width: 130px;">Rs.
							<br/><br/>
							<label>Gross Amount </label>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="sergrossamount" id=sergrossamount  value="<%=sercost %>"  style="width: 130px;">
							</font> --%>
					
<!-- 							Banner -->
				</div>
			</div>
		</div>
	</div>
	<%--  <INPUT TYPE="text" NAME="hidden" VALUE="<%= current %>">
            <INPUT TYPE="BUTTON" VALUE="Next Record" formaction="select_quotation.jsp" ONCLICK="moveNext()">
            <INPUT TYPE="BUTTON" VALUE="Previous Record" ONCLICK="movePrevious()">
        </FORM> --%>

        <!-- <SCRIPT LANGUAGE="JavaScript">
            
            function moveNext()
            {
                var counter = 0
                counter = parseInt(document.form1.hidden.value) + 1
                document.form1.hidden.value = counter
                form1.submit()
            }    
            function movePrevious()
            {
                var counter = 0
                counter = parseInt(document.form1.hidden.value) - 1
                document.form1.hidden.value = counter
                form1.submit()
            }    

            // 
        </SCRIPT> -->
		</form>
      </body>
 </html>   
    
   
