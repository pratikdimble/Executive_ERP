package com.erp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.erp.delegate.ServiceOperationsBusinessDelegate;
import com.erp.dto.ServiceDataDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
import com.erp.errors.ServiceRemovalProblemException;

//@WebServlet("/controller")
public class ServiceControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       ServiceOperationsBusinessDelegate delegate=null;
       List<ServiceDataDTO> listserviceDTOs=null;
       List<ServiceDataDTO> findserviceDTOs=null;
       RequestDispatcher rd=null;
       String serviceRemovalMsg=null;
       String name=null,provider=null;
       float serviceCost=0;
       int sid=0;
         String insertResult=null;
         PrintWriter out=res.getWriter();
         HttpSession session = req.getSession(true);
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new ServiceOperationsBusinessDelegate();
    	try{
    	listserviceDTOs=delegate.getAllServices();
    	req.setAttribute("listserviceDTOs",listserviceDTOs);
    	rd=req.getRequestDispatcher("/list_services.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//if
      else if(pval.equalsIgnoreCase("Details")){
      	delegate=new ServiceOperationsBusinessDelegate();
  	  String thisRole = (String) session.getAttribute("role");
      	try{
      	listserviceDTOs=delegate.getService(req.getParameter("choice"));
      	req.setAttribute("listserviceDTOs",listserviceDTOs);
      	out.println("<script type=\"text/javascript\">");
      	if(thisRole.equalsIgnoreCase("Service Executive"))
    	{
    	 	rd=req.getRequestDispatcher("/select_service_exec.jsp");
    	}
      	else if(thisRole.equalsIgnoreCase("Admin"))
    	{
    	 	rd=req.getRequestDispatcher("/servicedata.jsp");
    	}
    	else if(thisRole.equalsIgnoreCase("Service Manager"))
    	{
    	 	rd=req.getRequestDispatcher("/select_service_manager.jsp");
    	}
    	else
    	{
    		out.println("location='home.jsp';");
    	}
        out.println("</script>");
     
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
    	  delegate=new ServiceOperationsBusinessDelegate();
    	  try{
    	 serviceRemovalMsg=delegate.deleteService(Integer.parseInt(req.getParameter("choice")));
    	  req.setAttribute("serviceRemovalMsg", serviceRemovalMsg);
  	  	rd=req.getRequestDispatcher("deleteservice.jsp");
    	rd.forward(req,res);
    	  listserviceDTOs=delegate.getAllServices();
      	  req.setAttribute("listserviceDTO",listserviceDTOs);


    	  }
    	  catch(ServiceRemovalProblemException sepe){
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
    	  name=req.getParameter("name");
    	//  provider=req.getParameter("provider");
    	  //serviceCost=Float.parseFloat(req.getParameter("cost"));
    	//use Delegage
    	  delegate=new ServiceOperationsBusinessDelegate();
    	  try{
    	  //insertResult=delegate.addService(name, provider,serviceCost);
    		  insertResult=delegate.addService(name);
    		  req.setAttribute("insertMsg",insertResult);
          	rd=req.getRequestDispatcher("/service_ack.jsp");
  				rd.forward(req,res);
          
          
          listserviceDTOs=delegate.getAllServices();
          req.setAttribute("listserviceDTOs",listserviceDTOs);
          
         	rd=req.getRequestDispatcher("/list_services.jsp");
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
      
        else if(pval.equalsIgnoreCase("ADD Data")){
        	sid=Integer.parseInt(req.getParameter("id"));
    	  name=req.getParameter("name");
    	  provider=req.getParameter("provider");
    	  serviceCost=Float.parseFloat(req.getParameter("cost"));
    	//use Delegage
    	  delegate=new ServiceOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addServiceData(sid,name, provider,serviceCost);
    		  req.setAttribute("insertMsg",insertResult);
          	rd=req.getRequestDispatcher("/service_ack.jsp");
  				rd.forward(req,res);
          
          
          listserviceDTOs=delegate.getAllServices();
          req.setAttribute("listserviceDTOs",listserviceDTOs);
          
         	rd=req.getRequestDispatcher("/list_services.jsp");
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
      	delegate=new ServiceOperationsBusinessDelegate();
    	try{
    	listserviceDTOs=delegate.findService(sid);
    	req.setAttribute("findserviceDTOs",findserviceDTOs);
    	rd=req.getRequestDispatcher("/search_service.jsp");
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
