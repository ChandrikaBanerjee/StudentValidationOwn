<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>UPDATE DETAILS</title>
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





input[type=text1], select {
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

   <li><a href="admin.jsp">Contact</a></li>
  
  <li style="float:right"><a class="active" href="admin.jsp">ADMIN</a></li>
</ul>
       <% String rll=(String)request.getSession().getAttribute("uname"); %>
    <center>
    <body>
        <body style="background-color:papayawhip;">
        <h1 style="color:blue;">STUDENT VALIDATION</h1>
       <form action="studentValidation" Method="Post">
           <p><font size="5" color=magenta>
            
 ROLL:<br>
 <input type="Text" name="uproll" value="${Reportobj1.getRoll()}" readonly> <br>
         NAME:<br> 
         <input type="text" name="upname" value="${Reportobj1.getName()}"required><br>  
         DEPT_ID:<br>
         <input type="Text" name="updeptid" value="${Reportobj1.getDeptId()}"required> <br>
          CLG_ID:<br>
         <input type="Text" name="upclgid" value="${Reportobj1.getClgId()}"readonly> <br>
  SEM:<br>
  <input type="Text" name="upsem" value="${Reportobj1.getSem()}"required><br>
   SEMMARKS:<br>
  <input type="Text" name="upsemmarks" value="${Reportobj1.getSemMarks()}"readonly><br>
   EMAIL:<br>
 <input type="Text" name="upemail" value="${Reportobj1.getEmail()}"required> <br>
         PASSWORD:<br> 
         <input type="text" name="uppassword" value="${Reportobj1.getPassword()}"required><br>  
         ADDRESS1:<br>
         <input type="Text" name="upadd1" value="${Reportobj1.getAddress1()}"required> <br>
  ADDRESS2:<br>
  <input type="Text" name="upadd2" value="${Reportobj1.getAddress2()}"required><br>
   CONTACT:<br>
  <input type="Text" name="upcontact" value="${Reportobj1.getContact()}"required><br>
  STUDENT_REG:<br>
 <input type="Text" name="upstudentreg" value="${Reportobj1.getStudentReg()}"required> <br>

<input type="Submit" name="updatesubmit1"  value="SUBMIT" style="font-size:10pt;color:white;background-color:yellowgreen;border:2px solid blueviolet;padding:3px">
            

    </body>
    </center>
</html>
