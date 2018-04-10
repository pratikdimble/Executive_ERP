<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Javascript ::Very Important File of This Project</title>
</head>
<body>
<script> 
	
	
	function showId(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
					{// code for IE7+, Firefox, Chrome, Opera, Safari 
				xmlhttp=new XMLHttpRequest(); 
			} 
		else 
			{// code for IE6, IE5 
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
		} 
			xmlhttp.onreadystatechange=function() 
		{ 
			if (xmlhttp.readyState==4 && xmlhttp.status==200) 
				{ 
					document.getElementById("empname").innerHTML=xmlhttp.responseText; 
				} 
		} 
	xmlhttp.open("POST","populateid2.jsp?q="+str,true); 
		//xmlhttp.open("POST","populate_dsgn.jsp?q="+str,true); 
	xmlhttp.send(); 
	} 
</script>
<script> 
function showProdComp(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
		xmlhttp=new XMLHttpRequest(); 
			} 
		else 
			{// code for IE6, IE5 
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
		} 
			xmlhttp.onreadystatechange=function() 
			{ 
				if (xmlhttp.readyState==4 && xmlhttp.status==200) 
				{ 
					document.getElementById("company").innerHTML=xmlhttp.responseText; 
			} 
		} 
		xmlhttp.open("POST","compout.jsp?q="+str,true); 
		xmlhttp.send(); 
	} 

	function showType(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
		xmlhttp=new XMLHttpRequest(); 
			} 
		else 
			{// code for IE6, IE5 
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
		} 
			xmlhttp.onreadystatechange=function() 
			{ 
				if (xmlhttp.readyState==4 && xmlhttp.status==200) 
				{ 
					document.getElementById("productType").innerHTML=xmlhttp.responseText; 
			} 
		} 
		xmlhttp.open("POST","typeout.jsp?q="+str,true); 
		xmlhttp.send(); 
	} 

function showPid(str){ 
			var xmlhttp; 
				if (window.XMLHttpRequest) 
					{// code for IE7+, Firefox, Chrome, Opera, Safari 
				xmlhttp=new XMLHttpRequest(); 
				} 
			else 
		{// code for IE6, IE5 
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
			} 
				xmlhttp.onreadystatechange=function() 
			{ 
				if (xmlhttp.readyState==4 && xmlhttp.status==200) 
			{ 
				document.getElementById("productId").innerHTML=xmlhttp.responseText; 
			} 
	} 
		xmlhttp.open("POST","populate_pid.jsp?q="+str,true); 
		xmlhttp.send(); 
	} 
	
		function showpType(str){ 
			var xmlhttp; 
				if (window.XMLHttpRequest) 
					{// code for IE7+, Firefox, Chrome, Opera, Safari 
				xmlhttp=new XMLHttpRequest(); 
				} 
			else 
		{// code for IE6, IE5 
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
			} 
				xmlhttp.onreadystatechange=function() 
			{ 
				if (xmlhttp.readyState==4 && xmlhttp.status==200) 
			{ 
				document.getElementById("productType").innerHTML=xmlhttp.responseText; 
			} 
	} 
		xmlhttp.open("POST","ptypeout.jsp?q="+str,true); 
		xmlhttp.send(); 
	} 

function showppType(str){ 
	var xmlhttp; 
		if (window.XMLHttpRequest) 
			{// code for IE7+, Firefox, Chrome, Opera, Safari 
				xmlhttp=new XMLHttpRequest(); 
			} 
		else 
		{// code for IE6, IE5 
		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
		} 
			xmlhttp.onreadystatechange=function() 
		{ 
		if (xmlhttp.readyState==4 && xmlhttp.status==200) 
		{ 
			document.getElementById("productType").innerHTML=xmlhttp.responseText; 
		} 
	} 
		xmlhttp.open("POST","ptypeout2.jsp?q="+str,true); 
	xmlhttp.send(); 
} 


function showStock(str){ 
var xmlhttp; 
if (window.XMLHttpRequest) 
{// code for IE7+, Firefox, Chrome, Opera, Safari 
xmlhttp=new XMLHttpRequest(); 
} 
else 
{// code for IE6, IE5 
xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
} 
xmlhttp.onreadystatechange=function() 
{ 
if (xmlhttp.readyState==4 && xmlhttp.status==200) 
{ 
document.getElementById("productStock").innerHTML=xmlhttp.responseText; 
} 
} 
xmlhttp.open("POST","stockout.jsp?q="+str,true); 
xmlhttp.send(); 
} 

function showCompany(str){ 
var xmlhttp; 
if (window.XMLHttpRequest) 
{// code for IE7+, Firefox, Chrome, Opera, Safari 
xmlhttp=new XMLHttpRequest(); 
} 
else 
{// code for IE6, IE5 
xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
} 
xmlhttp.onreadystatechange=function() 
{ 
if (xmlhttp.readyState==4 && xmlhttp.status==200) 
{ 
document.getElementById("productCompany").innerHTML=xmlhttp.responseText; 
} 
} 
xmlhttp.open("POST","companyout.jsp?q="+str,true); 
xmlhttp.send(); 
} 
function showpCompany(str){ 
var xmlhttp; 
if (window.XMLHttpRequest) 
{// code for IE7+, Firefox, Chrome, Opera, Safari 
xmlhttp=new XMLHttpRequest(); 
} 
else 
{// code for IE6, IE5 
xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
} 
xmlhttp.onreadystatechange=function() 
{ 
if (xmlhttp.readyState==4 && xmlhttp.status==200) 
{ 
document.getElementById("productCompany").innerHTML=xmlhttp.responseText; 
} 
} 
xmlhttp.open("POST","companyout2.jsp?q="+str,true); 

xmlhttp.send(); 
} 

function showppCompany(str){ 
var xmlhttp; 
if (window.XMLHttpRequest) 
{// code for IE7+, Firefox, Chrome, Opera, Safari 
xmlhttp=new XMLHttpRequest(); 
} 
else 
{// code for IE6, IE5 
xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
} 
xmlhttp.onreadystatechange=function() 
{ 
if (xmlhttp.readyState==4 && xmlhttp.status==200) 
{ 
document.getElementById("productCompany").innerHTML=xmlhttp.responseText; 
} 
} 
xmlhttp.open("POST","companyout3.jsp?q="+str,true); 

xmlhttp.send(); 
}
</script> 

<script> 
	function showDsgn(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("dsgn").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_dsgn.jsp?q="+str,true); 
		xmlhttp.send(); 
	} 
	
	function showAddr(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("addr").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_custaddr.jsp?q="+str,true); 
		xmlhttp.send(); 
	} 
	
	
	function showCAddr(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("addr").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_custaddr2.jsp?q="+str,true); 
		xmlhttp.send(); 
	} 
		function showContact(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("contact").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_custcontact.jsp?q="+str,true); 
		xmlhttp.send(); 
	}
	
	
	function showCContact(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("contact").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_custcontact2.jsp?q="+str,true); 
		xmlhttp.send(); 
	}
	function showReq(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("custreq").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_custreq.jsp?q="+str,true); 
		xmlhttp.send(); 
	}
	
	
	
		function showCustoID(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("custid").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_custid2.jsp?q="+str,true); 
		xmlhttp.send(); 
	}
	
	function showCustooID(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("custid").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_custid3.jsp?q="+str,true); 
		xmlhttp.send(); 
	}
	
	
	function showppcost(comp){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("productCost").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_pcost.jsp?q="+comp,true); 
		xmlhttp.send(); 
	}
	
	function showCost(comp){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("costproduct").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_cost.jsp?q="+comp,true); 
		xmlhttp.send(); 
	}
	
</script>
				<!-- Populate the Supplier Data -->
<script type="text/javascript">
function showSuppAddr(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("addr").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_suppaddr.jsp?q="+str,true); 
		xmlhttp.send(); 
	} 
function showSuppName(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("suppname").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_suppname.jsp?q="+str,true); 
		xmlhttp.send(); 
	} 
	
	function showSuppContact(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("contact").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_suppcontact.jsp?q="+str,true); 
		xmlhttp.send(); 
	}
	
	function showSuppId(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("suppid").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_suppid.jsp?q="+str,true); 
		xmlhttp.send(); 
	}
	function showSupplAddr(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("addr").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_suppaddr2.jsp?q="+str,true); 
		xmlhttp.send(); 
	} 
		function showSupplContact(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("contact").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_suppcontact2.jsp?q="+str,true); 
		xmlhttp.send(); 
	}
	
	function showSuppAddrr(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("addr").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_suppaddr3.jsp?q="+str,true); 
		xmlhttp.send(); 
	} 
		function showSuppContactt(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("contact").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_suppcontact3.jsp?q="+str,true); 
		xmlhttp.send(); 
	}
	
	function showSupplierName(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("suppname").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_suppliername.jsp?q="+str,true); 
		xmlhttp.send(); 
	} 
</script>
<script> 
	function showState(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("area").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populatearea.jsp?q="+str,true); 
		xmlhttp.send(); 
	} 
	
</script> 

<script type="text/javascript">
function tabledata(str)
{

document.getElementById('tabledata').style.display='block';
var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("tabledata").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","select_sales2.jsp?q="+str,true); 
		xmlhttp.send(); 
obj.value='Hide';
return;
}


function showProvider(str)
{

//document.getElementById('tabledata').style.display='block';
var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("provider").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_provider.jsp?q="+str,true); 
		xmlhttp.send(); 
obj.value='Hide';
return;
}

function showSerProvider(str)
{

//document.getElementById('tabledata').style.display='block';
var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("provider").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_provider2.jsp?q="+str,true); 
		xmlhttp.send(); 
obj.value='Hide';
return;
}

function showSerCost(prov,ser){ 
		var xmlhttp; 
		//var prov=document.getElementById('sername').value;
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("servicecost").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_sercost.jsp?q="+prov+"&r="+ser,true); 
		xmlhttp.send(); 
	}
	
	function showSCost(prov){ 
		var xmlhttp; 
		//var prov=document.getElementById('sername').value;
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("serviceCost").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_scost.jsp?q="+prov,true); 
		xmlhttp.send(); 
	}
	
	function getCost(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("seramt").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_sercost2.jsp?q="+str,true); 
		xmlhttp.send(); 
	}
	
	function getPCost(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("prodamt").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_prodcost2.jsp?q="+str,true); 
		xmlhttp.send(); 
	}
	
	function getPrCost(str){ 
		var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("prodamt").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_prodcost3.jsp?q="+str,true); 
		xmlhttp.send(); 
	}
			/* For Enquiry */
function productDiv()
{

 document.getElementById('sname').removeAttribute('required');
document.getElementById('provide').removeAttribute('required'); 

document.getElementById('productName').style.display='block';
document.getElementById('productType').style.display='block';
document.getElementById('productCost').style.display='block';
document.getElementById('productCompany').style.display='block';
document.getElementById('quantity').style.display='block';

// document.getElementById('productdata').style.display='block';
document.getElementById('prodamt').style.display='block';
document.getElementById('serCost').value=0.0; 
document.getElementById('sername').style.display='none';
document.getElementById('provider').style.display='none';
document.getElementById('serviceCost').style.display='none';

return;
}
function newProdDiv()
{
 document.getElementById('productdata').style.display='block';
document.getElementById('prodamt').style.display='block';
return;
}
function serDiv()
{

 document.getElementById('prodName').removeAttribute('required');
document.getElementById('prodType').removeAttribute('required');
document.getElementById('prodcompany').removeAttribute('required'); 
document.getElementById('quant').removeAttribute('required'); 
document.getElementById('productCost').removeAttribute('required'); 

document.getElementById('quant').value=0; 
document.getElementById('prodCost').value=0; 

document.getElementById('productName').style.display='none';
document.getElementById('productType').style.display='none';
document.getElementById('productCompany').style.display='none';
document.getElementById('productCost').style.display='none';
document.getElementById('quantity').style.display='none';

document.getElementById('sername').style.display='block';
document.getElementById('provider').style.display='block';
document.getElementById('serviceCost').style.display='block';

// document.getElementById('servicedata').style.display='block';
document.getElementById('seramt').style.display='block';

return;
}

/* function productserviceDiv()
{

document.getElementById('productName').style.display='block';
document.getElementById('productType').style.display='block';
document.getElementById('productCompany').style.display='block';
document.getElementById('quantity').style.display='block';
document.getElementById('productCost').style.display='block';
document.getElementById('sername').style.display='block';
document.getElementById('provider').style.display='block';
document.getElementById('serviceCost').style.display='block';
return;
} */
			/* For Quotation */
function prodDiv()
{
document.getElementById('sname').removeAttribute('required');
document.getElementById('provide').removeAttribute('required');

document.getElementById('productName').style.display='block';
document.getElementById('productType').style.display='block';
document.getElementById('productCompany').style.display='block';
document.getElementById('quantity').style.display='block';
document.getElementById('costproduct').style.display='block';

document.getElementById('sername').style.display='none';
document.getElementById('provider').style.display='none';
document.getElementById('servicecost').style.display='none';
obj.value='Hide';

return;
}

function serviceDiv()
{
document.getElementById('prodName').removeAttribute('required');
document.getElementById('prodCompany').removeAttribute('required');
document.getElementById('quant').removeAttribute('required');

document.getElementById('productName').style.display='none';
document.getElementById('productType').style.display='none';
document.getElementById('productCompany').style.display='none';
document.getElementById('quantity').style.display='none';
document.getElementById('costproduct').style.display='none';

document.getElementById('sername').style.display='block';
document.getElementById('provider').style.display='block';
document.getElementById('servicecost').style.display='block';
obj.value='Show';

return;
}

function prodserviceDiv()
{

document.getElementById('productName').style.display='block';
document.getElementById('productType').style.display='block';
document.getElementById('productCompany').style.display='block';
document.getElementById('quantity').style.display='block';
document.getElementById('costproduct').style.display='block';
document.getElementById('sername').style.display='block';
document.getElementById('provider').style.display='block';
document.getElementById('servicecost').style.display='block';
obj.value='Show';

return;
}

function showBlock() {
document.getElementById('seramt').style.display='block';
document.getElementById('sertax').style.display='block';
document.getElementById('sergrossnet').style.display='block';
document.getElementById('serdiscount').style.display='block';
document.getElementById('sergrossamount').style.display='block';

return;	
}
			/* For Product Data Quotation */

function myFunction() {
 var total = parseFloat(document.getElementById("totalamt").value, 10);
 var servicetax = parseInt(document.getElementById("servicetax").value, 10);
 tax=(total * servicetax) / 100;
 		document.getElementById("grossnet").value = total + tax;
 		
}
function myFun() {
 var gross = parseFloat(document.getElementById("grossnet").value, 10);
 var discount = parseInt(document.getElementById("discount").value, 10);
 		 document.getElementById("grossamount").value= gross - discount;
	
}
function myFunct() {
  var total = parseFloat(document.getElementById("totalcost").value, 10);
 var quantity = parseInt(document.getElementById("quant").value, 10);
 var result=total * quantity;
 		document.getElementById("pamt").value = result;
 		
}
function myFunctionn() {
  var total = parseFloat(document.getElementById("totalcost").value, 10);
 var quantity = parseInt(document.getElementById("quant").value, 10);
 var result=total * quantity;
 var servicetax = parseInt(document.getElementById("servicetax").value, 10);
 tax=(result * servicetax) / 100;
 		document.getElementById("grossnet").value = result + tax;
}
function myFunn() {
 var gross = parseFloat(document.getElementById("grossnet").value, 10);
 var discount = parseInt(document.getElementById("discount").value, 10);
 		 document.getElementById("grossamount").value= gross - discount;
	
}
			/* For Service Data Quotation */

function calTax() {
 var servicetax = parseInt(document.getElementById("sertax").value, 10);
 var seramt= parseFloat(document.getElementById("amt").value, 10);
 var sertax=(seramt * servicetax) / 100;
 		document.getElementById("sergrossnet").value = seramt + sertax;
 		document.getElementById("sergrossamount").value=seramt + sertax;
}

function calDiscount() {
 var sergross = parseFloat(document.getElementById("sergrossnet").value, 10);
 var serdiscount = parseInt(document.getElementById("serdiscount").value, 10);
 		 document.getElementById("sergrossamount").value= sergross - serdiscount;
	
}
function showNetCost(prov,ser){ 
		var xmlhttp; 
		//var prov=document.getElementById('sername').value;
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("seramt").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_netcost.jsp?q="+prov+"&r="+ser,true); 
		xmlhttp.send(); 
	}

function calTaxx() {
 var servicetax = parseInt(document.getElementById("sertax").value, 10);
 var seramt= parseFloat(document.getElementById("mysercost").value, 10);
//  document.getElementById("seramt").innerHTML=seramt;
 var sertax=(seramt * servicetax) / 100;
 		document.getElementById("sergrossnet").value = seramt + sertax;
 		document.getElementById("sergrossamount").value=seramt + sertax;
}

function calDiscountt() {
 var sergross = parseFloat(document.getElementById("sergrossnet").value, 10);
 var serdiscount = parseInt(document.getElementById("serdiscount").value, 10);
 		 document.getElementById("sergrossamount").value= sergross - serdiscount;
	
}

			/*Populate the product details  */
function showProdData(str)
{
var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("pdata1").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_prod_details.jsp?q="+str,true); 
		xmlhttp.send(); 

}
function showProdDataT(str)
{
var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("pdata2").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_prod_details2.jsp?q="+str,true); 
		xmlhttp.send(); 
}
function showProdDataC(str)
{
var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("pdata3").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_prod_details3.jsp?q="+str,true); 
		xmlhttp.send(); 
}
function showProdDataQ(str)
{
var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("pdata4").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_prod_details4.jsp?q="+str,true); 
		xmlhttp.send(); 
}
function showProdDataP(str)
{
var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("pdata5").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_prod_details5.jsp?q="+str,true); 
		xmlhttp.send(); 
}

				/*  Populate Product Purchase Data */
				
				function showProdN(str)
{
var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("pdata1").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_prod_details6.jsp?q="+str,true); 
		xmlhttp.send(); 

}
function showProdT(str)
{
var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("pdata2").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_prod_details7.jsp?q="+str,true); 
		xmlhttp.send(); 

}
function showProdC(str)
{
var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("pdata3").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_prod_details8.jsp?q="+str,true); 
		xmlhttp.send(); 

}
function showProdQ(str)
{
var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("pdata4").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_prod_details9.jsp?q="+str,true); 
		xmlhttp.send(); 

}
function showProdP(str)
{
var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("pdata5").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_prod_details10.jsp?q="+str,true); 
		xmlhttp.send(); 

}

			/* Populate Service Data  */
function showSerData(str)
{
var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("sdata1").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_ser_details.jsp?q="+str,true); 
		xmlhttp.send(); 
}
function showSerDataP(str)
{
var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("sdata2").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_ser_details2.jsp?q="+str,true); 
		xmlhttp.send(); 
}
function showSerDataC(str)
{
var xmlhttp; 
			if (window.XMLHttpRequest) 
				{// code for IE7+, Firefox, Chrome, Opera, Safari 
					xmlhttp=new XMLHttpRequest(); 
				} 
			else 
				{// code for IE6, IE5 
					xmlhttp=new ActiveXObject("Microsoft.XMLHTTP"); 
				} 
			xmlhttp.onreadystatechange=function() 
				{ 
					if (xmlhttp.readyState==4 && xmlhttp.status==200) 
						{ 
							document.getElementById("sdata3").innerHTML=xmlhttp.responseText; 
						} 
				} 
			xmlhttp.open("POST","populate_ser_details3.jsp?q="+str,true); 
		xmlhttp.send(); 
}


</script>
<script type="text/javascript">
	function showDBTable() {

		var prodname=	document.getElementById("prodname").value;
		var prodtype=document.getElementById("prodtype").value;
		var company=document.getElementById("comp").value;
 		var quantity = parseInt(document.getElementById("quantity").value, 10);
 		var total = parseFloat(document.getElementById("prodcost").value, 10);
  		var grand = parseFloat(document.getElementById("grossamount").value, 10);
	
    var table = document.getElementById("myTable");
    var row = table.insertRow(1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);
    var cell7 = row.insertCell(6);

    cell1.innerHTML = "<h2><input type='radio' id='choice' name='choice' onclick='showSelectedValue();'/></h2>";
    cell2.innerHTML = prodname;
    cell3.innerHTML =prodtype;
    cell4.innerHTML =company;
    cell5.innerHTML = quantity;
    cell6.innerHTML = total;
    cell7.innerHTML = grand;
    	
    	var result=0;
      	result = parseFloat(document.getElementById("grossamount").value, 10);
      	var a=parseFloat(document.getElementById("totalamount").value, 10);
      		result=result+a;
      	document.getElementById("totalamount").value=result;
}
function yFunction(x) {
    alert("Row index is: " + x.rowIndex);
}

function showDBTablee() {

		var prodname=	document.getElementById("prodname").value;
		var prodtype=document.getElementById("prodtype").value;
		var company=document.getElementById("comp").value;
 		var quantity = parseInt(document.getElementById("quantity").value, 10);
 		var total = parseFloat(document.getElementById("prodcost").value, 10);
  		var grand = parseFloat(document.getElementById("grossamount").value, 10);
	
    var table = document.getElementById("myTablee");

    var row = table.insertRow(1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5 = row.insertCell(4);
    var cell6 = row.insertCell(5);
    var cell7 = row.insertCell(6);
    var cell8 = row.insertCell(7);

    cell1.innerHTML = "<h2><input type='radio' name='choice' onclick='showSelectedVal();'/></h2>";
    cell2.innerHTML = "<input type='checkbox' name='ch'/>";
    cell3.innerHTML = prodname;
    cell4.innerHTML =prodtype;
    cell5.innerHTML =company;
    cell6.innerHTML = quantity;
    cell7.innerHTML = total;
    cell8.innerHTML = grand;
    	
    	var result=0;
    	
      	result = parseFloat(document.getElementById("grossamount").value, 10);
      	var a=parseFloat(document.getElementById("totalamount").value, 10);
      		result=result+a;
      	document.getElementById("totalamount").value=result;
}

function removeRow() {
	var id = parseInt(document.getElementById("choice").value, 10);
    document.getElementById("myTable").deleteRow(id);
     var totalamount=parseFloat(document.getElementById("totalamount").value, 10);
     var a=parseFloat(document.getElementById("val").value, 10);
      totalamount=totalamount - a;
      document.getElementById("totalamount").value=totalamount;
}

function calNetAmt(){
 var quantity = parseInt(document.getElementById("quantity").value, 10);
 var total = parseFloat(document.getElementById("prodcost").value, 10);
document.getElementById("totalamt").value=quantity * total;
}
function calTotalAmt(){
 var quantity = parseInt(document.getElementById("quantity").value, 10);
 var total = parseFloat(document.getElementById("totalamount").value, 10);
document.getElementById("totalamt").value=quantity * total;
}

			/* To get the product cost of which row is selected */
function showSelectedValue(str)
{
$("#myTable tr").click(function(){
   $(this).addClass('selected').siblings().removeClass('selected');    
   var value=$(this).find('td:last').html();
   document.getElementById("val").value=value;

});
document.getElementById("ch").value=str;

}

function showSelectedVal(str)
{

$("#myTablee tr").click(function(){
//var val=0;
   $(this).addClass('selected').siblings().removeClass('selected');    
  var val=$(this).find('td:last').html();
   document.getElementById("val").value=val;
    //var row_index = $(this).closest("tr").index(); //find the row index
   //var col_index = $(this).index();	//find the column index
   //alert(row_index);    
	});
}

/* function removee()
	{
	//document.getElementById("val").value=0;
	  /* var totalamount=parseFloat(document.getElementById("totalamount").value, 10);
     		var a=parseFloat(document.getElementById("val").value, 10);
     			 totalamount=totalamount - a;
      		document.getElementById("totalamount").value=totalamount; */
/* 	$("#myTablee tr").click(function(){
      		  $(this).closest('tr').remove(); */
      		  
/* });

	}  */ 
function cl()
{
var totalamount=parseFloat(document.getElementById("totalamount").value, 10);
     		var a=parseFloat(document.getElementById("val").value, 10);
     			 totalamount=totalamount - a;
      		document.getElementById("totalamount").value=totalamount;
      		$("#myTablee tr").click(function(){
      		var row_index = $(this).closest("tr").index();
      		document.getElementById("myTablee").deleteRow(row_index);
      		 // $(this).closest('tr').remove();
});
      		//removee();
}
</script>
</body>
</html>