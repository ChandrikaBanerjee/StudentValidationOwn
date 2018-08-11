/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage.servlet;
import mypackage.dao.*;
import mypackage.dto.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static mypackage.helper.Md5Encryption.encrypt;

/**
 *
 * @author sanu
 */
public class studentValidation extends HttpServlet 
{
   student s; 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,SQLException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String did="",se="",sm="",cid="",em="",ad1="",ad2="",ct="",sg="",nme="",rol="",pw1="";
        String rl;
         validate s1=new validate();        
        if(request.getParameter("Submit")!=null)
        {
        System.out.println("Servlet called");
        String email=request.getParameter("uname");
        String password12=request.getParameter("upassword");
         
      String password="";
            try {
                password = encrypt(password12);
            } catch (Exception ex) {
                Logger.getLogger(studentValidation.class.getName()).log(Level.SEVERE, null, ex);
            }
       rl=request.getParameter("upassword");                          //double quoted session obj jsp te use r single ta sevlet
        request.getSession().setAttribute("uname",rl); //session obj
         if((password.isEmpty()) && (email.isEmpty()))
         {  
             System.out.println("NO DATA received");  

    }
         
      
        
        else
        System.out.println("NULL roll received");   
        
         
                
         
        s=s1.stdvalidate(password,email);
       
        if(s.getRowFetched()==0)
        {//default value of uninitialised integer is 0
           
         System.out.println(s.getRoll()+"\t"+s.getName()+"\t"+s.getDeptId()+"\t"+s.getClgId()+"\t"+s.getSem()+"\t"+s.getSemMarks()+"\t"+s.getEmail()+"\t"+s.getPassword()+"\t"+s.getAddress1()+"\t"+s.getAddress2()+"\t"+s.getContact()+"\t"+s.getStudentReg());
                request.setAttribute("userdata",s);
        request.getRequestDispatcher("userprint.jsp").forward(request, response);
        //processRequest(request, response);
        }
        
      
        else
        {
            System.out.println("Student does not exist");
                request.setAttribute("userInsert","-1");
            request.setAttribute("Reportobj",s);
        request.getRequestDispatcher("index.jsp").forward(request, response);   
}
        }
        else if((request.getParameter("update"))!=null)   //if we want to update the details of userprint page then passing the student object to the uodate pge
        {
             request.setAttribute("Reportobj1",s);
        request.getRequestDispatcher("update.jsp").forward(request, response);
         
            
        }
        else if((request.getParameter("updatesubmit1"))!=null)
        {
        System.out.println("FOR UPDATION");
        
        rol=request.getParameter("uproll");
        nme=request.getParameter("upname");
        did=request.getParameter("updeptid");
        cid=request.getParameter("upclgid");
        se=request.getParameter("upsem");
        sm=request.getParameter("upsemmarks");

        em=request.getParameter("upemail");
        pw1=request.getParameter("uppassword");
        ad1=request.getParameter("upadd1");
        ad2=request.getParameter("upadd2");
         ct=request.getParameter("upcontact");
         sg=request.getParameter("upstudentreg");
     
       
    validate s2=new validate();
      System.out.println("DONE");      
       String rl1=(String)request.getSession().getAttribute("uname");
     s=s2.update(rol,nme,did,cid,se,sm,em,pw1,ad1,ad2,ct,sg);
       request.setAttribute("userdata",s);
        request.getRequestDispatcher("userprint.jsp").forward(request, response);   
      
        }
        else if((request.getParameter("newsub"))!=null)
        {
            String npassword="";
            validate s3=new validate();
        System.out.println("NEW user");
       
       String nroll=request.getParameter("newroll");
        String nname=request.getParameter("newname");
                String ndeptid=request.getParameter("newdeptid");
       String nclgid=request.getParameter("newclgid");
       String nsem=request.getParameter("newsem");
       String nsemmarks=request.getParameter("newsemmarks");
       
       String nemail=request.getParameter("newemail");
       String npassword12=request.getParameter("newpassword");
            try {
                npassword=encrypt(npassword12);
            } catch (Exception ex) {
                Logger.getLogger(studentValidation.class.getName()).log(Level.SEVERE, null, ex);
            }
               String nadd1=request.getParameter("newadd1");
       String nadd2=request.getParameter("newadd2");
       String ncontact=request.getParameter("newcontact");
       String nstudentreg=request.getParameter("newstudentreg");
       
   if(s3.alreadyexists(nroll)){
    
         System.out.println("ROLL already exist");
                request.setAttribute("userInsert","-1");
            
        request.getRequestDispatcher("newuser.jsp").forward(request, response);   
   
   }
        
        
        else {
    validate s4=new validate();
      System.out.println("DONE 2");      
      student st1=new student();
     st1=s4.newuser(nroll,nname,ndeptid,nclgid,nsem,nsemmarks,nemail,npassword,nadd1,nadd2,ncontact,nstudentreg);
       System.out.println(st1.getRoll()+"\t"+st1.getName()+"\t"+st1.getDeptId()+"\t"+st1.getClgId()+"\t"+st1.getSem()+"\t"+st1.getSemMarks()+"\t"+st1.getEmail()+"\t"+st1.getPassword()+"\t"+st1.getAddress1()+"\t"+st1.getAddress2()+"\t"+st1.getContact()+"\t"+st1.getStudentReg());
        request.setAttribute("userdata",st1);
        request.getRequestDispatcher("userprint.jsp").forward(request,response);   
      }
        }
   else if((request.getParameter("admin"))!=null)
           {
               System.out.println("yes");
               student ss = null;
                request.setAttribute("useradmin",ss);
                request.getRequestDispatcher("admin.jsp").forward(request,response); 
           }
   else if((request.getParameter("Login1"))!=null)
   {
       String user;
   String pw;
        validate s4=new validate();
       System.out.println("Super user");
       
        user=request.getParameter("userid");
       
            pw = request.getParameter("userpw");
       System.out.println(user+"\t"+pw);
     
            try {
                if(s4.check(user,pw))
                {
                    System.out.println("yes");
                    
                    ArrayList list=new ArrayList();
                    validate v=new validate();
                    list=v.insert();                                   //ekhanei hbe
                    student ob1=new student();
                    for(int i=0;i<7;i++) 
                    {
                        ob1=(student)list.get(i);            //norml array te a[i] kre we cn access i th elemnt but arraylust e .get(i) use krte hoe to access i th elmnt of list
                        System.out.println("\n\n"+ob1.getRoll()+"\t"+ob1.getName()+"\t"+ob1.getDeptId()+"\t"+ob1.getClgId()+"\t"+ob1.getSem()+"\t"+ob1.getSemMarks()+"\t"+ob1.getEmail()+"\t"+ob1.getPassword()+"\t"+ob1.getAddress1()+"\t"+ob1.getAddress2()+"\t"+ob1.getContact()+"\t"+ob1.getStudentReg());
                    }
                    System.out.println("admin exists");
                     request.setAttribute("Reportal",list);
                    request.getRequestDispatcher("final.jsp").forward(request, response);
                }
                 else
                {
                     System.out.println("INVALID ADMIN");
                    request.setAttribute("userInsert","-1");
                    request.setAttribute("Reported",s);
                    request.getRequestDispatcher("admin.jsp").forward(request, response); 
                }
            } catch (SQLException ex) {
                Logger.getLogger(studentValidation.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(studentValidation.class.getName()).log(Level.SEVERE, null, ex);
            }
                   
                     
                }
  
                
       else if((request.getParameter("final"))!=null){
            String s=request.getParameter("COLLEGE");
            System.out.println(s);
            
                        String ss=request.getParameter("DEPARTMENT");
            System.out.println(ss);
            validate v1=new validate();
            
                ArrayList arr=v1.sorted(s,ss);
                 
                    student ob2=new student();
                    for(int i=0;i<arr.size();i++) 
                    {
                        ob2=(student)arr.get(i);            //norml array te a[i] kre we cn access i th elemnt but arraylust e .get(i) use krte hoe to access i th elmnt of list
                        System.out.println("\n\n"+ob2.getRoll()+"\t"+ob2.getName()+"\t"+ob2.getDeptId()+"\t"+ob2.getClgId()+"\t"+ob2.getSem()+"\t"+ob2.getSemMarks()+"\t"+ob2.getEmail()+"\t"+ob2.getPassword()+"\t"+ob2.getAddress1()+"\t"+ob2.getAddress2()+"\t"+ob2.getContact()+"\t"+ob2.getStudentReg());
                    }
                    System.out.println("Sorted");
                     request.setAttribute("Reportal",arr);
                    request.getRequestDispatcher("final.jsp").forward(request, response);
                }
       else if((request.getParameter("Newsubmit"))!=null) 
       {
                       String clg=request.getParameter("newcollege");
            System.out.println(clg);
            
                        String clgid=request.getParameter("newid");
            System.out.println(clgid);
            validate s5=new validate();
            if(s5.checkclgexists(clgid))
            {
                     request.getRequestDispatcher("addclg.jsp").forward(request, response); 
            }
            else
            {
                s5.addclg(clgid,clg);
          
                     validate v1=new validate();
                   ArrayList list1=v1.inserttocollege(); 
                       request.setAttribute("Report1",list1);
                    request.getRequestDispatcher("showclg.jsp").forward(request, response);
                    
                    
            }
            }
                  else if((request.getParameter("Deptsubmit"))!=null) 
       {
                       String dept=request.getParameter("newdept");
            System.out.println(dept);
            
                        String deptid=request.getParameter("newdeptid");
            System.out.println(deptid);
                                 String newclgid=request.getParameter("newid");
            System.out.println(newclgid);
            validate s6=new validate();
            if(!s6.checkclgexists(newclgid))
            {
                request.getRequestDispatcher("adddept.jsp").forward(request, response); 
            }
                
           else if(s6.checkdeptexists(deptid,newclgid))
            {
                     request.getRequestDispatcher("adddept.jsp").forward(request, response);               // flag 1 retrn kre oi pge i  return krche
            }
           else 
            {
                
           s6.adddept(deptid,dept,newclgid);
            validate v1=new validate();
                   ArrayList list1=v1.inserttodept(); 
                       request.setAttribute("Report2",list1);
                    request.getRequestDispatcher("showdept.jsp").forward(request, response);
                    
                
                
                
            }
            //else (if not exists age tahole go to pmethod of inserting dept den send it to home page
            }
               else if((request.getParameter("click"))!=null)
               {
                     ArrayList list=new ArrayList();
                    validate v=new validate();
                    list=v.inserttocollege();                                   //ekhanei hbe
                    college ob1=new college();
                    for(int i=0;i<list.size();i++) 
                    {
                        ob1=(college)list.get(i);            //norml array te a[i] kre we cn access i th elemnt but arraylust e .get(i) use krte hoe to access i th elmnt of list
                        System.out.println("\n\n"+ob1.getClgId()+"\t"+ob1.getClgName());
                    }
                    System.out.println("GO");
                     request.setAttribute("Reportclg",list);
                    request.getRequestDispatcher("updatedcollege.jsp").forward(request, response);
                }
                
                  else if(request.getParameter("Done")!=null){
                    
                   String y=request.getParameter("sizelist");
                   int s=Integer.parseInt(y);
                   String n[]=new String[s];
                   String id[]=new String[s];
                    
                    for(int i=0;i<s;i++)
                    {
                        n[i]=(String)request.getParameter("newname"+i);
                        id[i]=(String)request.getParameter("colgid"+i);
                        System.out.println(n[i]+"\t"+id[i]);
                    }
                    validate v=new validate();
                    v.updatecolgrecord(n,id);
                     ArrayList list1=new ArrayList();
                    validate v1=new validate();
                    list1=v1.inserttocollege(); 
                       request.setAttribute("Report1",list1);
                    request.getRequestDispatcher("showclg.jsp").forward(request, response);
                    
                    
                }
                    else if((request.getParameter("click1"))!=null)
               {
                     ArrayList list=new ArrayList();
                    validate v=new validate();
                    list=v.inserttodept();  
                    //ekhanei hbe
                    department d=new department();
                    for(int i=0;i<list.size();i++) 
                    {
                        d=(department)list.get(i);            //norml array te a[i] kre we cn access i th elemnt but arraylust e .get(i) use krte hoe to access i th elmnt of list
                        System.out.println("\n\n"+d.getDeptId()+"\t"+d.getDeptName());
                    }
                    System.out.println("Proceed");
                     request.setAttribute("Reportdept",list);
                    request.getRequestDispatcher("updateddept.jsp").forward(request, response);
                }
                      else if(request.getParameter("Done2")!=null){
                    
                   String y=request.getParameter("sizelist");
                   int s=Integer.parseInt(y);
                   String n[]=new String[s];
                   String id[]=new String[s];
                    
                    for(int i=0;i<s;i++)
                    {
                        n[i]=(String)request.getParameter("newname"+i);
                        id[i]=(String)request.getParameter("deptid"+i);
                        System.out.println(n[i]+"\t"+id[i]);
                    }
                    validate v=new validate();
                    v.updatedeptrecord(n,id);
                       ArrayList list1=new ArrayList();
                    validate v1=new validate();
                    list1=v1.inserttodept(); 
                       request.setAttribute("Report2",list1);
                    request.getRequestDispatcher("showdept.jsp").forward(request, response);
                    
                    
                }
                   
                   
                   
      /**       
                 * 
                 * 
                 * 
                 * Returns a short description of the servlet.
                 *
                 * @return a String containing servlet description
                 */
                //@Override
                // public String getServletInfo() {
                //return "Short description";
            } 
    }

    
    /** 
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    //@Override
   // public String getServletInfo() {
        //return "Short description";
    
    




