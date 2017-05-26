<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Store</title>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
        <script src="http://s.codepen.io/assets/libs/modernizr.js" type="text/javascript"></script> 
        <link rel='stylesheet prefetch'  href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
        <link rel='stylesheet prefetch'  href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>
        <link rel='stylesheet prefetch' href='http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css'>
        <link rel='stylesheet prefetch'  href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="/datatables/dataTables.bootstrap.css">
        <!-- Content Wrapper. Contains page content -->
    </head>
    <body> 
        <div class="container">    
            <div class="header-middle"><!--header-middle-->
                <div class="container">
                    <div class="row">
                        <div class="logo pull-left">
                            <a href="index.html"><img src="images/logo.png" alt="" /></a>
                            <a class="navbar-brand" href="./">Book Store</a> 
                        </div> 
                        <div class="shop-menu pull-right">
                            <ul class="nav navbar-nav">
                                <!--                                <li><a href="acount"><i class="fa fa-user"></i> Account</a></li>
                                                                <li><a href="wishlist"><i class="fa fa-star"></i> Wishlist</a></li>
                                                                <li><a href="checkout"><i class="fa fa-crosshairs"></i> Checkout</a></li>-->
                                <li><a href="view_cart"><i class="fa fa-shopping-cart"></i> Cart</a></li>

                                <%if (session.getAttribute("user_c") == null) {%>
                                <li><a href="login"><i class="fa fa-lock"></i> Login</a></li>
                                    <%  }%>

                            </ul>
                        </div>
                    </div>
                </div> 
            </div><!--/header-middle-->
            <div class="row">