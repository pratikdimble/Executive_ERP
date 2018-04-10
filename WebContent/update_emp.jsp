
<%@ page import="java.sql.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Employee Assign</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <link rel="stylesheet" type="text/css" href="css/empassigndefault.css"/>
       <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
     <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>


    </head>
    <body>    
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
	PreparedStatement ps = null,ps1 = null,ps2 = null,ps3= null,ps4= null,ps5= null,ps6=null;
	ResultSet rs = null,rs1 = null,rs2 = null,rs3 = null,rs4 = null,rs5 = null,dsgn=null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

String empName = "SELECT * FROM ERP_EMPLOYEE";
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


<form Name="myForm" action="./empassign" class="register" onsubmit="return validateForm();return validateMobile();">       
    <h1><Center><font size="6" color="red">Employee Assign</font></Center></h1>
            <pre></pre>
            
            <fieldset class="row1">
                <legend>Employee Details</legend>
                <p>
                    <label>Employee Name*</label>
                    <select onchange="showDsgn(this.value)" name="name" style="width: 143px; height: 30px">
				<option >select</option>
	<%
		while(rs.next())
			{
				String emp = rs.getString("EMPNAME");
				//int id = Integer.parseInt(rs.getString("EMPID"));
				int id =rs.getInt("EMPID");
	%>
<%-- 			<option value="<%=rs.getInt(1)%>"><%=rs.getString(7)%></option> --%>
	<option value="<%=rs.getInt(1)%>"><%=rs.getString(7)%></option>
		<% 
		}
		%> </select>

                </p>
                 <p>
                    <label>Designation*</label>
                   <!--  <input id="dsgn" type="text" name="dsgn" style="width: 143px; height: 30px" required/> -->
						<div id="dsgn"> 
						<input type="text" name="dsgn" style="width: 143px; height: 30px"/>
						</div> 
                </p>
                <p>
                     <label>Select Date*</label>
                    <input type="date" name="date" style="width: 143px; height: 30px" required="required"/> 	
                </p>
            </fieldset>
            
            
            <fieldset class="row2">
                <legend>Status*</legend>
    			<p>
  					<input type="radio" name="status" value="Product" onclick="myProduct()">
                    <label class="radio">Product</label></input>
                    </p><p>
                    <input type="radio" name="status" value="Service" onclick="myService()">
                    <label class="radio">Service</label></input>
                    </p>
                </fieldset>
                
                
            <fieldset class="row3">
                             <legend>Other Details</legend>
                <p>
                    <label>Select Product Name*</label>
                    <select id="prodname" name="pname" style="width: 143px; height: 30px" required="required">
				<option >No</option>
	<%
		while(rs1.next())
			{
				String prod = rs1.getString("NAME");
	%>
			<option value=<%=prod%>><%=prod%></option>
		<% 
		}
		%> </select>
                </p>
                    <p>
                    	<label>Select Product Type*</label>
                    	<select id="prodtype" name="ptype" style="width: 143px; height: 30px" required="required">
				<option >No</option>
	<%
		while(rs2.next())
			{
				String type = rs2.getString("TYPE");
	%>
			<option value=<%=type%>><%=type%></option>
		<% 
		}
		%> </select>
   							</p> 
     
                    <p>
                    	<label>Select Service Name*</label>
                    	<select id="ser" name="service" style="width: 143px; height: 30px" required="required">
				<option >No</option>
	<%
		while(rs3.next())
			{
				String ser = rs3.getString("NAME");
	%>
			<option value=<%=ser%>><%=ser%></option>
		<% 
		}
		%> </select>
                </p>
               
               
            </fieldset>
            
            <fieldset class="row4">
                <legend>Location Details</legend>
                <p>
                    <label>Select Department*</label>
                    <input type="text" name="dept"/>
                                   </p>
                    <p>
                    	<label>Select Region*</label>
                    	<select onchange="showArea(this.value)" name="reg" style="width: 143px; height: 30px" required="required"> 
<!--                     <select id="dbType" name="reg" style="width: 143px; height: 30px" required="required"> -->
				<option>Select Region</option> 
			<% 
while(rs4.next()){ 
%> 
<option value="<%=rs4.getInt(1)%>"><%=rs4.getString(3)%></option> 
<% 
} 
%> 
</select> </p> 
<p>
<div id="area"> 
<select style="width: 195px; height: 29px"> 
<option>Select Area</option> 
</select> 
</div> 
   							</p>

                </fieldset>
            
         		   				<%
	}
		catch(SQLException sqe)
		{
			out.println("home"+sqe);
		}
		%>   
            <fieldset class="row7">
                 <font color="RED" size="5"> <input type="submit" color="RED" name="operation" value="Assign"/></font>      
                </p>
               </fieldset>   
</pre> 


        </form>


<script> 
// 	FUNCTION FOR POPULATE THE EMPLOYEE DESIGNATION
	function showDsgn(design){ 
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
					document.getElementById("dsgn").innerHTML=xmlhttp.responseText; 
				} 
			} 
		xmlhttp.open("POST","update_emp_dsgn_populate.jsp?ename="+design,true); 
	xmlhttp.send(); 
	}
		// 	FUNCTION FOR POPULATE THE AREA
	function showArea(str){ 
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
					document.getElementById("area").innerHTML=xmlhttp.responseText; 
				} 
			} 
		xmlhttp.open("POST","update_emp_area_populate.jsp?q="+str,true); 
	xmlhttp.send(); 
	} 
</script> 	

<!--SCRIPT FOR VALIDATE THE EMAIL  -->

<script>
 function myProduct() {
 document.getElementById("prodname").enabled = true;
 document.getElementById("prodtype").enabled = true;
    document.getElementById("ser").disabled = true;
} 

</script>
<script>
 function myService() {
 document.getElementById("prodname").disabled = true;
 document.getElementById("prodtype").disabled = true;
    document.getElementById("ser").enabled = true;
} </script>
    </body>
</html>

       


