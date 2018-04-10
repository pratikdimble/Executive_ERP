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

import com.erp.delegate.SaleOperationsBusinessDelegate;
import com.erp.dto.SaleDTO;
import com.erp.dto.SaleQuotationDTO;
import com.erp.errors.SaleRemovalProblemException;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

@WebServlet("/sale")
public class SaleControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       SaleOperationsBusinessDelegate delegate=null;
       List<SaleDTO> listsaleDTOs=null;
       List<SaleQuotationDTO> listquotationDTOs=null;
       List<SaleDTO> findsaleDTOs=null;
       RequestDispatcher rd=null;
       String saleRemovalMsg=null,custReq=null,provider=null;
       String empName=null, design=null, custName=null, address=null, prodName=null, prodType=null, serName=null, company=null;
       float prodCost=0,sercost=0;
		float prodAmount=0,prodTax=0,prodGross=0,prodDiscount=0,prodGrand=0;
		float serAmount=0,serTax=0,serGross=0,serDiscount=0,serGrand=0;
       int sid=0,quantity=0,custId=0;
       long contact=0;
         String insertResult=null;
         PrintWriter out=res.getWriter();
         HttpSession session = req.getSession(true);
         
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new SaleOperationsBusinessDelegate();
    	try{
    	listsaleDTOs=delegate.getAllSales();
    	req.setAttribute("listsaleDTOs",listsaleDTOs);
    	rd=req.getRequestDispatcher("/list_sales.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//if
      else if(pval.equalsIgnoreCase("product")){
      	delegate=new SaleOperationsBusinessDelegate();
      	try{
      	listquotationDTOs=delegate.loadAllPRODUCTQUOTATION();
      	req.setAttribute("listsaleDTOs",listquotationDTOs);
      	rd=req.getRequestDispatcher("/list_prod_quotation.jsp");
      	rd.forward(req,res);
      	}
      	catch(InternalProblemException ipe){
      		req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res);
      	}
        }//if
      else if(pval.equalsIgnoreCase("Edit")){
        	delegate=new SaleOperationsBusinessDelegate();
        	custReq=req.getParameter("custreq");
        	try{
        	listquotationDTOs=delegate.editQUOTATION(Integer.parseInt(req.getParameter("choice")));
        	req.setAttribute("listsaleDTOs",listquotationDTOs);
        		if(custReq.equalsIgnoreCase("Product Only")){
        				rd=req.getRequestDispatcher("/edit_prod_quotation.jsp");
        		}else
        		{
        			rd=req.getRequestDispatcher("/edit_ser_quotation.jsp");
        		}
        	rd.forward(req,res);
        	}
        	catch(InternalProblemException ipe){
        		req.setAttribute("errMsg",ipe.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res);
        	}
          }//if
      
      else if(pval.equalsIgnoreCase("service")){
        	delegate=new SaleOperationsBusinessDelegate();
        	try{
        	listquotationDTOs=delegate.loadAllSERVICEQUOTATION();
        	req.setAttribute("listsaleDTOs",listquotationDTOs);
        	rd=req.getRequestDispatcher("/list_ser_quotation.jsp");
        	rd.forward(req,res);
        	}
        	catch(InternalProblemException ipe){
        		req.setAttribute("errMsg",ipe.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res);
        	}
          }//if
      
      else if(pval.equalsIgnoreCase("View")){
    	  String thisRole = (String) session.getAttribute("empname");
      	delegate=new SaleOperationsBusinessDelegate();
      	try{
      		
      	listsaleDTOs=delegate.getSale(thisRole);
      	req.setAttribute("listsaleDTOs",listsaleDTOs);
      	rd=req.getRequestDispatcher("/select_sales.jsp");
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
    	  delegate=new SaleOperationsBusinessDelegate();
    	  try{
    	 saleRemovalMsg=delegate.deleteSale(Integer.parseInt(req.getParameter("choice")));
    	 out.println("<script type=\"text/javascript\">");
         out.println("alert('"+saleRemovalMsg+"');");
         out.println("location='salesmanagerfirstpage.jsp';");
         out.println("</script>");
    	  }
    	  catch(SaleRemovalProblemException sepe){
    		req.setAttribute("errMsg",sepe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res); 
    	  }
    	 
    	  catch(Exception e){
    		  req.setAttribute("errMsg",e.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res); 
    	  }
      }//else if
      
      else if(pval.equalsIgnoreCase("DELETE QUOTATION")){
    	  //use Delegage
    	  delegate=new SaleOperationsBusinessDelegate();
    	  try{
    	 saleRemovalMsg=delegate.deleteQuotation(Integer.parseInt(req.getParameter("choice")));
    	 out.println("<script type=\"text/javascript\">");
         out.println("alert('"+saleRemovalMsg+"');");
         out.println("location='salesmanagerfirstpage.jsp';");
         out.println("</script>");
    	  }
    	  catch(SaleRemovalProblemException sepe){
    		req.setAttribute("errMsg",sepe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res); 
    	  }
    	 
    	  catch(Exception e){
    		  req.setAttribute("errMsg",e.getMessage());
        		rd=req.getRequestDispatcher("/error.jsp");
        		rd.forward(req,res); 
    	  }
      }//else if
      else if(pval.equalsIgnoreCase("Remove")){
    	  //use Delegage
    	  delegate=new SaleOperationsBusinessDelegate();
    	  try{
    	 saleRemovalMsg=delegate.deleteQuotation(Integer.parseInt(req.getParameter("choice")));
    	 out.println("<script type=\"text/javascript\">");
         out.println("alert('"+saleRemovalMsg+"');");
         out.println("location='salesmanagerfirstpage.jsp';");
         out.println("</script>");
    	  }
    	  catch(SaleRemovalProblemException sepe){
    		req.setAttribute("errMsg",sepe.getMessage());
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
    	//use Delegage
    	  delegate=new SaleOperationsBusinessDelegate();
    	  empName=req.getParameter("name");
    	  	 design=req.getParameter("dsgn");
    	  	 custId=Integer.parseInt(req.getParameter("custid"));
    	  custName=req.getParameter("custname");
 	  address=req.getParameter("addr");
 	  contact=Long.parseLong(req.getParameter("contact"));
 	  custReq=req.getParameter("type");
 	  prodName=req.getParameter("pname");
 	  prodType=req.getParameter("prodtype");
 	 company=req.getParameter("company");
 	  quantity=Integer.parseInt(req.getParameter("quantity"));
 	  //prodCost=Float.parseFloat(req.getParameter("prodcost"));
 	  //sercost=Float.parseFloat(req.getParameter("sercost"));
 	  serName=req.getParameter("sername");
 	 provider=req.getParameter("provider");
 	 
 	if(custReq.equalsIgnoreCase("Product Only")){
 		 /*prodName=req.getParameter("prodname");
    	  prodType=req.getParameter("prodtype");
    	  company=req.getParameter("company");
    	  quantity=Integer.parseInt(req.getParameter("quantity"));*/
    	  prodCost=Float.parseFloat(req.getParameter("prodcost"));
    	  sercost=0;
 			}
		 		else if(custReq.equalsIgnoreCase("Service Only")){
       	     	  
       	     	/*  serName=req.getParameter("sername");
       	     	  provider=req.getParameter("provider");*/
       	     	  sercost=Float.parseFloat(req.getParameter("sercost"));
       	     	prodCost=0;
				 }
		 		else
		 		{
		 			 prodName=req.getParameter("pname");
       	     	  prodType=req.getParameter("prodtype");
       	     	  company=req.getParameter("company");
       	     	  quantity=Integer.parseInt(req.getParameter("quantity"));
       	     	  prodCost=Float.parseFloat(req.getParameter("prodcost"));
       	     	  
       	     	  serName=req.getParameter("sername");
       	     	  provider=req.getParameter("provider");
       	     	  sercost=Float.parseFloat(req.getParameter("sercost"));
       	     	  
       	     	  prodAmount=Float.parseFloat(req.getParameter("total"));
       	     	  prodTax=Float.parseFloat(req.getParameter("servicetax"));
       	     	  prodGross=Float.parseFloat(req.getParameter("grossnet"));
       	     	  prodDiscount=Float.parseFloat(req.getParameter("discount"));
       	     	  prodGrand=Float.parseFloat(req.getParameter("grossamount"));
       	     	  
       	     	  serAmount=Float.parseFloat(req.getParameter("seramt"));
       	     	  serTax=Float.parseFloat(req.getParameter("sertax"));
       	     	  serGross=Float.parseFloat(req.getParameter("sergrossnet"));
       	     	  serDiscount=Float.parseFloat(req.getParameter("serdiscount"));
       	     	  serGrand=Float.parseFloat(req.getParameter("sergrossamount"));
				 }

    	  try{
    	  insertResult=delegate.addSaleEnquiry(empName, design, custId, custName, address, contact, custReq, prodName, prodType, company, quantity, prodCost, serName, provider, sercost);
    	  out.println("<script type=\"text/javascript\">");
          out.println("alert('"+insertResult+"');");
          out.println("location='salesmanagerfirstpage.jsp';");
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
        
        else if(pval.equalsIgnoreCase("Generate Quotation")){
        	//use Delegage
        	  delegate=new SaleOperationsBusinessDelegate();
        	  empName=req.getParameter("name");
        	  design=req.getParameter("dsgn");
        	  	 
        	  	 custId=Integer.parseInt(req.getParameter("custid"));
        	  	 custName=req.getParameter("custname");
        	  	 address=req.getParameter("addr");
        	  	 contact=Long.parseLong(req.getParameter("contact"));
        	  	 custReq=req.getParameter("custreq");
        	  	 
        	  	if(custReq.equalsIgnoreCase("Product Only")){
        	  		 prodName=req.getParameter("prodname");
        	     	  prodType=req.getParameter("prodtype");
        	     	  company=req.getParameter("company");
        	     	  quantity=Integer.parseInt(req.getParameter("quantity"));
        	     	  prodCost=Float.parseFloat(req.getParameter("prodcost"));
        	     	  
        	     	  prodAmount=Float.parseFloat(req.getParameter("total"));
        	     	  prodTax=Float.parseFloat(req.getParameter("servicetax"));
        	     	  prodGross=Float.parseFloat(req.getParameter("grossnet"));
        	     	  prodDiscount=Float.parseFloat(req.getParameter("discount"));
        	     	  prodGrand=Float.parseFloat(req.getParameter("grossamount"));
        	     	  
        	  			}
        			 		else if(custReq.equalsIgnoreCase("Service Only")){
        	        	     	  
        	        	     	  serName=req.getParameter("sername");
        	        	     	  provider=req.getParameter("provider");
        	        	     	  sercost=Float.parseFloat(req.getParameter("sercost"));
        	        	     	  
        	        	     	  serAmount=Float.parseFloat(req.getParameter("seramt"));
        	        	     	  serTax=Float.parseFloat(req.getParameter("sertax"));
        	        	     	  serGross=Float.parseFloat(req.getParameter("sergrossnet"));
        	        	     	  serDiscount=Float.parseFloat(req.getParameter("serdiscount"));
        	        	     	  serGrand=Float.parseFloat(req.getParameter("sergrossamount"));
        					 }
        			 		else
        			 		{
        			 			 prodName=req.getParameter("pname");
        	        	     	  prodType=req.getParameter("prodtype");
        	        	     	  company=req.getParameter("company");
        	        	     	  quantity=Integer.parseInt(req.getParameter("quantity"));
        	        	     	  prodCost=Float.parseFloat(req.getParameter("prodcost"));
        	        	     	  
        	        	     	  serName=req.getParameter("sername");
        	        	     	  provider=req.getParameter("provider");
        	        	     	  sercost=Float.parseFloat(req.getParameter("sercost"));
        	        	     	  
        	        	     	  prodAmount=Float.parseFloat(req.getParameter("total"));
        	        	     	  prodTax=Float.parseFloat(req.getParameter("servicetax"));
        	        	     	  prodGross=Float.parseFloat(req.getParameter("grossnet"));
        	        	     	  prodDiscount=Float.parseFloat(req.getParameter("discount"));
        	        	     	  prodGrand=Float.parseFloat(req.getParameter("grossamount"));
        	        	     	  
        	        	     	  serAmount=Float.parseFloat(req.getParameter("seramt"));
        	        	     	  serTax=Float.parseFloat(req.getParameter("sertax"));
        	        	     	  serGross=Float.parseFloat(req.getParameter("sergrossnet"));
        	        	     	  serDiscount=Float.parseFloat(req.getParameter("serdiscount"));
        	        	     	  serGrand=Float.parseFloat(req.getParameter("sergrossamount"));
        					 }
     	  
     	 

        	  try{
        	  insertResult=delegate.addSaleQuotation(empName, design, custId, custName, address, contact, custReq, prodName, prodType, company, quantity, prodCost, serName, provider, sercost, prodAmount, prodTax, prodGross, prodDiscount, prodGrand, serAmount, serTax, serGross, serDiscount, serGrand);
        	  out.println("<script type=\"text/javascript\">");
              out.println("alert('"+insertResult+"');");
              out.println("location='salesmanagerfirstpage.jsp';");
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
