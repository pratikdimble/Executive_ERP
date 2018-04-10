package com.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.delegate.DepartmentOperationsBusinessDelegate;
import com.erp.dto.DepartmentDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

@WebServlet("/dept")
public class DepartmentControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       DepartmentOperationsBusinessDelegate delegate=null;
       List<DepartmentDTO> listDepartmentDTOs=null;
       List<DepartmentDTO> findDepartmentDTOs=null;
       RequestDispatcher rd=null;
       String deptRemovalMsg=null;
       String deptName=null;
       int deptId=0;
       String insertResult=null;
       PrintWriter out=res.getWriter();
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new DepartmentOperationsBusinessDelegate();
    	try{
    	listDepartmentDTOs=delegate.getAllDepartment();
    	req.setAttribute("listDepartmentDTOs",listDepartmentDTOs);
    	rd=req.getRequestDispatcher("/list_depts.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//if
      
    //condition for ADD
        else if(pval.equalsIgnoreCase("ADD")){
    	  deptName=req.getParameter("name");
    	//use Delegage
    	  delegate=new DepartmentOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addDepartment(deptName);
    	     out.println("<script type=\"text/javascript\">");
             out.println("alert('"+insertResult+"');");
             out.println("location='firstpage.jsp';");
             out.println("</script>");
          
          
 /*         listDepartmentDTOs=delegate.getAllCompanies();
           req.setAttribute("listDepartmentDTOs",listDepartmentDTOs);
          
         	rd=req.getRequestDispatcher("/list_dept.jsp");
          	rd.forward(req,res);*/

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
