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
import javax.servlet.http.HttpSession;

import com.erp.delegate.PaymentSlipOperationsBusinessDelegate;
import com.erp.dto.PaymentSlipDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
//import com.erp.errors.PaymentSlipRemovalProblemException;

@WebServlet("/paymentslip")
public class PaymentSlipControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       PaymentSlipOperationsBusinessDelegate delegate=null;
       List<PaymentSlipDTO> listpaymentDTOs=null;
       RequestDispatcher rd=null;
       String paymentuctRemovalMsg=null;
       String salMonth=null,empName=null,dsgn=null;
    	long mobile=0;
       int empId=0,pid=0,slipId=0;
       float basic=0,service=0,hra=0,income=0,da=0,incentive=0,transport=0,netpay=0;
       String insertResult=null;
       PrintWriter out=res.getWriter();
       HttpSession session = req.getSession(true);
       
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new PaymentSlipOperationsBusinessDelegate();
    	try{
    	listpaymentDTOs=delegate.getAllPaymentSlips();
    	req.setAttribute("listpaymentDTOs",listpaymentDTOs);
    	rd=req.getRequestDispatcher("/list_payment.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//if
      else if(pval.equalsIgnoreCase("Details")){
      	delegate=new PaymentSlipOperationsBusinessDelegate();
      	try{
      	listpaymentDTOs=delegate.getPaymentSlip(req.getParameter("choice"));
      	req.setAttribute("listpaymentDTOs",listpaymentDTOs);
      	rd=req.getRequestDispatcher("/list_emp_payment.jsp");
      	rd.forward(req,res);
      	}
      	catch(InternalProblemException ipe){
      		req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res);
      	}
        }//if
     
      else if(pval.equalsIgnoreCase("View")){
    	  String myName=(String) session.getAttribute("empname");
        	delegate=new PaymentSlipOperationsBusinessDelegate();
        	try{
        	listpaymentDTOs=delegate.getEmpPaymentSlip(myName,req.getParameter("choice"));
        	req.setAttribute("listpaymentDTOs",listpaymentDTOs);
        	rd=req.getRequestDispatcher("/list_emp_payment.jsp");
        	rd.forward(req,res);
        	}
        	catch(InternalProblemException ipe){
        		req.setAttribute("errMsg",ipe.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res);
        	}
          }//if

        else if(pval.equalsIgnoreCase("Generate Slip")){
        	salMonth=req.getParameter("salmonth");
    	  empName=req.getParameter("ename");
    	  empId=Integer.parseInt(req.getParameter("eid"));
    	  dsgn=req.getParameter("dsgn");
    	  mobile=Long.parseLong(req.getParameter("mobile"));
    	  
    	  basic=Float.parseFloat(req.getParameter("basic"));
    	  service=Float.parseFloat(req.getParameter("service"));
    	  hra=Float.parseFloat(req.getParameter("hra"));
    	  income=Float.parseFloat(req.getParameter("income"));
    	  da=Float.parseFloat(req.getParameter("da"));
    	  incentive=Float.parseFloat(req.getParameter("incentive"));
    	  transport=Float.parseFloat(req.getParameter("transport"));
    	  netpay=Float.parseFloat(req.getParameter("netpay"));
    	  
    	//use Delegage
    	  delegate=new PaymentSlipOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addPaymentSlip(salMonth, empId, empName, mobile, dsgn, basic, service, hra, income, da, incentive, transport, netpay);
    	  out.println("<script type=\"text/javascript\">");
          out.println("alert('"+insertResult+"');");
          out.println("location='hr_firstpage.jsp';");
          out.println("</script>");
    	  }
    	  catch(InsertOperationProblemException iop){
    		  req.setAttribute("errMsg",iop.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res); 
    	  }
    	  catch(InternalProblemException ipe){
    		  req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res); 
    	  }
    	  catch(Exception e){
    		  req.setAttribute("errMsg",e.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res);   
    	  }
    	  
      }
       
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
}//class
