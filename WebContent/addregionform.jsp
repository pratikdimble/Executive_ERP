
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
</head>
<body background="img/back.jpg" >

<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="firstpage.jsp">Home</a>
    <a href="bankandbranch.jsp">Back</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>


		
	<form action="./region" method="POST">
	<font color="RED"><b>
	<pre>
   		Region Name	 	 		 :: <input type="text" name="regname"><br>
   		RegionDescription	 	 :: <input type="text" name="regdesc"><br>
   		Area Name	 	 		 :: <input type="text" name="areaname"><br>
   		Area Description	 	 :: <input type="text" name="areadesc" style="width: 383px; "><br>
  		 <input type="submit" name="operation" value="ADD">
	</font></b></pre>
</form>

</body>
</html>