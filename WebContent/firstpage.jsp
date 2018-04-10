<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin first page</title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
</head>
<body background="img/back.jpg">
<%
String thisRole = (String) session.getAttribute("role");
String thisName = (String) session.getAttribute("name");
 %>
<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <b><font color="red" size="3">Welcome <%=thisName %>--> Role:: <%=thisRole%></font></b>
  <div class="header-right">
    <a class="active" href="firstpage.jsp">Home</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>


<div class="navbar">

  <div class="dropdown">
    <button class="dropbtn">Masters 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="displayproduct.jsp">Product Master</a>
      <a href="displayservice.jsp">Service Master</a>
      <a href="add_department_form.jsp">Department Master</a>
      <a href="add_designation_form.jsp">Designation Master</a>
      <a href="addcompanyform.html">Company Master</a>
      <a href="bankandbranch.jsp">Bank and Branch Master</a>
      <a href="addregionform.jsp">Region Master</a>
      <a href="addareaform.jsp">Area Master</a>
<!--       <a href="display_incentive.jsp">Incentive Master</a> -->
      <a href="#">Telecaller</a>
    </div>
      </div>
      
    <div class="dropdown">
    <button class="dropbtn">Employee 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="emp_assign.jsp">Assign To</a>
      <a href="adminlogindetails.jsp">Login Details</a>
      <a href="change_dept.jsp">Change Department</a>
       <a href="leaveapp?operation=link2">Approved Leaves</a>
       
     </div>
  </div> 
  
<!--       <div class="dropdown">
    <button class="dropbtn">Customer 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="displaycustappoint.jsp">Appointment</a>
     </div>
  </div>  -->
  
  <div class="dropdown">
    <button class="dropbtn">Transaction 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <div class="row">
        <div class="column">
          <h3>Purchase</h3>
         <a href="#">Purchase Enquiry</a>
     	<a href="#">Purchase Quotation</a>
     	<a href="#">Purchase Order</a>
     	 <a href="#">GRN</a>
        </div>
        <div class="column">
          <h3>Sale</h3>
           <a href="sale?operation=link1">Sale Enquiry</a>
     		<a href="#">Sale Quotation</a>
     		<a href="#">Sale Order</a>
     		<a href="#">GRN</a>
        </div>
        </div>
      </div>
      </div>
      						
  	<div class="dropdown">
    <button class="dropbtn">Invoice 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="#">Purchase Bill</a>
      <a href="#">Sale Bill</a>
      <a href="#">Amount Pay/Receive</a>
     </div>
  </div>  
  
   <div class="dropdown">
    <button class="dropbtn">Payroll 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="#">Attendace</a>
      <a href="#">Leave Application</a>
      <a href="#">Payment</a>
     </div>
  </div> 
  
   <div class="dropdown">
    <button class="dropbtn">Events and Holidays 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="display_holiday_date.jsp">Holiday Master</a>
      <a href="#">Event Master</a>
     </div>
  </div> 
    <div class="dropdown">
    <button class="dropbtn">Search 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <div class="row">
        <div class="column">
      <a href="controller?operation=link1">View All Products</a>
      <a href="service?operation=link1">View All Services</a>
      <a href="company?operation=link1">View All Companies</a>
      <a href="employee?operation=link1">View All Employees</a>
      <a href="customer?operation=link1">View All Customers</a>
      <a href="bank?operation=link1">View All Banks</a>
       <a href="holiday?operation=link1">View All Holidays</a>
       <a href="incentive?operation=link1">View All Incentives</a>
        </div>
        <div class="column">
        <a href="dept?operation=link1">View All Departments</a>
     <a href="branch?operation=link1">View All Branches</a>
       <a href="region?operation=link1">View All Regions</a>
      <a href="area?operation=link1">View All Areas</a>
       <a href="custappoint?operation=link1">View All Appointments</a>
        <a href="empassign?operation=link1">View All Assignments</a>
         <a href="leaveapp?operation=link1">View All Leave Applications</a>
        </div>
        </div>
      </div>
      </div>
  
</div>

</body>
</html>