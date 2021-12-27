<%@ page import ="petShopProject.beans.Commande" %>
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
            <li><a href="specials.jsp">specials pets</a></li>
            <li><a href="myaccount.jsp">my accout</a></li>
            <li><a href="register.jsp">register</a></li>
            <li><a href="details.jsp">prices</a></li>
            <li><a href="contact.jsp">contact</a></li>
            </ul>
        </div>    
            
            
       </div> 
       
       
       <div class="center_content">
       	<div class="left_content">
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>My cart<span style="margin-left:40px; color:green;font-size:13px;"> <%
            String nameUser = (String) session.getAttribute("nameUser");
            if(String.valueOf(session.getAttribute("nameUser")).equals("null")){
            	out.print("you are not connected");
            } else{
            out.print("connected: "+nameUser);} %></span></div>
        
        	<div class="feat_prod_box_details">
            
            <table class="cart_table">
            	<tr class="cart_title">
                	<td>Item pic</td>
                	<td>Book name</td>
                    <td>Unit price</td>
                    <td>Qty</td>
                    <td>Total</td>               
                </tr>
               <%
               List<Commande> commandes = new ArrayList<Commande>();            
               commandes = (List) request.getAttribute("commandes"); 
               application.setAttribute("commandes", request.getAttribute("commandes"));
               float x = 0.0f;
              if(String.valueOf(commandes).equals("null")) {
               	
               }else {
               for(Commande commande: commandes) {
               
               %> 
            	<tr>
                	<td><a href="details.jsp"><img src="<% out.println(commande.getItem_pic()); %>" alt="" title="" border="0" class="cart_thumb" /></a></td>
                	<td><% out.println(commande.getItem_name()); %></td>
                    <td><% out.println(commande.getPrice()+"$"); %></td>
                    <td><% out.println(commande.getQuantite()); %></td>
                    <td><% out.println(commande.getPrice()*commande.getQuantite()+"$"); %></td>               
                </tr>   
                <% x+=commande.getPrice()*commande.getQuantite();}} %>       
            <!--  	<tr>
                	<td><a href="details.jsp"><img src="images/cart_thumb.gif" alt="" title="" border="0" class="cart_thumb" /></a></td>
                	<td>Books</td>
                    <td>100$</td>
                    <td>1</td>
                    <td>100$</td>               
                </tr>                  
            	<tr>
                	<td><a href="details.jsp"><img src="images/cart_thumb.gif" alt="" title="" border="0" class="cart_thumb" /></a></td>
                	<td>Books</td>
                    <td>100$</td>
                    <td>1</td>
                    <td>100$</td>               
                </tr>
-->
                <tr>
                <td colspan="4" class="cart_total"><span class="red">TOTAL SHIPPING:</span></td>
                <td> 250$</td>                
                </tr>  
                
                <tr>
                <td colspan="4" class="cart_total"><span class="red">TOTAL:</span></td>
                <td> <% out.println(x+"$");%></td>                
                </tr>                  
            
            </table>
            <a href="index.jsp" class="continue">&lt; continue</a>
            <a href="#" class="checkout" id="checkout" onclick="payer()">checkout &gt;</a>
            

             
            
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
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
                <script>
                  var options = {
                    key: "rzp_test_aIfnpuWEudWnID", // Enter the Key ID generated from the Dashboard
                    amount: "5000", // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 $
                    currency: "INR",
                    name: "checkout",
                    description: "Secure payment",
                    handler: function (response) {
                      if (
                        typeof response.razorpay_payment_id == "undefined" ||
                        response.razorpay_payment_id < 1
                      ) {
                        swal({
                          title: "Please try again later!",
                          icon: "error",
                          button: "Close",
                        });
                      } else {
                        swal({
                          title: "Thank You!",
                          icon: "success",
                          button: "Close",
                        });
                      }
                    },
                    theme: {
                      color: "#3399cc",
                    },
                  };
                  var rzp1 = new Razorpay(options);
                  document.getElementById("checkout").onclick = function (
                    e
                  ) {
                	  e.preventDefault();
                    rzp1.open();
                   
                  };
                </script>

</body>
</html>