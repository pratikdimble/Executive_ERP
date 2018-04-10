package com.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.erp.delegate.EmployeeOperationsBusinessDelegate;
import com.erp.delegate.ProductOperationsBusinessDelegate;
import com.erp.domain.LoginMaster;
import com.erp.dto.EmployeeDTO;
import com.erp.dto.LoginDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

//@WebServlet("/controller")
public class EmployeeControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       EmployeeOperationsBusinessDelegate delegate=null;
       List<EmployeeDTO> listEmployeeDTOs=null;
       List<EmployeeDTO> listEmpDTOs=null;
       List<LoginDTO>listLogin=null;
       List<EmployeeDTO> findEmployeeDTOs=null;
       RequestDispatcher rd=null;
       String employeeRemovalMsg=null;
       String empName=null,empAddr=null,empCity=null,designation=null,department=null,qualification=null,
    		   			workExp=null,doj=null,empMail=null,empUsername=null,empPassword=null;
       int empId=0,pin=0,loginId=0;
       long mobile=0;
         String insertResult=null;
         PrintWriter out=res.getWriter();
         HttpSession session = req.getSession();
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new EmployeeOperationsBusinessDelegate();
    	try{
    	listEmployeeDTOs=delegate.getAllEmployee();
    	req.setAttribute("listEmployeeDTOs",listEmployeeDTOs);
    	rd=req.getRequestDispatcher("/list_employee.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }
    	 else if(pval.equalsIgnoreCase("link2")){
    	try{
        	listEmpDTOs=delegate.getAllEmployee();
        	req.setAttribute("listEmployeeDTOs",listEmpDTOs);
        	rd=req.getRequestDispatcher("/empdetails.jsp");
        	rd.forward(req,res);
        	}
        	catch(InternalProblemException ipe){
        		req.setAttribute("errMsg",ipe.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res);
        	}
      }//if
         else if(pval.equalsIgnoreCase("Edit Profile")){
         	delegate=new EmployeeOperationsBusinessDelegate();
         	try{
         		
         		String thisUser = (String) session.getAttribute("myUser");
         		System.out.println("*******"+thisUser);
         	listEmpDTOs=delegate.getEmployee(thisUser);
         	listLogin=delegate.getEmployeeLogin(thisUser);
         	req.setAttribute("listEmployeeDTOs",listEmpDTOs);
         	req.setAttribute("listLogin",listLogin);
         	rd=req.getRequestDispatcher("/update_emp_form.jsp");
         	rd.forward(req,res);
         	}
         	catch(InternalProblemException ipe){
         		req.setAttribute("errMsg",ipe.getMessage());
         		rd=req.getRequestDispatcher("/error.jsp");
         		rd.forward(req,res);
         	}
           }//if
         else if(pval.equalsIgnoreCase("Back")){
          	delegate=new EmployeeOperationsBusinessDelegate();

          		
          		String thisRole = (String) session.getAttribute("role");
          		 out.println("<script type=\"text/javascript\">");
                 	if(thisRole.equalsIgnoreCase("Product Executive"))
                 	{
                 		out.println("location='prod_exec_firstpage.jsp';");
                 	}
                 	else if(thisRole.equalsIgnoreCase("Service Executive"))
                 	{
                 		out.println("location='service_exec_firstpage.jsp';");
                 	}
                 	else if(thisRole.equalsIgnoreCase("Purchase Manager"))
                 	{
                 		out.println("location='purchase_manager_firstpage.jsp';");
                 	}
                 	else if(thisRole.equalsIgnoreCase("Sales Manager"))
                 	{
                 		out.println("location='salesmanagerfirstpage.jsp';");
                 	}
                 	else if(thisRole.equalsIgnoreCase("Product Manager"))
                 	{
                 		out.println("location='prod_manager_firstpage.jsp';");
                 	}
                 	else if(thisRole.equalsIgnoreCase("Service Manager"))
                 	{
                 		out.println("location='service_manager_firstpage.jsp';");
                 	}
                 	else
                 	{
                 		out.println("location='home.jsp';");
                 	}
                 	
                 out.println("</script>");

            }//if
    //condition for ADD
        else if(pval.equalsIgnoreCase("Register")){
    	  empName=req.getParameter("name");
    	  empAddr=req.getParameter("permenent");
    	  empUsername=req.getParameter("uname");
    	  empPassword=req.getParameter("password");
    	  empCity=req.getParameter("city");
    	  pin=Integer.parseInt(req.getParameter("pin"));
    	  
    	  designation=req.getParameter("dsgn");
    	  department=req.getParameter("dept");
    	  qualification=req.getParameter("qual");
    	  workExp=req.getParameter("exp");

    	  doj=req.getParameter("date");
    	  
    	  mobile=Long.parseLong(req.getParameter("mob"));
    	  empMail=req.getParameter("email");
   	  
    	  
    	//use Delegage
    	  delegate=new EmployeeOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addEmployee(empName, empAddr, empCity, pin, designation,department, qualification, workExp, doj, mobile, empMail,empUsername,empPassword);
          req.setAttribute("insertMsg",insertResult);
          	rd=req.getRequestDispatcher("/emp_ack.jsp");
  				rd.forward(req,res);
          
          
          listEmployeeDTOs=delegate.getAllEmployee();
          req.setAttribute("listEmployeeDTOs",listEmployeeDTOs);
          
         	rd=req.getRequestDispatcher("/list_employee.jsp");
          	rd.forward(req,res);

    	  }//try close
    	  catch(InsertOperationProblemException iop){
    		  req.setAttribute("errMsg",iop.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res); 
    	  }//catch
    	  catch(InternalProblemException ipe){
    		  req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res); 
    	  }//catch
    	  catch(Exception e){
    		  req.setAttribute("errMsg",e.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res);   
    	  }//catch
    	  
      }//else-->if
        else if(pval.equalsIgnoreCase("Save")){
        	loginId=Integer.parseInt(req.getParameter("loginid"));
        	empId=Integer.parseInt(req.getParameter("empid"));
      	  empName=req.getParameter("name");
      	  empAddr=req.getParameter("permenent");
      	  //empUsername=req.getParameter("uname");
      	  //empPassword=req.getParameter("password");
      	  empCity=req.getParameter("city");
      	  pin=Integer.parseInt(req.getParameter("pin"));
      	  
      	  designation=req.getParameter("dsgn");
      	  qualification=req.getParameter("qual");
      	  workExp=req.getParameter("exp");

      	  doj=req.getParameter("date");
      	  
      	  mobile=Long.parseLong(req.getParameter("mob"));
      	  empMail=req.getParameter("email");
     	  
      	  
      	//use Delegage
      	  delegate=new EmployeeOperationsBusinessDelegate();
      	  try{
      	  insertResult=delegate.updateEmployee(loginId,empId,empName, empAddr, empCity, pin, designation, qualification, workExp, doj, mobile, empMail);
      	 out.println("<script type=\"text/javascript\">");
         out.println("alert('"+insertResult+"');");
         	if(designation.equalsIgnoreCase("Product Executive"))
         	{
         		out.println("location='prod_exec_firstpage.jsp';");
         	}
         	else if(designation.equalsIgnoreCase("Service Executive"))
         	{
         		out.println("location='service_exec_firstpage.jsp';");
         	}
         	else if(designation.equalsIgnoreCase("Purchase Manager"))
         	{
         		out.println("location='purchase_manager_firstpage.jsp';");
         	}
         	else if(designation.equalsIgnoreCase("Product Manager"))
         	{
         		out.println("location='prod_manager_firstpage.jsp';");
         	}
         	else if(designation.equalsIgnoreCase("Service Manager"))
         	{
         		out.println("location='service_manager_firstpage.jsp';");
         	}
         	else
         	{
         		out.println("location='home.jsp';");
         	}
         	
         out.println("</script>");
   

      	  }//try close
      	  catch(InsertOperationProblemException iop){
      		  req.setAttribute("errMsg",iop.getMessage());
          		rd=req.getRequestDispatcher("/error.jsp");
          		rd.forward(req,res); 
      	  }//catch
      	  catch(InternalProblemException ipe){
      		  req.setAttribute("errMsg",ipe.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res); 
      	  }//catch
      	  catch(Exception e){
      		  req.setAttribute("errMsg",e.getMessage());
          		rd=req.getRequestDispatcher("/error.jsp");
          		rd.forward(req,res);   
      	  }//catch
      	  
        }//else-->if
        
        else if(pval.equalsIgnoreCase("Change Password")){
        	String dsgn = (String) session.getAttribute("role");
        	int eid=(Integer)session.getAttribute("id");
        	 empPassword=req.getParameter("new");
      	  
      	//use Delegage
      	  delegate=new EmployeeOperationsBusinessDelegate();
      	  try{
      	  insertResult=delegate.changePassword(eid, empPassword);
      	 out.println("<script type=\"text/javascript\">");
         out.println("alert('"+insertResult+"');");
         	if(dsgn.equalsIgnoreCase("Product Executive"))
         	{
         		out.println("location='prod_exec_firstpage.jsp';");
         	}
         	else if(dsgn.equalsIgnoreCase("HR"))
         	{
         		out.println("location='hr_firstpage.jsp';");
         	}
         	else if(dsgn.equalsIgnoreCase("Service Executive"))
         	{
         		out.println("location='service_exec_firstpage.jsp';");
         	}
         	else if(dsgn.equalsIgnoreCase("Product Manager"))
         	{
         		out.println("location='prod_manager_firstpage.jsp';");
         	}
         	else if(dsgn.equalsIgnoreCase("Purchase Manager"))
         	{
         		out.println("location='purchase_manager_firstpage.jsp';");
         	}
         	else if(dsgn.equalsIgnoreCase("Service Manager"))
         	{
         		out.println("location='service_manager_firstpage.jsp';");
         	}
         	else
         	{
         		out.println("location='home.jsp';");
         	}
         	
         out.println("</script>");
   

      	  }//try close
      	  catch(InsertOperationProblemException iop){
      		  req.setAttribute("errMsg",iop.getMessage());
          		rd=req.getRequestDispatcher("/error.jsp");
          		rd.forward(req,res); 
      	  }//catch
      	  catch(InternalProblemException ipe){
      		  req.setAttribute("errMsg",ipe.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res); 
      	  }//catch
      	  catch(Exception e){
      		  req.setAttribute("errMsg",e.getMessage());
          		rd=req.getRequestDispatcher("/error.jsp");
          		rd.forward(req,res);   
      	  }//catch
      	  
        }//else-->if
      
        else if(pval.equalsIgnoreCase("Change Department")){
        	int id=Integer.parseInt(req.getParameter("empid"));
        	String empDept=req.getParameter("dept");
      	  
      	//use Delegage
      	  delegate=new EmployeeOperationsBusinessDelegate();
      	  try{
      	  insertResult=delegate.changeDepartment(id, empDept);
      	 out.println("<script type=\"text/javascript\">");
         out.println("alert('"+insertResult+"');");
         		out.println("location='firstpage.jsp';");
         out.println("</script>");
   

      	  }//try close
      	  catch(InsertOperationProblemException iop){
      		  req.setAttribute("errMsg",iop.getMessage());
          		rd=req.getRequestDispatcher("/error.jsp");
          		rd.forward(req,res); 
      	  }//catch
      	  catch(InternalProblemException ipe){
      		  req.setAttribute("errMsg",ipe.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res); 
      	  }//catch
      	  catch(Exception e){
      		  req.setAttribute("errMsg",e.getMessage());
          		rd=req.getRequestDispatcher("/error.jsp");
          		rd.forward(req,res);   
      	  }//catch
      	  
        }//else-->if

	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
}//class
