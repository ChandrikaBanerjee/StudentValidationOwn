/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypackage.dto;

/**
 *
 * @author Chandrika
 */
public class department {
    private String deptid;
    private String deptname;
 
 public void setDeptId(String deptid)
 {
     this.deptid=deptid;
 }
 public void setDeptName(String deptname)
 {
     this.deptname=deptname;
 }  
      public String getDeptId()
 {
     return deptid;
 }
    public String getDeptName()
 {
     return deptname;
 }
    
    
}