package com.erp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.delegate.BranchOperationsBusinessDelegate;
import com.erp.dto.BranchDTO;
import com.erp.errors.BranchRemovalProblemException;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

//@WebServlet("/controller")
public class BranchControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       BranchOperationsBusinessDelegate delegate=null;
       List<BranchDTO> listBranchDTOs=null;
       List<BranchDTO> findBranchDTOs=null;
       RequestDispatcher rd=null;
       String branchRemovalMsg=null;
       String branchName=null, desc=null,bankName=null;
       int branchId=0;
       String insertResult=null;
       
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new BranchOperationsBusinessDelegate();
    	try{
    	listBranchDTOs=delegate.getAllBranch();
    	req.setAttribute("listBranchDTOs",listBranchDTOs);
    	rd=req.getRequestDispatcher("/list_branch.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//if
      else if(pval.equalsIgnoreCase("DETAILS")){
    	delegate=new BranchOperationsBusinessDelegate();
    	try{
    	listBranchDTOs=delegate.getBranch(req.getParameter("choice"));
    	req.setAttribute("listBranchDTOs",listBranchDTOs);
    	rd=req.getRequestDispatcher("/selectbranch.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//if
    //condition for DELETE
      else if(pval.equalsIgnoreCase("DELETE")){
    	  //use Delegage
    	  delegate=new BranchOperationsBusinessDelegate();
    	  try{
    	 branchRemovalMsg=delegate.deleteBranch(req.getParameter("choice"));
    	  req.setAttribute("branchRemovalMsg", branchRemovalMsg);
  	  	rd=req.getRequestDispatcher("deletebranch.jsp");
    	rd.forward(req,res);
    	  listBranchDTOs=delegate.getAllBranch();
      	  req.setAttribute("listBranchDTO",listBranchDTOs);


    	  }
    	  catch(BranchRemovalProblemException sepe){
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
        else if(pval.equalsIgnoreCase("ADD")){
        	bankName=req.getParameter("bank");
    	  branchName=req.getParameter("brname");
    	  desc=req.getParameter("desc");
     
    	  
    	//use Delegage
    	  delegate=new BranchOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addBranch(bankName,branchName,desc);
          req.setAttribute("insertMsg",insertResult);
          	rd=req.getRequestDispatcher("/branch_ack.jsp");
  				rd.forward(req,res);
          
          
          listBranchDTOs=delegate.getAllBranch();
          req.setAttribute("listBranchDTOs",listBranchDTOs);
          
         	rd=req.getRequestDispatcher("/list_branch.jsp");
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
      //condition for FIND
/*        else if(pval.equalsIgnoreCase("FIND")){
      	  sid=Integer.parseInt(req.getParameter("id"));
   	  
      	//use Delegage
      	delegate=new BranchOperationsBusinessDelegate();
    	try{
    	listBranchDTOs=delegate.findBranch(sid);
    	req.setAttribute("findBranchDTOs",findBranchDTOs);
    	rd=req.getRequestDispatcher("/search_Branch.jsp");
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
