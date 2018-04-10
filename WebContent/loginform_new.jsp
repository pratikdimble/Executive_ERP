
<html>
<head>

	<title>Login Form Responsive NEW</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Portrait Login Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements"
	/>
	<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!-- Meta tag Keywords -->
	<!-- css files -->
	<link rel="stylesheet" href="css/style6.css" type="text/css" media="all" />
	<!-- Style-CSS -->
	<link rel="stylesheet" href="css/font-awesome.css">
	<!-- Font-Awesome-Icons-CSS -->
	<!-- //css files -->
	<!-- online-fonts -->
	<link href="//fonts.googleapis.com/css?family=Tangerine:400,700" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
	<!-- //online-fonts -->

	<!--header-->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
</head>
<body>

<div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="index.jsp">Home</a>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
  </div>
</div>

	<div class="header-w3l">
		<h1>
			<span>L</span>ogin
			<span>F</span>orm</h1>
	</div>
	<!--//header-->
	<div class="main-content-agile">
		<div class="sub-main-w3">
<!-- 			<img src="img/newlogo.png" alt="" style="width: 315px; height: 171px; "/> -->
<!-- 			<h2>Pratik IT Solution</h2> -->
			<form method="post" action="login.jsp">
				<div class="pom-agile">
					<span class="fa fa-user-o" aria-hidden="true"></span>
					<input placeholder="Username" name="name" class="user" type="text" required="">
				</div>
				<div class="pom-agile">
					<span class="fa fa-key" aria-hidden="true"></span>
					<input placeholder="Password" name="password" class="pass" type="password" required="">
				</div>
				<div class="pom-agile">
					<span class="fa fa-address-card-o" aria-hidden="true"></span>
<!-- 				<td><font color="red" size="5">Select Login Role</font></td> -->
				<select name="role" style="height: 46px; width: 241px" >
				<option selected disabled value="none">Select Role</option>
				<option value="admin">Admin</option>
				<option value="HR">HR</option>
				<option value="Purchase Manager">Purchase Manager</option>
				<option value="Sales Manager">Sales Manager</option>
				<option value="Product Manager">Product Manager</option>
				<option value="Service Manager">Service Manager</option>
				<option value="Service Executive">Service Executive</option>
				<option value="Product Executive">Product Executive</option>
			</select>
			</div>
				<div class="sub-w3l">
					<div class="sub-agile">
						<input type="checkbox" id="brand1" value="">
						<label for="brand1">
							<span></span>Remember me</label>
					</div>
					<div class="clear"></div>
				</div>
				<div class="right-w3l">
					<input type="submit" value="Login">
				</div>
				<div class="forgot-w3l">
					<a href="#">Forgot Password?</a>
				</div>
			</form>
		</div>
	</div>
	<!--//main-->



</body>
</html>