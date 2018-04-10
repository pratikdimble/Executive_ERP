package com.erp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.delegate.BankOperationsBusinessDelegate;
import com.erp.dto.BankDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

//@WebServlet("/controller")
public class BankControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       BankOperationsBusinessDelegate delegate=null;
       List<BankDTO> listBankDTOs=null;
       List<BankDTO> findBankDTOs=null;
       RequestDispatcher rd=null;
       String bankRemovalMsg=null;
       String bankName=null;
       int bankId=0;
       String insertResult=null;
       
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new BankOperationsBusinessDelegate();
    	try{
    	listBankDTOs=delegate.getAllCompanies();
    	req.setAttribute("listBankDTOs",listBankDTOs);
    	rd=req.getRequestDispatcher("/list_banks.jsp");
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
    	  bankName=req.getParameter("name");
     
    	  
    	//use Delegage
    	  delegate=new BankOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addBank(bankName);
          req.setAttribute("insertMsg",insertResult);
          	rd=req.getRequestDispatcher("/bank_ack.jsp");
  				rd.forward(req,res);
          
          
          listBankDTOs=delegate.getAllCompanies();
          req.setAttribute("listBankDTOs",listBankDTOs);
          
         	rd=req.getRequestDispatcher("/list_banks.jsp");
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
      	delegate=new BankOperationsBusinessDelegate();
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
