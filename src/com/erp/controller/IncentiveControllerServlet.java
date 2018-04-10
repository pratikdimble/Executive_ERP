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

import com.erp.delegate.CompanyOperationsBusinessDelegate;
import com.erp.delegate.IncentiveOperationsBusinessDelegate;
import com.erp.dto.IncentiveDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
import com.erp.errors.IncentiveRemovalProblemException;

//@WebServlet("/controller")
public class IncentiveControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       IncentiveOperationsBusinessDelegate delegate=null;
       List<IncentiveDTO> listincentiveDTOs=null;
       RequestDispatcher rd=null;
       String incentiveRemovalMsg=null;
       String incDate=null,empName=null,prodName=null,prodType=null,serName=null,provider=null;
       int target=0,achieved=0,workdone=0,pid=0,empId;
       float incentivepp=0,amount=0;
       String insertResult=null;
       PrintWriter out=res.getWriter();
       HttpSession session = req.getSession(true);
       String thisRole = (String) session.getAttribute("role");
       
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new IncentiveOperationsBusinessDelegate();
    	try{
    	listincentiveDTOs=delegate.getAllIncentives();
    	req.setAttribute("listincentiveDTOs",listincentiveDTOs);
    	rd=req.getRequestDispatcher("/list_incentive.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//if
      else if(pval.equalsIgnoreCase("Details")){
      	delegate=new IncentiveOperationsBusinessDelegate();
      	try{
      		
      	listincentiveDTOs=delegate.getIncentive(req.getParameter("choice"));
    	req.setAttribute("listincentiveDTOs",listincentiveDTOs);
      	if(thisRole.equalsIgnoreCase("Product Manager"))
    	{
      		rd=req.getRequestDispatcher("/select_incentive_prod_manager.jsp");
          	rd.forward(req,res);
    	}
    	else if(thisRole.equalsIgnoreCase("Service Manager"))
    	{
    		rd=req.getRequestDispatcher("/select_incentive_ser_manager.jsp");
          	rd.forward(req,res);
    	}
    	else if(thisRole.equalsIgnoreCase("ADMIN"))
    	{
    		rd=req.getRequestDispatcher("/select_incentive_admin.jsp");
          	rd.forward(req,res);
    	}
    	else if(thisRole.equalsIgnoreCase("HR"))
    	{
    		rd=req.getRequestDispatcher("/select_incentive_admin.jsp");
          	rd.forward(req,res);
    	}

    	else
    	{
    		out.println("location='index.jsp';");
    	}
    	
    out.println("</script>");
      
      	
      	}
      	catch(InternalProblemException ipe){
      		req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res);
      	}
        }//if
 
      else if(pval.equalsIgnoreCase("DELETE")){
    	  //use Delegage
    	  delegate=new IncentiveOperationsBusinessDelegate();
    	  try{
    	  incentiveRemovalMsg=delegate.deleteIncentive(Integer.parseInt(req.getParameter("choice")));
    	    out.println("<script type=\"text/javascript\">");
            out.println("alert('"+incentiveRemovalMsg+"');");
            if(thisRole.equalsIgnoreCase("Product Manager"))
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
    	  listincentiveDTOs=delegate.getAllIncentives();
      	  req.setAttribute("listincentiveDTO",listincentiveDTOs);
      /* 	rd=req.getRequestDispatcher("deleteincentive.jsp");
        	rd.forward(req,res);*/

    	  }
    	  catch(IncentiveRemovalProblemException sepe){
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
        else if(pval.equalsIgnoreCase("ADD")){
        	empId=Integer.parseInt(req.getParameter("empid"));
        	
    	  empName=req.getParameter("name");
    	  incDate=req.getParameter("incdate");
    	  prodType=req.getParameter("prodtype");
    	  prodName=req.getParameter("pname");
    	  serName=req.getParameter("sername");
    	  provider=req.getParameter("provider");
    	  
    	  target=Integer.parseInt(req.getParameter("tarppro"));
    	  incentivepp=Float.parseFloat(req.getParameter("incppro"));
    	  achieved=Integer.parseInt(req.getParameter("achtar"));
    	  workdone=Integer.parseInt(req.getParameter("work"));
    	  amount=Float.parseFloat(req.getParameter("incamt"));
    	  
    	//use Delegage
    	  delegate=new IncentiveOperationsBusinessDelegate();
    		
    	  try{
    		  if(thisRole.equalsIgnoreCase("Product Manager"))
            	{
    			  insertResult=delegate.addIncentiveProduct(empId,empName, incDate, prodName, prodType, incentivepp, target, achieved, workdone, amount);
    	          req.setAttribute("insertMsg",insertResult);
    	          out.println("<script type=\"text/javascript\">");
    	          out.println("alert('"+insertResult+"');");
    	          out.println("location='prod_manager_firstpage.jsp';");
    	          out.println("</script>");
            	}
            	else if(thisRole.equalsIgnoreCase("Service Manager"))
            	{
            		insertResult=delegate.addIncentiveService(empId,empName, incDate, serName, provider, incentivepp, target, achieved, workdone, amount);
                    req.setAttribute("insertMsg",insertResult);
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('"+insertResult+"');");
                    out.println("location='service_manager_firstpage.jsp';");
                    out.println("</script>");
            	}

            	else
            	{
            		out.println("location='home.jsp';");
            	}
            	
            out.println("</script>");
    	  
          	/*rd=req.getRequestDispatcher("/incentive_ack.jsp");
  				rd.forward(req,res);*/
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
