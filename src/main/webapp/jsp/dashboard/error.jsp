<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<title>Error Chaucherita</title>

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
		<div class="alert alert-danger" role="alert">
			<h4 class="alert-heading">Error</h4>
			<p>${mensaje}</p>
			<hr>
			<p class="mb-0">Por favor, intenta nuevamente más tarde.</p>
		</div>
	</div>
</body>
</html>