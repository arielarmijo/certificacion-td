<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	    <span class="navbar-brand h1">${titulo}</span>
	  </div>
	</nav>

	<main class="container-fluid">
		<h1 class="text-center">Monitor de órdenes</h1>
		<div class="row justify-content-center my-3">
			<div class="col-sm-6 col-md-3 col-lg-auto">
				<label for="estado" class="text-muted">Estado</label>
				<select id="estado" class="form-select form-select-sm"">
					  <option selected>Seleccione Estado</option>
					  <option value="1">One</option>
					  <option value="2">Two</option>
					  <option value="3">Three</option>
				</select>
			</div>
			<div class="col-sm-6 col-md-3 col-lg-auto">
				<label for="cliente" class="text-muted">Cliente</label>
				<select id="cliente" class="form-select form-select-sm">
					  <option selected>Seleccione Cliente</option>
					  <option value="1">One</option>
					  <option value="2">Two</option>
					  <option value="3">Three</option>
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
				<input type="button" class="btn btn-primary" value="Buscar">
			</div>
		</div>
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
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td>
							<a href="#" class="btn btn-sm btn-primary">Ver</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</main>
	<%@ include file="/WEB-INF/snippets/footer.jsp" %>
</body>
</html>