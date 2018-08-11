<%-- 
    Document   : final
    Created on : 18 Jul, 2017, 10:35:55 AM
    Author     : Chandrika
--%>

<%@page import="mypackage.dto.department"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="mypackage.dto.student"%>
<%@page import="mypackage.dto.college"%>
<%@page import="javax.servlet.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Department</title>
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
    <center>
        <h1>List of Department</h1>
          <table cell padding="10" cell span="10" border="10" class="table table-box">
            <tr>
                <th style="width:200"> DEPT_ID</th>          
                <th style="width:200"> DEPT_NAME</th>
                <th style="width:200"> UPDATE DEPT NAME</th>
            </tr>
            <%ArrayList a=(ArrayList)request.getAttribute("Reportdept");
            String name1=""; 
            String id1="";
             String name2="";
             int i=0;
            %>
         <%for ( i=0;i<a.size();i++)
         {%>
            <% department b=(department)a.get(i); 
            name1=b.getDeptName();
             id1=b.getDeptId();
            name2=name1;
            
            
            %>
                       <tr>
                          <form action="studentValidation" method="Post">
                           <td> <input type="text" name="oldname" value="<%= name1 %>" readonly/></td>
                           <td> <input type="text" name="deptid<%=i%>" value="<%= id1 %>" readonly/></td>
                <td><input type="text" name="newname<%=i%>" value="<%= name1 %>"  required></td>
                    
           
                
                
                
            <%}%>
                      
            </tr>
              
              </table>
            <input type="hidden" name="sizelist" value="<%=i%>" >
                      <button style="color:black" type="submit" name="Done2" value="DONE">DONE</button>
            </form>       
 
          
           
       </center>      
        
    </body>
</html>
