<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
      <%@ include file="JavaScript.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Purchase Enquiry Form</title>
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
	if(thisRole.equalsIgnoreCase("Purchase Manager"))
                 	{
                 		%>
                 	 <a href="purchase_manager_firstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else
                 	{
                 				%>
                 	 <a href="index.jsp">Home</a>
                 	 <% 
                 	} 
                 	Connection con= null;
	PreparedStatement ps = null,ps1 = null;
	ResultSet rs = null,rs1 = null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

String custName = "SELECT * FROM ERP_vendor";
String prodName = "SELECT * FROM ERP_PRODUCT";
	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(custName);ps1 = con.prepareStatement(prodName);
			rs = ps.executeQuery();rs1 = ps1.executeQuery(); 
						%>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
<!-- banner -->
	<div class="center-container">
		<div class="main">
			<h1 class="w3layouts_head">Purchase Enquiry  Form</h1>
				<div class="w3layouts_main_grid">
					<%
						int thisId = (Integer)session.getAttribute("id");
						String thisName = (String) session.getAttribute("empname");
						//String thisRole = (String) session.getAttribute("role");
						%>
					<form action="./purchase" method="POST">
					<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Date </label>
								<input class="date" type="date" name="todaydate" id="theDate" style="height: 30px; width: 130px">
								</span>
						</div>
								
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label><font color="red">Supplier Details</font></label>
							</span>
						</div>
						<hr>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Supplier Name </label>
								 <select  style="width: 143px; height: 40px" required="required" onchange="showSuppAddr(this.value);showSuppContact(this.value);showSuppId(this.value);showSuppName(this.value);" >
				<option disabled selected="selected" value="none">select</option>
	<%
		while(rs.next())
			{
	%>
			<option value=<%=rs.getString("vendorName")%>><%=rs.getString("vendorName")%></option>
		<% 
		}
		%> </select>&nbsp&nbsp<a href="register_vendor_form_quotation.jsp"><input type="button" value="New" style="height: 40px; width: 152px"/></a>
							</span>
						</div>
						
						<div class="w3_agileits_main_grid w3l_main_grid" id="suppname" >
							<span class="agileits_grid">
								<input type="hidden" name="suppname" readonly style="width: 200px;">
							</span>
						</div>
						<div class="w3_agileits_main_grid w3l_main_grid" id="suppid" >
							<span class="agileits_grid">
								<input type="hidden" name="suppid" readonly style="width: 200px;">
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
								<label><font color="red">Purchase Details</font></label>
							</span>
						</div>
						<hr><br/>
		<div class="w3_agileits_main_grid w3l_main_grid"  class="text" >
		<span class="agileits_grid">
				<label>Product Name</label>
  <select  required name="prodname" style="width: 143px; height: 40px" class="text" onchange="showppType(this.value);showpCompany(this.value);showPid(this.value)">
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
			<div class="w3_agileits_main_grid w3l_main_grid" id="productId" >
				<span class="agileits_grid">
				<input required type="hidden" name="pid" readonly style="width: 130px;" >
				</span>
				<div class="clear"></div>
			</div>
			<div class="w3_agileits_main_grid w3l_main_grid" id="productType" >
				<span class="agileits_grid">
				<label>Product Type</label>
				<input id="prodType" required type="text" name="prodtype" readonly style="width: 130px;" >
				</span>
				<div class="clear"></div>
			</div>
			
			<div class="w3_agileits_main_grid w3l_main_grid"  id="productCompany" >
			<span class="agileits_grid">
				<label>Product Company</label>
				  <select id="prodcompany" required name="company" style="width: 143px; height: 40px"  >
				<option disabled selected="selected" value="none">Select Company</option>
				</select>
				</span><div class="clear"></div>
			</div>
	<div class="w3_agileits_main_grid w3l_main_grid"  class="text">
				<span class="agileits_grid">
				<label>Product Cost</label>
				<input type="text" required name="prodcost"  style="width: 130px;" />
				</span>
				<div class="clear"></div>
			<div class="w3_agileits_main_grid w3l_main_grid" class="text">
				<span class="agileits_grid">
				<label>Quantity</label>
				<input type="text" required name="quantity"  style="width: 130px;" />
				</span>
				<div class="clear"></div>
				
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

</body>
</html>