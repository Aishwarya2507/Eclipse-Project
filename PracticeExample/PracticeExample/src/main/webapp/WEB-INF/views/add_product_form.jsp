<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp" %>
<title>Crud App</title>
</head>
<body>

<div class="container mt-3">
<div class="row">
<div class="col-md-6 offset-md-3">
<h2 align="center"> Add Product Form</h2>
<h3 align="center" style="color:green">Fill Product Details</h3>

<form action="handleProduct" method="post">

<div class="form-group">
    <label for="name">Product Name</label>
    <input type="text" class="form-control" id="name" aria-describedby="Product Name" 
    name="name" placeholder="Enter Product Name">
</div>

<div class="form-group">
    <label for="description">Product Description</label>
    <textarea id="description" class="form-control" rows="5"
    name="description" placeholder="Enter Product Description"> 
</textarea>

<div class="form-group">
    <label for="price">Product Price</label>
    <input type="text" class="form-control" id="price" aria-describedby="Product Price"
    name="price" placeholder="Enter Product Price">
</div>

<div class="container text-center">
<a href="${pageContext.request.contextPath}/"
class="btn btn-outline-danger">Back</a>

<button type="submit" class="btn btn-primary">Add</button>
</div>


</form>

</div>
</div>
</div>

</body>
</html>