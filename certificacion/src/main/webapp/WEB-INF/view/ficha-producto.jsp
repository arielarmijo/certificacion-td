<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<link rel="icon" href="<c:url value="/img/favicon.ico"/>">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="<c:url value="/css/main.css"/>"/>
	<script src="https://kit.fontawesome.com/aaf6652f81.js"></script>
	<title>${titulo}</title>
<body>
	
	<main class="container py-5">
		<div class="row justify-content-center">
			<div class="card col-md-6 animated fadeIn">
			  	<div class="card-body">
				    <h5 class="card-title">${producto.name}</h5>
				    <h6 class="card-subtitle mb-2 text-muted">${producto.category.name}</h6>
				    <p class="card-text">${producto.description}</p>
					<p class="card-text"><fmt:formatNumber type="currency" value="${producto.listPrice}" currencySymbol="$"/></p>
					<div class="d-flex flex-wrap mb-3">
						<c:forEach var="wh" items="${producto.inventory}">
							<span class="badge badge-info ml-2 mb-2">
							  ${wh.warehouse.name}<span class="badge badge-light ml-1">${wh.quantity}</span>
							</span>
						</c:forEach>
					</div>
					<div class="d-flex justify-content-end">
						<a class="btn btn-primary" href="<c:url value="/"/>">Volver</a>
					</div>
		  		</div>
		  	</div>
	  	</div>
  	</main>
  	
  	<%@ include file="/WEB-INF/snippets/footer.jsp" %>
  	
</body>
</html>