<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ page import ="petShopProject.beans.Products" %>
<%@ page import ="java.util.ArrayList" %>
<%@ page import ="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
<title>Pet Shop</title>
<link rel="stylesheet" type="text/css" href="style.css" />

</head>
<body>
<div id="wrap">

      <div class="header">
       		<div class="logo"><a href="index.jsp"><img src="images/logo.gif" alt="" title="" border="0" /></a></div>            
     <div id="menu">
            <ul>                                                                       
            <li><a href="index.jsp">home</a></li>
            <li><a href="about.jsp">about us</a></li>
            <li><a href="category.jsp">pets</a></li>
            <li class="selected"><a href="specials.jsp">specials pets</a></li>
            <li><a href="myaccount.jsp">my accout</a></li>
            <li><a href="register.jsp">register</a></li>
            <li><a href="details.jsp">prices</a></li>
            <li><a href="contact.jsp">contact</a></li>
            </ul>
        </div>     
            
            
       </div> 
       
       
       <div class="center_content">
       	<div class="left_content">
        	
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>Special gifts<span style="margin-left:40px; color:green;font-size:13px;"> <%
            String nameUser = (String) session.getAttribute("nameUser");
            if(String.valueOf(session.getAttribute("nameUser")).equals("null")){
            	out.print("you are not connected");
            } else{
            out.print("connected: "+nameUser);} %></span></div>
        
        
        
        
        
        
         	<%  List<Products> products = new ArrayList<Products>();            
            products = (List) application.getAttribute("products");            
           if(String.valueOf(products).equals("null")) {
            	
            }else {
            for(Products product: products) {
            	
            %>
        	<div class="feat_prod_box">   
        	  	<div class="prod_img"><a href="details.jsp"><img src="<% out.println(product.getImage()); %>" alt="" title="" border="0" /></a></div>
                
                <div class="prod_det_box">
                	<span class="special_icon"><img src="images/special_icon.gif" alt="" title="" /></span>
                	<div class="box_top"></div>
                    <div class="box_center">
                    <div class="prod_title"><% out.println(product.getTitle()); %></div>
                    <p class="details"><% out.println(product.getDetails()); %></p>
                    <a href="mainServ?productId=<%out.println(product.getId()); %>" class="more " >- more details -</a>
                    <div class="clear"></div>
                    </div>
                    
                    <div class="box_bottom"></div>
                </div>    
            <div class="clear"></div>
            </div>	
            
            <%}} %>
        <!--  	<div class="feat_prod_box">
            
            	<div class="prod_img"><a href="details.jsp"><img src="images/prod2.gif" alt="" title="" border="0" /></a></div>
                
                <div class="prod_det_box">
                <span class="special_icon"><img src="images/special_icon.gif" alt="" title="" /></span>
                	<div class="box_top"></div>
                    <div class="box_center">
                    <div class="prod_title">Product name</div>
                    <p class="details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
                    <a href="details.jsp" class="more">- more details -</a>
                    <div class="clear"></div>
                    </div>
                    
                    <div class="box_bottom"></div>
                </div>    
            <div class="clear"></div>
            </div>
            
            
            
        	<div class="feat_prod_box">
            
            	<div class="prod_img"><a href="details.jsp"><img src="images/prod1.gif" alt="" title="" border="0" /></a></div>
                
                <div class="prod_det_box">
                	<span class="special_icon"><img src="images/special_icon.gif" alt="" title="" /></span>
                	<div class="box_top"></div>
                    <div class="box_center">
                    <div class="prod_title">Product name</div>
                    <p class="details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
                    <a href="details.jsp" id="showDetail"class="more">- more details -</a>
                    <div class="clear"></div>
                    </div>
                    
                    <div class="box_bottom"></div>
                </div>    
            <div class="clear"></div>
            </div>	
            
            
        	<div class="feat_prod_box">
            
            	<div class="prod_img"><a href="details.jsp"><img id="image_specials" src="images/prod2.gif" alt="" title="" border="0" /></a></div>
                
                <div class="prod_det_box">
                <span class="special_icon"><img  src="images/special_icon.gif" alt="" title="" /></span>
                	<div class="box_top"></div>
                    <div class="box_center">
                    <div id="productName_specials" class="prod_title">Product nametoto</div>
                    <p class="details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
                    <a href="details.jsp" id="showDetail" class="more" onclick="show()">- more details -</a>
                    <div class="clear"></div>
                    </div>
                    
                    <div class="box_bottom"></div>
                </div>    
            <div class="clear"></div>
            </div>  -->          
            
                      <div class="pagination">
            <span class="disabled"><<</span><span class="current">1</span><a href="#?page=2">2</a><a href="#?page=3">3</a><a href="#?page=199">10</a><a href="#?page=200">11</a><a href="#?page=2">>></a>
            </div>   
                     
            
        <div class="clear"></div>
        </div><!--end of left content-->
        
              <jsp:include page="rightContent.jsp"/>
<!--end of right content-->
        
        
       
       
       <div class="clear"></div>
       </div><!--end of center content-->
       
              
       <div class="footer">
       	<div class="left_footer"><img src="images/footer_logo.gif" alt="" title="" /><br /> <a href="http://csscreme.com/freecsstemplates/" title="free css templates"><img src="images/csscreme.gif" alt="free css templates" border="0" /></a></div>
        <div class="right_footer">
        <a href="#">home</a>
        <a href="#">about us</a>
        <a href="#">services</a>
        <a href="#">privacy policy</a>
        <a href="#">contact us</a>
       
        </div>
        
       
       </div>
    

</div>
<script type="text/javascript" src="js/ordeer.js"></script>

</body>
</html>