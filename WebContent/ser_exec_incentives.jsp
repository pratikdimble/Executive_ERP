<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html style="height: 1491px; ">
<head>
<title>Incentives Master Data:: Service Manager</title>
<!-- metatags-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <link rel="stylesheet" type="text/css" href="css/menubar1.css"/>
<!-- css files -->
<link rel="stylesheet" href="css/jquery-ui.css"/>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/><!--stylesheet-css-->
<link href="//fonts.googleapis.com/css?family=Josefin+Sans:100,100i,300,300i,400,400i,600,600i,700,700i" rel="stylesheet"/>
<link href="//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i" rel="stylesheet"/>

<!-- //css files -->
</head>
<body>
<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="service_manager_firstpage.jsp">Home</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
<%
	Connection con= null;
	PreparedStatement ps = null,ps1 = null;
	ResultSet rs = null,rs1 = null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";
		
String ename=request.getParameter("choice");
String empName = "SELECT EMPID FROM ERP_EMPLOYEE WHERE EMPNAME='"+ename+"'";
String prodName = "SELECT NAME FROM ERP_SERVICE";

	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(empName);ps1 = con.prepareStatement(prodName);
			rs = ps.executeQuery();rs1 = ps1.executeQuery(); 
	%>
	<form action="./incentive" method="post">	
	<h1>Service Executive Incentives</h1>
<div class="w3l-main">
	<div class="w3l-from">
			<div class="w3l-lef1">
				<h3>Employee Information</h3>
					<div class="w3l-num">
					<label class="head">Date<span class="w3l-star"> * </span></label>
						<div class="styled-input">
							<input class="date" id="datepicker"  name="incdate" type="text" value="MM/DD/YYYY" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'MM/DD/YYYY';}" required>
						</div>
					</div>	<br/><br/><div class="clear"></div>
					<div class="clear"></div>
							<div class="w3l-sym">
					<label class="head">Employee ID ::</label>
					<div id="empname">
					<%
		while(rs.next())
			{
	%>
					<input type="text" name="empid" value="<%=rs.getInt("EMPID")%>" readonly="readonly" style="width: 150px; "/>
						<% 
		}
		%>
					</div>
			</div>
			<div class="w3l-user">

				<label class="head">Employee Name<span class="w3l-star"> * </span></label>
				<input type="text" name="name"  value="<%=ename%>" readonly="readonly" style="width: 150px; "/>
					
			</div><br/>
<!-- 		  -->
			<div class="w3l-mail">
				<label class="head">Service Name<span class="w3l-star"> * </span></label>
						<select  class="category2" id="sername" name="sername" style="width: 143px; height: 30px" required="required" onchange="showProv(this.value)">
				<option >Select</option>
	<%
		while(rs1.next())
			{
	%>
	<option value="<%=rs1.getString("NAME")%>"><%=rs1.getString("NAME")%></option>
		<% 
		}
		%> </select>
			</div>
			<div class="clear"></div>
				<div class="w3l-num">
		<label class="head">Service Provider<span class="w3l-star"> * </span></label>
			<div id="provide">
<!-- 				<input type="text" name="provider" required="required"/> -->
				<select id="provider" name="provider" style="width: 143px; height: 40px" required="required" onchange="showCost(this.value); document.getElementById('productdata').style.display='block';document.getElementById('prodamt').style.display='block';">
					<option disabled selected="selected" value="none">Select Provider</option>
				</select>
			</div>  
		</div>
	</div>
			<div class="clear"></div>
			<div class="w3l-sym">
				<label class="head">Target per Service<span class="w3l-star"> * </span></label>	
					<input  type="text" name="tarppro"  required id="target"style="width: 150px; "/>
			</div>
			<div class="w3l-num">
			<label class="head">Incentive per Service<span class="w3l-star"> * </span></label>	
				<input type="text" name="incppro" value="50"  id="incentive" onkeyup="workdone();myFunction()"style="width: 150px; "/>Rs.
			</div>

			<div class="clear"></div>
			<div class="w3l-lef1">
				<h3>Incentive Calculation</h3></div>	
			<div class="w3l-user">
				<label class="head">Achieved Target<span class="w3l-star"> * </span></label>
				<input type="text" name="achtar"  id="achieve" onkeyup="workdone();myFunction()" style="width: 150px; "/>
			</div>
			
				<div class="w3l-num">
					<label class="head">Work Done<span class="w3l-star"> * </span></label>
						<input type="text"  name="work" id="workdon" onkeyup="myFunction();"style="width: 150px; "/>
				</div>
			<div class="w3l-sym">
					<label class="head">Incentive Amount<span class="w3l-star"> * </span></label>
					<input type="text" name="incamt" placeholder="" id="amount"style="width: 150px; "/>Rs.
			</div>
			<div class="clear"></div>
				<div class="btn">
					<input type="submit" name="operation" value="ADD"/>
				</div>
			<div class="clear"></div>
			<div class="btn">
				<input type="reset" value="Reset" onClick="window.location.reload()">
			</div>
			
		<%
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		%>   
	</div>
</div>
	</form>
	<!-- Default-JavaScript --> <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>

<!-- Calendar -->
<script src="js/jquery-ui.js"></script>
	<script>
		$(function() {
		$( "#datepicker,#datepicker1" ).datepicker();
		});
	</script>
<!-- //Calendar -->
<script> 
function showProv(str){ 
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
document.getElementById("provide").innerHTML=xmlhttp.responseText; 
} 
} 
xmlhttp.open("POST","providerout.jsp?q="+str,true); 
xmlhttp.send(); 
} 

</script> 

<script> 
function showId(str){ 
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
document.getElementById("empname").innerHTML=xmlhttp.responseText; 
} 
} 
xmlhttp.open("POST","populateid.jsp?q="+str,true); 
xmlhttp.send(); 
} 

</script> 
<script type="text/javascript">
function myFunction() {
 var target = parseInt(document.getElementById("target").value, 10);
 var achieve = parseInt(document.getElementById("achieve").value, 10);
 var amount = parseInt(document.getElementById("amount").value, 10);
 var workdone = parseInt(document.getElementById("workdon").value, 10);
 var incentive = parseInt(document.getElementById("incentive").value, 10);
 var result;
  	if(achieve < target)
 	{
 		document.getElementById("amount").value = 0;
 		 document.getElementById("workdon").value=0;
	 }else{ 
	 			 document.getElementById("amount").value = incentive * workdone;	
	 		}
}
</script>

<script type="text/javascript">
/* calculate the work done  */
function workdone() {
 var target = parseInt(document.getElementById("target").value, 10);
 var achieve = parseInt(document.getElementById("achieve").value, 10);
 document.getElementById("workdon").value = achieve - target;
}
</script>
</body>
</html>