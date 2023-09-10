<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />

<div
	class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
	<h2>Dashboard</h2>
</div>

<h2>Cuentas</h2>

<div class="table-responsive">
	<table class="table">
		<thead>
			<tr>
				<th>Cuenta</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cuentas}" var="cuenta">
				<tr>
					<td>${cuenta.nombre}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


<form id="agregarCuentaForm" action="CuentaController?ruta=registrarCuenta" method="post">
    <div class="mb-3">
        <label for="nombreCuenta" class="form-label">Nombre de la cuenta</label>
        <input type="text" class="form-control" id="nombreCuenta" name="nombreCuenta" placeholder="Nombre de la cuenta">
        <label for="valorInicial" class="form-label">Valor:</label>
                <input type="number" id="valorInicial" name="valorInicial" step="0.01" class="form-control">
    </div>
    <button type="submit" class="btn btn-primary">Guardar</button>
</form>

<!--<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>/-->



<jsp:include page="../../templates/footer.jsp" />