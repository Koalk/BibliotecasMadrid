<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>index</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/pages/js/index.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="/pages/index.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<img src="http://i.imgur.com/x8r8SHH.jpg"
						class="img-responsive margin-auto" width="400px">
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="page-header text-center">
						<h1>Gestión de Usuarios Externos&nbsp;</h1>
						<br> <br>
						<h1>
							<font color="#777777"> <span
								style="font-size: 23.4px; line-height: 23.4px;">Bibliotecas
									de zona del Centro Asociado de Madrid</span>
							</font>
						</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form name="loginForm" class="form-horizontal text-right" role="form">
		<div class="section">
			<div class="container">
				<div class="row text-right">
					<div class="col-md-10">
						<div class="row">

							<div class="form-group">
								<div class="col-sm-5">
									<label for="inputUsername"
										class="control-label login-form-label">Nombre de
										usuario:</label>
								</div>
								<div class="col-sm-6">
									<input id="user" type="text" class="form-control input-lg"
										name="user" placeholder="Nombre de usuario">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-5">
									<label for="inputPassword3"
										class="control-label login-form-label">Contraseña:</label>
								</div>
								<div class="col-sm-6 text-center">
									<input id="pass" type="password" class="form-control input-lg"
										name="pass" placeholder="Contraseña">
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="section">
			<div class="container">
				<div class="row">
					<div class="col-md-12 text-center">
						<button type="submit" class="btn btn-primary loginbutton"
							name="submit" value="submit">Acceder</button>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
					</div>
				</div>
			</div>
		</div>
	</form>

</body>
</html>