<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%> 
<!DOCTYPE html>
<html lang="en">
<head>
<title>Update Vendor Form</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- //for-mobile-apps -->
<!-- //custom-theme -->
<link href="css/sstyle2.css" rel="stylesheet" type="text/css" media="all" />
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
    <a class="active" href="purchase_manager_firstpage.jsp">Home</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
<!-- banner -->
<c:choose>
  <c:when test="${!empty listVendorDTOs}">
      <c:forEach var="dto"  items="${listVendorDTOs}">
	<div class="center-container">
		<div class="main">
		<font color="red">
			<h1 class="w3layouts_head">Vendor/Supplier Update Form</h1>
				<div class="w3layouts_main_grid">

					<form action="./vendor" method="POST">
					<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
							<label>Company ID </label>
								<input type="text" name="id" readonly="readonly" style="height: 15px; width: 130px" value="${dto.vendorId}"/>
												</span>
						</div>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Company Name </label>
								<input type="text" name="company" readonly="readonly" value="${dto.vendorName}">
							</span>
						</div>
					
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Company Website </label>
								<input type="text" name="web" value="${dto.website}">
							</span>
						</div>
						
						<div class="agileits_w3layouts_main_grid w3ls_main_grid">
							<span class="agileinfo_grid">
								<label style="width: 77px; ">Country  </label>
								<div class="agileits_w3layouts_main_gridl">
									&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input style="height: 15px; width: 130px" id="country" name="country" type="text" value="${dto.vendorCountry}"/>
								</div>
								<%
	Connection con= null;
	PreparedStatement ps = null,ps1 = null,ps2 = null,ps4= null,ps5= null,ps6= null;
	ResultSet rs = null,rs1 = null,rs2 = null,rs4 = null,rs5 = null,rs6= null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";


String state = "SELECT state FROM ERP_STATE"; 

	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(state);
			rs = ps.executeQuery();
	%>
								<div class="agileits_w3layouts_main_gridl">
									<label style="width: 77px; ">State</label>
									<select id="state" name="state" onchange="showState(this.value)" >
								<option value="${dto.vendorState}">${dto.vendorState}</option> 
			<% 
while(rs.next()){ 
%> 
<option value="<%=rs.getString("State")%>"><%=rs.getString("State")%></option> 
<% 
} 
%> 
</select>
								</div><div class="clear"> </div> </span></div>
<%
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		%>
						<div class="agileits_w3layouts_main_grid w3ls_main_grid">
							<span class="agileinfo_grid">
								<label style="width: 77px; ">City  </label>
								<div class="agileits_w3layouts_main_gridl">
									&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									<select id="city" name="city" required> 
<option value="${dto.vendorCity}">${dto.vendorCity}</option>
<!-- <option>Pune</option>   -->
</select> 
<!-- 									<input style="height: 15px; width: 130px" id="city" name="city" type="text" /> -->
								</div>
								
								<div class="agileits_w3layouts_main_gridl">
									<label style="width: 77px; ">Pin</label><input style="height: 15px; width: 130px" id="pin" name="pin" type="text" value="${dto.pin}"/>
								</div>
									<div class="clear"> </div>
							</span>
						</div>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Company Address </label>
								<input type="text" name="addr" value="${dto.vendorAddr}">
							</span>
						</div>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Company Phone </label>
								<input type="text" name="phone" value="${dto.mobile}">
							</span>
						</div>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Company EMail </label>
								<input type="text" name="email" value="${dto.vendorMail}">
							</span>
						</div>
						<hr>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Type of Business </label>
								<select name="business">
									<option value="${dto.business}">${dto.business}</option>
									<option value="Manufacturer">Manufacturer</option>
									<option value="Service Provider">Service Provider</option>
									<option value="Distributor">Distributor</option>

								</select>
							</span>
						</div>
						
						</c:forEach>
  </c:when>
 
  <c:otherwise>
     <h1 style="color:red;text-align:center">Records not found</h1>
  </c:otherwise>
</c:choose>
						<div class="clear"></div>
					<div class="w3_main_grid">
						<div class="w3_main_grid_right">
							<input type="submit" name="operation" value="Save Changes">
						</div>
				</font>	</div>
				</form>
			</div>
					</div>
	</div>
<!-- DISPLAY Cities -->
<script> 
	function showState(str){ 
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
							document.getElementById("city").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populatecity.jsp?q="+str,true); 
		xmlhttp.send(); 
	} 
</script> 


</body>
</html>