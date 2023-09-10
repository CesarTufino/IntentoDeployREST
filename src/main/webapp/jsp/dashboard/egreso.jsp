<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />

<div class="container">
    <h1 class="heading">Registro de Gasto</h1>
    <form action="EgresoController?ruta=registrarEgreso" method="post">
        <div class="row">
            <div class="col-md-4 mb-3">
                <label for="cuenta" class="form-label">Cuenta:</label>
                <select id="cuenta" name="cuenta" class="form-select">
                    <c:forEach items="${cuentas}" var="cuenta">
                        <option value="${cuenta.id}">${cuenta.nombre}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-4 mb-3">
                <label for="categoria" class="form-label">Categoría:</label>
                <select id="categoria" name="categoria" class="form-select">
                    <c:forEach items="${categoriasEgreso}" var="categoria">
                        <option value="${categoria.id}">${categoria.nombre}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-4 mb-3">
                <label for="concepto" class="form-label">Concepto:</label>
                <input type="text" id="concepto" name="concepto" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 mb-3">
                <label for="fecha" class="form-label">Fecha:</label>
                <input type="date" id="fecha" name="fecha" class="form-control">
            </div>
            <div class="col-md-4 mb-3">
                <label for="valor" class="form-label">Valor:</label>
                <input type="number" id="valor" name="valor" step="0.01" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <button type="submit" class="btn btn-primary">Registrar Gasto</button>
            </div>
        </div>
    </form>
</div>

<jsp:include page="../../templates/footer.jsp" />