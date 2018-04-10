package com.erp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.delegate.CustomerOperationsBusinessDelegate;
import com.erp.dto.CustomerDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

//@WebServlet("/controller")
public class CustomerControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       CustomerOperationsBusinessDelegate delegate=null;
       List<CustomerDTO> listCustomerDTOs=null;
       List<CustomerDTO> listEmpDTOs=null;
       List<CustomerDTO> findCustomerDTOs=null;
       RequestDispatcher rd=null;
       String customerRemovalMsg=null;
       String custName=null,shopAddr=null,shopName=null,delivery=null,contactPerson=null,
    		   			shopMail=null;
       int custId=0,pin=0;
       long mobile=0,personMobile=0;
         String insertResult=null;
       
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new CustomerOperationsBusinessDelegate();
    	try{
    	listCustomerDTOs=delegate.getAllCustomer();
    	req.setAttribute("listCustomerDTOs",listCustomerDTOs);
    	rd=req.getRequestDispatcher("/list_customer.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }

      
    //condition for ADD
        else if(pval.equalsIgnoreCase("Register")){
    	  custName=req.getParameter("name");
    	  shopName=req.getParameter("shopname");
    	  shopAddr=req.getParameter("addr");
    	  pin=Integer.parseInt(req.getParameter("pin"));
    	  delivery=req.getParameter("delivery");
    	  mobile=Long.parseLong(req.getParameter("mob"));
    	  shopMail=req.getParameter("email");
    	  contactPerson=req.getParameter("cntname");
    	  personMobile=Long.parseLong(req.getParameter("cntmob"));
    	 
 	 
    	
   	  
    	  
    	//use Delegage
    	  delegate=new CustomerOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addCustomer(custName, shopName, shopAddr, pin, delivery, mobile, shopMail, contactPerson, personMobile);
          req.setAttribute("insertMsg",insertResult);
          	rd=req.getRequestDispatcher("/cust_ack.jsp");
  				rd.forward(req,res);
          
          
          listCustomerDTOs=delegate.getAllCustomer();
          req.setAttribute("listCustomerDTOs",listCustomerDTOs);
          
         	rd=req.getRequestDispatcher("/list_customer.jsp");
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
      	delegate=new CustomerOperationsBusinessDelegate();
    	try{
    	listCustomerDTOs=delegate.findCustomer(sid);
    	req.setAttribute("findCustomerDTOs",findCustomerDTOs);
    	rd=req.getRequestDispatcher("/search_Customer.jsp");
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
