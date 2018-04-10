<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<%! String userdbName,userName,empName;
String userdbPsw,userPsw;
String userdbRole,userRole;
int userId;
%>
<%
	Connection con= null;
	PreparedStatement ps = null,ps1 = null,ps2=null,ps3=null;
	ResultSet rs = null,rs1 = null,rs2=null,rs3=null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

		
		String sql = "select * from erptab where name=? and password=? and role=?";
		String newsql = "select * from erp_login where name=? and password=? and role=?";
		String sql2 = "select id from erp_login where name=?";
		String empsql = "select empname from erp_employee where empid=?";
			
		String name = request.getParameter("name");
		String password= request.getParameter("password");
		String role=request.getParameter("role");
	
	if(!(name.equals(null) || name.equals("")) && !(password.equals(null) || password.equals("")) && !role.equals("select"))
{
	try{
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(sql);ps1 = con.prepareStatement(newsql);ps2 = con.prepareStatement(sql2);ps3 = con.prepareStatement(empsql);
			ps.setString(1, name);		ps1.setString(1, name);ps2.setString(1, name);
			ps.setString(2, password);	ps1.setString(2, password);
			ps.setString(3, role);		ps1.setString(3, role);
			rs = ps.executeQuery();		rs1 = ps1.executeQuery();rs2 = ps2.executeQuery();
					while (rs2.next()) {
						 userId=rs2.getInt(1);
						}
						ps3.setInt(1, userId);
						rs3 = ps3.executeQuery();	
						while (rs3.next()) {
						 empName=rs3.getString("empname");
						}
		if(rs.next())
		{ 
			userdbName = rs.getString("name");
			userdbPsw = rs.getString("password");
			userdbRole= rs.getString("role");
				
		if(name.equals(userdbName) && password.equals(userdbPsw) && role.equalsIgnoreCase("ADMIN") )	
	{
		session.setAttribute("name",userdbName);
			session.setAttribute("role",userdbRole);
		response.sendRedirect("firstpage.jsp"); 
	} 
/* 	else if(name.equals(userdbName) && password.equals(userdbPsw) && role.equalsIgnoreCase("Service Executive") )	
	{
		session.setAttribute("name",userdbName);
			session.setAttribute("role",userdbRole);
		response.sendRedirect("registration.html"); 
	} */ 
	
}else if(rs1.next())
		{ 
			
			userName = rs1.getString("name");
			userPsw = rs1.getString("password");
			userRole= rs1.getString("role");
				
				if(name.equals(userName) && password.equals(userPsw) && role.equalsIgnoreCase("Product Executive") )	
				{
				session.setAttribute("name",userName);
				session.setAttribute("password",userPsw);
				session.setAttribute("empname",empName);
				session.setAttribute("id",userId);
				session.setAttribute("role",userRole);
				response.sendRedirect("prod_exec_firstpage.jsp"); 
			}
				else if(name.equals(userName) && password.equals(userPsw) && role.equalsIgnoreCase("Service Executive") )	
				{
				session.setAttribute("name",userName);
				session.setAttribute("password",userPsw);
				session.setAttribute("empname",empName);
				session.setAttribute("id",userId);
				session.setAttribute("role",userRole);
				response.sendRedirect("service_exec_firstpage.jsp"); 
			}
			else if(name.equals(userName) && password.equals(userPsw) && role.equalsIgnoreCase("Product Manager") )	
				{
				session.setAttribute("id",userId);
				session.setAttribute("password",userPsw);
				session.setAttribute("empname",empName);
				session.setAttribute("name",userName);
				session.setAttribute("role",userRole);
				response.sendRedirect("prod_manager_firstpage.jsp"); 
			}
			else if(name.equals(userName) && password.equals(userPsw) && role.equalsIgnoreCase("Service Manager") )	
				{
				session.setAttribute("id",userId);
				session.setAttribute("password",userPsw);
				session.setAttribute("empname",empName);
				session.setAttribute("name",userName);
				session.setAttribute("role",userRole);
				response.sendRedirect("service_manager_firstpage.jsp"); 
			}
			else if(name.equals(userName) && password.equals(userPsw) && role.equalsIgnoreCase("Purchase Manager") )	
				{
				session.setAttribute("id",userId);
				session.setAttribute("password",userPsw);
				session.setAttribute("empname",empName);
				session.setAttribute("name",userName);
				session.setAttribute("role",userRole);
				response.sendRedirect("purchase_manager_firstpage.jsp"); 
			}
			else if(name.equals(userName) && password.equals(userPsw) && role.equalsIgnoreCase("Sales Manager") )	
				{
				session.setAttribute("id",userId);
				session.setAttribute("password",userPsw);
				session.setAttribute("empname",empName);
				session.setAttribute("name",userName);
				session.setAttribute("role",userRole);
				response.sendRedirect("salesmanagerfirstpage.jsp"); 
			}
			else if(name.equals(userName) && password.equals(userPsw) && role.equalsIgnoreCase("HR") )	
				{
				session.setAttribute("id",userId);
				session.setAttribute("password",userPsw);
				session.setAttribute("empname",empName);
				session.setAttribute("name",userName);
				session.setAttribute("role",userRole);
				response.sendRedirect("hr_firstpage.jsp"); 
			}
		}
	else
		response.sendRedirect("loginerror.jsp");
	rs.close();
	ps.close(); 
	}
		catch(SQLException sqe)
		{
			out.println(sqe);
		} 
	}
else
	{

	%>
		<center><p style="color:red">Error In Login</p></center>
	<% 
		getServletContext().getRequestDispatcher("/loginform.jsp").include(request,response);
	}
%>

<form method="post" action="adminlogindetails.jsp">
<%
	String st=request.getParameter("role");
	String uname=request.getParameter("name");
	String pass=request.getParameter("password");
		session.setAttribute("myUser", uname);
		session.setAttribute("myPass", pass);
		session.setAttribute("myRole", role);
%>
</form>
</body>
</html>