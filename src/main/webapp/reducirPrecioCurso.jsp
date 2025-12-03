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
	<h1>Aplicar descuento cursos. </h1>
	<p class="alert alert-info">
        Este formulario aplicará el descuento indicado a <strong>todos los cursos</strong> 
        cuya duración sea igual o mayor a la especificada.
    </p>
	<br/><br/>
	<form action="descuentoCurso" method="post" class="form-horizontal">
		<div class="form-group">
			<label class="control-label col-sm-2">Duración mínima del curso (horas):</label>
            <div class="col-sm-10">
                <input type="text" name="duracion" class="form-control" style="width:30%"/>
            </div>
            <div class="clearfix" style="margin-bottom: 15px;"></div>
            <label class="control-label col-sm-2">Introduce descuento curso (%):</label>
            <div class="col-sm-10">
                <input type="text" name="porcentaje" class="form-control" style="width:30%"/>
            </div>
            <div class="clearfix" style="margin-bottom: 15px;"></div>
            <div class="from-group">
            	<div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default" style="width:15%">Aplicar </button>
                </div>
            </div>
		</div>
	
	</form>
</div>

</body>
</html>