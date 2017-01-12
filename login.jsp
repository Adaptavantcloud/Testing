<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!Doctype html>
<html lang="en">
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"> </script>
<title>Login</title>
  <script>
  function valiateForm(){
  	var str2=document.getElementById("usernameId2").value;
  	//alert(str2);
  	 var str=localStorage.getItem("username");
  	// alert(str);
  	var len=str.length;
   //alert(len);
  	// alert("str");
    var res = str.split("$$$$");
      for(var i=0;i<len;i++)
      {
      	//alert(str[i]);
      	 if(res[i]==str2)
      	 {
      	 	window.location = 'processs.html';
      	 }
      }
   //   alert(res[0]);
   //   alert(res[1]);
   //   alert(res[2]);
   //  //document.getElementById("demo").innerHTML = res;

}
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
$(document).ready(function() {
	$("#login").click(function () {
		var username = $("#lUserid").val();
		var password = $("#lUserpassword").val();
		
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

<marquee width="100%" behaviour="alternate" bgcolor="ffffff" style=" padding: 16px; font-style: courier-style">WELCOME TO NOTE MAKING </marquee>
<div class="container">
    <div class="col-lg-5 col-lg-offset-3 col-md-8 col-md-offset-2">
      <div class="customDiv">
        <h1>Login</h1>
 <form name="myform" method="get" action="LoginServlet">
 <hr/>
 <table>
	<tr><div ng-app="" id="demo">
<p>Name : <input type="text" ng-model="name" placeholder="Enter name here" id="lUserid"  name="loginUsername" required></p>
{{name}}
</tr>
	<tr> 
<p>password:<input type="password" placeholder="Enter the password" id="lUserpassword" name="loginPassword" required></p><br></div></tr>
	
<hr/>
	
	 <tr><input type="submit" value="login" id="login" /></tr>
	
	 </table>
</form>

</div>
    </div>
  </div>

</body>
</html>
