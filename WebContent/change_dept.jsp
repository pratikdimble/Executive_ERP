<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ page import="java.sql.*" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Change Password Form</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
       <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
  		<link href="css/style3.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<!--google fonts-->
<link href='//fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>

    </head>
    <body>   
    <form Name="myForm" action="./employee" class="register" > 
    <div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
  <a class="active" href="firstpage.jsp">Home</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
	 <%
	Connection con= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

String sql = "select empname  from erp_employee";
	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
	%>
	<!-- login -->
		<div class="login-section w3l">
			 <div class="login">	
				<div class="modal-content modal-info">
					<div class="modal-header">
						<h3>CHANGE DEPARTMENT</h3>	
					</div>
					<div class="modal-body modal-spa">
						<div class="login-form">	
						<font color="red" size="4">
						<label>Employee Name</label>
						 <select name="emp" style="width: 143px; height: 40px" required="required" onchange="showDept(this.value);showEId(this.value);" >
				<option disabled selected="selected" value="none">Select Employee</option>
	<%
		while(rs.next())
			{
	%>
			<option value="<%=rs.getString("empName")%>"><%=rs.getString("empName")%></option> 
		<% 
		}
		%> </select>
		<% 
		
	}
		catch(SQLException sqe)
		{
			out.println(sqe);
		}
		%>
<br/></br/>
					<div class="login-form"  id="dept">
							<label>Department</label>
								&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<select name="dept" id="dept" style="width: 143px; height: 40px" required="required"  >
								<option disabled selected="selected" value="none">Select Department</option>
								</select>
							</div>
								<div class="login-form"  id="eid">
							<input type="hidden"  name="empid" readonly="readonly" style="width: 150px; "/>
							</div>
					</font><br/></br/>
					
							<input type="submit" value="Change Department" name="operation"  />
				</div>
					<div class="clear"></div>
							</div>		
					</div>
				</div> 
</div>	

</form>
<script> 
function showDept(str){ 
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
				document.getElementById("dept").innerHTML=xmlhttp.responseText; 
				} 
			} 
		xmlhttp.open("POST","deptout.jsp?q="+str,true); 
		xmlhttp.send(); 
	} 

function showEId(str){ 
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
					document.getElementById("eid").innerHTML=xmlhttp.responseText; 
				} 
		} 
	xmlhttp.open("POST","populateid3.jsp?q="+str,true); 
	xmlhttp.send(); 
	} 
</script>
    </body>
</html>

       


