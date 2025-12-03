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
	<h1>Alta de cursos</h1>
	<br/><br/>
	<form action="alta" method="post" class="form-horizontal">
		<div class="form-group">
			<label class="control-label col-sm-2">Denominación</label>
			<input type="text" name="denominacion" class="form-control"  style="width:20%" placeholder="Denominación del curso" required>
		</div>
		<div class="form-group">
            <label class="control-label col-sm-2">Duración</label>
            <input type="text" name="duracion" class="form-control" style="width:20%" placeholder="Descripción del curso" required>
        </div>
        <div class="form-group">
        	<label class="control-label col-sm-2">Descripción</label>
        	<input type="text" name="precio" class="form-control" style="width:20%" placeholder="Precio del curso" required>
        </div>
        <div class="form-group">
        	<div class="col-sm-offset-2 col-sm-20">
        	<button type="submit" class="btn btn-default" style="width:20%">Enviar</button>
        	</div>
        </div>
	</form>
</div>

</body>
</html>