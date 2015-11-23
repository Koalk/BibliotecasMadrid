<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<html>
<head>
<title>Configuración</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="<c:url value="/resources/js/libs/jquery.js" />"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/configuracion.css" />" rel="stylesheet"
	type="text/css">
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
					<div class="col-md-12">
						<form:form method="POST" action="configuracion" modelAttribute="user">
							<div class="form-horizontal" role="form">
								<div class="form-group">
<!-- 									<div class="form-inline"> -->
										<div class="col-md-12" style="padding-bottom: 20px; padding-left: 20px;">
											<div class="col-md-12">
												<form:label path="usuario" style="padding-right: 10px">Nombre de usuario</form:label>
												<form:input type="text" class="form-control" path="usuario" size="20" />
											</div>
											<div class="col-md-12">
												<form:label path="password" style="padding-right: 10px">Contraseña</form:label>
												<form:input type="password" class="form-control" path="password" size="20" />
											</div>
											<div class="col-md-12">
												<form:label path="confirmPassword" style="padding-right: 10px">Confirmar contraseña</form:label>
												<form:input type="password" class="form-control" path="confirmPassword" size="20" />
											</div>
											<div class="col-md-12,row text-right" style="padding-right: 10%">
												<input type="submit" class="btn btn-primary" id="search" value="Guardar" />
											</div>
										</div>
<!-- 									</div> -->
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>