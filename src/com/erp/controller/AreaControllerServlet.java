package com.erp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.delegate.AreaOperationsBusinessDelegate;
import com.erp.dto.AreaDTO;
import com.erp.errors.AreaRemovalProblemException;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

//@WebServlet("/controller")
public class AreaControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       AreaOperationsBusinessDelegate delegate=null;
       List<AreaDTO> listAreaDTOs=null;
       List<AreaDTO> findAreaDTOs=null;
       RequestDispatcher rd=null;
       String areaRemovalMsg=null;
       String areaName=null, desc=null,regName=null;
       int areaId=0;
       String insertResult=null;
       
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new AreaOperationsBusinessDelegate();
    	try{
    	listAreaDTOs=delegate.getAllArea();
    	req.setAttribute("listAreaDTOs",listAreaDTOs);
    	rd=req.getRequestDispatcher("/list_area.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//if
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link4")){
    	delegate=new AreaOperationsBusinessDelegate();
    	try{
    	listAreaDTOs=delegate.getAllArea();
    	req.setAttribute("listAreaDTOs",listAreaDTOs);
    	rd=req.getRequestDispatcher("/NewTest.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//if
      
      
      
    //condition for DELETE
      else if(pval.equalsIgnoreCase("DELETE")){
    	  //use Delegage
    	  delegate=new AreaOperationsBusinessDelegate();
    	  try{
    	 areaRemovalMsg=delegate.deleteArea(Integer.parseInt(req.getParameter("id")));
    	  req.setAttribute("areaRemovalMsg", areaRemovalMsg);
  	  	rd=req.getRequestDispatcher("deleteArea.jsp");
    	rd.forward(req,res);
    	  listAreaDTOs=delegate.getAllArea();
      	  req.setAttribute("listAreaDTO",listAreaDTOs);


    	  }
    	  catch(AreaRemovalProblemException sepe){
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
        	regName=req.getParameter("reg");
    	  areaName=req.getParameter("area");
    	  desc=req.getParameter("desc");
     
    	  
    	//use Delegage
    	  delegate=new AreaOperationsBusinessDelegate();
    	  try{
//    	  insertResult=delegate.addArea(regName,areaName,desc);
    		  insertResult=delegate.addAreaToExistingRegion(regName, areaName, desc);
          req.setAttribute("insertMsg",insertResult);
          	rd=req.getRequestDispatcher("/area_ack.jsp");
  				rd.forward(req,res);
          
          
          listAreaDTOs=delegate.getAllArea();
          req.setAttribute("listAreaDTOs",listAreaDTOs);
          
         	rd=req.getRequestDispatcher("/list_area.jsp");
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
      	delegate=new AreaOperationsBusinessDelegate();
    	try{
    	listAreaDTOs=delegate.findArea(sid);
    	req.setAttribute("findAreaDTOs",findAreaDTOs);
    	rd=req.getRequestDispatcher("/search_Area.jsp");
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
