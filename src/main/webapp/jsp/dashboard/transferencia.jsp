<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../../templates/header.jsp" />

<div class="container">
    <h1 class="heading">Transferencia entre Cuentas</h1>
    <form action="TransferenciaController?ruta=registrarTransferencia" method="post">
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="cuenta_origen" class="form-label">Cuenta Origen:</label>
                <select id="cuenta_origen" name="cuenta_origen" class="form-select">
                	<c:forEach items="${cuentas}" var="cuenta">
                        <option value="${cuenta.id}">${cuenta.nombre}</option>
                    </c:forEach>
                    
                </select>
            </div>
            <div class="col-md-6 mb-3">
                <label for="cuenta_destino" class="form-label">Cuenta Destino:</label>
                <select id="cuenta_destino" name="cuenta_destino" class="form-select">
                    <c:forEach items="${cuentas}" var="cuentad">
                        <option value="${cuentad.id}">${cuentad.nombre}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="categoria" class="form-label">Categoría:</label>
                <select id="categoria" name="categoria" class="form-select">
                    <c:forEach items="${categoriasTransferencia}" var="categoria">
                        <option value="${categoria.id}">${categoria.nombre}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-6 mb-3">
                <label for="concepto" class="form-label">Concepto:</label>
                <input type="text" id="concepto" name="concepto" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="fecha" class="form-label">Fecha:</label>
                <input type="date" id="fecha" name="fecha" class="form-control">
            </div>
            <div class="col-md-6 mb-3">
                <label for="valor" class="form-label">Valor:</label>
                <input type="number" id="valor" name="valor" step="0.01" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 mb-3" style="text-align: right;">
                <input type="submit" class="btn btn-primary" value="Realizar Transferencia">
            </div>
        </div>
    </form>
</div>


<jsp:include page="../../templates/footer.jsp" />