package com.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.delegate.EmpAssignOperationsBusinessDelegate;
import com.erp.dto.EmpAssignDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
import com.erp.errors.EmpAssignRemovalProblemException;

//@WebServlet("/controller")
public class EmpAssignControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       EmpAssignOperationsBusinessDelegate delegate=null;
       List<EmpAssignDTO> listassignDTOs=null;
       List<EmpAssignDTO> findassignDTOs=null;
       RequestDispatcher rd=null;
       String assignRemovalMsg=null;
       String empName=null, design=null, assignDate=null, statusType=null, prodName=null, prodType=null, serName=null, region=null, area=null;
       int sid=0;
         String insertResult=null;
         PrintWriter out=res.getWriter();
         
         empName=req.getParameter("name");
   	  design=req.getParameter("dsgn");
   	  assignDate=req.getParameter("date");
	  region=req.getParameter("reg");
	  area=req.getParameter("area");
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new EmpAssignOperationsBusinessDelegate();
    	try{
    	listassignDTOs=delegate.getAllEmpAssigns();
    	req.setAttribute("listassignDTOs",listassignDTOs);
    	rd=req.getRequestDispatcher("/list_assigns.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//if
      else if(pval.equalsIgnoreCase("View")){
      	delegate=new EmpAssignOperationsBusinessDelegate();
      	try{
      	listassignDTOs=delegate.getEmpAssign(req.getParameter("choice"));
      	req.setAttribute("listassignDTOs",listassignDTOs);
      	rd=req.getRequestDispatcher("/select_assign.jsp");
      	rd.forward(req,res);
      	}
      	catch(InternalProblemException ipe){
      		req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res);
      	}
        }//if
      else if(pval.equalsIgnoreCase("DELETE")){
    	  //use Delegage
    	  delegate=new EmpAssignOperationsBusinessDelegate();
    	  try{
    	 assignRemovalMsg=delegate.deleteEmpAssign(req.getParameter("choice"));
    	  req.setAttribute("assignRemovalMsg", assignRemovalMsg);
  	  	rd=req.getRequestDispatcher("deleteassign.jsp");
    	rd.forward(req,res);
    	  listassignDTOs=delegate.getAllEmpAssigns();
      	  req.setAttribute("listassignDTO",listassignDTOs);


    	  }
    	  catch(EmpAssignRemovalProblemException sepe){
    		req.setAttribute("errMsg",sepe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res); 
    	  }
    	  catch (InternalProblemException ipe) {
    		  req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res);
   	    	}
    	  catch(Exception e){
    		  req.setAttribute("errMsg",e.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res); 
    	  }
      }//else if
    //condition for ADD

        else if(pval.equalsIgnoreCase("Assign Product")){
    	
    	  statusType="Product";
    	  prodName=req.getParameter("pname");
    	  prodType=req.getParameter("prodtype");
    	  serName="Null";

    	  
    	//use Delegage
    	  delegate=new EmpAssignOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addEmpProductAssign(empName, design, assignDate, statusType, prodName, prodType, serName, region, area);
    	  out.println("<script type=\"text/javascript\">");
          out.println("alert('"+insertResult+"');");
          out.println("location='prod_manager_firstpage.jsp';");
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
        else if(pval.equalsIgnoreCase("Assign Service")){
        	
      	  statusType="Service";
      	  prodName="Null";
      	  prodType="Null";
      	  serName=req.getParameter("service");

      	  
      	//use Delegage
      	  delegate=new EmpAssignOperationsBusinessDelegate();
      	  try{
      	  insertResult=delegate.addEmpProductAssign(empName, design, assignDate, statusType, prodName, prodType, serName, region, area);
      	  out.println("<script type=\"text/javascript\">");
            out.println("alert('"+insertResult+"');");
            out.println("location='service_manager_firstpage.jsp';");
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
      //condition for FIND
/*        else if(pval.equalsIgnoreCase("FIND")){
      	  sid=Integer.parseInt(req.getParameter("id"));
   	  
      	//use Delegage
      	delegate=new EmpAssignOperationsBusinessDelegate();
    	try{
    	listassignDTOs=delegate.findEmpAssign(sid);
    	req.setAttribute("findassignDTOs",findassignDTOs);
    	rd=req.getRequestDispatcher("/search_assign.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//else-->if
*/        
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
}//class
