<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body background="img/back.jpg" >

<form method="post" action="login.jsp">
<!-- <font color="WHITE"> -->
	<center><h2 style="color:green">Login Form</h2></center>
	<table border="1" align="center" style="width: 705px; height: 246px">
			<tr>
				<td style="width: 313px; "><font color="red" size="5">Enter UserName :</font></td>
				<td><input type="text " name="name" style="height: 46px; width: 241px"></td>
			</tr>
			<tr>
				<td><font color="red " size="5">Enter Password :</font></td>
				<td><input type="password" name="password" style="height: 46px; width: 241px"></td>
			</tr>
			<tr>
				<td><font color="red" size="5">Select Login Role</font></td>
				<td><select name="role" style="height: 46px; width: 241px" >
				<option value="select">select</option>
				<option value="admin">Admin</option>
				<option value="HR">HR</option>
				<option value="Purchase Manager">Purchase Manager</option>
				<option value="Sales Manager">Sales Manager</option>
				<option value="Product Manager">Product Manager</option>
				<option value="Service Manager">Service Manager</option>
				<option value="Service Executive">Service Executive</option>
				<option value="Product Executive">Product Executive</option>
			</select>
			</td>
		</tr>
			
	</table>
<!-- 	</center> -->
		
	<pre>&nbsp&nbsp<input type="submit" value="LOGIN"></pre>
</form>
<!-- </font> -->
</body>
</html>