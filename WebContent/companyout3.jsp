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
<head> 
<link href="css/sstyle.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/sstyle3.css" rel="stylesheet" type="text/css" media="all" />
<title>Product Type Page</title> 
</head> 
<body> 
<%String str=request.getParameter("q"); 
session.setAttribute("myproduct",str);
 %>
			<div class="w3_agileits_main_grid w3l_main_grid" id="productCompany">
			<span class="agileits_grid">
				<label>Product Company</label>
				  <select id="prodcomp" name="company" style="width: 143px; height: 40px" required="required" onchange="showCost(this.value); document.getElementById('productdata').style.display='block';document.getElementById('prodamt').style.display='block';">
				<option disabled selected="selected" value="none">Select Company</option>

<% 

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
		stmt=connection.prepareStatement("select pid from erp_productdata where name='"+str+"'"); 
		
			ResultSet rs=null,rs1=null; 
				rs= stmt.executeQuery(); 
					while(rs.next()){ 
						i=rs.getInt(1);
						}
		st=connection.prepareStatement("select company from erp_productdata where name='"+str+"'"); 
			rs1= st.executeQuery(); 
						while(rs1.next()){ 
		%> 
		<option value=<%=rs1.getString("company")%>><%=rs1.getString("company")%></option>
		<% 
	} 
		%>
						</select>
				</span><div class="clear"></div>
			</div>
<!-- 			<div class="w3_agileits_main_grid w3l_main_grid" id="costproduct">
							<span class="agileits_grid">
								<label>Cost Per Product </label>
								<input type="text" name="costproduct" readonly style="width: 130px;">
							</span><div class="clear"></div>
						</div>  -->
			
<!-- </select>  -->
</body> 
</html> 