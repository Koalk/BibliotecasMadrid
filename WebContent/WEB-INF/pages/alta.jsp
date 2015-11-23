<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<html>
<head>
<title>Nuevo usuario</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="<c:url value="/resources/js/libs/jquery.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/libs/webcam.js" />"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/alta.css" />" rel="stylesheet"
	type="text/css">
<script type="text/javascript"
	src="<c:url value="/resources/js/alta.js" />"></script>
</head>
<body>
	<div id="navigator">
		<c:if test="${empty userIdentificador}">
			<jsp:include page="navigation.jsp" />
		</c:if>
<!-- 		<div style="width: 100%;"> -->
<!-- 			<span style="position: absolute; top: 0px; left: 0px; z-index: 10;"> -->
<!-- 				<img height="80" alt="UNED Madrid" -->
<%-- 				src="<c:url value="/resources/img/logo.jpg" />" /> --%>
<!-- 			</span> -->
<!-- 			<div class="navbar navbar-default" -->
<!-- 				style="margin-top: 30px; position: absolute; left: 130px; overflow: hidden; width: 85%;"> -->
<!-- 				<div class="container"> -->
<!-- 					<div class="collapse navbar-collapse" id="navbar-ex-collapse"> -->
<!-- 						<ul class="nav navbar-nav navbar-left" style="width: 100%;"> -->
<!-- 							<li id="consulta-usuarios"><a href="consulta-usuarios">Consulta -->
<!-- 									de Usuarios</a></li> -->
<!-- 							<li id="alta" class="active"><a href="">Alta de usuarios</a></li> -->
<!-- 							<li id="configuracion"><a href="#">Configuración</a></li> -->
<!-- 							<li id="salir"><a href="login?logout">Salir</a></li> -->
<!-- 						</ul> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
	</div>
	<div class="content">
		<form:form method="POST" action="alta" modelAttribute="externalUser">
			<div class="section">
				<div class="container">
					<div class="row">
						<div class="col-md-12"
							style="font-size: 18px; padding-bottom: 20px; padding-left: 20px;">
							<div style="display: inline;" class="col-md-5">
								<form:label path="identificador" style="padding-right: 10px">Identificador:</form:label>
								<form:input path="identificador" size="20" readonly="true" />
							</div>
							<div class="col-md-7" style="display: inline;">
								<form:label path="biblioteca" style="padding-right: 10px;">Biblioteca de alta:</form:label>
								<div style="display: inline; width: 100;">
									<form:input path="biblioteca" style="width: auto;"
										readonly="true" />
								</div>
							</div>
						</div>
						<div class="col-md-8">
							<div class="col-md-6">
								<div class="form-field">
									<div>
										<form:label path="nombre">Nombre:</form:label>
									</div>
									<div>
										<form:input path="nombre" size="64"/>
									</div>
								</div>
								<div class="form-field">
									<div>
										<form:label path="apellido1">Primer apellido:</form:label>
									</div>
									<div>
										<form:input path="apellido1" size="64"/>
									</div>
								</div>
								<div class="form-field">
									<div>
										<form:label path="apellido2">Segundo apellido:</form:label>
									</div>
									<div>
										<form:input path="apellido2" size="64"/>
									</div>
								</div>
								<div class="form-field">
									<div>
										<form:label path="localidad" >Localidad:</form:label>
									</div>
									<div>
										<form:input path="localidad" size="64"/>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-field">
									<div>
										<form:label path="nifPasaporte">Nif/Pasaporte:</form:label>
									</div>
									<div>
										<form:input path="nifPasaporte"  size="16"/>
									</div>
								</div>
								<div class="form-field">
									<div>
										<form:label path="mail">Correo electrónico:</form:label>
									</div>
									<div>
										<form:input path="mail"  size="128"/>
									</div>
								</div>
								<div class="form-field">
									<div>
										<form:label path="telefono">Teléfono:</form:label>
									</div>
									<div>
										<form:input path="telefono" size="16"/>
									</div>
								</div>
								<div class="form-field">
									<div>
										<form:label path="codigoPostal">Código postal:</form:label>
									</div>
									<div>
										<form:input path="codigoPostal" size="5"/>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-field">
									<div>
										<form:label path="direccion">Dirección:</form:label>
									</div>
									<div>
										<form:input path="direccion" size="256"/>
									</div>
								</div>
								<div class="form-field">
									<div>
										<form:label path="observaciones">Observaciones:</form:label>
									</div>
									<div>
										<form:textarea path="observaciones" style="width: 100%;"
											rows="4"></form:textarea>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-4" style="display: table;">
							<div id="camContainer" align="center" style="padding-top: 15%;height: 350px;width: 290px;overflow:hidden;">
								<div id="camPreview" style="height: 350px; width: 290px;"></div>
							</div>
							<div align="center" style="padding-top: 15%;">
								<img id="fotoPreview" class="img-responsive img-rounded"
									src="https://www.uchceu.es/directorio/imagenes/silueta_hombre.gif"
									style="height: 290px; width: 290px; display: none;">
								<div class="btn-group btn-group-lg" style="padding-top: 20px;">
									<a id="newPictureButton" href="#" class="btn btn-default"
										style="width: 200px; display: none;">Nueva foto</a> <a
										id="takePictureButton" href="#" class="btn btn-default"
										style="width: 200px">Tomar foto</a>
								</div>
								<form:input id="foto" path="foto" type="hidden"/>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="section" style="position: relative; top: -20px">
				<div class="container">
					<div class="row">
						<div class="col-md-6" style="padding-top: 10px">
							<input type="submit" class="btn btn-block btn-lg btn-primary"
								style="height: 60px; font-size: 25px; padding-top: 10px;"
								value="Guardar" />
						</div>
						<div class="col-md-6" style="padding-top: 10px">
							<a class="btn btn-block btn-lg btn-warning"
								style="height: 60px; font-size: 25px; padding-top: 10px;">Descartar</a>
						</div>
					</div>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>