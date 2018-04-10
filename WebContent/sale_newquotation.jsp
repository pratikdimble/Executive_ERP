<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
      <%@ include file="JavaScript.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>New Sale Quotation Form</title>
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
                 	
                 	String thisName = (String) session.getAttribute("empname");
						String custname = request.getParameter("custname");
						String custaddr = request.getParameter("addr");
						String custcnt = request.getParameter("contact");
						
                 	Connection con= null;
	PreparedStatement ps = null,ps1 = null,ps2 = null,ps3=null;
	ResultSet rs = null,rs1 = null,rs2 = null,rs3=null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";
String myname=null;
String custName = "SELECT * FROM ERP_CUSTOMER WHERE CUSTNAME NOT LIKE ?";
String cname="SELECT CUSTNAME FROM ERP_CUSTOMER WHERE CUSTNAME LIKE ?";
String serviceName = "SELECT NAME FROM ERP_SERVICE";
String prodName = "SELECT NAME FROM ERP_PRODUCT";
	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(custName);ps1 = con.prepareStatement(prodName);ps2 = con.prepareStatement(serviceName);
			ps.setString(1,custname+"%");
			ps3 = con.prepareStatement(cname);
			ps3.setString(1,custname+"%");
			rs = ps.executeQuery();rs1 = ps1.executeQuery(); rs2 = ps2.executeQuery();rs3 = ps3.executeQuery();
			while(rs3.next())
			{
				myname=rs3.getString("CUSTNAME");
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
			<h1 class="w3layouts_head">Sale Quotation Form</h1>
				<div class="w3layouts_main_grid">
					<%
						int thisId = (Integer)session.getAttribute("id");
		
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
								 <select name="custname" id="custname" style="width: 143px; height: 40px"  onchange="showCustooID(this.value);showCAddr(this.value);showCContact(this.value);" >
				<option disabled selected="selected" value="<%=myname%>"><%=myname%></option>
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
<!-- 							<span class="agileits_grid"> -->
								<input type="hidden" name="custid" readonly style="width: 200px;">
<!-- 							</span> -->
						</div>
						<div class="w3_agileits_main_grid w3l_main_grid" id="addr" >
							<span class="agileits_grid">
								<label>Address </label>
								<input type="text" name="addr" id="addr" value="<%=custaddr%>" readonly style="width: 200px;">
							</span>
						</div>
						<div class="w3_agileits_main_grid w3l_main_grid" id="contact" >
							<span class="agileits_grid">
								<label>Contact </label>
								<input type="text" name="contact" id="contact" value="<%=custcnt%>" readonly style="width: 130px;">
							</span>
						</div>
							<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label><font color="red">Customer Requirement</font></label>
							</span>
						</div>
						<hr><br/>
					<font color="pink">
						<input type="radio" name="custreq" onclick="prodDiv();" required value="Product Only">Product Only
						<input type="radio" name="custreq" onClick ="serviceDiv();"  required value="Service Only">Service Only 
<!-- 						<br/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="radio"  required name="type" onClick ="prodserviceDiv()" value="Product With Service"> Product With Service -->
					</font>
		<div class="w3_agileits_main_grid w3l_main_grid" id="productName" style="display: none" >
		<span class="agileits_grid">
				<label>Product Name</label>
  <select id="prodName" name="prodname"  required style="width: 143px; height: 40px" class="text" onchange="showppType(this.value);showppCompany(this.value);">
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
			<div class="w3_agileits_main_grid w3l_main_grid" id="productType" style="display: none" >
				<span class="agileits_grid">
				<label>Product Type</label>
				<input id="prodtype" type="text" name="prodtype" readonly style="width: 130px;" >
				</span>
				<div class="clear"></div>
			</div>
			
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
			<div class="w3_agileits_main_grid w3l_main_grid" id="quantity" style="display: none" >
				<span class="agileits_grid">
				<label>Quantity</label>
				<input type="text" id="quant" name="quantity"  required style="width: 130px;" onkeyup="myFunct();" />
</span>
			</div>
			<div class="w3_agileits_main_grid w3l_main_grid" id="sername" style="display: none">
							<span class="agileits_grid">
								<label>Service Name </label>
								 <select id="sname" name="sername"  required style="width: 143px; height: 40px" onchange="showProvider(this.value);">
				<option disabled selected="selected" value="none">select</option>
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
				  <select id="provide"  name="provider"  required style="width: 143px; height: 40px"  >
				<option disabled selected="selected" value="none">Select Provider</option>
				</select>
				</span><div class="clear"></div>
			</div>
							<div class="w3_agileits_main_grid w3l_main_grid" id="servicecost" style="display: none">
							<span class="agileits_grid">
								<label>Service Cost</label>
								<input type="text" name="sercost" readonly style="width: 130px;">
							</span><div class="clear"></div>
						</div>
<div  id="prodamt"  style="display: none">
	<font color="white">
			<label>Net Amount </label>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input id="pamt"  type="text" name="total" style="width: 130px;">Rs.
</font>
</div>
<br/> 
<div class="w3_agileits_main_grid w3l_main_grid" id="productdata"  style="display: none">
							<font color="white">
									<label>Service Tax </label>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" id="servicetax" name="servicetax" onkeyup="myFunctionn();myFunn();" style="width: 130px;">%
<br/><br/>
<label>Gross Net Amount </label>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="grossnet" id="grossnet"  style="width: 130px;">
<br/><br/>
<label>Discount </label>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="discount" id="discount" value="0" onkeyup="myFunn();" style="width: 130px;">Rs.
							<br/><br/>
							<label>Grand Amount </label>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="grossamount" id=grossamount   style="width: 130px;">
							</font>
						</div>
	<div  id="seramt"  style="display: none">
	<font color="white">
		<label>Net Amount </label>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input id="samt" name="seramt" type="text" readonly style="width: 130px;">Rs.
</font>	
</div>
<br/>
<div class="w3_agileits_main_grid w3l_main_grid" id="servicedata"  style="display: none">
	<font color="white">
		<label>Service Tax </label>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" id="sertax" name="sertax" onkeyup="calTaxx();calDiscountt();" style="width: 130px;">%<br/><br/>
		<label>Gross Net Amount </label>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="sergrossnet" id="sergrossnet"   style="width: 130px;">Rs.<br/><br/>
		<label>Discount </label>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="serdiscount" id="serdiscount" value="0" onkeyup="calDiscountt();" style="width: 130px;">Rs.
	<br/><br/>
		<label>Gross Amount </label>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp	<input type="text" name="sergrossamount" id=sergrossamount    style="width: 130px;">Rs.
		</font>
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
							<input type="submit" name="operation" value="Generate Quotation" style="width: 200px; ">
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

</body>
</html>