<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
pageEncoding="ISO-8859-1"%> 

<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.*"%> 
<%@ page import="java.sql.*"%> 
<%!int i;
String company;%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 

<title>Product Type Page</title> 
</head> 
<body> 
			<div class="agile-username" id="productStock">

<% 
String str=request.getParameter("q"); 
i=Integer.parseInt(str); 
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
		
		//String company="select company from erp_requirement where reqid="+i;
	PreparedStatement stmt=null,st=null; 
		stmt=connection.prepareStatement("select prodcompany from erp_requirement where reqid="+i); 
			ResultSet rs=null,rs1=null; 
				rs= stmt.executeQuery(); 
					while(rs.next()){ 
					 company	=rs.getString("PRODCOMPANY");
						}
		st=connection.prepareStatement("select quantity from erp_product where company='"+company+"'"); 
			rs1= st.executeQuery(); 
						while(rs1.next()){ 
		%> 
		<input type="hidden" id="quan" name="quan"  value="<%=rs1.getString("quantity")%>"/><br>
		<% 
	} 
		%> 
						<div class="clear"></div>
			</div>
<!-- </select>  -->
</body> 
</html> 