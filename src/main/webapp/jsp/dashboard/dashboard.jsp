<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />

<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h2>Dashboard</h2>
</div>

<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th class="p-1 w-10">Cuentas</th>
				<th class="p-1 w-10">Total</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cuentas}" var="cuenta">
				<tr>
					<td class="p-2">${cuenta.nombre}</td>
					<td class="p-2">${cuenta.total}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<div class="btn-group d-flex flex-wrap justify-content-center pt-3 pb-5">
    <a href="DashboardController?ruta=verDashboard&mes=1" class="btn btn-secondary">Enero</a>
    <a href="DashboardController?ruta=verDashboard&mes=2" class="btn btn-secondary">Febrero</a>
    <a href="DashboardController?ruta=verDashboard&mes=3" class="btn btn-secondary">Marzo</a>
    <a href="DashboardController?ruta=verDashboard&mes=4" class="btn btn-secondary">Abril</a>
    <a href="DashboardController?ruta=verDashboard&mes=5" class="btn btn-secondary">Mayo</a>
    <a href="DashboardController?ruta=verDashboard&mes=6" class="btn btn-secondary">Junio</a>
    <a href="DashboardController?ruta=verDashboard&mes=7" class="btn btn-secondary">Julio</a>
    <a href="DashboardController?ruta=verDashboard&mes=8" class="btn btn-secondary">Agosto</a>
    <a href="DashboardController?ruta=verDashboard&mes=9" class="btn btn-secondary">Septiembre</a>
    <a href="DashboardController?ruta=verDashboard&mes=10" class="btn btn-secondary">Octubre</a>
    <a href="DashboardController?ruta=verDashboard&mes=11" class="btn btn-secondary">Noviembre</a>
    <a href="DashboardController?ruta=verDashboard&mes=12" class="btn btn-secondary">Diciembre</a>
</div>

<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th class="p-1 w-10">Categorías</th>
				<th class="p-1 w-10">Total</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach items="${categoriasConTotal}" var="categoria">
				<tr>
					<td class="p-2">${categoria.nombre}</td>
					<td class="p-2">${categoria.total}</td>
				</tr>
			</c:forEach>
			</tr>
		</tbody>
	</table>
</div>

<!--<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>/-->

<jsp:include page="../../templates/footer.jsp" />