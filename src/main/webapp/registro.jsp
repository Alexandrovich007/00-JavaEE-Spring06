<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
          body {
              font-family: Arial, sans-serif;
              background-color: #f4f4f4;
              display: flex;
              justify-content: center;
              align-items: center;
              height: 100vh;
              margin: 0;
          }
          .registro-container {
              background-color: white;
              padding: 30px;
              border-radius: 8px;
              box-shadow: 0 0 10px rgba(0,0,0,0.1);
              width: 350px;
          }
          h2 {
              text-align: center;
              color: #333;
          }
          .form-group {
              margin-bottom: 15px;
          }
          label {
              display: block;
              margin-bottom: 5px;
              color: #555;
              font-weight: bold;
          }
          input[type="text"],
          input[type="password"],
          input[type="email"] {
              width: 100%;
              padding: 10px;
              border: 1px solid #ddd;
              border-radius: 4px;
              box-sizing: border-box;
          }
          button {
              width: 100%;
              padding: 10px;
              background-color: #2196F3;
              color: white;
              border: none;
              border-radius: 4px;
              cursor: pointer;
              font-size: 16px;
              margin-top: 10px;
          }
          button:hover {
              background-color: #0b7dda;
          }
          .error {
              color: red;
              text-align: center;
              margin-bottom: 10px;
          }
          .login-link {
              text-align: center;
              margin-top: 15px;
          }
          .login-link a {
              color: #2196F3;
              text-decoration: none;
          }
          .login-link a:hover {
              text-decoration: underline;
          }
	</style>
</head>
<body>
	<div class="registro-container">
		<h2>Registro de usuario</h2>    
		
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
        </c:if> 
        
        <form action="registro" method="post">
        	<div class="form-group">
        		<label for="username">Usuario:</label>
        		<input type="text" id="username" name="username" required minlength="4" maxlength="50" placeholder="Ingrese su usuario">
        		
        	</div>
        	
        	<div class="form-group">
        		<label for="email">Email:</label>
        		<input type="email" id="email" name="email" required placeholder="Ingrese su email">
        	</div>
        	
        	<div class="form-group">
        		<label for="password">Contraseña</label>
        		<input type="password" id="password" name="password" required minlength="6" placeholder="Ingrese su contraseña">
        	</div>
        	
        	<button type="submit">Registrarse</button>
        </form>                                       
        
        <div class="login-link">
        	<p>¿Ya tienes una cuenta? <a href="login">Inicia sesión aquí</a></p>
        </div>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
	</div>
</body>
</html>