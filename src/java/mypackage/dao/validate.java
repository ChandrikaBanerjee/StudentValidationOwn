package mypackage.dao;
import java.sql.*;
import java.util.ArrayList;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.Scanner;
import mypackage.dto.*;
public class validate {
     student s1=new student();
       public void updatedeptrecord(String []n,String []id)
     {
           department s2=new department();
         try{
       
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
     Connection con1 = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:16000;databaseName=TRAINING;user=sa;password=12345");




  
     System.out.println("Connected to database !");
     Statement stmt1=con1.createStatement();
            System.out.println(id.length);
   
   for(int i=0;i<id.length;i++){
            String sqlstmt1="UPDATE DEPT SET DEPT_NAME='"+n[i]+"' where DEPT_ID='"+id[i]+"'";
                  PreparedStatement stmt2=con1.prepareStatement(sqlstmt1);
                  stmt2.executeUpdate();
            

     
         }
         }
       catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }
          
     }   
     
             public ArrayList inserttodept()
    {
        
   ArrayList cl = new ArrayList();
 
   
    try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
     Connection concl = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:16000;databaseName=TRAINING;user=sa;password=12345");




  
     System.out.println("Connected to database for alist !");
        Statement stmtcl = concl.createStatement();
         ResultSet rscl=stmtcl.executeQuery("select distinct DEPT_ID,DEPT_NAME from DEPT"); //distinct wse
       

        while (rscl.next()) {
              department c=new department();
       
             c.setDeptId(rscl.getString(1));
             c.setDeptName(rscl.getString(2));
            
            cl.add(c);
        }

        rscl.close();
    } 
    catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }

    return cl;
}
     public void updatecolgrecord(String []n,String []id)
     {
           college s2=new college();
         try{
       
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
     Connection con1 = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:16000;databaseName=TRAINING;user=sa;password=12345");




  
     System.out.println("Connected to database !");
     Statement stmt1=con1.createStatement();
            System.out.println(id.length);
   
   for(int i=0;i<id.length;i++){
            String sqlstmt1="UPDATE CLG SET CLG_NAME='"+n[i]+"' where CLG_ID='"+id[i]+"'";
                  PreparedStatement stmt2=con1.prepareStatement(sqlstmt1);
                  stmt2.executeUpdate();
            

     
         }
         }
       catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }
          
     }   
     

     
     
        public ArrayList inserttocollege()
    {
        
   ArrayList cl = new ArrayList();
 
   
    try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
     Connection concl = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:16000;databaseName=TRAINING;user=sa;password=12345");




  
     System.out.println("Connected to database for alist !");
        Statement stmtcl = concl.createStatement();
         ResultSet rscl=stmtcl.executeQuery("select * from CLG"); //distinct wse
       

        while (rscl.next()) {
              college c=new college();
       
             c.setClgId(rscl.getString(1));
             c.setClgName(rscl.getString(2));
            
            cl.add(c);
        }

        rscl.close();
    } 
    catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }

    return cl;
}
    public ArrayList sort(String college,String department)
    {
        ArrayList al = new ArrayList();
 
   
    try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
     Connection conal = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:16000;databaseName=TRAINING;user=sa;password=12345");




  
     System.out.println("Connected to database for alist !");
        Statement stmtal = conal.createStatement();
         ResultSet rsal=stmtal.executeQuery("select * from MYIBMPRO");
       

        while (rsal.next()) {
              student s=new student();
       if(college.equals(rsal.getString(4)) && department.equals(rsal.getString(3)))
       {
             s.setRoll(rsal.getString(1));
             s.setName(rsal.getString(2));
             s.setDeptId(rsal.getString(3)); 
             s.setClgId(rsal.getString(4)); 
             s.setSem(rsal.getString(5));
             s.setSemMarks(rsal.getString(6));
             s.setEmail(rsal.getString(7));
             s.setPassword(rsal.getString(8));
             s.setAddress1(rsal.getString(9));
             s.setAddress2(rsal.getString(10));
             s.setContact(rsal.getString(11));
             s.setStudentReg(rsal.getString(12));
           
            al.add(s);
       }
        }

       
    } 
    catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }

    return al;  
    
    }
    public  student stdvalidate(String password,String email)
    {
       
     try{
       
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
     Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:16000;databaseName=TRAINING;user=sa;password=12345");




  
     System.out.println("Connected to database !");
     Statement stmt=con.createStatement();
     ResultSet rs=stmt.executeQuery("select * from MYIBMPRO");
     int flag=0;
     while(rs.next())
     {
         
         if((rs.getString(8).equals(password)) && (rs.getString(7).equalsIgnoreCase(email)))
         {
             
             s1.setRoll(rs.getString(1));
             s1.setName(rs.getString(2));
             s1.setDeptId(rs.getString(3)); 
             s1.setClgId(rs.getString(4)); 
             s1.setSem(rs.getString(5));
             s1.setSemMarks(rs.getString(6));
             s1.setEmail(rs.getString(7));
             s1.setPassword(rs.getString(8));
             s1.setAddress1(rs.getString(9));
             s1.setAddress2(rs.getString(10));
             s1.setContact(rs.getString(11));
             s1.setStudentReg(rs.getString(12));
             flag=1;
             
         }
         else if((rs.getString(8).equals(password)) && email.equals("") )
         {
             
             s1.setRoll(rs.getString(1));
             s1.setName(rs.getString(2));
             s1.setDeptId(rs.getString(3)); 
             s1.setClgId(rs.getString(4)); 
             s1.setSem(rs.getString(5));
             s1.setSemMarks(rs.getString(6));
             s1.setEmail(rs.getString(7));
             s1.setPassword(rs.getString(8));
             s1.setAddress1(rs.getString(9));
             s1.setAddress2(rs.getString(10));
             s1.setContact(rs.getString(11));
             s1.setStudentReg(rs.getString(12));
             flag=1;
         }
         else if((password.equals("")) && (rs.getString(7).equalsIgnoreCase(email)) )
         {
             
             s1.setRoll(rs.getString(1));
             s1.setName(rs.getString(2));
             s1.setDeptId(rs.getString(3)); 
             s1.setClgId(rs.getString(4)); 
             s1.setSem(rs.getString(5));
             s1.setSemMarks(rs.getString(6));
             s1.setEmail(rs.getString(7));
             s1.setPassword(rs.getString(8));
             s1.setAddress1(rs.getString(9));
             s1.setAddress2(rs.getString(10));
             s1.setContact(rs.getString(11));
             s1.setStudentReg(rs.getString(12));
             flag=1;
         }
         }
      if(flag==0)
          s1.setRowFetched(1);
     
    }
   catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }
        return s1;
    }
     public  student update(String roll,String name,String deptid,String clgid,String sem,String semmarks,String email,String password,String address1,String address2,String contact,String studentreg)
     {
         
         student s2=new student();
         try{
       
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
     Connection con1 = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:16000;databaseName=TRAINING;user=sa;password=12345");




  
     System.out.println("Connected to database !");
     Statement stmt1=con1.createStatement();
            
   
            String sqlstmt1="UPDATE MYIBMPRO SET ROLL='"+roll+"',NAME='"+name+"',DEPT_ID='"+deptid+"',CLG_ID='"+clgid+"',SEM='"+sem+"',SEM_MARKS='"+semmarks+"',PASSWORD1='"+password+"',ADDRESS1='"+address1+"',ADDRESS2='"+address2+"',CONTACT='"+contact+"',STUDENT_REG='"+studentreg+"' WHERE EMAIL_ID='"+email+"'";
                  PreparedStatement stmt2=con1.prepareStatement(sqlstmt1);
                 int x= stmt2.executeUpdate();
            System.out.println(x);

            
             s2.setRoll(roll);
             s2.setName(name);
             s2.setDeptId(deptid); 
             s2.setClgId(clgid); 
             s2.setSem(sem);
             s2.setSemMarks(semmarks);
             s2.setEmail(email);
             s2.setPassword(password);
             s2.setAddress1(address1);
             s2.setAddress2(address2);
             s2.setContact(contact);
             s2.setStudentReg(studentreg);
     
         }
       catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }
        return s2;    
     }
     public boolean alreadyexists(String roll)
     {
         
       int f=0;
           try{
       
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
     Connection con3 = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:16000;databaseName=TRAINING;user=sa;password=12345");




  
     
     Statement stmt3=con3.createStatement();
     ResultSet rs3=stmt3.executeQuery("select * from MYIBMPRO");
     System.out.println("Going for check!");
          while(rs3.next())
     {
     
        if(roll.equals(rs3.getString(1)))
                {
                    System.out.println("ALREADY EXISTS");
                    f=1;
                }        
     }
           }
      catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }
           if(f==1)
        return true;
           else 
               return false;
     }
                 
     public student newuser(String roll,String name,String deptid,String clgid,String sem,String semmarks,String email,String password,String address1,String address2,String contact,String studentreg)
     {
         student s3=new student();
            
     try{
       
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
     Connection con4 = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:16000;databaseName=TRAINING;user=sa;password=12345");




  
     System.out.println("Connected to database !");
     Statement stmt4=con4.createStatement();
      ResultSet rs4=stmt4.executeQuery("select * from MYIBMPRO");
      rs4.next();
      String sqlstmt2="INSERT INTO MYIBMPRO(ROLL,NAME,DEPT_ID,CLG_ID,SEM,SEM_MARKS,EMAIL_ID,PASSWORD1,ADDRESS1,ADDRESS2,CONTACT,STUDENT_REG) VALUES('"+roll+"','"+name+"','"+deptid+"','"+clgid+"','"+sem+"','"+semmarks+"','"+email+"','"+password+"','"+address1+"','"+address2+"','"+contact+"','"+studentreg+"')";
                  PreparedStatement stmt3=con4.prepareStatement(sqlstmt2);
                 int x= stmt3.executeUpdate();
            System.out.println("Succesfully Inserted.");

             s3.setRoll(roll);
             s3.setName(name);
             s3.setDeptId(deptid); 
             s3.setClgId(clgid); 
             s3.setSem(sem);
             s3.setSemMarks(semmarks);
             s3.setEmail(email);
             s3.setPassword(password);
             s3.setAddress1(address1);
             s3.setAddress2(address2);
             s3.setContact(contact);
             s3.setStudentReg(studentreg);
     
         }
       catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }
        return s3;    
     }
    public boolean check(String user,String pw) throws SQLException, ClassNotFoundException
    {
 int flag=0;          
       
     try{
       
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
     Connection consp = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:16000;databaseName=TRAINING;user=sa;password=12345");




  
     System.out.println("Connected to database for super !");
     Statement stmtsp=consp.createStatement();
     ResultSet rssp=stmtsp.executeQuery("select * from ADMIN3");

     while(rssp.next())
     {
         
         if((rssp.getString(1).equals(user)) && (rssp.getString(2).equals(pw)))
         {
       
             flag=1;
        
            break;
             
           }
    
    }
     }
   catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }
      
       if(flag==1)
          return true;
      else
          return false; 
 
    }
    public ArrayList insert()
    {
        
   ArrayList al = new ArrayList();
 
   
    try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
     Connection conal = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:16000;databaseName=TRAINING;user=sa;password=12345");




  
     System.out.println("Connected to database for alist !");
        Statement stmtal = conal.createStatement();
         ResultSet rsal=stmtal.executeQuery("select * from MYIBMPRO");
       

        while (rsal.next()) {
              student s=new student();
       
             s.setRoll(rsal.getString(1));
             s.setName(rsal.getString(2));
             s.setDeptId(rsal.getString(3)); 
             s.setClgId(rsal.getString(4)); 
             s.setSem(rsal.getString(5));
             s.setSemMarks(rsal.getString(6));
             s.setEmail(rsal.getString(7));
             s.setPassword(rsal.getString(8));
             s.setAddress1(rsal.getString(9));
             s.setAddress2(rsal.getString(10));
             s.setContact(rsal.getString(11));
             s.setStudentReg(rsal.getString(12));
           
            al.add(s);
        }

        rsal.close();
    } 
    catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }

    return al;
}
    public ArrayList sorted(String college,String department)
    {
        ArrayList al = new ArrayList();
 
   
    try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
     Connection conal = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:16000;databaseName=TRAINING;user=sa;password=12345");




  
     System.out.println("Connected to database for alist !");
        Statement stmtal = conal.createStatement();
         ResultSet rsal=stmtal.executeQuery("select * from MYIBMPRO");
       

        while (rsal.next()) {
              student s=new student();
       if(college.equals(rsal.getString(4)) && department.equals(rsal.getString(3)))
       {
             s.setRoll(rsal.getString(1));
             s.setName(rsal.getString(2));
             s.setDeptId(rsal.getString(3)); 
             s.setClgId(rsal.getString(4)); 
             s.setSem(rsal.getString(5));
             s.setSemMarks(rsal.getString(6));
             s.setEmail(rsal.getString(7));
             s.setPassword(rsal.getString(8));
             s.setAddress1(rsal.getString(9));
             s.setAddress2(rsal.getString(10));
             s.setContact(rsal.getString(11));
             s.setStudentReg(rsal.getString(12));
           
            al.add(s);
       }
        }

       
    } 
    catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }

    return al;  
    
    }
       public boolean checkclgexists(String clgid)
     {
         
       int f=0;
           try{
       
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
     Connection con3 = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:16000;databaseName=TRAINING;user=sa;password=12345");




  
     
     Statement stmt3=con3.createStatement();
     ResultSet rs3=stmt3.executeQuery("select * from CLG");
     System.out.println("Going for checking existence of clg!");
          while(rs3.next())
     {
     
        if(clgid.equals(rs3.getString(1)))
                {
                    System.out.println("ALREADY EXIST");
                    f=1;
                }        
     }
           }
      catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }
           if(f==1)
        return true;
           else 
               return false;
     }
            public void addclg(String clgid,String clg)
     {
       
            
     try{
       
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
     Connection con4 = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:16000;databaseName=TRAINING;user=sa;password=12345");




  
     System.out.println("Connected to database !");
     Statement stmt4=con4.createStatement();
      ResultSet rs4=stmt4.executeQuery("select * from CLG");
      rs4.next();
      String sqlstmt2="INSERT INTO CLG(CLG_ID,CLG_NAME) VALUES('"+clgid+"','"+clg+"')";
                  PreparedStatement stmt3=con4.prepareStatement(sqlstmt2);
                 int x= stmt3.executeUpdate();
            System.out.println("Succesfully Added clg.");

            
     
         }
       catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }
         
     }
      public boolean checkdeptexists(String deptid,String newclgid)
     {
         
       int f=0;
           try{
       
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
     Connection con3 = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:16000;databaseName=TRAINING;user=sa;password=12345");




  
     System.out.println(deptid+"\t"+newclgid);
     Statement stmt3=con3.createStatement();
     ResultSet rs3=stmt3.executeQuery("select * from DEPT ");

     System.out.println("Going for checking existence of dept in a particular college!");
          while(rs3.next())
     {
         
        if(newclgid.equals(rs3.getString(3)) && deptid.equals(rs3.getString(1))  )
                {
                    System.out.println(deptid+"\t"+newclgid);
                    System.out.println("ALREADY EXISTS");
                    f=1;
                    break;
                }
        
                 // only clg id check if exists in the clg table or not..   (not equal check)   if invlid true else false     
     }
          
           }
      catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }
           if(f==1)
        return true;
           else 
               return false;
     }
                  public void adddept(String deptid,String dept,String newclgid)
     {
       
            
     try{
       
     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
     Connection con4 = DriverManager.getConnection("jdbc:sqlserver://localhost\\SQLEXPRESS:16000;databaseName=TRAINING;user=sa;password=12345");




  
     System.out.println("Connected to database !");
     Statement stmt4=con4.createStatement();
      ResultSet rs4=stmt4.executeQuery("select * from DEPT");
      rs4.next();
      String sqlstmt2="INSERT INTO DEPT(DEPT_ID,DEPT_NAME,CLG_ID) VALUES('"+deptid+"','"+dept+"','"+newclgid+"')";
                  PreparedStatement stmt3=con4.prepareStatement(sqlstmt2);
                 int x= stmt3.executeUpdate();
            System.out.println("Succesfully Added Dept.");

            
     
         }
       catch(SQLException sqle) {
      System.out.println("Sql Exception :"+sqle.getMessage());
   }
   catch(ClassNotFoundException e) {
    System.out.println("Class Not Found Exception :" + e.getMessage());
   }
         
     }
    }



             
