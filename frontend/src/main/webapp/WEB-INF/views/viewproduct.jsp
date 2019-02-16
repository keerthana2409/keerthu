<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<b>Product Details
</b>
<pre>
<b>Product Name  :</b> ${productAttr.productName}
<b>Description   :</b>${productAttr.description }
<b>Price         :</b>${productAttr.price }
<b>In Stock      :</b>${productAttr.quantity}
<security:authorize access="hasRole('ROLE_USER')">
<form action="<c:url value='/cart/addtocart/${ productAttr.id}'></c:url>" >
Enter required units<br>
<input type="number" name="requestedQuantity" min="1" max="${productAttr.quantity }">
<input type="submit" class="btn btn-lg btn-info" value="Add To Cart">
</form> 
</security:authorize>
</pre>
<a href="<c:url value='/all/getallproducts'></c:url>">Previous Page</a></div>
</body>
</html>