<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.switch {
  position: relative;
  display: inline-block;
  width: 60px;
  height: 34px;
}

.switch input {display:none;}

.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: #ccc;
  -webkit-transition: .4s;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 26px;
  width: 26px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
}

input:checked + .slider {
  background-color: #2196F3;
}

input:focus + .slider {
  box-shadow: 0 0 1px #2196F3;
}

input:checked + .slider:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}

/* Rounded sliders */
.slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
}
</style>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- <script>
    $(function(){
        //Range
        var val     = $('#slider').val();
            output  = $('#output');

        output.html(val);

        $('#slider').on('change', function(){
            output.html(this.value);
        });
    });
</script> -->
<script>
$('#status').click(function() {
    $("#txtAge").toggle(this.checked);
});
</script>
<script type="text/javascript">
function myFunction() {
if(document.getElementById('status').checked) {
document.getElementById("txtAge").value = document.getElementById("status").value;
document.getElementById("output").value = document.getElementById("status").value;
}
}
</script>
<h2>Toggle Switch</h2>
<p>
    <label for="range">Select Age:</label> 
    <input type="range" min="14" max="60" id="slider" value="10" name="range"> 
    
</p>


<label class="switch">
  <!-- <input type="checkbox"  name="status" id="status" value="Approved">  -->
  <span class="slider round"></span>
<!--   <label id="output"></label> -->
</label>
<input type="checkbox"  name="status" id="status" value="Approved" onclick="myFunction()">
<div id="txtAge" style="display:none">Age is something</div>
 <p id="output"></p>
</body>
</html> 