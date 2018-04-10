<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Employee Update Form</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <link rel="stylesheet" type="text/css" href="css/registrationdefault.css"/>
       <link rel="stylesheet" type="text/css" href="css/menubar.css"/>
     <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>

<style type="text/css">
#dvPreview
{
    filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);
    min-height: 100px;
    min-width: 100px;
    display: none;
}
/* The message box is shown when the user clicks on the password field */
#message {
    display:none;
    color: #000;
    position: relative;
    padding: 10px;
    margin-top: 5px;
}

#message p {
    padding: 5px 45px;
    font-size: 10px;
}

/* Add a green text color and a checkmark when the requirements are right */
.valid {
    color: green;
}

.valid:before {
    position: relative;
    left: -35px;
    content: "✔";
}

/* Add a red text color and an "x" when the requirements are wrong */
.invalid {
    color: red;
}

.invalid:before {
    position: relative;
    left: -35px;
    content: "✖";
}
</style>

    </head>
    <body>   
    <form Name="myForm" action="./employee" class="register"> 
    <div class="header">
 <img src="img/newlogo.png" class="logo" style="width: 149px; height: 75px; "/>
  <div class="header-right">
<!--       <a  ><input type="submit" name="operation" value="Back"/></a> -->

<%
String thisRole = (String) session.getAttribute("role");
	if(thisRole.equalsIgnoreCase("Product Executive"))
                 	{
                 	%>
                 	 <a href="prod_exec_firstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("HR"))
                 	{
                 		%>
                 	 <a href="hr_firstpage.jsp">Back</a>
                 	 <% 
                 	}
                 		else if(thisRole.equalsIgnoreCase("Purchase Manager"))
                 	{
                 		%>
                 	 <a href="purchase_manager_firstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Service Executive"))
                 	{
                 		%>
                 	 <a href="service_exec_firstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Product Manager"))
                 	{
                 		%>
                 	 <a href="prod_manager_firstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Sales Manager"))
                 	{
                 		%>
                 	 <a href="salesmanagerfirstpage.jsp">Back</a>
                 	 <% 
                 	}
                 	else if(thisRole.equalsIgnoreCase("Service Manager"))
                 	{
                 		%>
                 	 <a href="service_manager_firstpage.jsp">Back</a>
                 	 <% 
						}
                 	else
                 	{
                 				%>
                 	 <a href="index.jsp">Home</a>
                 	 <% 
                 	} 
%>
    <a href="#contact">Contact</a>
    <a href="#about">About</a>
    <a href="logout.jsp">Logout</a>
  </div>
</div>
<!-- </form> -->
<!--         <form Name="myForm" action="./employee" class="register" onsubmit="return validateMobile();"> -->
<!--            <form Name="myForm" action="./employee" class="register" onsubmit="return validateForm();return validateMobile();">  -->
   <h1>Update Employee Profile</h1>
  <c:choose>
  	<c:when test="${!empty listLogin}">
 		 <c:forEach var="dt"  items="${listLogin}"> 
   <h2> ::This Is Your Login ID <input type="text" name="loginid" value="${dt.id}" readonly="readonly" style="width: 67px; "/>
   		</h2> </c:forEach>
  	</c:when>
  		<c:otherwise>
     		<h1 style="color:red;text-align:center">Records not found</h1>
  		</c:otherwise>
	</c:choose>      
          <c:choose>
  <c:when test="${!empty listEmployeeDTOs}">
  <c:forEach var="dto"  items="${listEmployeeDTOs}">  
            <fieldset class="row1">
                <legend>Employee Details</legend>
                <p>
                    <label>Employee Name*</label>
    
                    <input type="text" name="name" value="${dto.empName}"/>
                </p>
                <p>
                     <label>Local Address*</label>
                    <input type="text" class="long" name="local" required/>
                </p>
                    <p>
                     <label>Permenent Address*</label>
                    <input type="text" class="long" name="permenent"  value="${dto.empAddr}" required/>
                   </p>
             <p>
                    <label>City*</label>
                    <input type="text"  name="city" value="${dto.empCity}" required/>
                </p>
                <p>
                    <label>Pin Code*</label>
                    <input type="text"  name="pin" value="${dto.pin}" 
                    pattern="[1-9]{1}[0-9]{5}" onkeypress="return IsNumeric(event);" 
                    ondrop="return false;" onpaste="return false;" 
                    title="Pin code is only 6 digits" required/>
   			</p> 
			 <span id="error" style="color: Red; display: none">*Only digits (0-9) Not Start with 0</span>
 
                </p>
                <p>
                    <label>Country*</label>
                    <select name="country" required>
                        <option value="1">Select</option>
                        <option value="1">India</option>
                        <option value="2">Japan</option>
                        <option value="3">Singapore</option>
                        <option value="4">Dubai</option>
                        <option value="5">Norway</option>
                    </select>
                </p>
            </fieldset>
           <fieldset class="row2">
                <legend>Employee  ID</legend>
      				<p>
                    <label>Employee ID::</label>
             			<input type="text" name="empid" value="${dto.empId}" readonly="readonly" style="width: 70px; "/>
                    </p>
                </fieldset>
            <fieldset class="row3">
                <legend>Personal Details   </legend>
                <p>
                    <label>Date of Birth*</label>
                    <select  class="date" style="width: 66px; " required>
                   	    <option value="1">01</option>
                        <option value="2">02</option>
                        <option value="3">03</option>
                        <option value="4">04</option>
                        <option value="5">05</option>
                        <option value="6">06</option>
                        <option value="7">07</option>
                        <option value="8">08</option>
                        <option value="9">09</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>
                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>
                        <option value="31">31</option>
                    </select>
                    <select style="width: 80; "  required>
                        <option value="January">January</option>
                        <option value="February">February</option>
                        <option value="March">March</option>
                        <option value="April">April </option>
                        <option value="May">May   </option>
                        <option value="June">June </option>
                        <option value="July">July    </option>
                        <option value="August">August  </option>
                        <option value="September">September  </option>
                        <option value="October">October   </option>
                        <option value="November">November  </option>
                        <option value="December">December</option>
                    </select>
                    <input class="year" type="text" size="4" maxlength="4" style="width: 52px; " required/>e.g 1976
                </p>
                <p>
                    <label>Nationality*</label>
                    <select required>
                        <option>Select</option>
                        <option value="1">India</option>
                        <option value="2">Japan</option>
                        <option value="3">Singapore</option>
                        <option value="4">Dubai</option>
                        <option value="5">Norway</option>
                    </select>
                </p>
                  <p>
                    <label>Gender*</label>
  					<input type="radio" name="gender" checked="checked" value="male">
                    <label class="gender">Male</label></input>
                    <input type="radio" name="gender" value="female">
                    <label class="gender">Female</label></input>
                    <input type="radio" name="gender"  value="other">
                    <label class="gender">Other</label></input>
                  </p>
                <p>
                    <label>Marital Status*
                    </label>
  					 <input type="radio" name="status" checked="checked" value="marry">
                    <label class="gender">Married</label></input>
                    <input type="radio" name="status" value="un">
                    <label class="gender">Unmarried</label></input>
                </p>
                
               
            </fieldset>
            
            <fieldset class="row4">
                <legend>Contact Details</legend>
                <p>
                    <label>Telephone</label>
                    <input type="text" name="phone"/>
                </p>
                    <p>
                    	<label>Mobile No.*</label>
                    	<input type="text" id="text1" name="mob" value="${dto.mobile}" pattern="[7-9]{1}[0-9]{9}" onkeypress="return IsNumeric(event);" ondrop="return false;" onpaste="return false;" title="Mobile number is only 10 digits Start with 7 or 8 or 9" />
   							</p> 
                    <p>
   							 <span id="error" style="color: Red; display: none">*Only digits (0-9) Start with 7 or 8 or 9</span>
                    </p> 
                    <p>
                    	<label>E-Mail ID*</label>
                    	<input type="text" name="email" value="${dto.empMail}"
                    	title="EMAIL MUST CONTAIN @ AND . SYMBOL" required/>
                </p>
                </fieldset>
            
            <fieldset class="row5">
                <legend>Job Profile Information
                </legend>
                <p>
                        <label>Designation*</label>
                    <select name="dsgn" required>
                        <option value="${dto.designation}">${dto.designation}</option>
                        <option value="Manager">Manager</option>
                         <option value="Sales Manager">Sales Manager</option>
                          <option value="Marketing Manager">Marketing Manager</option>
                           <option value="Product Executive">Product Executive</option>
                            <option value="Service Executive">Service Executive</option>
                    </select>
                    </p>
                          <p>
                        <label>Qualification*</label>
                    <select name="qual" required>
                        <option value="${dto.qualification}">${dto.qualification}</option>
                        <option value="BE/BTEC">BE/BTEC</option>
                         <option value="BCA">BCA</option>
                          <option value="MBA">MBA</option>
                           <option value="ME">ME</option>
                           <option value="BCS">BCS</option>
                    </select>
                    </p>
					 <p>
                        <label>Work Experience*</label>
                    <select name="exp" required>
                        <option value="${dto.workExp}">${dto.workExp}</option>
                        <option value="0-2">0-2</option>
                         <option value="2-5">2-5</option>
                          <option value="5-10">5-10</option>
                           <option value="10-20">10-20</option>
                           <option value="20+">More than 20</option>
                    </select>
                    </p>   
                             <p>
                    <label>Date of Joining*
                    </label>
                    <input type="date" name="date" value="${dto.doj}" style="width: 143px; height: 30px" required="required"/>
              </p>             
             </fieldset>
  
                              <fieldset class="row6">
                    <p><br />
   <font color="RED" size="5"> <input type="submit" color="RED" name="operation" value="Save" onClick="conf()" style="width: 138px; "/>&nbsp&nbsp<a href="prod_exec_firstpage.jsp"><input type="button" value="CANCEL" onClick="exit()" style="height: 45px; width: 119px"/></a>	 </font>      
                </p>
               </fieldset> 
               <br>

</pre>
          </c:forEach>
  </c:when>
 
  <c:otherwise>
     <h1 style="color:red;text-align:center">Records not found</h1>
  </c:otherwise>
</c:choose>

        </form>


	<!--SCRIPT FOR VALIDATE THE PASSWORD  -->			
<script>
var myInput = document.getElementById("password");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
    document.getElementById("message").style.display = "block";
}

// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
    document.getElementById("message").style.display = "none";
}

// When the user starts to type something inside the password field
myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }

  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(myInput.value.length >= 6) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}
</script>

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
<script type="text/javascript">
function conf()
{
var con=confirm("Do you want to Save the Changes???");
}
function exit()
{
var con=confirm("Do you want to Exit???");
}
</script>
    </body>
</html>

       


