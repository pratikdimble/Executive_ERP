<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Product Manager first page</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a, .dropbtn {
    display: inline-block;
    color: red;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
    background-color: cyan;
}

li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1}

.dropdown:hover .dropdown-content {
    display: block;
}
</style>
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
    <input type="submit" name="operation" value="Edit Profile"/>
   <!--   <a href="update_emp_form.jsp">Edit Profile</a> -->
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
<ul>
    <li><a href="display_empassign_prod_manager.jsp">Assign Product and Region</a></li>
  <li><a href="display_incentive_prod_manager.jsp">Incentives Master</a></li>
    <li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Leave Master</a>
    <div class="dropdown-content">
      <a href="leave_application_form.jsp">Leave Application</a>
      <a href="leaveapp?operation=check">Application Status</a>
    </div>
  </li>
<li class="dropdown">
    <a href="javascript:void(0)" class="dropbtn">Events and Holidays</a> 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="display_holiday_date_other.jsp">Holiday Master</a>
      <a href="#">Event Master</a>
     </div>
  </li> 
    <li><a href="change_password.jsp">Change Password</a></li>
</ul>

</form>
</body>
</html>