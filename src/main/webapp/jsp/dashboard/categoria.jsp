<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />

<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h2>Dashboard</h2>
</div>

<h2>Categor�as</h2>

<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th>Categor�a</th>
				<th>Tipo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${categorias}" var="categoria">
				<tr>
					<td>${categoria.nombre}</td>
					<td>${categoria.tipo.descripcion}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<h2>Registro de nuevas Categor�as</h2>

<form id="agregarCategoriaForm" method="post"
	action="CategoriaController?ruta=registrarCategoria">
	<div class="mb-3">
		<label for="nombreCategoria" class="form-label">Nombre de la
			categor�a</label> <input type="text" class="form-control"
			id="nombreCategoria" name="nombreCategoria"
			placeholder="Nombre de la categor�a">
	</div>
	<div class="mb-3">
		<label for="tipoCategoria" class="form-label">Tipo de
			categor�a</label> <select class="form-select" id="tipoCategoria"
			name="tipoCategoria">
			<c:forEach items="${tipos}" var="tipo">
				<option value="${tipo.id}">${tipo.descripcion}</option>
			</c:forEach>
		</select>
	</div>
	<button type="submit" class="btn btn-primary" id="guardarCategoriaBtn">Guardar</button>
</form>

<jsp:include page="../../templates/footer.jsp" />