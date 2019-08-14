<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, webshop.dto.Product" %> 
<<jsp:useBean id="productDAO" class="webshop.dao.ProductRepository"/>
   
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>
</head>
<body>
	<%@include file="header.jsp" %>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">
				상품목록
			</h1>
		</div>
	</div>
	
	<%
		ArrayList<Product> listOfProducts=productDAO.getAllProducts();
	%>
	
	<div class="container">
		<div class="row" align="center">
			<%
				for(int i=0; i < listOfProducts.size(); i++){
					Product product=listOfProducts.get(i);
			%>
			<div class="col-md-4">
				<h3><%=product.getPname() %></h3>
				<p><%=product.getDescription() %>
				<p><%=product.getUnitPrice() %>
			</div>
			<%
				}
			%>
		</div>
		<hr/>
	</div>
	
	<%@include file="footer.jsp" %>
	
</body>
</html>