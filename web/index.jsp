<!DOCTYPE html>
<%@ page import="mypackage.dto.student"%>
<html>
    <head>
        <title>FIRST PROGRAM</title>
        
    </head>
            <style>
        
        
        
        * {
    box-sizing: border-box;
}
.head {
    
    padding: 15px;
}

.vids {
    width: 30%;
    float: left;
    padding: 15px;
    
}
.login {
    width: 40%;
    float: left;
    padding: 15px;
   
}
.pics{

width: 30%;
    float: right;
    padding: 15px;
    
    }
        
        
        
        
        
.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 8px 16px;
    text-align:center;
    text-decoration: none;
    display: inline-block;
    font-size: 14px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}

.button1 {
    background-color: white; 
    color: black; 
    border: 2px solid #4CAF50;
}

.button1:hover {
    background-color: #4CAF50;
    color: white;
}

.button2 {
    background-color: white; 
    color: black; 
    border: 2px solid #4CAF50;
}

.button2:hover {
    background-color: #3366ff;
    color: white;
}





input[type=text], select {
    width: 20%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=password], select {
    width: 20%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 20px 28px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #111;
}

.active {
    background-color: #4CAF50;
}

video {
    
    max-width: 100%;
    
    
}





</style>
      
         <ul>
  <li><a href="index.jsp">Home</a></li>

   <li><a href="">Contact</a></li>
  
  <li style="float:right"><a class="active" href="admin.jsp">ADMIN</a></li>
</ul>
    <center>
    <body>
        <body background="image.jpg">
       
         <% String userInsert=(String)request.getAttribute("userInsert");
        student obj;
        if(request.getAttribute("Reportobj")!=null)
            obj=(student)request.getAttribute("Reportobj");
        else
            userInsert="0";
        if(userInsert==null)
            userInsert="0";
        %>
        <h5 style="color:red">                                                                              
        <% if(userInsert.equals("-1")) {%>>USER AUTHENTICATION FAILED<%}%></h5>
        <form action="studentValidation" Method="Post">
             <p><font size="5" color= blue>
        USERNAME:<br> 
       
         <input type="text" name="uname"><br>  
         <br>
         <br>
 PASSWORD:<br>
  <input type="Password" name="upassword" required><br>
  <br>
 
    <input type="Submit" name="Submit"  value="SUBMIT" style="font-size:15pt;color:white;background-color:red;border:2px solid blueviolet;padding:3px">
  
</form>
       <form action="newuser.jsp">
           <br>
   <input type="Submit" name="reg"  value="NEW REGISTRATION" style="font-size:15pt;color:white;background-color:red;border:2px solid blueviolet;padding:3px">
   <br>
   <br>
   <br>
   
   </form>
  
           <form action="studentValidation" Method="Post">   
       <input type="Submit" name="admin"  value="ADMIN" style="font-size:15pt;color:white;background-color:red;border:2px solid blueviolet;padding:3px"> 
       </form>
</body>
</center>
</html>

