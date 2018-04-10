<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login Error</title>

</head>

<body>

<center><p style="color:pink">Invalid Username or Password or Login Role</p></center>

<%

getServletContext().getRequestDispatcher("/loginform_new.jsp").include(request, 
response);

%>

</body>

</html>