
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
    <a class="active" href="service_manager_firstpage.jsp">Home</a>
      <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
<%
	Connection con= null;
	PreparedStatement ps = null,ps1 = null,ps4= null;
	ResultSet rs = null,rs1 = null,rs4 = null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

String empName = "SELECT EMPNAME FROM ERP_EMPLOYEE WHERE designation='Service Executive'";

String serName = "SELECT NAME FROM ERP_SERVICE";

String areaName = "SELECT AREANAME FROM ERP_AREA";
String regName = "SELECT * FROM ERP_REGION"; 

	try {
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(empName);ps1 = con.prepareStatement(serName);
			ps4 = con.prepareStatement(regName);
			rs = ps.executeQuery();rs1 = ps1.executeQuery(); 
			 rs4 = ps4.executeQuery();
	%>


<form Name="myForm" action="./empassign" class="register" method="post">       
    <h1><Center><font size="6" color="red">Employee Assign</font></Center></h1>
            <pre></pre>
            
            <fieldset class="row1">
                <legend>Employee Details</legend>
                <p>
                    <label>Employee Name*</label>
                    <select name="name" style="width: 143px; height: 30px" required="required" onchange="showId(this.value);showDsgn(this.value);">
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
                <!-- <div id="empname"> -->
<p>
 					<div id="empname">
					 <label>    Employee ID</label>
					 <input type="text" name="empid" readonly="readonly" style="width: 143px; height: 30px "/>
					</div>
</p>
                 <p>
                 <div id="dsgn">
                    <label>Designation*</label>
                    <input type="text" name="dsgn" readonly="readonly" style="width: 143px; height: 30px "/>
				
	</div>
                </p>	
                <p>
                     <label>Select Date*</label>
                    <input type="date" name="date" style="width: 143px; height: 30px" required="required"/> 	
                </p>
            </fieldset>
                
            <fieldset class="row3">
                             <legend>Other Details</legend>
                <p>
                    <label>Select Service Name*</label>
                    <select name="service" style="width: 143px; height: 30px" required="required">
				<option >NULL</option>
	<%
		while(rs1.next())
			{
				String service = rs1.getString("NAME");
	%>
			<option value=<%=service%>><%=service%></option>
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
<option value="<%=rs4.getString(3)%>"><%=rs4.getString(3)%></option> 
<% 
} 
%> 
</select> </p> 
	<p>
		<label>Select Area*</label>
			<div id="area"> 
				<select name="area" required> 
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
                 <font color="RED" size="5"> <input type="submit" color="RED" name="operation" value="Assign Service"/></font>      
                </p>
               </fieldset>   
					</pre> 
        </form>
	
    </body>
</html>

       


