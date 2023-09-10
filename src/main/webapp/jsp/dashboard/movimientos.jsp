<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />

<div class="btn-group d-flex flex-wrap justify-content-center">
	<a href="MovimientoController?ruta=vizualizarTodo" class="btn btn-primary">Todo</a>
    <a href="MovimientoController?ruta=vizualizarPorMes&mes=1" class="btn btn-secondary">Enero</a>
    <a href="MovimientoController?ruta=vizualizarPorMes&mes=2" class="btn btn-secondary">Febrero</a>
    <a href="MovimientoController?ruta=vizualizarPorMes&mes=3" class="btn btn-secondary">Marzo</a>
    <a href="MovimientoController?ruta=vizualizarPorMes&mes=4" class="btn btn-secondary">Abril</a>
    <a href="MovimientoController?ruta=vizualizarPorMes&mes=5" class="btn btn-secondary">Mayo</a>
    <a href="MovimientoController?ruta=vizualizarPorMes&mes=6" class="btn btn-secondary">Junio</a>
    <a href="MovimientoController?ruta=vizualizarPorMes&mes=7" class="btn btn-secondary">Julio</a>
    <a href="MovimientoController?ruta=vizualizarPorMes&mes=8" class="btn btn-secondary">Agosto</a>
    <a href="MovimientoController?ruta=vizualizarPorMes&mes=9" class="btn btn-secondary">Septiembre</a>
    <a href="MovimientoController?ruta=vizualizarPorMes&mes=10" class="btn btn-secondary">Octubre</a>
    <a href="MovimientoController?ruta=vizualizarPorMes&mes=11" class="btn btn-secondary">Noviembre</a>
    <a href="MovimientoController?ruta=vizualizarPorMes&mes=12" class="btn btn-secondary">Diciembre</a>
</div>

<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h1 class="h2">Movimientos</h1>
</div>
<div class="table-responsive small">
	<table class="table table-striped table-sm">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Concepto</th>
				<th scope="col">Valor</th>
				<th scope="col">Fecha</th>
				<th scope="col">Cuenta</th>
				<th scope="col">Categoria</th>
				<th scope="col">Eliminar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${movimientos}" var="movimiento">
				<tr>
					<td>${movimiento.id}</td>
					<td>${movimiento.concepto}</td>
					<td>${movimiento.valor}</td>
					<td>${movimiento.fechaFormateada}</td>
					<td>${movimiento.cuenta.nombre}</td>
					<td>${movimiento.categoria.nombre}</td>
					<td><a class="btn btn-outline-danger" href="MovimientoController?ruta=eliminarMovimiento&idMovimiento=${movimiento.id}"> <i class="bi bi-trash"></i> </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<jsp:include page="../../templates/footer.jsp" />