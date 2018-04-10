<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
      <%@ include file="JavaScript.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
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
/*     padding-top: 12px; */
/*     padding-bottom: 12px; */
    text-align: left;
    background-color: #4CAF50;
    color: white;
}

</style>
<title>Purchase New Order Form</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="css/sstylee.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/sstylee3.css" rel="stylesheet" type="text/css" media="all" />

<!-- js -->
<script type="text/javascript" src="js/jjquery-2.1.4.min.js"></script>
<!-- //js -->
<!-- //font-awesome-icons -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
</head>
<body>
 <div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">

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
	PreparedStatement ps = null,ps1 = null,ps2=null;
	ResultSet rs = null,rs1 = null,rs2=null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";
String quot = " SELECT * FROM ERP_PURCHASEQUOTATION";
String prodName = "SELECT NAME FROM ERP_PRODUCT";
	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(quot);ps1 = con.prepareStatement(prodName);
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
			<h1 class="w3layouts_head">Purchase Order Form</h1>
				<div class="w3layouts_main_grid">
					<%
						int thisId = (Integer)session.getAttribute("id");
						String thisName = (String) session.getAttribute("empname");
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
								<label><font color="red">Employee Details</font></label>
							</span>
						</div>
						<hr><br/>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<font color="white">
								<label>Employee Name</label>
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input readonly value="<%= thisName %>" type="text" name="name" style="width: 100px; ">
							<label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspEmployee ID </label>
							&nbsp&nbsp<input type="text" name="eid" value="<%= thisId %>" readonly style="width: 45px; ">
						</font>
						</div>
					
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Designation </label>
								<input type="text" name="dsgn" readonly  value="<%= thisRole %>" style="width: 140px; ">
							</span>
						</div>
								<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label><font color="red">Supplier Details</font></label>
							</span>
						</div>
						<hr><br/>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
<!-- 							location.reload(); -->
								<%-- <label>Quotation ID</label>
								 <select style="width: 200px; height: 40px" required="required" onchange="showSupplierName(this.value);showSupplAddr(this.value);showSupplContact(this.value);productQData(this.value);" >
				<option disabled selected="selected" value="none">Select Quotation ID</option>
	<%
		while(rs.next())
			{
	%>
			<option value=<%=rs.getInt("id")%>><%=rs.getInt("id")%></option>
		<% 
		}
		%> </select>&nbsp&nbsp<a href="register_vendor_form_quotation.jsp"><input type="button" value="New" style="height: 40px; width: 152px"/></a> --%>
						
						<div class="w3_agileits_main_grid w3l_main_grid" id="suppname">
							<span class="agileits_grid">
								<label>Supplier Name </label>
								 <select id="suppname" suppname style="width: 200px; height: 40px" required="required" onchange="showSuppAddrr(this.value);showSuppContactt(this.value);productQDataa();" >
								<option value="none" disabled="disabled" selected="selected">Select Supplier</option>
								<% 
								 ps2=con.prepareStatement("select vendorName from erp_vendor"); 
						rs2= ps2.executeQuery(); 

						while(rs2.next()){   
						
%>
<option value="<%=rs2.getString("vendorName")%>"><%=rs2.getString("vendorName")%></option>
<%-- <input type="text"  value="<%=rs.getString("suppName")%>" name="suppname" readonly style="width: 200px;" />  --%>
<% 
} 
%> 
<!-- <input type="text" name="suppname" readonly style="width: 200px;"> -->
							</select>
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
		
<div class="w3_agileits_main_grid w3l_main_grid" id="mytabledata" >
<span class="agileits_grid">

 </span>
</div>
<div class="w3_agileits_main_grid w3l_main_grid" id="tabledataa" >
<span class="agileits_grid">

 </span>
</div>
	<%
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		%> 
						<div class="clear"></div>
<!-- <table id="tabledataa">

  
</table> -->

					<div class="w3_main_grid">
						<div class="w3_main_grid_right">
							<input type="submit" name="operation" value="Order" style="width: 217px; ">
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

function productQDataa()
{
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
							document.getElementById("mytabledata").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","select_purchase3.jsp",true); 
		xmlhttp.send(); 
return;
}
	</script>	

</body>
</html>