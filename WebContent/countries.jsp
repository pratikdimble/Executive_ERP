<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type= "text/javascript" src = "countries.js"></script>
<title>Insert title here</title>
</head>
<body>
      <div align="center">
         <h1>Free JavaScript Country/State Selection Demo</h1>

        <hr/>
        <br/>Select Country (with states):
        <select id="country" name="country"></select>
        <br />State:
        <select name="state" id="state"></select>
        <br/>
        <br />Select Country (without states):
        <select id="country2" name="country2"></select>
        <br />
        <script language="javascript">
            populateCountries("country", "state");
            populateCountries("country2");
        </script>
        <br/>
        <br/>
        <br />
        <br />
    </div>   
</body>
</html>