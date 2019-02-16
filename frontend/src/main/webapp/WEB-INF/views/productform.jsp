<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ProductForm</title>
</head>
<body>
<div class="container">
<c:url value="/admin/addproduct" var="url"></c:url>
<form:form action="${url }" modelAttribute="product" enctype="multipart/form-data">
<pre>
Enter Productname : <form:input path="ProductName"/><form:errors path="ProductName" cssStyle="color:red" ></form:errors>
Enter description : <form:input path="Description"/><form:errors path="Description" cssStyle="color:red" ></form:errors>
Enter price       : <form:input path="Price"/>     <form:errors path="Price" cssStyle="color:red"></form:errors>
Enter quantity    : <form:input path="Quantity"/>   <form:errors path="Quantity" cssStyle="color:red"></form:errors>
Select Category   : <form:select path="category.categoryId">	
<c:forEach items="${categories }" var="c"><%--model.addAttribute("categories",categories), items refers the model attribute categories --%>
<form:option value="${c.categoryId }">${c.categoryName}</form:option>
</c:forEach>
</form:select>
Upload image      : <form:input path="image" type="file"/>
<input type="submit" value="Add Product">
</pre>
</form:form>
</div>
</body>
</html>
