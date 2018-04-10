<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%> 

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*"%> 
<%@ page import="java.sql.*"%> 
<%@ include file="JavaScript.jsp" %>
<%!int i;%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
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
<title>Department Populate Page</title> 
<body> 
<div class="login-form"  id="dept">
		<label>Department</label>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<select name="dept" style="width: 143px; height: 40px" required="required"  >
<% 
String str=request.getParameter("q"); 
//i=Integer.parseInt(str); 
	try { 
		Class.forName("oracle.jdbc.OracleDriver"); 
		} catch (ClassNotFoundException e) { 
			e.printStackTrace(); 
		return; 
	} 
	Connection connection = null; 
		try { 
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"system","oracle"); 
		} 
		catch (SQLException e) { 
			e.printStackTrace(); 
			return; 
		} 
	PreparedStatement stmt=null,st=null; 
		stmt=connection.prepareStatement("select department from erp_employee where empname='"+str+"'");
		
			ResultSet rs=null,rs1=null; 
			String dept=null;
				rs= stmt.executeQuery(); 
					while(rs.next()){ 
					dept=rs.getString("DEPARTMENT");
						}
						%>
							<option  selected="selected" value="<%= dept %>"><%= dept %></option>
						<% 
						
		st=connection.prepareStatement("select deptname from erp_department where deptname!='"+dept+"'"); 
			rs1= st.executeQuery(); 
						while(rs1.next()){ 
		%> 
		<option value=<%=rs1.getString("deptname")%>><%=rs1.getString("deptname")%></option>
		<% 
	} 
		%>			
	
							
								</select>
		</div>	
<!-- </select>  -->
</body> 
</html> 