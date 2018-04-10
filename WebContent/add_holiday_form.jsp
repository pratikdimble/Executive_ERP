<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Holiday</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<!-- //custom-theme -->
<link href="css/sstyle.css" rel="stylesheet" type="text/css" media="all" />
<!-- js -->
<script type="text/javascript" src="js/jjquery-2.1.4.min.js"></script>
<!-- //js -->
<!-- font-awesome-icons -->
<!-- //font-awesome-icons -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
</head>
<body>
<!-- banner -->
	<div class="center-container">
		<div class="main">
			<h1 class="w3layouts_head">Insert Holiday Form</h1>
				<div class="w3layouts_main_grid">
					<form action="./holiday" method="POST">
						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Holiday Name</label>
							<input type="text" name="hname" style="width: 148px;"required>
									</span>
						</div>

						<div class="w3_agileits_main_grid w3l_main_grid">
							<span class="agileits_grid">
								<label>Date </label>
								<input class="date" type="date" name="hdate" style="height: 30px; width: 130px">
								</span>
						</div>
						
						<div class="clear"></div>

					<div class="w3_main_grid">
						<div class="w3_main_grid_right">
							<input type="submit" name="operation" value="Insert">
						</div>
					</div>
				</form>
			</div>
					</div>
	</div>
<!-- DISPLAY TODAYS DATE -->
	<script type="text/javascript">
	var date = new Date();

var day = date.getDate();
var month = date.getMonth() + 1;
var year = date.getFullYear();

if (month < 10) month = "0" + month;
if (day < 10) day = "0" + day;

var today = year + "-" + month + "-" + day;


document.getElementById('theDate').value = today;
	</script>	

</body>
</html>