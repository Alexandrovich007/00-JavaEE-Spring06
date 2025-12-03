<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h1>Buscador de cursos</h1>
	<br/><br/>
	<form action="${requestScope.url}" method="get" class="form-horizontal">
		<div class="form-group">
			<label class="control-label col-sm-2">Identificador curso:</label>
            <div class="col-sm-10">
                <input type="text" name="idCurso" class="form-control" style="width:30%"/>
            </div>
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