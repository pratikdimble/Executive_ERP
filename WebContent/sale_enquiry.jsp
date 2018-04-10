<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
      <%@ include file="JavaScript.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Sale Enquiry Form</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- //for-mobile-apps -->
<!-- <link rel="stylesheet" type="text/css" href="css/menubar.css"/> -->
<!-- //custom-theme -->
<link href="css/sstyle.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/sstyle3.css" rel="stylesheet" type="text/css" media="all" />

<!-- js -->
<script type="text/javascript" src="js/jjquery-2.1.4.min.js"></script>
<!-- //js -->
<!-- font-awesome-icons -->
<!-- //font-awesome-icons -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
</head>
<body>
 <div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
<!--       <a  ><input type="submit" name="operation" value="Back"/></a> -->

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
                 	Connection con= null;
	PreparedStatement ps = null,ps1 = null,ps2 = null;
	ResultSet rs = null,rs1 = null,rs2 = null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

String custName = "SELECT * FROM ERP_CUSTOMER";
String serviceName = "SELECT NAME FROM ERP_SERVICE";
String prodName = "SELECT NAME FROM ERP_PRODUCT";
	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(custName);ps1 = con.prepareStatement(prodName);ps2 = con.prepareStatement(serviceName);
			rs = ps.executeQuery();rs1 = ps1.executeQuery(); rs2 = ps2.executeQuery();
						%>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
<!-- banner -->
	<div class="center-container">
		<div class="main">
			<h1 class="w3layouts_head">Sale Enquiry  Form</h1>
				<div class="w3layouts_main_grid">
					<%
						int thisId = (Integer)session.getAttribute("id");
						String thisName = (String) session.getAttribute("empname");
						//String thisRole = (String) session.getAttribute("role");
						%>
					<form action="./sale" method="POST">
					<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Date </label>
								<input class="date" type="date" name="todaydate" id="theDate" style="height: 30px; width: 130px">
								</span>
						</div>
								<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label><font color="red">Employee Details</font></label>
							</span>
						</div>
						<hr><br/>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<font color="white">
								<label>Employee Name</label>
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  <input readonly value="<%= thisName %>" type="text" name="name" style="width: 100px; ">
							<label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspEmployee ID </label>
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
						<hr>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Customer Name </label>
								 <select name="custname" id="custname" style="width: 143px; height: 40px" required="required" onchange="showAddr(this.value);showContact(this.value);showCustoID(this.value);" >
				<option disabled selected="selected" value="none">select</option>
	<%
		while(rs.next())
			{
	%>
			<option value=<%=rs.getString("CUSTNAME")%>><%=rs.getString("CUSTNAME")%></option>
		<% 
		}
		%> </select>
							</span>
						</div>
						<div class="w3_agileits_main_grid w3l_main_grid" id="custid" >
							<span class="agileits_grid">
								<input type="hidden" name="custid" readonly style="width: 200px;">
							</span>
						</div>
						<div class="w3_agileits_main_grid w3l_main_grid" id="addr" >
							<span class="agileits_grid">
								<label>Address </label>
								<input type="text" name="addr" id="addr" readonly style="width: 200px;">
							</span>
						</div>
						<div class="w3_agileits_main_grid w3l_main_grid" id="contact" >
							<span class="agileits_grid">
								<label>Contact </label>
								<input type="text" name="contact" id="contact" readonly style="width: 130px;">
							</span>
						</div>
							<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label><font color="red">Customer Requirement</font></label>
							</span>
						</div>
						<hr><br/>
					<font color="pink">
						<input type="radio" name="type" onclick="productDiv();" value="Product Only">Product Only</input>
						<input type="radio" name="type"  onClick ="serDiv();" value="Service Only">Service Only </input>
<!-- 						<br/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="radio" name="type" onClick ="productserviceDiv()" value="Product With Service"> Product With Service -->
					</font>
		<div class="w3_agileits_main_grid w3l_main_grid" id="productName" class="text" style="display: none">
		<span class="agileits_grid">
				<label>Product Name</label>
  <select id="prodName" required name="pname" style="width: 143px; height: 40px" class="text" onchange="showppType(this.value);showpCompany(this.value);">
				<option disabled selected="selected" value="none">Select Product</option>
	<%
		while(rs1.next())
			{
				String prod = rs1.getString("NAME");
	%>
			<option value=<%=prod%>><%=prod%></option>
		<% 
		}
		%> </select></span>
				<div class="clear"></div>
			</div>
			<div class="w3_agileits_main_grid w3l_main_grid" id="productType" style="display: none">
				<span class="agileits_grid">
				<label>Product Type</label>
				<input id="prodType" required type="text" name="prodtype" readonly style="width: 130px;" >
				</span>
				<div class="clear"></div>
			</div>
			
			<div class="w3_agileits_main_grid w3l_main_grid"  id="productCompany" style="display: none" >
			<span class="agileits_grid">
				<label>Product Company</label>
				  <select id="prodcompany" required name="company" style="width: 143px; height: 40px"  >
				<option disabled selected="selected" value="none">Select Company</option>
				</select>
				</span><div class="clear"></div>
			</div>
	<div class="w3_agileits_main_grid w3l_main_grid" id="productCost" style="display: none">
				<span class="agileits_grid">
				<label>Product Cost</label>
				<input id="prodCost"  type="text" name="prodcost"  style="width: 130px;" >
				</span>
				<div class="clear"></div>
			</div>
			<div class="w3_agileits_main_grid w3l_main_grid" id="quantity" class="text" style="display: none">
				<span class="agileits_grid">
				<label>Quantity</label>
				<input type="text" required id="quant" name="quantity"  style="width: 130px;" />
				</span>
				<div class="clear"></div>
			</div>
			<div class="w3_agileits_main_grid w3l_main_grid" id="sername" style="display: none">
							<span class="agileits_grid">
								<label>Service Name </label>
								 <select id="sname" required name="sername" style="width: 143px; height: 40px" onchange="showSerProvider(this.value);">
				<option disabled selected="selected" value="none">Select Service</option>
	<%
		while(rs2.next())
			{
	%>
			<option value=<%=rs2.getString("NAME")%>><%=rs2.getString("NAME")%></option>
		<% 
		}
		%> </select>
							</span>
						</div>
<div class="w3_agileits_main_grid w3l_main_grid" id="provider" style="display: none">
			<span class="agileits_grid">
				<label>Service Provider</label>
				  <select id="provide" required name="provider" style="width: 143px; height: 40px"  >
				<option disabled selected="selected" value="none">Select Provider</option>
				</select>
				</span><div class="clear"></div>
			</div>
			<div class="w3_agileits_main_grid w3l_main_grid" id="serviceCost" style="display: none">
				<span class="agileits_grid">
				<label>Service Cost</label>
				<input id="serCost"  type="text" name="sercost"  style="width: 130px;" >
				</span>
				<div class="clear"></div>
			</div>
			        		   				<%
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		%> 
						<div class="clear"></div>

					<div class="w3_main_grid">
						<div class="w3_main_grid_right">
							<input type="submit" name="operation" value="ADD">
						</div>
					</div>
				</form>
			</div>
					</div>
	</div>
<!-- DISPLAY TODAYS DATE -->
	<script type="text/javascript">
	var date = new Date();

var day = date.getDate();
var month = date.getMonth() + 1;
var year = date.getFullYear();

if (month < 10) month = "0" + month;
if (day < 10) day = "0" + day;

var today = year + "-" + month + "-" + day;


document.getElementById('theDate').value = today;
	</script>	
<script type="text/javascript">
function sDiv()
{

document.getElementById('productName').style.display='none';
document.getElementById('productType').style.display='none';
document.getElementById('productCompany').style.display='none';
document.getElementById('quantity').style.display='none';
document.getElementById('costproduct').style.display='none';

document.getElementById('sername').style.display='block';
document.getElementById('provider').style.display='block';
// document.getElementById('servicecost').style.display='block';
// obj.value='Show';
return;
}
</script>
</body>
</html>