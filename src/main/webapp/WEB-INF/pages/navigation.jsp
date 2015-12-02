<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>UNED Madrid</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="<c:url value="/resources/js/navigation.js" />"></script>
<link href="<c:url value="/resources/css/navigation.css" />" rel="stylesheet" type="text/css">
</head>
<body>
	<div style="width: 100%;">
		<span style="position: absolute; top: 0px; left: 0px; z-index: 10;">
			<img height="80" alt="UNED Madrid"
			src="<c:url value="/resources/img/logo.jpg" />"/>
		</span>
		<div class="navbar navbar-default"
			style="margin-top: 30px; position: absolute; left: 130px; overflow: hidden; width: 85%;">
			<div class="container">
				<div class="collapse navbar-collapse" id="navbar-ex-collapse">
					<ul class="nav navbar-nav navbar-left" style="width: 100%;">
						<li id="consulta-usuarios">
							<a href="consulta-usuarios">Consulta de Usuarios</a>
						</li>
						<li id="alta"><a href="alta">Alta de usuarios</a></li>
						<li id="configuracion"><a href="configuracion">Configuración</a></li>
						<li id="salir"><a href="logout?msg=Su sesion se ha cerrado correctamente">Salir</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>