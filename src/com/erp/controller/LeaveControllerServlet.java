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

import com.erp.delegate.IncentiveOperationsBusinessDelegate;
import com.erp.delegate.LeaveOperationsBusinessDelegate;
import com.erp.dto.LeaveDTO;
import com.erp.errors.LeaveRemovalProblemException;
import com.erp.errors.IncentiveRemovalProblemException;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

//@WebServlet("/controller")
public class LeaveControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       LeaveOperationsBusinessDelegate delegate=null;
       List<LeaveDTO> listLeaveDTOs=null;
       List<LeaveDTO> findLeaveDTOs=null;
       RequestDispatcher rd=null;
       String leaveRemovalMsg=null;
       String empName=null, dsgn=null,leaveType=null,dateFrom=null,dateTo=null;
       int leaveId=0,empId=0,days=0;
       String insertResult=null;
       PrintWriter out=res.getWriter();
       HttpSession session = req.getSession(true);
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new LeaveOperationsBusinessDelegate();
    	try{
    	listLeaveDTOs=delegate.getAllLeave();
    	req.setAttribute("listLeaveDTOs",listLeaveDTOs);
    	rd=req.getRequestDispatcher("/list_leave.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//if
      else if(pval.equalsIgnoreCase("link2")){
      	delegate=new LeaveOperationsBusinessDelegate();
      	try{
      	listLeaveDTOs=delegate.getApprovedLeave();
      	req.setAttribute("listLeaveDTOs",listLeaveDTOs);
      	rd=req.getRequestDispatcher("/list_appr_leave.jsp");
      	rd.forward(req,res);
      	}
      	catch(InternalProblemException ipe){
      		req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res);
      	}
        }//if
      else if(pval.equalsIgnoreCase("Check")){
    	  
    	  int myId = (Integer)session.getAttribute("id");
      	delegate=new LeaveOperationsBusinessDelegate();
      	try{
      	listLeaveDTOs=delegate.getUserLeave(myId);
      	req.setAttribute("listLeaveDTOs",listLeaveDTOs);
      	rd=req.getRequestDispatcher("/leave_application_status.jsp");
      	rd.forward(req,res);
      	}
      	catch(InternalProblemException ipe){
      		req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res);
      	}
        }//else if
    //condition for DELETE
      else if(pval.equalsIgnoreCase("DELETE")){
    	  String thisRole = (String) session.getAttribute("role");
    	  //use Delegage
    	  delegate=new LeaveOperationsBusinessDelegate();
    	  try{
    	 leaveRemovalMsg=delegate.deleteLeave(Integer.parseInt(req.getParameter("choice")));
    	  out.println("<script type=\"text/javascript\">");
          out.println("alert('"+leaveRemovalMsg+"');");
          if(thisRole.equalsIgnoreCase("Product Executive"))
      	{
      		out.println("location='prod_exec_firstpage.jsp';");
      	}
      	else if(thisRole.equalsIgnoreCase("Service Executive"))
      	{
      		out.println("location='service_exec_firstpage.jsp';");
      	}
      	else if(thisRole.equalsIgnoreCase("Product Manager"))
      	{
      		out.println("location='prod_manager_firstpage.jsp';");
      	}
      	else
      	{
      		out.println("location='home.jsp';");
      	}
          out.println("</script>");
    	  listLeaveDTOs=delegate.getAllLeave();
      	  req.setAttribute("listLeaveDTO",listLeaveDTOs);


    	  }
    	  catch(LeaveRemovalProblemException sepe){
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
        	empId=Integer.parseInt(req.getParameter("eid"));
        	empName=req.getParameter("ename");
        	dsgn=req.getParameter("dsgn");
        	
        	leaveType=req.getParameter("leavetype");
        	dateFrom=req.getParameter("datefrom");
        	dateTo=req.getParameter("dateto");
        	days=Integer.parseInt(req.getParameter("days"));
        	
    	//use Delegage
    	  delegate=new LeaveOperationsBusinessDelegate();
    	  try{
//    	  insertResult=delegate.addLeave(regName,leaveName,desc);
    		  insertResult=delegate.addLeave(empId, empName, dsgn, leaveType, dateFrom, dateTo, days);
    		    out.println("<script type=\"text/javascript\">");
                out.println("alert('"+insertResult+"');");
                	if(dsgn.equalsIgnoreCase("Product Executive"))
                	{
                		out.println("location='prod_exec_firstpage.jsp';");
                	}
                	else if(dsgn.equalsIgnoreCase("Service Executive"))
                	{
                		out.println("location='service_exec_firstpage.jsp';");
                	}
                	else if(dsgn.equalsIgnoreCase("Product Manager"))
                	{
                		out.println("location='prod_manager_firstpage.jsp';");
                	}
                	else
                	{
                		out.println("location='home.jsp';");
                	}
                	
                out.println("</script>");
          
          
          /*listLeaveDTOs=delegate.getAllLeave();
          req.setAttribute("listLeaveDTOs",listLeaveDTOs);
          
         	rd=req.getRequestDispatcher("/list_leave.jsp");
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
        else if(pval.equalsIgnoreCase("Approve")){
      	  //use Delegage
      	  delegate=new LeaveOperationsBusinessDelegate();
      	  String Status="Approved";
      	  int id=Integer.parseInt(req.getParameter("choice"));
      	  try{
      	  insertResult=delegate.updateStatus(id,Status);
      	    out.println("<script type=\"text/javascript\">");
              out.println("alert('"+insertResult+"');");
              out.println("location='firstpage.jsp';");
              out.println("</script>");

      	  }
      	  catch(Exception e){
      		  req.setAttribute("errMsg",e.getMessage());
          		rd=req.getRequestDispatcher("/error.jsp");
          		rd.forward(req,res); 
      	  }
        }
        else if(pval.equalsIgnoreCase("Reject")){
        	  //use Delegage
        	  delegate=new LeaveOperationsBusinessDelegate();
        	  String Status="Rejected";
        	  int id=Integer.parseInt(req.getParameter("choice"));
        	  try{
        	  insertResult=delegate.updateStatus(id,Status);
        	    out.println("<script type=\"text/javascript\">");
                out.println("alert('"+insertResult+"');");
                out.println("location='firstpage.jsp';");
                out.println("</script>");

        	  }
        	  catch(Exception e){
        		  req.setAttribute("errMsg",e.getMessage());
            		rd=req.getRequestDispatcher("/error.jsp");
            		rd.forward(req,res); 
        	  }
          }
      //condition for FIND
/*        else if(pval.equalsIgnoreCase("FIND")){
      	  sid=Integer.parseInt(req.getParameter("id"));
   	  
      	//use Delegage
      	delegate=new LeaveOperationsBusinessDelegate();
    	try{
    	listLeaveDTOs=delegate.findLeave(sid);
    	req.setAttribute("findLeaveDTOs",findLeaveDTOs);
    	rd=req.getRequestDispatcher("/search_Leave.jsp");
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
