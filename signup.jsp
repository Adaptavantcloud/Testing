<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html">
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">



  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Signup</title>
<script>
$(document).ready(function() {
	$("#signupid").click(function () {
		var username = $("#suserid").val();
		var password = $("#suserpassword").val();
		
		if(username == "" || null){
			alert("Please enter the username");
			return false;
		}
		if(password == "" || null){
			alert("Please enter the password");
			return false;
		}
	});
});	
</script>
 <style>
 .customDiv{

  
  margin: 30px;
  min-height: 350px;
  background-color: #e4e4e4;
  text-align: center;
  font-size: large;
  border-top: 30px;
}
</style>
<script>
function reseet() {
  alert(localStorage.getItem("username"));
localStorage.removeItem("username");
//alert(localStorage.getItem("username"));
}

function add() {
var start=localStorage.getItem("username");
//alert(start);


var currentval=document.getElementById("userid").value;
//alert(currentval);
var finalvar="";
if(start!=null && start!=""){

finalvar=start+"$$$$"+currentval;
}else{
finalvar=currentval;
}
//document.getElementById("demo").innerHTML =finalvar;
//document.getElementById("demo").innerHTML =finalvar;
localStorage.setItem("username", finalvar);
//alert(localStorage.getItem("username"));
window.location = 'index.html';
}
</script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
     <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">NoteMaking</a>
    </div>
 
    <div class="collapse navbar-collapse" id="myNavbar">
    
     <ul class="nav navbar-nav navbar-right">
      <li><a href="homemain.html"><span class="glyphicon glyphicon-user"></span> Home</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Aboutus</a></li>
     </ul>
   </div>
  </div>

</nav>
<br>
<br>
<br>
<br>
<marquee width="100%" behaviour="alternate" bgcolor="ffffff" style=" padding: 16px; font-style: courier-style">WELCOME TO NOTE MAKING </marquee>
<div class="container">
    <div class="col-lg-5 col-lg-offset-3 col-md-8 col-md-offset-2">
      <div class="customDiv">
        <h1>Singin</h1>
        
        <form method="get" action="SignupServlet">
        <hr/>
          <table><tr><td><div id="demo">user_name:</td><td><input  type="text" id ="suserid"name="SuserName" required><br>
   </div></td></tr>
   <tr><td>password: </td><td><input   type="password" id ="suserpassword" name="SuserPassword" required></td></tr>
   <tr><td>Re_password: </td><td><input type="password" name="Re_password" required></td></tr>
<hr/>
<tr>
<td><input type="reset" value="reset"></td><td> <input type="submit" value="signup"/></td>
 </table>
        </form>
<!--<div style="bottom: 10px;">

   <tr><td><input type="button" value="reset" onclick="reseet();"/></td>
   <td> </td>
   <td><input type="button" value="add" onclick="add();"/></td></tr>
 </div> -->
 
 
      </div>
    </div>
  </div>
</body>
</html>