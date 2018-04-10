package com.erp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.delegate.CompanyOperationsBusinessDelegate;
import com.erp.dto.CompanyDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

//@WebServlet("/controller")
public class CompanyControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       CompanyOperationsBusinessDelegate delegate=null;
       List<CompanyDTO> listCompanyDTOs=null;
       List<CompanyDTO> findCompanyDTOs=null;
       RequestDispatcher rd=null;
       String companyRemovalMsg=null;
       String compName=null,compAddr=null,compMail=null,compWeb=null;
       int compId=0,year=0;
       long contact=0;
         String insertResult=null;
       
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new CompanyOperationsBusinessDelegate();
    	try{
    	listCompanyDTOs=delegate.getAllCompanies();
    	req.setAttribute("listCompanyDTOs",listCompanyDTOs);
    	rd=req.getRequestDispatcher("/list_companies.jsp");
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
    	  compName=req.getParameter("name");
    	  compAddr=req.getParameter("addr");
    	  contact=Integer.parseInt(req.getParameter("contact"));
    	  compMail=req.getParameter("mail");
    	  compWeb=req.getParameter("web");
    	  year=Integer.parseInt(req.getParameter("year"));
    	  
    	  
    	//use Delegage
    	  delegate=new CompanyOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addCompany(compName, compAddr, contact, compWeb, compMail, year);
          req.setAttribute("insertMsg",insertResult);
          	rd=req.getRequestDispatcher("/comp_ack.jsp");
  				rd.forward(req,res);
          
          
          listCompanyDTOs=delegate.getAllCompanies();
          req.setAttribute("listCompanyDTOs",listCompanyDTOs);
          
         	rd=req.getRequestDispatcher("/list_companies.jsp");
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
      	delegate=new CompanyOperationsBusinessDelegate();
    	try{
    	listCompanyDTOs=delegate.findCompany(sid);
    	req.setAttribute("findCompanyDTOs",findCompanyDTOs);
    	rd=req.getRequestDispatcher("/search_Company.jsp");
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
