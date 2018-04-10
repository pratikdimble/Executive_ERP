<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>   
<!DOCTYPE html>
<html lang="en">
<head>
<title>Emp Payment Slip::Employee</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
       <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
<!-- //for-mobile-apps -->
<!-- //custom-theme -->
<link href="css/style2.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script type="text/javascript" src="js/jjquery-2.1.4.min.js"></script>
<!-- //js -->
<!-- font-awesome-icons -->
<!-- //font-awesome-icons -->
<!-- <link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'> -->
</head>
<body>
<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
<%
String thisRole = (String) session.getAttribute("role");
	if(thisRole.equalsIgnoreCase("Product Executive"))
                 	{
                 	%>
                 	 <a href="prod_exec_firstpage.jsp">Home</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("HR"))
                 	{
                 		%>
                 	 <a href="hr_firstpage.jsp">Home</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Service Executive"))
                 	{
                 		%>
                 	 <a href="service_exec_firstpage.jsp">Home</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Product Manager"))
                 	{
                 		%>
                 	 <a href="prod_manager_firstpage.jsp">Home</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Service Manager"))
                 	{
                 		%>
                 	 <a href="service_manager_firstpage.jsp">Home</a>
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
						<c:choose>
  						<c:when test="${!empty listpaymentDTOs}">
  						<c:forEach var="dto"  items="${listpaymentDTOs}">
	<div class="center-container">
		<div class="main">
			<h1 class="w3layouts_head">Payment Slip</h1>
				<div class="w3layouts_main_grid">

					<form action="./paymentslip" method="POST">

									<br/>
								<font color="white">		
								<div class="agileits_w3layouts_main_grid w3ls_main_grid">
								<label style="width: 77px; ">Salary Month: </label>
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input id="month" type="text" name="salmonth" value="${dto.salMonth}" style="width: 86px; "readonly="readonly">
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<label style="width: 77px; ">Slip ID:</label>
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input id="month" type="text" name="slip" value="${dto.slipId}" readonly="readonly" style="width: 81px; ">
					
					</div><div class="clear"></div><br/>
						<div class="w3_agileits_main_grid w3l_main_grid">
<!-- 							<font color="white"> -->
								<label>Emp Name</label>
			&nbsp&nbsp  <input readonly value="${dto.empName}" type="text" name="ename" style="width: 148px; ">
				
							<label>&nbsp&nbsp&nbspEmp ID </label>
							&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="eid" value="${dto.empId}" readonly style="width: 75px; "></input>
						</div><br/>
						
						<div class="w3_agileits_main_grid w3l_main_grid">
							<font color="white">
								<label>Designation</label>
			&nbsp&nbsp<input readonly value="${dto.designation}" type="text" name="dsgn" style="width: 148px; ">
					<label>&nbsp&nbspContact No. </label>
							<input type="text" name="mobile" value="${dto.mobile}" size="10" readonly style="width: 100px; "></input>
						
			</font>
						<p>Payment Details:</p><hr>

						<div class="agileits_w3layouts_main_grid w3ls_main_grid">
								<label style="width: 77px; ">Basic Pay </label>
									&nbsp&nbsp
									<input style="width: 130px" id="basic" name="basic" type="text" value="${dto.basic}"readonly="readonly"/>Rs.
									&nbsp&nbsp&nbsp&nbsp<label style="width: 90px; ">Service Tax: </label><input style="width: 80px" id="service" name="service" type="text" value="${dto.service}" readonly="readonly"/>Rs.
									<div class="clear"> </div>
						</div>
							
						<div class="clear"></div><br/>
								<div class="agileits_w3layouts_main_grid w3ls_main_grid">
								<label style="width: 77px; ">H.R.A </label>
									&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									<input style="width: 130px" id="hra" name="hra" type="text" value="${dto.hra}" readonly="readonly"/>Rs.
									&nbsp&nbsp&nbsp&nbsp<label style="width: 90px; ">Income Tax: </label><input style="width: 80px" id="income" name="income" type="text" readonly="readonly" value="${dto.income}"/>Rs.
									<div class="clear"> </div>
						</div>
							<div class="clear"></div><br/>
								<div class="agileits_w3layouts_main_grid w3ls_main_grid">
								<label style="width: 77px; ">D.A. </label>
									&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									<input style="width: 130px" id="da" name="da" type="text" value="${dto.da}" readonly="readonly"/>Rs.
						</div>
							<div class="clear"></div>	<br/>			
						<div class="agileits_w3layouts_main_grid w3ls_main_grid">
								<label style="width: 77px; ">Incentives: </label>
								&nbsp
										<input style="width: 130px" id="incentive" name="incentive" type="text" value="${dto.incentive}" readonly="readonly"/>Rs.
						</div>
						<div class="clear"></div><br/>
										<div class="agileits_w3layouts_main_grid w3ls_main_grid">
								<label style="width: 77px; ">Trans Allow.: </label>
									<input style="width: 130px"id="transport" name="transport" type="text" value="${dto.transport}" readonly="readonly"/>Rs.
						</div>
					<hr></font>
						<div class="clear"></div><br/>
										<div class="agileits_w3layouts_main_grid w3ls_main_grid">
							<font color="red">	<label style="width: 77px; ">Net Pay.: </label>
									<input style="width: 130px"id="netpay" name="netpay" type="text" value="${dto.netpay}" readonly="readonly"/>Rs.
						</div></font>
          </c:forEach>
  </c:when>
 
  <c:otherwise>
     <h1 style="color:red;text-align:center">Records not found</h1>
  </c:otherwise>
</c:choose>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
	    
    
