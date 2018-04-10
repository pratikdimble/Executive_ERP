<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Registration Form</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <link rel="stylesheet" type="text/css" href="css/cust_registrationdefault.css"/>
       <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
     <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>


    </head>
    <body>    
    <div class="header">
   <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
    <a class="active" href="salesmanagerfirstpage.jsp">Home</a>
      <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
<!--         <form Name="myForm" action="./employee" class="register" onsubmit="return validateMobile();"> -->
<form Name="myForm" action="./customer" class="register" onsubmit="return validateForm();return validateMobile();">       
    <h1>Customer Registration</h1>
            <pre></pre>
            
            <fieldset class="row1">
                <legend>Customer Details</legend>
                <p>
                    <label>Customer Name*</label>
                    <input type="text" name="name" required/>
                </p>
                 <p>
                    <label>Shop Name*</label>
                    <input type="text" name="shopname" required/>
                </p>
                <p>
                     <label>Shop Address*</label>
                    <input type="text" class="long" name="addr" required style="width: 223px; "/>
                </p>

                <p>
                    <label>Pin Code*</label>
                    <input type="text"  name="pin" 
                    pattern="[1-9]{1}[0-9]{5}" onkeypress="return IsNumeric(event);" 
                    ondrop="return false;" onpaste="return false;" 
                    title="Pin code is only 6 digits" required/>
   			</p> 
			 <span id="error" style="color: Red; display: none">*Only digits (0-9) Not Start with 0</span>
 
                </p>
            </fieldset>
            
            
            <fieldset class="row2">
                <legend>Delivery Information</legend>
               <p>
  					<input type="radio" name="delivery" checked="checked" value="Home Delivery">
                    <label class="radio">Home Delivery</label></input>
                    <input type="radio" name="delivery" value="Shop Delivery">
                    <label class="radio">Shop Delivery</label></input>
                  </p>
   
                </fieldset>
                
                
            <fieldset class="row3">
                             <legend>Contact Details</legend>
                <p>
                    <label>Telephone</label>
                    <input type="text" name="phone"/>
                </p>
                    <p>
                    	<label>Mobile No.*</label>
                    	<input type="text" id="text1" name="mob" pattern="[7-9]{1}[0-9]{9}" onkeypress="return IsNumeric(event);" ondrop="return false;" onpaste="return false;" title="Mobile number is only 10 digits Start with 7 or 8 or 9" />
   							</p> 
                    <p>
   							 <span id="error" style="color: Red; display: none">*Only digits (0-9) Start with 7 or 8 or 9</span>
                    </p> 
                    <p>
                    	<label>E-Mail ID*</label>
                    	<input type="text" name="email"
                    	title="EMAIL MUST CONTAIN @ AND . SYMBOL" required/>
                </p>
               
               
            </fieldset>
            
            <fieldset class="row4">
                <legend>Another Contact Details</legend>
                <p>
                    <label>Contact Person </label>
                    <input type="text" name="cntname"/>
                </p>
                    <p>
                    	<label>Contact Person Mobile No.*</label>
                    	<input type="text" id="text1" name="cntmob" pattern="[7-9]{1}[0-9]{9}" onkeypress="return IsNumeric(event);" ondrop="return false;" onpaste="return false;" title="Mobile number is only 10 digits Start with 7 or 8 or 9" />
   							</p> 
                    <p>
   							 <span id="error" style="color: Red; display: none">*Only digits (0-9) Start with 7 or 8 or 9</span>
                    </p> 
                </fieldset>
            
            
             
             
            <fieldset class="row7">
                <legend>Terms and Mailing
                </legend>
                <p class="agreement">
                    <input type="checkbox" value="" required/>
                    <label>*  I accept the <a href="#">Terms and Conditions</a></label>
                </p>
                <p><br />
  <font color="RED" size="5"> <input type="submit" color="RED" name="operation" value="Register"/></font>      
                </p>
               </fieldset>   
</pre> 

        
         <!--  <button type="submit" class="button" value="Register" >Register &raquo;</button> -->

        </form>


	
<!--SCRIPT FOR VALIDATE THE Mobile Number  -->			
    <script type="text/javascript">
        var specialKeys = new Array();
        specialKeys.push(8); //Backspace
        function IsNumeric(e) {
            var keyCode = e.which ? e.which : e.keyCode
            var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
            document.getElementById("error").style.display = ret ? "none" : "inline";
            return ret;
        }
    </script>

<!--SCRIPT FOR VALIDATE THE EMAIL  -->
<script>
function validateForm() {
    var x = document.forms["myForm"]["email"].value;
    var atpos = x.indexOf("@");
    var dotpos = x.lastIndexOf(".");
    if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length) {
        alert("Not a valid e-mail address");
        return false;
    }
}

</script>

    </body>
</html>

       


