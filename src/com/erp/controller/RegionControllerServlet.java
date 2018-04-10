package com.erp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.delegate.RegionOperationsBusinessDelegate;
import com.erp.dto.RegionDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

//@WebServlet("/controller")
public class RegionControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       RegionOperationsBusinessDelegate delegate=null;
       List<RegionDTO> listRegionDTOs=null;
       List<RegionDTO> findRegionDTOs=null;
       RequestDispatcher rd=null;
       String regionRemovalMsg=null;
       String regName=null,regDesc=null,areaName=null,areaDesc=null;
       int regId=0;
       String insertResult=null;
       
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new RegionOperationsBusinessDelegate();
    	try{
    	listRegionDTOs=delegate.getAllRegions();
    	req.setAttribute("listRegionDTOs",listRegionDTOs);
    	rd=req.getRequestDispatcher("/list_regions.jsp");
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
      regName=req.getParameter("regname");
    	  regDesc=req.getParameter("regdesc");
    	  areaName=req.getParameter("areaname");
    	  areaDesc=req.getParameter("areadesc");
    	//use Delegage
    	  delegate=new RegionOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addRegion(regName, regDesc,areaName,areaDesc);
          req.setAttribute("insertMsg",insertResult);
          	rd=req.getRequestDispatcher("/region_ack.jsp");
  				rd.forward(req,res);
          
/*          
          listRegionDTOs=delegate.getAllRegions();
          req.setAttribute("listRegionDTOs",listRegionDTOs);
          
         	rd=req.getRequestDispatcher("/list_regions.jsp");
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
      	delegate=new RegionOperationsBusinessDelegate();
    	try{
    	listRegionDTOs=delegate.findRegion(sid);
    	req.setAttribute("findRegionDTOs",findRegionDTOs);
    	rd=req.getRequestDispatcher("/search_Region.jsp");
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
