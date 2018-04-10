<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
<title>Filter Purchase:: Purchase Manager</title>
<style type="text/css">

#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<body background="img/back.jpg" >
		
<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="purchase_manager_firstpage.jsp">Home</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
<%
	Connection con= null;
	PreparedStatement ps = null,ps1=null;
	ResultSet rs = null,rs1=null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

String sql = "SELECT vendorName FROM ERP_vendor";
String prodName = "SELECT NAME FROM ERP_PRODUCT";

	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(sql);ps1=con.prepareStatement(prodName);
			rs = ps.executeQuery(); rs1=ps1.executeQuery();
	%>

<form method="POST"  Name="MyForm" action="./purchase">
	<center><h2 style="color:green">Select Supplier</h2>	</center>
	<select id="supp"  name="supplier" style="width: 143px; height: 40px" class="text" onchange="" onclick="document.getElementById('prod').setAttribute('disabled',true);" onmouseover="document.getElementById('supp').removeAttribute('disabled');">
				<option  selected="selected" value="none">Select Supplier</option>
	<%
		while(rs.next())
			{
				String name = rs.getString("vendorName");
	%>
	<font color="red" size="5">
		<option value=<%=name%>><%=name%></option>
	</font>

		<% 
		}//while close
		%>
		</select>
		<select id="prod" name="product" style="width: 143px; height: 40px" class="text" onchange="" onmouseover="document.getElementById('prod').removeAttribute('disabled');" onclick="document.getElementById('supp').setAttribute('disabled',true);" >
				<option  selected="selected" value="none">Select Product</option>
	<%
		while(rs1.next())
			{
				String prod = rs1.getString("NAME");
	%>
			<option value=<%=prod%>><%=prod%></option>
		<% 
		}
		%> </select>
		<% 
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		
		%>
		<pre>&nbsp&nbsp<input type="submit" name="operation" value="DETAILS" onclick="document.getElementById('prod').removeAttribute('disabled');document.getElementById('supp').removeAttribute('disabled');" style="width: 95px; height: 36px" />
		</pre>
</form>

</body>
</html>