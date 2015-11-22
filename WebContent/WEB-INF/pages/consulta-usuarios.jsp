<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Consulta usuarios</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/consulta-usuarios.js" />"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/consulta-usuarios.css" />"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="navigator">
		<div style="width: 100%;">
			<span style="position: absolute; top: 0px; left: 0px; z-index: 10;">
				<img height="80" alt="UNED Madrid"
				src="<c:url value="/resources/img/logo.jpg" />" />
			</span>
			<div class="navbar navbar-default"
				style="margin-top: 30px; position: absolute; left: 130px; overflow: hidden; width: 85%;">
				<div class="container">
					<div class="collapse navbar-collapse" id="navbar-ex-collapse">
						<ul class="nav navbar-nav navbar-left" style="width: 100%;">
							<li id="consulta-usuarios" class="active"><a href="#">Consulta
									de Usuarios</a></li>
							<li id="alta"><a href="alta">Alta de usuarios</a></li>
							<li id="configuracion"><a href="#">Configuración</a></li>
							<li id="salir"><a href="login?logout">Salir</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="modify-user-modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x—</button>
					<h4 class="modal-title">Modificar usuario</h4>
				</div>
				<div class="modal-body">
					<p>One fine body...</p>
				</div>
				<div class="modal-footer">
					<a class="btn btn-default" data-dismiss="modal">Cerrar</a> <a
						class="btn btn-primary">Editar</a> <a class="btn btn-primary"
						style="display: none">Guardar cambios</a>
				</div>
			</div>
		</div>
	</div>
	<div class="content">
		<div class="section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<form method="POST">
							<div class="form-horizontal" role="form">
								<div class="form-group">
									<div class="form-inline">
										<div class="col-sm-4">
											<label for=nombre class="control-label" style="min-width: 125px;">Nombre: </label>
											<input type="text" class="form-control" id="nombre" placeholder="Nombre">
										</div>
										<div class="col-sm-4">
											<label for="apellido1" class="control-label" style="min-width: 125px;">Apellido 1: </label>
											<input type="text" class="form-control" id="apellido1" placeholder="Primer apellido">
										</div>
										<div class="col-sm-4">
											<label for="apellido2" class="control-label" style="min-width: 125px;">Apellido 2: </label>
											<input type="text" class="form-control" id="apellido2" placeholder="Segundo apellido">
										</div>
									</div>
								</div>
							</div>
							<div class="form-horizontal" role="form">
								<div class="form-group">
									<div class="form-inline">
										<div class="col-sm-4">
											<label for="numeroUsuario" class="control-label" style="min-width: 125px;">Número de usuario: </label>
											<input type="text" class="form-control" id="numeroUsuario" placeholder="Número de usuario">
										</div>
										<div class="col-sm-4">
											<label for="nif" class="control-label" style="min-width: 125px;">NIF/Pasaporte: </label>
											<input type="text" class="form-control" id="nif" placeholder="NIF/Pasaporte">
										</div>
										<div class="col-sm-4">
											<label for="telefono" class="control-label" style="min-width: 125px;">Teléfono: </label>
											<input type="text" class="form-control" id="telefono" placeholder="Teléfono">
										</div>
									</div>
								</div>
							</div>
							<div class="form-horizontal" role="form">
								<div class="form-group">
									<div class="form-inline">
										<div class="col-sm-4">
											<label for="correo" class="control-label" style="min-width: 125px;">Correo: </label>
											<input type="text" class="form-control" id="correo" placeholder="Correo">
										</div>
										<div class="col-sm-4">
											<label for="localidad" class="control-label" style="min-width: 125px;">Localidad: </label>
											<input type="text" class="form-control" id="localidad" placeholder="Localidad">
										</div>
										<div class="col-sm-4,row text-right" style="padding-right: 10%">
											<a class="btn btn-warning" id="clean">Limpiar</a>
											<input type="submit" class="btn btn-primary" id="search" value="Buscar" />
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<table class="table table-hover" id="table">
							<thead>
								<tr>
									<th>Numero de usuario</th>
									<th>NIF/Pasaporte</th>
									<th>Nombre</th>
									<th>Apellidos</th>
									<th>Localidad</th>
									<th>Correo electrónico</th>
									<th>Teléfono</th>
									<th>Código postal</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>Mark</td>
									<td>Otto</td>
									<td>@mdo</td>
									<td>1</td>
									<td>Mark</td>
									<td>Otto</td>
									<td>@mdo</td>
									<td id="modify-user1"><a class="btn btn-primary"
										data-toggle="modal" data-target="#modify-user-modal">Modificar</a>
									</td>
								</tr>
								<tr>
									<td>2</td>
									<td>Jacob</td>
									<td>Thornton</td>
									<td>@fat</td>
								</tr>
								<tr>
									<td>3</td>
									<td>Larry</td>
									<td>the Bird</td>
									<td>@twitter</td>
								</tr>
							</tbody>
						</table>
						<ul class="pagination">
							<li><a href="#">Ant</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">Sig</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>