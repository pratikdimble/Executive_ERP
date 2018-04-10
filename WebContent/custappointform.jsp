
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="css/registrationdefault.css"/>
       <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
</head>
<body background="img/back.jpg" >

<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="prod_exec_firstpage.jsp">Home</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
	<form action="./custappoint" method="POST">
	
	<h1><Center><b><font color="RED" size="7">CUSTOMER APPOINTMENT FORM</font></b></Center></h1>
<font color="RED" size="5">	<pre><br><hr><b>
Enter Customer Name	  :: <input type="text" name="name" style="width: 383px; height: 30px" required="required"/><br>
Appoint To	 	  :: <input type="text" name="to" style="width: 383px; height: 30px" required="required"/><br>
Appointment Type  	  ::  <input type="radio" name="type" value="To Call" checked="checked">To Call</input>		<input type="radio" name="type" value="To Visit">To Visit</input><br>
Subject 	 	  :: <input type="text" name="subject" style="width: 143px; height: 30px" required="required"/><br>
Date	  	 	  :: <input type="date" name="date" id="theDate" style="width: 143px; height: 30px" required="required"/> 		Appointment Time	::<input type="time"  name="time" value="hh:mm AM/PM" style="width: 143px; height: 30px" required="required"/><br>
Venue	 	 	  :: <input type="text" name="venue" style="width: 383px; height: 30px" required="required"/><br>
Contact No./EMail    	  :: <input type="text" name="contact" style="width: 383px; height: 30px" required="required"/><br>
  		 <input type="submit" name="operation" value="ADD">
	</pre></b></font>
</form>
<script type="text/javascript">
	var date = new Date();

var day = date.getDate();
var month = date.getMonth() + 1;
var year = date.getFullYear();

if (month < 10) month = "0" + month;
if (day < 10) day = "0" + day;

var today = year + "-" + month + "-" + day;


document.getElementById('theDate').value = today;

var time = date.toLocaleTimeString();
time=date.getHours( )+ ":" +date.getMinutes() 
document.getElementById('myTime').innerHTML = time;
</script>
</body>
</html>

		