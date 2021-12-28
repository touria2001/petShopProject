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
            <li class="selected"><a href="about.jsp">about us</a></li>
            <li><a href="category.jsp">pets</a></li>
            <li><a href="specials.jsp">specials pets</a></li>
            <li><a href="myaccount.jsp">my accout</a></li>
            <li><a href="register.jsp">register</a></li>
            <li><a href="details.jsp">prices</a></li>
            <li><a href="admin.jsp">admin</a></li>
            <li><a href="contact.jsp">contact</a></li>
            </ul>
        </div>       
            
            
       </div> 
       
       
       <div class="center_content">
       	<div class="left_content">
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>My account <span style="margin-left:40px; color:green;font-size:13px;"> <%
            String nameUser = (String) session.getAttribute("nameUser");
            if(String.valueOf(session.getAttribute("nameUser")).equals("null")){
            	out.print("you are not connected");
            } else{
            out.print("connected: "+nameUser);
            } %></span></div>
            
        
        	<div class="feat_prod_box_details">
            <p class="details">
             Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud. Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud.
            </p>
            
              	<div class="contact_form">
                <div class="form_subtitle">login into your account</div>
                 <form name="register" action="mainServ" method="post">          
                    <div class="form_row">
                    <label class="contact" ><strong>Username:</strong></label>
                    <input type="text" class="contact_input" name="user" />
                    </div>  


                    <div class="form_row">
                    <label class="contact" ><strong>Password:</strong></label>
                    <input type="password" class="contact_input" name="pass" />
                    </div>                     

                    <div class="form_row">
                        <div class="terms">
                        <input type="checkbox" name="terms" />
                        Remember me
                        </div>
                    </div> 

                    
                    <div class="form_row">
                    <input type="submit" class="register" value="login" />
                    </div>   
                    
                  </form>     
                    <p style="color:red" ><% 
                    String resultat = String.valueOf(application.getAttribute("resultat"));
                   if(String.valueOf(application.getAttribute("resultat")).equals("null")){
                    	out.print("");
                    }
                    else{               
                       out.print(application.getAttribute("resultat"));
                    } %></p>
                </div>  
            
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

</body>
</html>