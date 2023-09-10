<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script src="assets/js/color-modes.js"></script>

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="" />
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors" />
<meta name="generator" content="Hugo 0.115.4" />
<title>Registro Chaucherita</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.3/examples/dashboard/" />

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@docsearch/css@3" />

<link href="assets/dist/css/bootstrap.min.css" rel="stylesheet" />

<!-- Custom styles for this template -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"
	rel="stylesheet" />
<!-- Custom styles for this template -->
</head>
<body>
	<div class="container my-5">
		<h1 class="d-block text-center">Registro</h1>

		<div class="w-100 text-center">
			<a href="LoginController?ruta=iniciar"> <i class="bi bi-arrow-left"></i> Volvera inicio de sesión</a>
		</div>
		<form action="RegistroController?ruta=registrar" method="POST"
			class="w-50 mx-auto shadow my-3 p-3">
			<div class="input-group my-3">
				<label for="username" class="input-group-text"><i
					class="bi bi-person-fill me-2"></i>Usuario</label> <input id="username"
					name="username" type="text" class="form-control"
					placeholder="Ingrese su usuario" required />
			</div>
			<div class="input-group my-3">
				<label for="firstName" class="input-group-text"><i
					class="bi bi-person me-2"></i>Nombre</label> <input id="firstName"
					name="firstName" type="text" class="form-control"
					placeholder="Ingrese su nombre" required />
			</div>
			<div class="input-group my-3">
				<label for="lastName" class="input-group-text"><i
					class="bi bi-person me-2"></i>Apellido</label> <input id="lastName"
					name="lastName" type="text" class="form-control"
					placeholder="Ingrese su apellido" required />
			</div>
			<div class="input-group my-3">
				<label for="password" class="input-group-text"><i
					class="bi bi-key-fill me-2"></i>Contraseña</label> <input id="password"
					name="password" type="password" class="form-control"
					placeholder="Ingrese su contraseña" required />
			</div>
			<div class="d-grid gap-2">
				<button class="btn btn-primary" type="submit">Registrarse</button>
			</div>
		</form>
	</div>
</body>
</html>
