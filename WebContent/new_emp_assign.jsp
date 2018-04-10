<%@ page import="java.sql.*" %>
<html>
    <head>
        <title>Employee Assign</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <link rel="stylesheet" type="text/css" href="css/empassigndefault.css"/>
       <link rel="stylesheet" type="text/css" href="css/menubar.css"/>


    </head>
 <title>Employee Assign</title>
<body background="img/back.jpg" >

<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="firstpage.jsp">Home</a>
    <a href="bankandbranch.jsp">Back</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
<%
	Connection con= null;
	PreparedStatement ps = null,ps1 = null,ps2 = null,ps3= null,ps4= null,ps5= null;
	ResultSet rs = null,rs1 = null,rs2 = null,rs3 = null,rs4 = null,rs5 = null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

String empName = "SELECT EMPNAME FROM ERP_EMPLOYEE";
String prodName = "SELECT NAME FROM ERP_PRODUCT";
String prodType = "SELECT TYPE FROM ERP_PRODUCT";
String serName = "SELECT NAME FROM ERP_SERVICE";
String areaName = "SELECT AREANAME FROM ERP_AREA";
String regName = "SELECT * FROM ERP_REGION"; 

	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(empName);ps1 = con.prepareStatement(prodName);ps2 = con.prepareStatement(prodType);
			ps3 = con.prepareStatement(serName);ps4 = con.prepareStatement(regName);ps5 = con.prepareStatement(areaName);
			rs = ps.executeQuery();rs1 = ps1.executeQuery(); rs2 = ps2.executeQuery();
			rs3 = ps3.executeQuery(); rs4 = ps4.executeQuery();rs5 = ps5.executeQuery();
	%>


<form Name="myForm" action="./empassign" class="register">       
    <h1><Center><font size="6" color="red">Employee Assign</font></Center></h1>
	<pre>
<fieldset class="row1">
                <legend>Employee Details</legend>
                <p>
                    <label>Employee Name*</label>
                    <select name="name" style="width: 143px; height: 30px" required="required">
				<option >select</option>
	<%
		while(rs.next())
			{
				String emp = rs.getString("EMPNAME");
	%>
			<option value=<%=emp%>><%=emp%></option>
		<% 
		}
		%> </select>

                </p>
</fieldset>
  		 <input type="submit" name="operation" value="ADD"> 
	</font></b></pre>
	        		   				<%
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		%> 
</form>

</body>
</html>