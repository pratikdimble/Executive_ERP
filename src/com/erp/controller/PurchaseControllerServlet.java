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

import com.erp.delegate.PurchaseOperationsBusinessDelegate;
import com.erp.dto.PurchaseDTO;
import com.erp.dto.PurchaseQuotationDTO;
import com.erp.errors.PurchaseRemovalProblemException;
import com.erp.errors.InsertOperationProblemException;
import com.erp.errors.InternalProblemException;

@WebServlet("/purchase")
public class PurchaseControllerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       String pval=null;
       PurchaseOperationsBusinessDelegate delegate=null;
       List<PurchaseDTO> listpurchaseDTOs=null;
       List<PurchaseQuotationDTO> listquotationDTOs=null;
       List<PurchaseDTO> findpurchaseDTOs=null;
       RequestDispatcher rd=null;
       String purchaseRemovalMsg=null,custReq=null,provider=null;
       String empName=null, design=null, suppName=null, address=null, prodName=null, prodType=null, serName=null, company=null;
       float prodCost=0,sercost=0;
		float prodAmount=0,prodTax=0,prodGross=0,prodDiscount=0,prodGrand=0;
		float serAmount=0,serTax=0,serGross=0,serDiscount=0,serGrand=0;
       int sid=0,quantity=0,suppId=0,prodId=0;
       long contact=0;
         String insertResult=null;
         PrintWriter out=res.getWriter();
         HttpSession session = req.getSession(true);
         
		//read additional req param value
      pval=req.getParameter("operation");
      if(pval.equalsIgnoreCase("link1")){
    	delegate=new PurchaseOperationsBusinessDelegate();
    	try{
    	listpurchaseDTOs=delegate.getAllPurchases();
    	req.setAttribute("listpurchaseDTOs",listpurchaseDTOs);
    	rd=req.getRequestDispatcher("/list_purchases.jsp");
    	rd.forward(req,res);
    	}
    	catch(InternalProblemException ipe){
    		req.setAttribute("errMsg",ipe.getMessage());
    		rd=req.getRequestDispatcher("/error.jsp");
    		rd.forward(req,res);
    	}
      }//if
      else if(pval.equalsIgnoreCase("details")){
      	delegate=new PurchaseOperationsBusinessDelegate();
      	String prod=req.getParameter("product");
      	String supp=req.getParameter("supplier");
      	System.out.println(prod+"\t"+supp);
      	try{
      		if(supp.equalsIgnoreCase("none"))
      		{
      			listpurchaseDTOs=delegate.getPurchaseByProduct(req.getParameter("product"));
      		}
      			else if(prod.equalsIgnoreCase("none"))
      		{
      			listpurchaseDTOs=delegate.getPurchaseBySupplier(req.getParameter("supplier"));
      		}
      	req.setAttribute("listpurchaseDTOs",listpurchaseDTOs);
      	rd=req.getRequestDispatcher("/list_purchases.jsp");
      	rd.forward(req,res);
      	}
      	catch(InternalProblemException ipe){
      		req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res);
      	}
        }//if
      
      else if(pval.equalsIgnoreCase("View All")){
      	delegate=new PurchaseOperationsBusinessDelegate();
      	try{
      	listquotationDTOs=delegate.loadAllQUOTATION();
      	req.setAttribute("listpurchaseDTOs",listquotationDTOs);
      				rd=req.getRequestDispatcher("/list_purchase_quotation.jsp");
      	rd.forward(req,res);
      	}
      	catch(InternalProblemException ipe){
      		req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res);
      	}
        }//if
     
     
      /*else if(pval.equalsIgnoreCase("Edit")){
        	delegate=new PurchaseOperationsBusinessDelegate();
        	custReq=req.getParameter("custreq");
        	try{
        	listquotationDTOs=delegate.editQUOTATION(Integer.parseInt(req.getParameter("choice")));
        	req.setAttribute("listpurchaseDTOs",listquotationDTOs);
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
      
      
*/      
     /* else if(pval.equalsIgnoreCase("View")){
    	  String thisRole = (String) session.getAttribute("empname");
      	delegate=new PurchaseOperationsBusinessDelegate();
      	try{
      		
      	listpurchaseDTOs=delegate.getPurchase(thisRole);
      	req.setAttribute("listpurchaseDTOs",listpurchaseDTOs);
      	rd=req.getRequestDispatcher("/select_purchases.jsp");
      	rd.forward(req,res);
      	}
      	catch(InternalProblemException ipe){
      		req.setAttribute("errMsg",ipe.getMessage());
      		rd=req.getRequestDispatcher("/error.jsp");
      		rd.forward(req,res);
      	}
        }//if
*/      else if(pval.equalsIgnoreCase("DELETE")){
    	  //use Delegage
    	  delegate=new PurchaseOperationsBusinessDelegate();
    	  try{
    	 purchaseRemovalMsg=delegate.deletePurchase(Integer.parseInt(req.getParameter("choice")));
    	 out.println("<script type=\"text/javascript\">");
         out.println("alert('"+purchaseRemovalMsg+"');");
         out.println("location='purchases_manager_firstpage.jsp';");
         out.println("</script>");
    	  }
    	  catch(PurchaseRemovalProblemException sepe){
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
    	  delegate=new PurchaseOperationsBusinessDelegate();
    	  try{
    	 purchaseRemovalMsg=delegate.deleteQuotation(Integer.parseInt(req.getParameter("choice")));
    	 out.println("<script type=\"text/javascript\">");
         out.println("alert('"+purchaseRemovalMsg+"');");
         out.println("location='purchase_manager_firstpage.jsp';");
         out.println("</script>");
    	  }
    	  catch(PurchaseRemovalProblemException sepe){
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
    	  delegate=new PurchaseOperationsBusinessDelegate();
    	  	 suppId=Integer.parseInt(req.getParameter("suppid"));
    	  suppName=req.getParameter("suppname");
    	  address=req.getParameter("addr");
    	  contact=Long.parseLong(req.getParameter("contact"));
    	  
    	  	prodId=Integer.parseInt(req.getParameter("pid"));
    	  	prodName=req.getParameter("prodname");
    	  	prodType=req.getParameter("prodtype");
    	  	company=req.getParameter("company");
    	  	quantity=Integer.parseInt(req.getParameter("quantity"));
    	  	prodCost=Float.parseFloat(req.getParameter("prodcost"));
    	  try{
    	  insertResult=delegate.addPurchaseEnquiry(suppId, suppName, address, contact, prodId, prodName, prodType, company, quantity, prodCost);
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
        
        else if(pval.equalsIgnoreCase("Generate Quotation")){
        	//use Delegage
        	  delegate=new PurchaseOperationsBusinessDelegate();
        	  empName=req.getParameter("name");
        	  	 
        	  	 suppId=Integer.parseInt(req.getParameter("suppid"));
        	  	 suppName=req.getParameter("suppname");
        	  	 address=req.getParameter("addr");
        	  	 contact=Long.parseLong(req.getParameter("contact"));
        	  	 
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
        	     	  

        	  try{
        	  insertResult=delegate.addPurchaseQuotation(empName, suppId, suppName, address, contact, prodName, prodType, company, quantity, prodCost, prodAmount, prodTax, prodGross, prodDiscount, prodGrand);
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
