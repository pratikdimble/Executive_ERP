<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Emp Payment Form::HR</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- //for-mobile-apps -->
<!-- //custom-theme -->
<link href="css/style2.css" rel="stylesheet" type="text/css" media="all" />
       <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
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
	<div class="center-container">
		<div class="main">
			<h1 class="w3layouts_head">Payment Slip Form</h1>
				<div class="w3layouts_main_grid">

<%@ page import="java.sql.*"%> 
	<%
String name = request.getParameter("choice");
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
	PreparedStatement stmt=null,st=null; 
	stmt=connection.prepareStatement("select * from erp_employee where empname='"+name+"'"); 
	st=connection.prepareStatement("select amount from erp_incentive where empname='"+name+"'");
	ResultSet rs=null,rs1=null; 
	rs= stmt.executeQuery(); 
	rs1= st.executeQuery(); 
						%>
					<form action="./paymentslip" method="POST">
									<br/>
								<font color="white">		
								<div class="agileits_w3layouts_main_grid w3ls_main_grid">
								<label style="width: 77px; ">Salary Month: </label>
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			<!-- 		<select style="width: 80; " name="salmonth"  required>
                        <option value="January">January</option>
                        <option value="February">February</option>
                        <option value="March">March</option>
                        <option value="April">April </option>
                        <option value="May">May   </option>
                        <option value="June">June </option>
                        <option value="July">July    </option>
                        <option value="August">August  </option>
                        <option value="September">September  </option>
                        <option value="October">October   </option>
                        <option value="November">November  </option>
                        <option value="December">December</option>
                    </select> -->
                    <input id="month" type="month" name="salmonth">
					</div><div class="clear"></div><br/>
						<div class="w3_agileits_main_grid w3l_main_grid">
<!-- 							<font color="white"> -->
								<label>Employee Name</label>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  <input readonly value="<%= name %>" type="text" name="ename" style="width: 148px; ">
							<%
							while(rs.next()){  %>
							<label>&nbsp&nbsp&nbspEmployee ID </label>
							&nbsp&nbsp<input type="text" name="eid" value="<%=rs.getInt(1)%>" readonly style="width: 75px; "></input>
						</div><br/>
						
						<div class="w3_agileits_main_grid w3l_main_grid">
							<font color="white">
								<label>Employee Designation</label>
			<input readonly value="<%=rs.getString(2)%>" type="text" name="dsgn" style="width: 148px; ">
					<label>&nbsp&nbspContact No. </label>
							<input type="text" name="mobile" value="<%=rs.getLong("MOBILE")%>" size="10" readonly style="width: 80px; "></input>
						
			</font>
						</div>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Date </label>
								<input class="date" type="date" name="attenddate" id="theDate" style="height: 30px; width: 130px">
								</span>
					</div>
						
						<% 
					} 
				%> 

						
						<p>Payment Details:</p><hr>

						<div class="agileits_w3layouts_main_grid w3ls_main_grid">
								<label style="width: 77px; ">Basic Pay </label>
									&nbsp&nbsp
									<input style="width: 130px" id="basic" name="basic" type="text" onkeyup="myFunction();"/>Rs.
									&nbsp&nbsp&nbsp&nbsp<label style="width: 90px; ">Service Tax: </label><input style="width: 80px" id="service" name="service" type="text" readonly="readonly"/>Rs.
									<div class="clear"> </div>
						</div>
							
						<div class="clear"></div><br/>
								<div class="agileits_w3layouts_main_grid w3ls_main_grid">
								<label style="width: 77px; ">H.R.A </label>
									&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									<input style="width: 130px" id="hra" name="hra" type="text"/>Rs.
									&nbsp&nbsp&nbsp&nbsp<label style="width: 90px; ">Income Tax: </label><input style="width: 80px" id="income" name="income" type="text" readonly="readonly"/>Rs.
									<div class="clear"> </div>
						</div>
							<div class="clear"></div><br/>
								<div class="agileits_w3layouts_main_grid w3ls_main_grid">
								<label style="width: 77px; ">D.A. </label>
									&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									<input style="width: 130px" id="da" name="da" type="text"/>Rs.
						</div>
							<div class="clear"></div>	<br/>			
						<div class="agileits_w3layouts_main_grid w3ls_main_grid">
								<label style="width: 77px; ">Incentives: </label>
								<%float cal=0;
								while(rs1.next())
								{
								 cal+=rs1.getFloat("Amount");
								}%>
									&nbsp
										<input style="width: 130px" id="incentive" name="incentive" type="text" value="<%=cal%>" readonly="readonly"/>Rs.
						</div>
						<div class="clear"></div><br/>
										<div class="agileits_w3layouts_main_grid w3ls_main_grid">
								<label style="width: 77px; ">Trans Allow.: </label>
									<input style="width: 130px"id="transport" name="transport" type="text"/>Rs.
						</div>
					<hr></font>
						<div class="clear"></div><br/>
										<div class="agileits_w3layouts_main_grid w3ls_main_grid">
							<font color="red">	<label style="width: 77px; ">Net Pay.: </label>
									<input style="width: 130px"id="netpay" name="netpay" type="text"/>Rs.
						<button type="button" name="operation" value="Calculate" onclick="myFun();">Calculate</button>
						</div></font>
					<!-- 	<div class="clear"></div>
						<br/>
						<div class="agileits_w3layouts_main_grid w3ls_main_grid">
						<font color="blue">		<label style="width: 77px; ">Total:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input style="width: 130px" id="mypayment" name="payment" type="text"/>Rs.
						&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<label style="width: 90px; ">Total: </label>&nbsp&nbsp&nbsp&nbsp<input style="width: 130px" id="taxation" name="taxation" type="text"/>Rs.
									
						</div>
						<div class="clear"/> 
						<hr>
						</font>		<br/>			
						<div class="agileits_w3layouts_main_grid w3ls_main_grid">
							<font color="red">	
								<label style="width: 77px; ">Net Pay: </label>
									&nbsp&nbsp&nbsp&nbsp
									<input style="width: 130px" id="netpay" name="netpay" type="text"/>Rs.
						</font></div> -->
					<div class="w3_main_grid">
						<div class="w3_main_grid_right">
							<input type="submit" name="operation" value="Generate Slip">
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
	<!--  CALCULATE THE SERVICE TAX-->	
	<script type="text/javascript">
function myFunction() {

document.getElementById("hra").value = 5000;
document.getElementById("transport").value = 100;
//document.getElementById("mypayment").value=5000;
 var basic = parseInt(document.getElementById("basic").value, 10);
 var result;
 var calc,da,hra,taxation,payment,trans,incentive,income;
 var bas=(basic * 0.12)/12;
 		document.getElementById("service").value = bas;
				
 					da=(basic * 0.05)/12;
 						document.getElementById("da").value = da;
 						
	 result=basic * 12;
  	if(result < 250000)
 	{
 	calc=00;
 		document.getElementById("income").value = calc;
 		document.getElementById("taxation").value = calc + bas;
	 }	else if(result >= 250000 && result <500000)
 	{
 	calc=(result * 0.05) /12;
 		document.getElementById("income").value = calc;
 		document.getElementById("taxation").value = calc + bas;
	 }
	 else if(result >= 500000 && result <1000000)
 	{
 	calc=(result * 0.20) /12;
 		document.getElementById("income").value = calc;
 		document.getElementById("taxation").value = calc + bas;
	 }
	 else{ 
	 calc=(result * 0.30) /12;
	 			 document.getElementById("income").value = calc;	
	 			 document.getElementById("taxation").value = calc + bas;
	 		}
	  		hra=parseInt(document.getElementById("hra").value, 10);
	 		income=parseInt(document.getElementById("income").value, 10);
 			trans= parseInt(document.getElementById("transport").value, 10);
  			incentive= parseInt(document.getElementById("incentive").value, 10); 
	 		taxation= parseInt(document.getElementById("taxation").value, 10);
	 		
	 		payment=basic+hra+da+trans+incentive;
	 	document.getElementByName("mypayment").value =payment;	
	 	document.getElementById("netpay").value = payment + taxation;
} 
</script>
		<!--  CALCULATE THE Net pay-->	
	<script type="text/javascript">
function myFun() {

 var basic = parseInt(document.getElementById("basic").value, 10);
   var service = parseInt(document.getElementById("service").value, 10);
var hra= parseInt(document.getElementById("hra").value, 10);
  var da= parseInt(document.getElementById("da").value, 10);
 var income=parseInt(document.getElementById("income").value, 10);
 var trans= parseInt(document.getElementById("transport").value, 10);
 var incentive= parseInt(document.getElementById("incentive").value, 10);  
document.getElementById("netpay").value=basic+service+hra+da+income+trans+incentive;

} 
</script>
</body>
</html>