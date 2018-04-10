package com.erp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.delegate.CustAppointOperationsBusinessDelegate;
import com.erp.dto.CustAppointDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
import com.erp.errors.CustAppointRemovalProblemException;

//@WebServlet("/controller")
public class CustAppointControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       CustAppointOperationsBusinessDelegate delegate=null;
       List<CustAppointDTO> listappointDTOs=null;
       List<CustAppointDTO> findappointDTOs=null;
       RequestDispatcher rd=null;
       String appointRemovalMsg=null;
       String custName=null,appointTo=null,type=null,subject=null,appointDate=null,time=null,venue=null,contact=null;
       int id=0;
         String insertResult=null;
       
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new CustAppointOperationsBusinessDelegate();
    	try{
    	listappointDTOs=delegate.getAllCustAppoints();
    	req.setAttribute("listappointDTOs",listappointDTOs);
    	rd=req.getRequestDispatcher("/list_appoints.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//if
      else if(pval.equalsIgnoreCase("View")){
      	delegate=new CustAppointOperationsBusinessDelegate();
      	try{
      	listappointDTOs=delegate.getCustAppoint(req.getParameter("choice"));
      	req.setAttribute("listappointDTOs",listappointDTOs);
      	rd=req.getRequestDispatcher("/selectappoint.jsp");
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
    	  delegate=new CustAppointOperationsBusinessDelegate();
    	  try{
    	 appointRemovalMsg=delegate.deleteCustAppoint(req.getParameter("choice"));
    	  req.setAttribute("appointRemovalMsg", appointRemovalMsg);
  	  	rd=req.getRequestDispatcher("deleteappoint.jsp");
    	rd.forward(req,res);
    	  listappointDTOs=delegate.getAllCustAppoints();
      	  req.setAttribute("listappointDTO",listappointDTOs);


    	  }
    	  catch(CustAppointRemovalProblemException sepe){
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
    	  custName=req.getParameter("name");
    	  appointTo=req.getParameter("to");
    	  type=req.getParameter("type");
    	  subject=req.getParameter("subject");
    	  appointDate=req.getParameter("date");
    	  time=req.getParameter("time");
    	  venue=req.getParameter("venue");
    	  contact=req.getParameter("contact");
    	  //use Delegage
    	  delegate=new CustAppointOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addCustAppoint(custName, appointTo, type, subject, appointDate, time, venue, contact);
          req.setAttribute("insertMsg",insertResult);
          	rd=req.getRequestDispatcher("/appoint_ack.jsp");
  				rd.forward(req,res);
          
          
/*          listappointDTOs=delegate.getAllCustAppoints();
          req.setAttribute("listappointDTOs",listappointDTOs);
          
         	rd=req.getRequestDispatcher("/list_appoints.jsp");
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
      	delegate=new CustAppointOperationsBusinessDelegate();
    	try{
    	listappointDTOs=delegate.findCustAppoint(sid);
    	req.setAttribute("findappointDTOs",findappointDTOs);
    	rd=req.getRequestDispatcher("/search_appoint.jsp");
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
