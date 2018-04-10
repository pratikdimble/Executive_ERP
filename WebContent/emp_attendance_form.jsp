<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Emp Attendance Form::HR</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- //for-mobile-apps -->
<!-- //custom-theme -->
<link href="css/sstyle.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script type="text/javascript" src="js/jjquery-2.1.4.min.js"></script>
<!-- //js -->
<!-- font-awesome-icons -->
<!-- //font-awesome-icons -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
</head>
<body>
<!-- banner -->
	<div class="center-container">
		<div class="main">
			<h1 class="w3layouts_head">Attendance Form</h1>
				<div class="w3layouts_main_grid">
				<%-- 	<%
						int thisId = (Integer)session.getAttribute("id");
						String thisName = (String) session.getAttribute("name");
						String thisRole = (String) session.getAttribute("role");
						%> --%>
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
	PreparedStatement stmt=null; 
	stmt=connection.prepareStatement("select empid from erp_employee where empname='"+name+"'"); 
	ResultSet rs=null; 
	rs= stmt.executeQuery(); 
						%>
					<form action="./attendance" method="POST">
						<div class="w3_agileits_main_grid w3l_main_grid">
							<font color="white">
								<label>Employee Name</label>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  <input readonly value="<%= name %>" type="text" name="ename" style="width: 148px; ">
							<%
							while(rs.next()){  %>
							<label>&nbsp&nbsp&nbspEmployee ID </label>
							&nbsp&nbsp<input type="text" name="eid" value="<%=rs.getInt(1)%>" readonly style="width: 75px; "></input>
						</font>
						</div>
						<% 
					} 
				%> 

						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Date </label>
								<input class="date" type="date" name="attenddate" id="theDate" style="height: 30px; width: 130px">
								</span>
						</div>
						<hr>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Entry Status </label>
								<select name="entry">
									<option value="none" selected="" disabled="">Select Entry Status</option>
									<option value="present">Present</option>
									<option value="absent">Absent</option>
									<option value="Half Day">Half Day</option>
								</select>
							</span>
						</div>
						<div class="agileits_w3layouts_main_grid w3ls_main_grid">
							<span class="agileinfo_grid">
								<label style="width: 77px; ">In Time </label>
								<div class="agileits_w3layouts_main_gridl">
									&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input style="height: 30px; width: 130px" class="date" id="intime" name="intime" type="time">
								</div>
								
								<div class="agileits_w3layouts_main_gridl">
									<label style="width: 77px; ">Out Time</label><input style="height: 30px; width: 130px" class="date" id="outtime" name="outtime" type="time" />
								</div>
									<div class="clear"> </div>
							</span>
						</div>
							
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