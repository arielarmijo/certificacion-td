<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
</head>
<body>

	<main class="container">
	
		<h1 class="mt-4">Monitor de Productos</h1>
		
		<form class="row my-3" method="get">
			<div class="form-group col-md-4">
				<label class="" for="almacen">Almacen</label>
				<select id="almacen" class="form-control" name="warehouseId">
					<option value="0" selected>Todos</option>
					<c:forEach items="${warehouses}" var="wh">
						<option value="${wh.id}" ${warehouseId == wh.id ? 'selected' : ''}>${wh.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group col-md-4">
				<label class="" for="categoria">Categoria Producto</label>
				<select id="categoria" class="form-control" name="productCategoryId">
					<option value="0" selected>Todas</option>
					<c:forEach items="${productCategories}" var="pc">
						<option value="${pc.id}" ${productCategoryId == pc.id ? 'selected' : ''}>${pc.name}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group col-md-2">
				<button class="btn btn-primary" type="submit">Buscar</button>
			</div>
		</form>
		
		<c:if test="${empty inventories}">
			<p class="alert alert-danger">No se encontraron productos</p>
		</c:if>
		
		<c:if test="${not empty inventories}">
			<%@ include file="/WEB-INF/snippets/pagination.jsp" %>
			<table class="table table-responsive animated fadeIn">
				<thead>
					<tr>
						<th>Almacen</th>
						<th>ID Producto</th>
						<th>Nombre Producto</th>
						<th>Precio Lista</th>
						<th>Costo estandar</th>
						<th>Inventario</th>
						<th>Accion</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${inventories}">
						<tr>
							<td>${item.warehouse.name}</td>
							<td>${item.product.id}</td>
							<td>${item.product.name}</td>
							<fmt:setLocale value="en_US"/>
							<td><fmt:formatNumber type="currency" value="${item.product.listPrice}" currencySymbol="$"/></td>
							<td><fmt:formatNumber type="currency" value="${item.product.standardCost}" currencySymbol="$"/></td>
							<td>${item.quantity}</td>
							<td class="d-flex justify-content-center">
								<c:url value="/product" var="producto">
									<c:param name="id" value="${item.product.id}"/>
								</c:url>
								<a class="btn btn-primary" href="${producto}">Ver</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<%@ include file="/WEB-INF/snippets/pagination.jsp" %>
		</c:if>
	</main>
	
	<%@ include file="/WEB-INF/snippets/footer.jsp" %>
	
</body>
</html>