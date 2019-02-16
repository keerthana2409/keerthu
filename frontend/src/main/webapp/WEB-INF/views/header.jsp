<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<c:url value='/resources/css/header.css'></c:url>">
<head>
<meta charset="ISO-8859-1">
<title>header</title>
</head>
<body>
<div class="navbar">
<nav class="navbar navbar-default" id="navcolor">
<div  class="navbar-header">
<a href="" class="navbar-brand"><img src="<c:url value='/resources/images/logo.jpg'></c:url>" height="40px" width="60px"></a>
<button type="button" class="navbar-toggle collapsed" 
   data-toggle="collapse" data-target="#collapse-example" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
</div>
<div class="collapse navbar-collapse" id="collapse-example">
<ul class="nav navbar-nav" id="links">
<li><a href="<c:url value='/'></c:url>"><span class="glyphicon glyphicon-home"></span>Home</a></li>
<li><a href="<c:url value='/all/getallproducts'></c:url>">Browse all products</a></li>
<security:authorize access="hasRole('ROLE_ADMIN')">
<li><a href="<c:url value='/admin/getproductform'></c:url>">Add Product</a></li>
</security:authorize>
<li class="dropdown">
			<a href="#" class="dropdown-toggle" data-toggle="dropdown">Select By Cateogory
			<span class="caret"></span></a>
			<ul class="dropdown-menu">
			<li><a href="<c:url value='/all/getallproducts/electronics'></c:url>">ELectronics</a></li>
			<li><a href="<c:url value='/all/getallproducts/fashion'></c:url>">Fashion</a></li>
			<li><a href="<c:url value='/all/getallproducts/books'></c:url>">Books</a></li>
			</ul>
			</li>
<c:if test="${pageContext.request.userPrincipal.name==null }">			
<li><a href="<c:url value='/all/getregistrationform'></c:url>">Sign Up</a></li>
<li><a href="<c:url value='/login'></c:url>"><span class="glyphicon glyphicon-log-in"></span>Sign In</a></li>
</c:if>
<c:if test="${pageContext.request.userPrincipal.name!=null }">
<security:authorize access="hasRole('ROLE_USER')">
<li><a href="<c:url value='/cart/getcartitems'></c:url>"><span class="glyphicon glyphicon-shopping-cart"></span>(${cartSize })</a></li>
</security:authorize>
<li><a href="<c:url value='/j_spring_security_logout'></c:url>"><span class="glyphicon glyphicon-log-out"></span>Sign Out</a></li>
<li><a href="">Welcome ${pageContext.request.userPrincipal.name }</a></li>
</c:if>
<li><a href="<c:url value='/aboutus'></c:url>">About Us</a></li>
</ul>
</div>
</nav>
</div>
</body>
</html>