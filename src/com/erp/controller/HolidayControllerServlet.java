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

import com.erp.delegate.HolidayOperationsBusinessDelegate;
import com.erp.delegate.ProductOperationsBusinessDelegate;
import com.erp.dto.HolidayDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

//@WebServlet("/controller")
public class HolidayControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       HolidayOperationsBusinessDelegate delegate=null;
       List<HolidayDTO> listHolidayDTOs=null;
       List<HolidayDTO> findHolidayDTOs=null;
       RequestDispatcher rd=null;
       String holidayRemovalMsg=null;
       String holidayName=null,holidayDate=null;
       int holidayId=0;
       String insertResult=null;
       PrintWriter out=res.getWriter();
       HttpSession session = req.getSession(true);
       
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new HolidayOperationsBusinessDelegate();
    	try{
    	listHolidayDTOs=delegate.getAllHolidays();
    	req.setAttribute("listHolidayDTOs",listHolidayDTOs);
    	rd=req.getRequestDispatcher("/list_holidays.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//if
      else if(pval.equalsIgnoreCase("Details")){
        	delegate=new HolidayOperationsBusinessDelegate();
        	try{
        	listHolidayDTOs=delegate.getHoliday(req.getParameter("choice"));
        	req.setAttribute("listHolidayDTOs",listHolidayDTOs);
        	rd=req.getRequestDispatcher("/list_holidays.jsp");
        	rd.forward(req,res);
        	}
        	catch(InternalProblemException ipe){
        		req.setAttribute("errMsg",ipe.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res);
        	}
          }//if
    //condition for ADD
        else if(pval.equalsIgnoreCase("Insert")){
        	
    	  holidayName=req.getParameter("hname");
    	  holidayDate=req.getParameter("hdate");
    	  
    	//use Delegage
    	  delegate=new HolidayOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addHoliday(holidayName,holidayDate);
    	   out.println("<script type=\"text/javascript\">");
           out.println("alert('"+insertResult+"');");
           out.println("location='firstpage.jsp';");
           out.println("</script>");

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
       
	}//doGet(-,-)

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
}//class
