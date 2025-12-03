<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
 <html>
<head>
<meta charset="UTF-8">
<title>Iniciar Sesión</title>
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

.login-container {
	background-color: white;
	padding: 30px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
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

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 10px;
	border: 1px solid #ddd;
	border-radius: 4px;
	box-sizing: border-box;
}

button {
	width: 100%;
	padding: 10px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
	margin-top: 10px;
}

button:hover {
	background-color: #45a049;
}

.error {
	color: red;
	text-align: center;
	margin-bottom: 10px;
}

.mensaje {
	color: green;
	text-align: center;
	margin-bottom: 10px;
}

.registro-link {
	text-align: center;
	margin-top: 15px;
}

.registro-link a {
	color: #4CAF50;
	text-decoration: none;
}

.registro-link a:hover {
	text-decoration: underline;
}

/* Estilos del Modal/Popup */
.modal {
	display: none;
	position: fixed;
	z-index: 1000;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
	background-color: white;
	margin: 15% auto;
	padding: 30px;
	border-radius: 8px;
	width: 400px;
	text-align: center;
	box-shadow: 0 4px 20px rgba(0, 0, 0, 0.3);
	animation: slideDown 0.3s ease-out;
}

@
keyframes slideDown {from { transform:translateY(-50px);
	opacity: 0;
}

to {
	transform: translateY(0);
	opacity: 1;
}

}
.modal-header {
	color: #ff9800;
	font-size: 24px;
	margin-bottom: 15px;
}

.modal-body {
	color: #555;
	font-size: 16px;
	margin-bottom: 20px;
	line-height: 1.5;
}

.modal-footer {
	display: flex;
	gap: 10px;
	justify-content: center;
	flex-wrap: wrap;
}

.btn-primary,
.btn-secondary {
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer; /* mano de puntero al pasar por encima */
    font-size: 14px;
    font-weight: 400;   /* o 600, pero igual para ambos */
    line-height: 1.5;
    text-decoration: none;
    display: inline-block;
    text-align: center;
    box-sizing: border-box; /* para que el padding no afecte al width */
    width: 130px;
}
.btn-primary {
	background-color: #2196F3;
}

.btn-primary:hover {
	background-color: #0b7dda;
}

.btn-secondary {
    background-color: #CFD8DC; /* gris azuladito claro */
    color: #333;               /* texto oscuro para que se lea bien */
}

.btn-secondary:hover {
    background-color: #B0BEC5; /* un poco más oscuro al pasar el ratón */
}
.checkbox-group {
	margin-bottom: 15px;
	display: flex;
	align-items: center;
}

.checkbox-group input[type="checkbox"] {
    width: auto;
    margin-right: 8px;
}

.checkbox-group label {
    margin-bottom: 0;
    font-weight: normal;
    cursor: pointer;
}

</style>
</head>
<body>
	<!-- Modal de acceso restringido -->
	<div id="modalAccesoRestringido" class="modal">
		<div class="modal-content">
			<div class="modal-header">⚠️ Acceso Restringido</div>
			<div class="modal-body">
				<p>Debes iniciar sesión para acceder a esta página.</p>
				<p>Si no tienes una cuenta, por favor regístrate.</p>
			</div>
			<div class="modal-footer">
				<button class="btn-primary" onclick="location.href='registro'">Registrarse</button>
				<button class="btn-secondary" onclick="cerrarModal()">Cerrar</button>
			</div>
		</div>
	</div>
	<div class="login-container">
		<h2>Iniciar Sesión</h2>

		<c:if test="${not empty error}">
			<p class="error">${error}</p>
		</c:if>
		
		<c:if test="${not empty mensaje}">
            <p class="mensaje">${mensaje}</p>
        </c:if>
        
		<form action="login" method="post">
			<div class="form-group">
				<label for="username">Usuario:</label> 
				<!-- Prellenar con la cookie o con el intento fallido -->
				<input type="text" id="username" placeholder="Ingrese su usuario" name="username" required value=${not empty usuarioIntentado ? usuarioIntentado : usuarioRecordado} >
			</div>

			<div class="form-group">
				<label for="password">Contraseña:</label> <input type="password" id="password" placeholder="Ingrese su contraseña" name="password" required>
			</div>
			
			 <!-- Checkbox para recordar usuario,si existe la cookie, marca el checkbox automáticamente-->
			 <div class="checkbox-group">
			 	<input type="checkbox" id="recordar" name="recordar" ${not empty usuarioRecordado ? 'checked' : ''}>
			 	<label for="recordar">Recordar usuario</label>
			 	
			 </div>

			<button type="submit">Iniciar Sesión</button>
		</form>
		
		<div class="registro-link">
			<p>¿No tienes una cuenta? <a href="registro">Regístrate aquí</a></p>
		</div>

	</div>
	<script>
		// Función para cerrar el modal
        function cerrarModal() {
			console.log('Cerrando modal de acceso restringido');
			var modal = document.getElementById('modalAccesoRestringido');
			modal.classList.remove('show');
			modal.style.display = 'none';
			
        }
		
		//Ejecutar cuando DOM este listo
		document.addEventListener('DOMContentLoaded', function() {
            console.log('DOM completamente cargado y analizado');
            console.log('URL actual: ' + window.location.href);
            console.log('Search params: ' + window.location.search);
            //Detectar si el parámetro acceso denegado está en la URL
            var urlParams = new URLSearchParams(window.location.search);
            var accesoRestringido = urlParams.get('accesoRestringido');
            
            var errorCredenciales = ${not empty error} ? 'true' : 'false';
            
            console.log('Paramámetro accesoRestringido: ' + accesoRestringido);
            if(accesoRestringido === 'true' || errorCredenciales === 'true') {
                console.log('Mostrando modal de acceso restringido');
                var modal = document.getElementById('modalAccesoRestringido');
                modal.classList.add('show');
                modal.style.display = 'block';
                
              //Limipar URL para que no vuelva a aparecer el modal al recargar
    			if(window.history.replaceState) {
                    window.history.replaceState({}, document.title, window.location.pathname);
                }
            }
        });
		
		//Cerrar modal al hacer clic fuera del contenido
        window.onclick = function(event) {
            var modal = document.getElementById('modalAccesoRestringido');
            if (event.target === modal) {
                cerrarModal();
            }
        }
		
</script>

</body>
</html>