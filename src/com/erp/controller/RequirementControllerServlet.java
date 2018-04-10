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

import com.erp.delegate.RequirementOperationsBusinessDelegate;
import com.erp.delegate.RequirementOperationsBusinessDelegate;
import com.erp.delegate.RequirementOperationsBusinessDelegate;
import com.erp.dto.RequirementDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

@WebServlet("/custreq")
public class RequirementControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       RequirementOperationsBusinessDelegate delegate=null;
       List<RequirementDTO> listRequirementDTOs=null;
       List<RequirementDTO> findRequirementDTOs=null;
       RequestDispatcher rd=null;
       String enquiryRemovalMsg=null;
       String  empName=null, custName=null, dsgn=null, prodName=null, prodType=null, company=null;
       int regId=0,quantity=0,empid=0, custid=0,stock=0;
       String insertResult=null;
       PrintWriter out=res.getWriter();
       HttpSession session = req.getSession(true);
       String thisRole = (String) session.getAttribute("role");
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new RequirementOperationsBusinessDelegate();
    	try{
    	listRequirementDTOs=delegate.getAllRequirements();
    	req.setAttribute("listRequirementDTOs",listRequirementDTOs);
    	rd=req.getRequestDispatcher("/list_requirements.jsp");
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
        	empid=Integer.parseInt(req.getParameter("eid"));
        	custid=Integer.parseInt(req.getParameter("custid"));
      empName=req.getParameter("ename");
      custName=req.getParameter("custname");
      dsgn=req.getParameter("dsgn");
      
      prodName=req.getParameter("pname");
      prodType=req.getParameter("prodtype");
      company=req.getParameter("company");
      
      quantity=Integer.parseInt(req.getParameter("quantity"));
    	 stock=Integer.parseInt(req.getParameter("quan"));
    	//use Delegage
    	  delegate=new RequirementOperationsBusinessDelegate();
    	  try{
    	  insertResult=delegate.addRequirement(empid, custid, empName, custName, dsgn, prodName, prodType, company, quantity,stock);
    	  out.println("<script type=\"text/javascript\">");
          out.println("alert('"+insertResult+"');");
          	if(thisRole.equalsIgnoreCase("Product Executive"))
          	{
          		out.println("location='prod_exec_firstpage.jsp';");
          	}
          	else if(thisRole.equalsIgnoreCase("Service Executive"))
          	{
          		out.println("location='service_exec_firstpage.jsp';");
          	}

          	else
          	{
          		out.println("location='home.jsp';");
          	}
          	
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
        else if(pval.equalsIgnoreCase("Report")){
      	  
      	 // int enquiryId =(Integer)session.getAttribute("id");
      	  
      	  String ename=(String)session.getAttribute("empname");
        	delegate=new RequirementOperationsBusinessDelegate();
        	try{
        	listRequirementDTOs=delegate.getUserRequirement(ename);
        	req.setAttribute("listRequirementDTOs",listRequirementDTOs);
        	rd=req.getRequestDispatcher("/enquiry_exec_status.jsp");
        	rd.forward(req,res);
        	}
        	catch(InternalProblemException ipe){
        		req.setAttribute("errMsg",ipe.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res);
        	}
          }//else if
      
        else if(pval.equalsIgnoreCase("Delivered")){
        	  //use Delegage
        	  delegate=new RequirementOperationsBusinessDelegate();
        	  String Status="Delivered";
        	  int id=Integer.parseInt(req.getParameter("choice"));
        	  try{
        	  insertResult=delegate.updateStatusDeliver(id, Status);
        	    out.println("<script type=\"text/javascript\">");
                out.println("alert('"+insertResult+"');");
                if(thisRole.equalsIgnoreCase("Product Executive"))
              	{
              		out.println("location='prod_exec_firstpage.jsp';");
              	}
              	else if(thisRole.equalsIgnoreCase("Service Executive"))
              	{
              		out.println("location='service_exec_firstpage.jsp';");
              	}
                else
              	{
              		out.println("location='home.jsp';");
              	}
              out.println("</script>");

        	  }
        	  catch(Exception e){
        		  req.setAttribute("errMsg",e.getMessage());
            		rd=req.getRequestDispatcher("/error.jsp");
            		rd.forward(req,res); 
        	  }
          }
          else if(pval.equalsIgnoreCase("Cancel")){
        	  //use Delegage
        	  delegate=new RequirementOperationsBusinessDelegate();
        	  String Status="Canceled";
        	  /*int id=Integer.parseInt(req.getParameter("choice"));
        	  prodName=req.getParameter("pname");
              prodType=req.getParameter("ptype");
              company=req.getParameter("company");
              quantity=Integer.parseInt(req.getParameter("quantity"));*/
        	  
        	  int id=(Integer)session.getAttribute("pid");
        	  prodName = (String) session.getAttribute("prodName");
        	 prodType = (String) session.getAttribute("prodType");
        	 company = (String) session.getAttribute("company");
        	 quantity = (Integer) session.getAttribute("quantity");
        	 stock=(Integer)session.getAttribute("stock");
        	 System.out.println("*****\n\t"+id+"\t"+prodName+"\t"+prodType+"\t"+company+"\t"+quantity+"\t"+stock);
        	  try{
        	  insertResult=delegate.updateStatusCancel(id, Status, prodName, prodType, company, quantity, stock);
        	    out.println("<script type=\"text/javascript\">");
                out.println("alert('"+insertResult+"');");
                if(thisRole.equalsIgnoreCase("Product Executive"))
              	{
              		out.println("location='prod_exec_firstpage.jsp';");
              	}
              	else if(thisRole.equalsIgnoreCase("Service Executive"))
              	{
              		out.println("location='service_exec_firstpage.jsp';");
              	}
                else
              	{
              		out.println("location='home.jsp';");
              	}
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
      	delegate=new RequirementOperationsBusinessDelegate();
    	try{
    	listRequirementDTOs=delegate.findRequirement(sid);
    	req.setAttribute("findRequirementDTOs",findRequirementDTOs);
    	rd=req.getRequestDispatcher("/search_Requirement.jsp");
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
