<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" data-bs-theme="auto">
<head>
<script src="assets/js/color-modes.js"></script>

<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="" />
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors" />
<meta name="generator" content="Hugo 0.115.4" />
<title>Login Chaucherita</title>

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
		<h1 class="d-block text-center">Inicio de sesión</h1>
		<form action="LoginController?ruta=ingresar" method="POST" class="w-50 mx-auto shadow my-3 p-3">
			<div class="input-group my-3">
				<label for="usuario" class="input-group-text"><i
					class="bi bi-person-fill me-2"></i>Usuario</label> <input id="user"
					name="user" type="text" class="form-control"
					placeholder="Ingrese su usuario" aria-label="User"
					aria-describedby="basic-addon1" />
			</div>
			<div class="input-group my-3">
				<label for="clave" class="input-group-text"><i
					class="bi bi-key-fill me-2"></i>Contraseña</label> <input id="password"
					name="password" type="password" class="form-control"
					placeholder="Ingrese su contraseña" aria-label="Password"
					aria-describedby="basic-addon1" />
			</div>
			<div class="d-grid gap-2">
				<button class="btn btn-primary" type="submit">Iniciar
					sesión</button>
			</div>
		</form>
		
		<div class="container text-center my-3">
			<p>¿No tienes una cuenta? <a href="RegistroController?ruta=iniciarRegistro">Regístrate aquí</a></p>
		</div>
	</div>
</body>
</html>
