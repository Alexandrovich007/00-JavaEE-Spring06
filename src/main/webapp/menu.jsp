<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
</head>
<body>
<div class="container">
	<br/><br/>
	<!--  Navegaciones estáticas: -->
	<h3><a href="toNuevo">Nuevo Curso</a></h3>
	<br/><br/>
	<!--  Estas tres pasan por ell PageController que lo que hace es unicamente actualizar la URL -->
	<h3><a href="toActualizar">Actualizar Curso</a></h3>
	<br/><br/>
	<h3><a href="toEliminar">Eliminar Curso</a></h3>
	<br/><br/>
	<h3><a href="toRecuperar">Recuperar Curso</a></h3>
	<br/><br/>
	<!--  Indicar en el MvcConfig nuestra vista estática -->
	<h3><a href="toSeleccionDuracion">Seleccionar cursos por duración máxima</a></h3>
	<br/><br/>
	<h3><a href="toReducirPrecioCurso">Reducir precio de un curso</a></h3>
</div>

</body>
</html>