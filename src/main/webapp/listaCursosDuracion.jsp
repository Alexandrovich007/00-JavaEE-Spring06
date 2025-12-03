<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<h1>Lista de cursos</h1>
	<div>
		<table border="1" class="table table-striped table-bordered">
			<thead><tr><th>Nombre</th><th>Precio</th><th>Duración</th></tr></thead>
			<tbody>
				<c:forEach var="c" items="${requestScope.cursos}">
					 <tr>
					    <td>${c.denominacion}</td>
					    <td>${c.precio}</td>
					    <td>${c.duracion}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<a href="toSeleccionDuracion" class="btn btn-primary">Volver</a>		
		<a href="menu" class="btn btn-primary">Inicio</a>
	</div>
	<div>
        
	</div>
	

</body>
</html>