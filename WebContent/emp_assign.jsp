
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@ page import="java.sql.*" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
      
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <link rel="stylesheet" type="text/css" href="css/empassigndefault.css"/>
       <link rel="stylesheet" type="text/css" href="css/menubar.css"/>


    </head>
      <title>Employee Assign</title>
    <%@ include file="JavaScript.jsp" %>
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
	PreparedStatement ps = null,ps1 = null,ps2 = null,ps3= null,ps4= null,ps5= null,ps6= null;
	ResultSet rs = null,rs1 = null,rs2 = null,rs3 = null,rs4 = null,rs5 = null,rs6= null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

String empName = "SELECT EMPNAME FROM ERP_EMPLOYEE";
String dsgnName = "SELECT DSGNNAME FROM ERP_DESIGNATION";
String prodName = "SELECT NAME FROM ERP_PRODUCT";
String prodType = "SELECT TYPE FROM ERP_PRODUCT";
String serName = "SELECT NAME FROM ERP_SERVICE";
String areaName = "SELECT AREANAME FROM ERP_AREA";
String regName = "SELECT * FROM ERP_REGION"; 

	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(empName);ps1 = con.prepareStatement(prodName);ps2 = con.prepareStatement(prodType);
			ps3 = con.prepareStatement(serName);ps4 = con.prepareStatement(regName);ps5 = con.prepareStatement(areaName);ps6 = con.prepareStatement(dsgnName);
			rs = ps.executeQuery();rs1 = ps1.executeQuery(); rs2 = ps2.executeQuery();
			rs3 = ps3.executeQuery(); rs4 = ps4.executeQuery();rs5 = ps5.executeQuery();rs6 = ps6.executeQuery();
	%>


<form Name="myForm" action="./empassign" class="register" onsubmit="return validateForm();return validateMobile();">       
    <h1><Center><font size="6" color="red">Employee Assign</font></Center></h1>
            <pre></pre>
            
            <fieldset class="row1">
                <legend>Employee Details</legend>
                <p>
                    <label>Employee Name*</label>
                    <select name="name" style="width: 143px; height: 30px" required="required" onchange="showId(this.value)">
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
<p>
 					<div id="empname">
					 <label>    Employee ID</label>
					 <input type="text" name="empid" readonly="readonly" style="width: 143px; height: 30px "/>
					</div>
</p>
                 <p>
                    <label>Designation*</label>
                   <select  name="dsgn" style="width: 143px; height: 30px" required="required"onchange="showType(this.value)">
				<option >Select</option>
	<%
		while(rs6.next())
			{
				//String type = rs6.getString("DSGNNAME");
	%>
			<option value=<%=rs6.getString("DSGNNAME")%>><%=rs6.getString("DSGNNAME")%></option>
		<% 
		}
		%> </select>
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
                    <select id="prodname" name="pname" style="width: 143px; height: 30px" required="required"onchange="showType(this.value)">
				<option >NULL</option>
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
                    	<label>Select Product Type</label>
                    	<div id="productType">
<input type="text" name="prodtype" value="NULL" /></div>  
</div>

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
   <!--              <p>
                    <label>Select Department*</label>
                    <input type="text" name="dept"/>
                                   </p> -->
                    <p>
                    	<label>Select Region*</label>
                    	<select onchange="showState(this.value)" name="reg" style="width: 143px; height: 30px" required="required"> 
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
<select> 
<option>Select Area</option> 
</select> 
</div> 
		</select>
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
function showState(str){ 
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
xmlhttp.open("POST","populatearea.jsp?q="+str,true); 
xmlhttp.send(); 
} 
</script> 	


<!--SCRIPT FOR VALIDATE THE Mobile Number  -->			
</script>

    <script type="text/javascript">
        var specialKeys = new Array();
        specialKeys.push(8); //Backspace
        function IsNumeric(e) {
            var keyCode = e.which ? e.which : e.keyCode
            var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
            document.getElementById("error").style.display = ret ? "none" : "inline";
            return ret;
        }
    </script>


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

       


