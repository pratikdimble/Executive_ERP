<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<%! String prodName,prodType,company,status;

int enqId,quantity,stock;
%>
<%
	Connection con= null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String driverName = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "system";
		String dbpsw = "oracle";

		
		String sql = "select * from erp_requirement where reqid=?";
		
		enqId= Integer.parseInt(request.getParameter("pid"));
		stock= Integer.parseInt(request.getParameter("quan"));
		String thisRole = (String) session.getAttribute("myRole");

	try{
		Class.forName(driverName);
			con = DriverManager.getConnection(url, user, dbpsw);
			ps = con.prepareStatement(sql);
			ps.setInt(1, enqId);	
			rs = ps.executeQuery();	
					
		if(rs.next())
		{ 
			prodName =rs.getString("PRODNAME");
			prodType= rs.getString("PRODTYPE");
			company= rs.getString("PRODCOMPANY");
			quantity= rs.getInt("QUANTITY");
			status=rs.getString("STATUS");
			session.setAttribute("stock", stock);
			
			if(thisRole.equalsIgnoreCase("Product Executive") )	
				{
				session.setAttribute("pid",enqId);
			session.setAttribute("prodName",prodName);
			session.setAttribute("prodType",prodType);
			session.setAttribute("company",company);
			session.setAttribute("quantity",quantity);
			session.setAttribute("status",status);
     %>
     <jsp:forward page="./custreq?operation=Cancel"/> 
	<%
			}
				else if(thisRole.equalsIgnoreCase("Service Executive") )	
				{
				/* session.setAttribute("name",userName);
				session.setAttribute("password",userPsw);
				session.setAttribute("empname",empName);
				session.setAttribute("id",userId);
				session.setAttribute("role",userRole);
				response.sendRedirect("service_exec_firstpage.jsp");  */
			}
		
			%>
<%-- 			
			Product Name:<input type="text" name="pname" id="pname" value="<%= prodName %>">
   			Type:<input type="text" name="ptype" id="ptype" readonly  value="<%= prodType %>">
   		Company:<input type="text" name="company" id="company" readonly  value="<%= company %>">
   		 Quantity:<input type="text" name="quantity" id="quantity" readonly  value="<%= quantity %>">
 		 --%>
		<% 		
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
	%>

</body>
</html>