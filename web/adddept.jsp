<%-- 
    Document   : addclg
    Created on : 20 Jul, 2017, 11:03:02 AM
    Author     : Chandrika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADD DEPT</title>
    </head>
    <body>
        <h1>NEW DEPT OF A PARTICULAR COLLEGE REGISTRATION PROCEDURE </h1>
        
                <form action="studentValidation" Method="Post">
                    
             <p><font size="5" color= blue>
        ENTER DEPT NAME:<br> 
       
         <input type="text" name="newdept"required><br>  
         <br>
         <br>
 ENTER DEPT ID:<br>
  <input type="Text" name="newdeptid" required><br>
  <br>
  <br>
    ENTER COLLEGE ID:<br> 
       
         <input type="text" name="newid"required><br>  
         <br>
         <br>
    <input type="Submit" name="Deptsubmit"  value="GO" style="font-size:15pt;color:white;background-color:red;border:2px solid blueviolet;padding:3px">
  
</form>

  
        
        
        
        
        
    </body>
</html>
