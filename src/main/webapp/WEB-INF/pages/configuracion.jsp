<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<html>
<head>
<title>BiblEx CAMA</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="<c:url value="/resources/js/libs/jquery.js" />"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/configuracion.css" />"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="<c:url value="/resources/js/configuracion.js" />"></script>
</head>
<body>
	<div id="navigator">
		<jsp:include page="navigation.jsp" />
	</div>
	<div class="content">
		<div class="section">
			<div class="container">
				<div class="row">
					<form:form method="POST" action="configuracion"
						modelAttribute="user">
						<div class="col-md-12" role="form">
							<div class="form-group">
								<div class="col-md-6"
									style="padding-bottom: 20px; padding-left: 20px;">
									<div class="form-field">
										<form:label path="nombre" style="padding-right: 10px">Nombre: </form:label>
										<form:input type="text" class="form-control" path="nombre"
											maxlength="64" readonly="true" style="background-color:#DEDEDE;"/>
										<form:errors path="nombre" cssClass="error-field" />
									</div>
									<div class="form-field">
										<form:label path="apellidos" style="padding-right: 10px">Apellidos: </form:label>
										<form:input type="text" class="form-control" path="apellidos"
											maxlength="128" readonly="true" style="background-color:#DEDEDE;"/>
										<form:errors path="apellidos" cssClass="error-field" />
									</div>
									<div class="form-field">
										<form:label path="mail" style="padding-right: 10px">Correo electrónico: </form:label>
										<form:input type="text" class="form-control" path="mail"
											maxlenght="256" readonly="true" style="background-color:#DEDEDE;"/>
										<form:errors path="mail" cssClass="error-field" />
									</div>
								</div>
								<div class="col-md-6"
									style="padding-bottom: 20px; padding-left: 20px;">
									<div class="form-field">
										<form:label path="usuario" style="padding-right: 10px">Usuario de acceso: </form:label>
										<form:input type="text" class="form-control" path="usuario"
											maxlength="64" readonly="true" style="background-color:#DEDEDE;"/>
										<form:errors path="usuario" cssClass="error-field" />
									</div>
									<div class="form-field">
										<form:label path="password" style="padding-right: 10px">Contraseña actual: </form:label>
										<form:password class="form-control" path="password"
											maxlength="64" />
										<form:errors path="password" cssClass="error-field" />
									</div>
									<div class="form-field">
										<form:label path="newPassword" style="padding-right: 10px">Nueva contraseña: </form:label>
										<form:password class="form-control" path="newPassword"
											maxlenght="64" />
										<form:errors path="newPassword" cssClass="error-field" />
									</div>
									<div class="form-field">
										<form:label path="confirmPassword" style="padding-right: 10px">Confirmar contraseña: </form:label>
										<form:password class="form-control" path="confirmPassword"
											maxlenght="64" />
										<form:errors path="confirmPassword" cssClass="error-field" />
									</div>
								</div>
								<div class="col-md-4"></div>
								<div class="col-md-4">
									<div class="form-field text-right" style="padding-right: 10%">
										<input type="submit" class="btn btn-primary" id="search"
											value="Guardar" /> <label
											style="color: grey; font-size: x-small;">*Al guardar
											los cambios se saldrá de la aplicación para acceder con los
											nuevos datos.</label>
									</div>
								</div>
								<div class="col-md-4"></div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>