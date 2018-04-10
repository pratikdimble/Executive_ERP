<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
      <%@ include file="JavaScript.jsp" %>
<html>
<head>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">

<link rel="stylesheet" href="css/style5.css" type="text/css" media="all" /><!-- Style-CSS -->
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css" media="all" />
<link href="//fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Expletus+Sans" rel="stylesheet">
	<!--header-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Requirements:: Product Executive</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
</head>
<body >

<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="prod_exec_firstpage.jsp">Home</a>
<!--     <a href="firstpage.jsp">Back</a> -->
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
<%
						int thisId = (Integer)session.getAttribute("id");
						String thisName = (String) session.getAttribute("empname");
						String thisRole = (String) session.getAttribute("role");
						
						Connection con= null;
	PreparedStatement ps = null,ps1 = null,ps2 = null,ps6= null;
	ResultSet rs = null,rs1 = null,rs2 = null,rs6= null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

String custName = "SELECT * FROM ERP_CUSTOMER";
String dsgnName = "SELECT DSGNNAME FROM ERP_DESIGNATION";
String prodName = "SELECT NAME FROM ERP_PRODUCT";
String prodType = "SELECT TYPE FROM ERP_PRODUCT";


	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(custName);ps1 = con.prepareStatement(prodName);ps2 = con.prepareStatement(prodType);
			ps6 = con.prepareStatement(dsgnName);
			rs = ps.executeQuery();rs1 = ps1.executeQuery(); rs2 = ps2.executeQuery();
			rs6 = ps6.executeQuery();
						%>
<section class="agile-main">
	<header><h1>Customer <label>Requirements</label> Form</h1></header>
	<div class="agile-top">
		<form action="./custreq" method="post" onsubmit="checkStock();">
		<div class="agile-user">
				<input type="hidden" name="eid" value="<%= thisId %>" readonly />
				<div class="clear"></div>
			</div>
			<div class="agile-user">
				<p>Employee Name</p>
				<span><i class="fa fa-user" aria-hidden="true"></i></span>
				<input type="text" name="ename" value="<%= thisName %>" readonly/>
				<div class="clear"></div>
			</div>
			<div class="agile-email">
				<p>Designation</p>
				<span><i class="fa fa-drivers-license" aria-hidden="true"></i></span>
				<input type="text" name="dsgn" readonly value="<%= thisRole %>"/>
				<div class="clear"></div>
			</div>
			<div class="agile-username">
				<p>Customer Name</p>
				<span><i class="fa fa-user-plus" aria-hidden="true"></i></span>
				 <select name="custname" id="custname" style="width: 143px; height: 40px" required="required" onchange="showCustId(this.value)" >
				<option disabled selected="selected" value="none">select</option>
	<%
		while(rs.next())
			{
				//String emp = rs.getString("CUSTNAME");
	%>
			<option value=<%=rs.getString("CUSTNAME")%>><%=rs.getString("CUSTNAME")%></option>
		<% 
		}
		%> </select>
				<div class="clear"></div>
			</div>
			<div class="agile-username" id="custid">
				<input type="hidden"  name="custid" >
				<div class="clear"></div>
			</div>
			<div class="agile-username">
				<p>Product Name</p>
				<span><i class="fa fa-trademark" aria-hidden="true"></i></span>
  <select id="prodname" name="pname" style="width: 143px; height: 40px" required="required" onchange="showpType(this.value);showCompany(this.value);">
				<option disabled selected="selected" value="none">Select Product</option>
	<%
		while(rs1.next())
			{
				String prod = rs1.getString("NAME");
	%>
			<option value=<%=prod%>><%=prod%></option>
		<% 
		}
		%> </select>
				<div class="clear"></div>
			</div>
			<div class="agile-username" id="productType">
				<p>Product Type</p>
				<span><i class="fa fa-support" aria-hidden="true"></i></span>
				<input type="text" name="prodtype" readonly="readonly">
				<div class="clear"></div>
			</div>
			
			<div class="agile-username" id="productCompany">
				<p>Product Company</p>
				<span><i class="fa fa-registered" aria-hidden="true"></i></span>
				  <select id="prodcomp" name="company" style="width: 143px; height: 40px" required="required" >
				<option disabled selected="selected" value="none">Select Company</option>
				</select>
				<div class="clear"></div>
			</div>
			<div class="agile-username" id="productStock">
				<input type="hidden" name="quan" id="quan" style="width: 50px; height: 10px">
				<div class="clear"></div>
			</div>
			
			<div class="agile-username">
				<p>Quantity</p>
				<span><i class="fa fa-user-plus" aria-hidden="true"></i></span>
				<input type="text" id="quantity" name="quantity" required oninput="checkStock();" onkeyup="checkStock();" onkeypress="checkStock();"/>
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
		<div id="error">
			<p></p>
		</div>
		<div class="clear"></div>
			<button id="submit" type="submit" name="operation" value="ADD"></button>
		</form>
		<div class="clear"></div>
	</div>
</section>

		<!--  Check the stock-->	
	<script type="text/javascript">
function checkStock() {

 var quan = parseInt(document.getElementById("quan").value, 10);
   var quantity = parseInt(document.getElementById("quantity").value, 10);
  	if(quantity >= quan)
 	{
 	 document.getElementById("error").innerHTML = "*Value is Out of Stock";
 	 document.getElementById("submit").disabled=true;
	 } 
	 else
	 {
	  document.getElementById("submit").disabled=false;
	 document.getElementById("error").innerHTML ="";
	 }
} 

	function showCustId(str){ 
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
							document.getElementById("custid").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_custid.jsp?q="+str,true); 
		xmlhttp.send();   
	}
</script>
</body>
</html>