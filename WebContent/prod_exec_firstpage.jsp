<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Executive First Page</title>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

   <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
</head>
<body background="img/back.jpg">
<%
String thisRole = (String) session.getAttribute("role");
String thisName = (String) session.getAttribute("empname");
 %>
<form method="POST" action="./employee">
<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
 <b><font color="red" size="3">Welcome <%=thisName %>--> Role:: <%=thisRole%></font></b>
  <div class="header-right">
    <a class="active" href="prod_exec_firstpage.jsp">Home</a>
    <a  ><input type="submit" name="operation" value="Edit Profile"/></a>
     <!-- <a href="update_emp_form.jsp">Edit Profile</a> -->
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>


<div class="navbar">
         <div class="dropdown">
    <button class="dropbtn">Products 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="displayproduct_exec.jsp">Search</a>
     <!--  <a href="controller?operation=link1">View ALL</a> -->
     </div>
  </div> 
      <div class="dropdown">
    <button class="dropbtn">Customer 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="displayappoint_exec.jsp">Appointment</a>
      <a href="customer_requirements.jsp">Customer Requirements</a>
      <a href="custreq?operation=Report">Delivery Report</a>
     </div>
  </div> 

       <div class="dropdown">
    <a href="#"><font color="red">Amount Receive </font></a>
  </div>
    <div class="dropdown">  
    <button class="dropbtn">Leave Master 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="leave_application_form.jsp">Leave Application</a>
      <a href="leaveapp?operation=check">Application Status</a>
    </div>
  </div>
       <div class="dropdown">
    <a  href="prod_exec_work.jsp"><font color="red">To Do List</font></a>
  </div>
     <div class="dropdown">
    <a  href="display_month.jsp"><font color="red">Payment Slip</font></a>
  </div>
     <div class="dropdown">
    <button class="dropbtn">Events and Holidays 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="display_holiday_date_other.jsp">Holiday Master</a>
      <a href="#">Event Master</a>
     </div>
  </div> 
       <div class="dropdown">
    <a href="change_password.jsp"><font color="red">Change Password </font></a>
  </div>
</div>

</body>
</html>