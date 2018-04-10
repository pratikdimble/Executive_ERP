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

import com.erp.delegate.VendorOperationsBusinessDelegate;
import com.erp.dto.VendorDTO;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;
import com.erp.errors.VendorRemovalProblemException;

@WebServlet("/vendor")
public class VendorControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       VendorOperationsBusinessDelegate delegate=null;
       List<VendorDTO> listVendorDTOs=null;
       List<VendorDTO> listEmpDTOs=null;
       List<VendorDTO> findVendorDTOs=null;
       RequestDispatcher rd=null;
       String vendorRemovalMsg=null;
       String vendorName=null,website=null,vendorCountry=null,vendorState=null,vendorCity=null,vendorAddr=null,vendorMail=null,business=null;
       int vendorId=0,pin=0;
       long mobile=0;
         String insertResult=null;
         PrintWriter out=res.getWriter();
         HttpSession session = req.getSession();
		//read additional req param value
         
        
         
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new VendorOperationsBusinessDelegate();
    	try{
    	listVendorDTOs=delegate.getAllVendor();
    	req.setAttribute("listVendorDTOs",listVendorDTOs);
    	rd=req.getRequestDispatcher("/list_vendor.jsp");
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
	//use Delegate
	  delegate=new VendorOperationsBusinessDelegate();
	  try{
	  insertResult=delegate.addVendor(vendorName, website, vendorCountry, vendorState, vendorCity, pin, vendorAddr, mobile, vendorMail, business);
	  out.println("<script type=\"text/javascript\">");
      out.println("alert('"+insertResult+"');");
      out.println("location='purchase_manager_firstpage.jsp';");
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
	  else if(pval.equalsIgnoreCase("Add Me")){
	    	//use Delegate
		  vendorName=req.getParameter("company");
	   	  website=req.getParameter("web");
	   	  
	   	  vendorCountry=req.getParameter("country");
	   	  vendorState=req.getParameter("state");
	   	  vendorCity=req.getParameter("city");
	   	  pin=Integer.parseInt(req.getParameter("pin"));
	   	  
	   	  vendorAddr=req.getParameter("addr");
	   	  mobile=Long.parseLong(req.getParameter("phone"));
	   	  vendorMail=req.getParameter("email");
	   	  
	   	  business=req.getParameter("business");
	    	  delegate=new VendorOperationsBusinessDelegate();
	    	  try{
	    	  insertResult=delegate.addVendor(vendorName, website, vendorCountry, vendorState, vendorCity, pin, vendorAddr, mobile, vendorMail, business);
	    	  out.println("<script type=\"text/javascript\">");
	          out.println("alert('"+insertResult+"');");
	          out.println("location='purchase_quotation.jsp';");
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
  
	  else if(pval.equalsIgnoreCase("Register Me")){
		  vendorName=req.getParameter("company");
	   	  website=req.getParameter("web");
	   	  
	   	  vendorCountry=req.getParameter("country");
	   	  vendorState=req.getParameter("state");
	   	  vendorCity=req.getParameter("city");
	   	  pin=Integer.parseInt(req.getParameter("pin"));
	   	  
	   	  vendorAddr=req.getParameter("addr");
	   	  mobile=Long.parseLong(req.getParameter("phone"));
	   	  vendorMail=req.getParameter("email");
	   	  
	   	  business=req.getParameter("business");
	    	//use Delegate
	    	  delegate=new VendorOperationsBusinessDelegate();
	    	  try{
	    	  insertResult=delegate.addVendor(vendorName, website, vendorCountry, vendorState, vendorCity, pin, vendorAddr, mobile, vendorMail, business);
	    	  out.println("<script type=\"text/javascript\">");
	          out.println("alert('"+insertResult+"');");
	          out.println("location='purchase_enquiry.jsp';");
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
      
	  else if(pval.equalsIgnoreCase("Signup")){
		  vendorName=req.getParameter("company");
	   	  website=req.getParameter("web");
	   	  
	   	  vendorCountry=req.getParameter("country");
	   	  vendorState=req.getParameter("state");
	   	  vendorCity=req.getParameter("city");
	   	  pin=Integer.parseInt(req.getParameter("pin"));
	   	  
	   	  vendorAddr=req.getParameter("addr");
	   	  mobile=Long.parseLong(req.getParameter("phone"));
	   	  vendorMail=req.getParameter("email");
	   	  
	   	  business=req.getParameter("business");
	    	//use Delegate
	    	  delegate=new VendorOperationsBusinessDelegate();
	    	  try{
	    	  insertResult=delegate.addVendor(vendorName, website, vendorCountry, vendorState, vendorCity, pin, vendorAddr, mobile, vendorMail, business);
	    	  out.println("<script type=\"text/javascript\">");
	          out.println("alert('"+insertResult+"');");
	          out.println("location='purchase_order.jsp';");
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
         else if(pval.equalsIgnoreCase("Update")){
         	delegate=new VendorOperationsBusinessDelegate();
         	try{
         		
         	listEmpDTOs=delegate.getVendor(req.getParameter("choice"));
         	req.setAttribute("listVendorDTOs",listEmpDTOs);
         	rd=req.getRequestDispatcher("/update_vendor_form.jsp");
         	rd.forward(req,res);
         	}
         	catch(InternalProblemException ipe){
         		req.setAttribute("errMsg",ipe.getMessage());
         		rd=req.getRequestDispatcher("/error.jsp");
         		rd.forward(req,res);
         	}
           }//if
         else if(pval.equalsIgnoreCase("View")){
          	delegate=new VendorOperationsBusinessDelegate();
          	try{
          		
          	listEmpDTOs=delegate.getVendor(req.getParameter("choice"));
          	req.setAttribute("listVendorDTOs",listEmpDTOs);
          	rd=req.getRequestDispatcher("/list_vendor.jsp");
          	rd.forward(req,res);
          	}
          	catch(InternalProblemException ipe){
          		req.setAttribute("errMsg",ipe.getMessage());
          		rd=req.getRequestDispatcher("/error.jsp");
          		rd.forward(req,res);
          	}
            }//if
      
         else if(pval.equalsIgnoreCase("Delete")){
          	delegate=new VendorOperationsBusinessDelegate();
          	try{
          		insertResult=delegate.deleteVendor(Integer.parseInt(req.getParameter("choice")));
          		out.println("<script type=\"text/javascript\">");
             out.println("alert('"+insertResult+"');");
             out.println("location='purchase_manager_firstpage.jsp';");
             out.println("</script>");
          	}
          	catch(VendorRemovalProblemException ipe){
          		req.setAttribute("errMsg",ipe.getMessage());
          		rd=req.getRequestDispatcher("/error.jsp");
          		rd.forward(req,res);
          		}
          	catch(InternalProblemException ipe){
          		req.setAttribute("errMsg",ipe.getMessage());
          		rd=req.getRequestDispatcher("/error.jsp");
          		rd.forward(req,res);
          		}
            }//if
         
   
        else if(pval.equalsIgnoreCase("Save Changes")){
        	vendorId=Integer.parseInt(req.getParameter("vendorid"));
      	  
        website=req.getParameter("web");
      	  vendorCountry=req.getParameter("country");
      	  vendorState=req.getParameter("state");
      	  vendorCity=req.getParameter("city");
      	  pin=Integer.parseInt(req.getParameter("pin"));
      	  
      	  vendorAddr=req.getParameter("addr");
      	  mobile=Long.parseLong(req.getParameter("phone"));
      	  vendorMail=req.getParameter("email");
      	  
      	  business=req.getParameter("business");
      	  
      	//use Delegage
      	  delegate=new VendorOperationsBusinessDelegate();
      	  try{
      	  insertResult=delegate.updateVendor(vendorId, vendorName, website, vendorCountry, vendorState, vendorCity, pin, vendorAddr, mobile, vendorMail, business);
      	 out.println("<script type=\"text/javascript\">");
         out.println("alert('"+insertResult+"');");
         out.println("location='purchase_manager_firstpage.jsp';");
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
