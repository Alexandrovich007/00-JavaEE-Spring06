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
	<h1>Selección duración</h1>
	<br/><br/>
	<form action="cursosDuracion" method="get" class="form-horizontal">
		<div class="form-group">
			<label class="control-label col-sm-2">Introduce duración max:</label>
            <div class="col-sm-10">
                <input type="text" name="duracion" class="form-control" style="width:30%"/>
            </div>
            <div class="clearfix" style="margin-bottom: 15px;"></div>
            <div class="from-group">
            	<div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default" style="width:30%">Buscar</button>
                </div>
            </div>
		</div>
	
	</form>
</div>

</body>
</html>