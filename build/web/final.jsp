<%-- 
    Document   : final
    Created on : 18 Jul, 2017, 10:35:55 AM
    Author     : Chandrika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="mypackage.dto.student"%>
<%@page import="javax.servlet.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Students</title>
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

   <li><a href="">Contact</a></li>
    <li><a href="addclg.jsp">Add College</a></li>
    <li><a href="adddept.jsp">Add Department</a></li>
    <li><a href="updateclg.jsp">Update College</a></li>
    <li><a href="updatedept.jsp">Update Department</a></li>
  <li style="float:right"><a class="active" href="admin.jsp">ADMIN</a></li>
</ul>
    <body>
        <h1>List of Students</h1>
          <table cell padding="10" cell span="10" border="10" class="table table-box">
            <tr>
                <th style="width:200"> ROLL</th>          <!--th is column..nd td is onek glo td ekta th e likhi-->
                <th style="width:200"> NAME</th>
                <th style="width:200"> DEPT_ID</th>          <!--th is column..nd td is onek glo td ekta th e likhi-->
                <th style="width:200"> CLG_ID</th>
                <th style="width:200"> SEM</th>
                <th style="width:200"> SEM_MARKS</th>
                <th style="width:200"> EMAIL</th>
                <th style="width:200"> PASSWORD</th>
                <th style="width:200"> ADDRESS1</th>          <!--th is column..nd td is onek glo td ekta th e likhi-->
                <th style="width:200"> ADDRESS2</th>
                <th style="width:200"> CONTACT</th>
                <th style="width:200"> STUDENT_REG</th>
            </tr>
            <%! int noRecord=0; %>
           
            
          <c:forEach items="${Reportal}" var="list">       
<!--reportal hchhe jsp r alias..r list ta hchhe servlet er var ekhne for loop er jnne ulto bpr so list.get krbo--> 
           <tr>
            <td style="width:200">  <c:out value="${list.getRoll()}"/></td>
             <td style="width:200"> <c:out value="${list.getName()}"/></td>
             <td style="width:200">  <c:out value="${list.getDeptId()}"/></td>
             <td style="width:200"> <c:out value="${list.getClgId()}"/></td>
             <td style="width:200"> <c:out value="${list.getSem()}"/></td>
             <td style="width:200"> <c:out value="${list.getSemMarks()}"/></td>
             <td style="width:200"> <c:out value="${list.getEmail()}"/></td>
             <td style="width:200"> <c:out value="${list.getPassword()}"/></td>
             <td style="width:200">  <c:out value="${list.getAddress1()}"/></td>
             <td style="width:200"> <c:out value="${list.getAddress2()}"/></td>
             <td style="width:200"> <c:out value="${list.getContact()}"/></td>
             <td style="width:200"> <c:out value="${list.getStudentReg()}"/></td>
          <%noRecord=noRecord+1;%>
           </tr>
        </c:forEach>
           
            </table>
             
            <form action="studentValidation" Method="Post">
                <center>
                <br>
                <br>
                  <% String var_val=request.getParameter("COLLEGE");
                  if (var_val==null || var_val.isEmpty()) { var_val="0";} %>
                <p> SELECT COLLEGE: </p>
                 <select name="COLLEGE">
                
                <option value="0"<%if(var_val.equals("0")){%>selected="selected"<%}%>>ALL</option>
                <option value="117"<%if(var_val.equals("117")){%>selected="selected"<%}%>>RCCIIT</option>
                <option value="118"<%if(var_val.equals("118")){%>selected="selected"<%}%>>HERITAGE INSTITUTE OF TECHNOLOGY</option>
                <option value="119"<%if(var_val.equals("119")){%>selected="selected"<%}%>>BENGAL INSTITUTE OF TECHNOLOGY</option>
                <option value="120"<%if(var_val.equals("120")){%>selected="selected"<%}%>>JADAVPUR UNIVERSITY</option>
                <option value="121"<%if(var_val.equals("121")){%>selected="selected"<%}%>>Abacus University</option>
                 <option value="123"<%if(var_val.equals("123")){%>selected="selected"<%}%>>PAILAN</option>
                  <option value="124"<%if(var_val.equals("124")){%>selected="selected"<%}%>>IIEST</option>
                   <option value="125"<%if(var_val.equals("125")){%>selected="selected"<%}%>>KALYANI</option>
                    <option value="126"<%if(var_val.equals("126")){%>selected="selected"<%}%>>BP PODDAR</option>
                
            </select>
                <br><br>
                                
                  <% String var=request.getParameter("DEPARTMENT");
                  if (var==null) { var="0";} %>
                <p> SELECT DEPARTMENT </p>
                             <select name="DEPARTMENT">
                
                <option value="0"<%if(var.equals("0")){%>selected="selected"<%}%>>ALL</option>
                <option value="001"<%if(var.equals("001")){%>selected="selected"<%}%>>ECE</option>
                <option value="002"<%if(var.equals("002")){%>selected="selected"<%}%>>CSE</option>
                <option value="003"<%if(var.equals("003")){%>selected="selected"<%}%>>IT</option>
                <option value="004"<%if(var.equals("004")){%>selected="selected"<%}%>>EE</option>
                <option value="005"<%if(var.equals("005")){%>selected="selected"<%}%>>MCA</option>
                <option value="007"<%if(var.equals("007")){%>selected="selected"<%}%>>MECHANICAL</option>
                <option value="008"<%if(var.equals("008")){%>selected="selected"<%}%>>AEIE</option>
                <option value="006"<%if(var.equals("006")){%>selected="selected"<%}%>>BIOTECHNOLOGY</option>
                <option value="010"<%if(var.equals("010")){%>selected="selected"<%}%>>MICROBIOLOGY</option>
                <option value="011"<%if(var.equals("011")){%>selected="selected"<%}%>>CIVIL</option>
                
                
            </select>
                <br><br> <br>
                 <button style="color:black" type="submit" name="final" value="Final">SELECT</button>
                
                
                
                
                
                
                
                
                </center>
                
                
                
              </form>
            
    </body>
</html>
