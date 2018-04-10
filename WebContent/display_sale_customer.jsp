<%@ page import="java.sql.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="css/menubar1.css"/>
 <link href="css/sstylee.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/sstylee3.css" rel="stylesheet" type="text/css" media="all" />
<title>Display Customer:Sale Manager</title>
<style> 
input[type=button], input[type=submit], input[type=reset] {
    background-color: #4CAF50;
    border: none;
    color: white;
    font-size: 20px;
    padding: 16px 32px;
    text-decoration: none;
    margin: 4px 4px;
    cursor: pointer;
}
</style>
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
    <a class="active" href="salesmanagerfirstpage.jsp">Home</a>
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

String sql= " select custname from erp_customer";

	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(); 
	%>

<form method="POST" action="./sale">
<br/><br/>
							<div class="w3_agileits_main_grid w3l_main_grid">
<font color="red">

								<label>Customer Name </label>
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		 <select  name="custname" id="custname" style="width: 143px; height: 40px">
<!-- 		  -->
				<option disabled selected="selected" value="none">Select Customer</option>
	<%
		while(rs.next())
			{
	%>
			<option  value=<%=rs.getString("CUSTNAME")%>><%=rs.getString("CUSTNAME")%></option>
		<% 
		}
		%> </select>
<!-- onclick="document.getElementById('myid').removeAttribute('disabled');document.getElementById('view').removeAttribute('disabled');document.getElementById('delete').removeAttribute('disabled');" -->
&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<label>Customer Requirement</label>
				  	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<select id="creq" name="custreq" style="width: 143px; height: 40px" onclick="document.getElementById('view').removeAttribute('disabled');"  >
						<option  disabled selected="selected" value="none">Select Requirement</option>
						<option   value="Product Only">Product Only</option>
						<option  value="Service Only">Service Only</option>
							</select>
							<!-- &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<label>Select Quotation ID</label>
				  	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<select id="qid" name="qid" style="width: 143px; height: 40px" >
						<option  disabled selected="selected" value="none">Select Requirement</option>
							</select> -->
					</font>

		<% 
	}//try
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		
		%>
		<pre>&nbsp&nbsp<input type="submit" name="operation" value="View All"  style="height: 40px; "/>&nbsp&nbsp<input type="submit"  id="view" value="Details" formaction="select_quotation.jsp"style="height: 40px; "disabled="disabled"/>&nbsp&nbsp<input type="submit" id="update"  name="operation" value="Update"style="height: 40px; " disabled="disabled"/>&nbsp&nbsp&nbsp&nbsp
		</pre>
</form>
<script type="text/javascript">
function showSReq(str){ 
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
							document.getElementById("creq").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_custreq2.jsp?q="+str,true); 
		xmlhttp.send(); 
	}

</script>
</body>
</html>