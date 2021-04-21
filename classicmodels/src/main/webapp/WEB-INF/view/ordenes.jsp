<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="/img/favicon.ico">
    <link rel="stylesheet" href="/css/bootstrap.css" >
	<link rel="stylesheet" href="/css/fontawesome.css"/>
	<link rel="stylesheet" href="/css/main.css"/>
	<title>${titulo}</title>
</head>
<body>

	<nav class="navbar navbar-light bg-light">
	  <div class="container-fluid">
	    <a href="/" class="navbar-brand h1">${titulo}</a>
	  </div>
	</nav>

	<main class="container-fluid">
		<h1 class="text-center">Monitor de órdenes</h1>
		<form class="row justify-content-center my-3">
			<div class="col-sm-6 col-md-3 col-lg-auto">
				<label for="estado" class="text-muted">Estado</label>
				<select id="estado" class="form-select form-select-sm" name="orderStatus">
					  <option value="%">Seleccione Estado</option>
					  <c:forEach var="estado" items="${estados}">
					  	<option value="${estado}" ${orderStatus == estado ? 'selected' : ''}>${estado}</option>
					  </c:forEach>
				</select>
			</div>
			<div class="col-sm-6 col-md-3 col-lg-auto">
				<label for="cliente" class="text-muted">Cliente</label>
				<select id="cliente" class="form-select form-select-sm" name="customerNumber">
					  <option value="-1">Seleccione Cliente</option>
					  <c:forEach var="cliente" items="${clientes}">
					  	<option value="${cliente.customerNumber}" ${customerNumber == cliente.customerNumber ? 'selected' : ''}>${cliente.customerName}</option>
					  </c:forEach>
				</select>
			</div>
			<div class="col-sm-6 col-md-3 col-lg-auto">
				<label for="desde" class="text-muted">Fecha Orden Desde</label>
				<input type="date" id="desde" class="form-control form-control-sm">
			</div>
			<div class="col-sm-6 col-md-3 col-lg-auto">
				<label for="hasta" class="text-muted">Fecha Orden Hasta</label>
				<input type="date" id="hasta" class="form-control form-control-sm">
			</div>
			<div class="col-sm-1 col-md-12 col-lg-auto d-flex justify-content-center align-items-end">
				<input type="submit" class="btn btn-primary" value="Buscar">
			</div>
		</form>
		<div class="animated fadeIn">
			<table class="table table-striped table-hover table-responsive">
				<thead>
					<tr>
						<th>Número de Orden</th>
						<th>Fecha Orden</th>
						<th>Fecha Requerida</th>
						<th>Estado</th>
						<th>Acción</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="order" items="${ordenes}">
						<tr>
							<td>${order.orderNumber}</td>
							<td><fmt:formatDate pattern="dd-MM-yyyy" value="${order.orderDate}"/></td>
							<td><fmt:formatDate pattern="dd-MM-yyyy" value="${order.requiredDate}"/></td>
							<td>${order.status}</td>
							<td>
								<a href="#" class="btn btn-sm btn-primary">Ver</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</main>
	<%@ include file="/WEB-INF/snippets/footer.jsp" %>
</body>
</html>