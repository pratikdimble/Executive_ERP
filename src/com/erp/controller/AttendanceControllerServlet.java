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

import com.erp.delegate.AttendanceOperationsBusinessDelegate;
import com.erp.dto.AttendanceDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

@WebServlet("/attendance")
public class AttendanceControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       AttendanceOperationsBusinessDelegate delegate=null;
       List<AttendanceDTO> listattendDTOs=null;
       RequestDispatcher rd=null;
       String attenductRemovalMsg=null;
       String attendDate=null,empName=null,entryStatus=null,inTime=null,outTime=null;
       int empId=0,attendId=0;
       String insertResult=null;
       PrintWriter out=res.getWriter();
       HttpSession session = req.getSession(true);
       
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new AttendanceOperationsBusinessDelegate();
    	try{
    	listattendDTOs=delegate.getAllAttendances();
    	req.setAttribute("listattendDTOs",listattendDTOs);
    	rd=req.getRequestDispatcher("/list_attend.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//if
      else if(pval.equalsIgnoreCase("Details")){
      	delegate=new AttendanceOperationsBusinessDelegate();
      	try{
      	listattendDTOs=delegate.getAttendance(req.getParameter("choice"));
      	req.setAttribute("listattendDTOs",listattendDTOs);
      	rd=req.getRequestDispatcher("/list_attend.jsp");
      	rd.forward(req,res);
      	}
      	catch(InternalProblemException ipe){
      		req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res);
      	}
        }//if
     
      /*else if(pval.equalsIgnoreCase("View")){
        	delegate=new AttendanceOperationsBusinessDelegate();
        	try{
        	listattendDTOs=delegate.getAttendance(req.getParameter("choice"));
        	req.setAttribute("listattendDTOs",listattendDTOs);
        	rd=req.getRequestDispatcher("/selectattend_emp.jsp");
        	rd.forward(req,res);
        	}
        	catch(InternalProblemException ipe){
        		req.setAttribute("errMsg",ipe.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res);
        	}
    
      }//else if*/
        else if(pval.equalsIgnoreCase("ADD")){
        	attendDate=req.getParameter("attenddate");
        	empName=req.getParameter("ename");
        	empId=Integer.parseInt(req.getParameter("eid"));
        	entryStatus=req.getParameter("entry");
        	inTime=req.getParameter("intime");
        	outTime=req.getParameter("outtime");
    	  //use Delegage
    	  delegate=new AttendanceOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addAttendance(attendDate, empId, empName, entryStatus, inTime, outTime);
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
