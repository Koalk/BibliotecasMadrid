<%@page session="true"%>
<html>
<head>
<title>Nuevo usuario</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/pages/js/alta.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="/pages/alta.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="navigator"></div>
	<div class="content">
		<div class="section">
			<div class="container">
				<div class="row">
					<div class="col-md-12"
						style="font-size: 18px; padding-bottom: 20px; padding-left: 20px;">
						<div style="display: inline;" class="col-md-5">
							<label style="padding-right: 10px">Identificador:</label> 
							<input value=${title} size="20" disabled="true">
						</div>
						<div class="col-md-7" style="display: inline;">
							<label style="padding-right: 10px;">Biblioteca de alta:</label>
							<div style="display: inline; width: 100;">
								<input style="width: auto;">
							</div>
						</div>
					</div>
					<div class="col-md-8">
						<div class="col-md-6">
							<div class="form-field">
								<div>
									<label>Nombre:</label>
								</div>
								<div>
									<input>
								</div>
							</div>
							<div class="form-field">
								<div>
									<label>Primer apellido:</label>
								</div>
								<div>
									<input>
								</div>
							</div>
							<div class="form-field">
								<div>
									<label>Segundo apellido:</label>
								</div>
								<div>
									<input>
								</div>
							</div>
							<div class="form-field">
								<div>
									<label>Localidad:</label>
								</div>
								<div>
									<input>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-field">
								<div>
									<label>Nif/Pasaporte:</label>
								</div>
								<div>
									<input>
								</div>
							</div>
							<div class="form-field">
								<div>
									<label>Correo electrónico:</label>
								</div>
								<div>
									<input>
								</div>
							</div>
							<div class="form-field">
								<div>
									<label>Teléfono:</label>
								</div>
								<div>
									<input>
								</div>
							</div>
							<div class="form-field">
								<div>
									<label>Código postal:</label>
								</div>
								<div>
									<input>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-field">
								<div>
									<label>Dirección:</label>
								</div>
								<div>
									<input>
								</div>
							</div>
							<div class="form-field">
								<div>
									<label>Observaciones:</label>
								</div>
								<div>
									<textarea style="width: 100%;" rows="4"></textarea>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4" style="display: table;">
						<div align="center" style="padding-top: 15%;">
							<img class="img-responsive img-rounded"
								src="https://www.uchceu.es/directorio/imagenes/silueta_hombre.gif" style="height: 350px">
							<div class="btn-group btn-group-lg" style="padding-top: 20px">
								<a href="#" class="btn btn-default" style="width: 200px">Nueva
									foto</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="section" style="position: relative; top: -20px">
			<div class="container">
				<div class="row">
					<div class="col-md-6" style="padding-top: 10px">
						<a class="btn btn-block btn-lg btn-primary"
							style="height: 60px; font-size: 25px; padding-top: 10px;">Guardar</a>
					</div>
					<div class="col-md-6" style="padding-top: 10px">
						<a class="btn btn-block btn-lg btn-warning"
							style="height: 60px; font-size: 25px; padding-top: 10px;">Descartar</a>
					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>