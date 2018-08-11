<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>USER INFORMATION</title>
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
    <center>
    <body>
        <body background="im.jpg">
        <h1>Student Exists</h1>
        <% String rl1=(String)request.getSession().getAttribute("uname");%>
        <table cell padding="10" cell span="10" border="10" class="table table-box">
            <tr>
                <th style="width:200"> ROLL</th>
                <th style="width:200"> NAME</th>
                <th style="width:200"> DEPT_ID</th>
                <th style="width:200"> CLG_ID</th>
                <th style="width:200"> SEM</th>
                <th style="width:200"> SEM_MARKS</th>
                <th style="width:200"> EMAIL_ID</th>
                <th style="width:200"> PASSWORD</th>
                <th style="width:200"> ADDRESS1</th>
                <th style="width:200"> ADDRESS2</th>
                <th style="width:200"> CONTACT</th>
                <th style="width:200"> STUDENT_REG</th>
            </tr>
            <%! int noRecord=0; %>
        <tr>
            <td style="width:200"> <c:out value="${userdata.getRoll()}"/></td>
             <td style="width:200"> <c:out value="${userdata.getName()}"/></td>
             <td style="width:200"> <c:out value="${userdata.getDeptId()}"/></td>
              <td style="width:200"> <c:out value="${userdata.getClgId()}"/></td>
            <td style="width:200"> <c:out value="${userdata.getSem()}"/></td>
             <td style="width:200"> <c:out value="${userdata.getSemMarks()}"/></td>
             <td style="width:200"> <c:out value="${userdata.getEmail()}"/></td>
              <td style="width:200"> <c:out value="${userdata.getPassword()}"/></td>
              <td style="width:200"> <c:out value="${userdata.getAddress1()}"/></td>
             <td style="width:200"> <c:out value="${userdata.getAddress2()}"/></td>
             <td style="width:200"> <c:out value="${userdata.getContact()}"/></td>
              <td style="width:200"> <c:out value="${userdata.getStudentReg()}"/></td>
        </tr>
            </table>
             <form action="index.jsp">
      <br>
      <br>
               
                 <input type="Submit"  value="LOGOUT" style="font-size:20pt;color:white;background-color:red;border:2px solid #336600;padding:3px">
            
                 
</form>
        <form action="studentValidation" method="Post">
            <br>
            <br>
         <input type="Submit" name="update" value="UPDATE" style="font-size:20pt;color:white;background-color:red;border:2px solid #336600;padding:3px">
        </form>

    </body>
    </center>
</html>
