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
<style type="text/css">
#dvPreview
{
    filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);
    min-height: 100px;
    min-width: 100px;
    display: none;
}
/* The message box is shown when the user clicks on the password field */
#message {
    display:none;
    color: #000;
    position: relative;
    padding: 10px;
    margin-top: 5px;
}

#message p {
    padding: 5px 45px;
    font-size: 10px;
}

/* Add a green text color and a checkmark when the requirements are right */
.valid {
    color: green;
}

.valid:before {
    position: relative;
    left: -35px;
    content: "✔";
}

/* Add a red text color and an "x" when the requirements are wrong */
.invalid {
    color: red;
}

.invalid:before {
    position: relative;
    left: -35px;
    content: "✖";
}
</style>

    </head>
    <body>   
    <form Name="myForm" action="./employee" class="register" > 
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
						else if(thisRole.equalsIgnoreCase("Purchase Manager"))
                 	{
                 		%>
                 	 <a class="active" href="purchase_manager_firstpage.jsp">Home</a>
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
	 <%
	Connection con= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";
		int id = (Integer) session.getAttribute("id");

String sql = "select password  from erp_login where id="+id;
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
						<h3>CHANGE PASSWORD</h3>	
					</div>
					<div class="modal-body modal-spa">
						<div class="login-form">	
						 <%
		while(rs.next())
			{
				String pass = rs.getString("password");
	%>
			<input type="hidden" id="old2" value="<%=pass%>"/>
		<% 
		}
	}
		catch(SQLException sqe)
		{
			out.println(sqe);
		}
		%>
							<input type="password" class="lock" id="old" name="old" placeholder="Old password" required="" />
								<input type="password" class="lock" id="newpass" name="new" placeholder="New password" 
								pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" 
                     		title="Password must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters" 
                     			required oninput="Fun();" onclick="Fun();"/>
                     			<input type="password" class="lock" id="cnf" name="new" placeholder="New password" 
								pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" 
                     		title="Password must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters" 
                     			required />
								<input type="submit" value="Change Password" name="operation" onmouseover="checkForm();" />
						</div>								
					</div>
				</div>
			<!-- //login -->
					<div class="clear"></div>
				</div> 
</div>	
<!-- check that old password is correct  -->
<script >
function Fun()
  {
  var old2=document.getElementById("old2").value;
  var old=document.getElementById("old").value;
       var flag=true;
    if(old!=old2){
     alert("Error: Old Password Incorrect!");
           flag=false;
    		        } 
  }
</script>
<!-- check that new password is correct  -->
<script >
function checkForm()
  {
    var newpass=document.getElementById("newpass").value;
    var cnf=document.getElementById("cnf").value;
    var flag=true;
       		if(newpass != cnf && newpass=="") {
       		 alert("Error: Password Not Matched!");
         			} 
  }
</script>
</form>
    </body>
</html>

       


