<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Leave Application Form</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Event Registration Form Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
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
	if(thisRole.equalsIgnoreCase("Product Executive"))
                 	{
                 	%>
                 	 <a href="prod_exec_firstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("HR"))
                 	{
                 		%>
                 	 <a href="hr_firstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Sales Manager"))
                 	{
                 		%>
                 	 <a href="salesmanagerfirstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Service Executive"))
                 	{
                 		%>
                 	 <a href="service_exec_firstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Purchase Manager"))
                 	{
                 		%>
                 	 <a href="purchase_manager_firstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Product Manager"))
                 	{
                 		%>
                 	 <a href="prod_manager_firstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Service Manager"))
                 	{
                 		%>
                 	 <a href="service_manager_firstpage.jsp">Back</a>
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
			<h1 class="w3layouts_head">Leave Application Form</h1>
				<div class="w3layouts_main_grid">
					<%
						int thisId = (Integer)session.getAttribute("id");
						String thisName = (String) session.getAttribute("empname");
						//String thisRole = (String) session.getAttribute("role");
						%>
					<form action="./leaveapp" method="POST">
						<div class="w3_agileits_main_grid w3l_main_grid">
							<font color="white">
								<label>Employee Name</label>
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp  <input readonly value="<%= thisName %>" type="text" name="ename" style="width: 100px; ">
							<label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspEmployee ID </label>
							&nbsp&nbsp<input type="text" name="eid" value="<%= thisId %>" readonly style="width: 45px; ">
						</font>
						</div>
					
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Designation </label>
								<input type="text" name="dsgn" readonly  value="<%= thisRole %>" style="width: 148px; ">
							</span>
						</div>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Date </label>
								<input class="date" type="date" name="todaydate" id="theDate" style="height: 30px; width: 130px">
								</span>
						</div>
						<hr>
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Type of Leave </label>
								<select name="leavetype" style="width: 160px">
									<option value="none" selected="" disabled="">Select Leave Type</option>
									<option value="Medical Leave">Medical Leave</option>
									<option value="Wedding Function Leave">Wedding Function Leave</option>
									<option value="Casual Leave">Casual Leave</option>
									<option value="Study Leave">Study Leave</option>
									<option value="Other">Other</option>
								</select>
							</span>
						</div>
						<div class="agileits_w3layouts_main_grid w3ls_main_grid">
							<span class="agileinfo_grid">
								<label style="width: 87px; ">Date From  </label>
								<div class="agileits_w3layouts_main_gridl">
									&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input style="height: 30px; width: 130px" class="date" id="datefrom" name="datefrom" type="date" value="mm/dd/yyyy" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required onchange="cal()">
								</div>
								
								<div class="agileits_w3layouts_main_gridl">
									<label style="width: 77px; ">Date To</label><input style="height: 30px; width: 130px" class="date" id="dateto" name="dateto" type="date" value="mm/dd/yyyy" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}" required onchange="cal()"/>
								</div>
									<div class="clear"> </div>
							</span>
						</div>
							<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Total Days </label>
								<input type="text" name="days" id="numdays" style="width: 103px; ">
							</span>
						</div>
						
							<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Descripition </label>
								<input type="text" name="desc"  style="width: 300px; ">
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
	<!-- CALCULATE THE DAYS  -->
	    <script type="text/javascript">
        function GetDays(){
                var dropdt = new Date(document.getElementById("dateto").value);
                var pickdt = new Date(document.getElementById("datefrom").value);
	 /* Calculate the days except saturday and sundays  */
	var count = 0;
   // var curDate = pickdt;
    while ( pickdt <= dropdt) {
        var dayOfWeek =  pickdt.getDay();
        var isWeekend = (dayOfWeek == 6) || (dayOfWeek == 0); 
        if(!isWeekend)
           count++;
         pickdt =  pickdt.addDays(1);
    }
    return count; 
   				 /* Calculate the days */
                //return parseInt((dropdt - pickdt) / (24 * 3600 * 1000));
        }

        function cal(){
        if(document.getElementById("datefrom")){
            document.getElementById("numdays").value=GetDays();
        }  
    }
    
    Date.prototype.addDays = function(days) {
    var date = new Date(this.valueOf())
    date.setDate(date.getDate() + days);
    return date;
}
    </script>	

</body>
</html>