package com.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.delegate.DesignationOperationsBusinessDelegate;
import com.erp.dto.DesignationDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

//@WebServlet("/controller")
public class DesignationControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       DesignationOperationsBusinessDelegate delegate=null;
       List<DesignationDTO> listDesignationDTOs=null;
       List<DesignationDTO> findDesignationDTOs=null;
       RequestDispatcher rd=null;
       String dsgnRemovalMsg=null;
       String dsgnName=null;
       int dsgnId=0;
       String insertResult=null;
       PrintWriter out=res.getWriter();
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new DesignationOperationsBusinessDelegate();
    	try{
    	listDesignationDTOs=delegate.getAllDesignation();
    	req.setAttribute("listDesignationDTOs",listDesignationDTOs);
    	rd=req.getRequestDispatcher("/list_dsgns.jsp");
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
    	  dsgnName=req.getParameter("name");
    	//use Delegage
    	  delegate=new DesignationOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addDesignation(dsgnName);
    	     out.println("<script type=\"text/javascript\">");
             out.println("alert('"+insertResult+"');");
             out.println("location='firstpage.jsp';");
             out.println("</script>");
          
          
 /*         listDesignationDTOs=delegate.getAllCompanies();
           req.setAttribute("listDesignationDTOs",listDesignationDTOs);
          
         	rd=req.getRequestDispatcher("/list_dsgn.jsp");
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
      //condition for FIND
/*        else if(pval.equalsIgnoreCase("FIND")){
      	  sid=Integer.parseInt(req.getParameter("id"));
   	  
      	//use Delegage
      	delegate=new DesignationOperationsBusinessDelegate();
    	try{
    	listBankDTOs=delegate.findBank(sid);
    	req.setAttribute("findBankDTOs",findBankDTOs);
    	rd=req.getRequestDispatcher("/search_Bank.jsp");
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
