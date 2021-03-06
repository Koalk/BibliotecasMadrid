<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<html>
<head>
<title>BiblEx CAMA</title>
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
		<jsp:include page="navigation.jsp" />
	</div>
	<div class="modal fade" id="modify-user-modal">
		<div class="modal-dialog" style="width:90%; height:80%;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x�</button>
					<h4 class="modal-title">Modificar usuario</h4>
				</div>
				<div id="modal-body" class="modal-body">
					<iframe id="modifyUserFrame" width="100%" height="100%" seamless="seamless" style="border:none;overflow:hidden;"></iframe>
				</div>
				<div class="modal-footer">
				</div>
			</div>
		</div>
	</div>
	<div class="content">
		<div class="section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<form:form id="searchForm" method="POST" modelAttribute="externalUser">
							<div class="form-horizontal" role="form">
								<div class="form-group">
									<div class="form-inline">
										<div class="col-sm-4">
											<form:label path="nombre" class="control-label" style="min-width: 125px;">Nombre: </form:label>
											<form:input type="text" class="form-control" path="nombre" placeholder="Nombre" />
										</div>
										<div class="col-sm-4">
											<form:label path="apellido1" class="control-label" style="min-width: 125px;">Apellido 1: </form:label>
											<form:input type="text" class="form-control" path="apellido1" placeholder="Primer apellido" />
										</div>
										<div class="col-sm-4">
											<form:label path="apellido2" class="control-label" style="min-width: 125px;">Apellido 2: </form:label>
											<form:input type="text" class="form-control" path="apellido2" placeholder="Segundo apellido" />
										</div>
									</div>
								</div>
							</div>
							<div class="form-horizontal" role="form">
								<div class="form-group">
									<div class="form-inline">
										<div class="col-sm-4">
											<form:label path="identificador" class="control-label" style="min-width: 125px;">N�mero de usuario: </form:label>
											<form:input id="identificador" type="text" class="form-control" path="identificador" placeholder="N�mero de usuario" />
										</div>
										<div class="col-sm-4">
											<form:label path="nifPasaporte" class="control-label" style="min-width: 125px;">NIF/Pasaporte: </form:label>
											<form:input type="text" class="form-control" path="nifPasaporte" placeholder="NIF/Pasaporte" />
										</div>
										<div class="col-sm-4">
											<form:label path="telefono" class="control-label" style="min-width: 125px;">Tel�fono: </form:label>
											<form:input type="text" class="form-control" path="telefono" placeholder="Tel�fono" />
										</div>
									</div>
								</div>
							</div>
							<div class="form-horizontal" role="form">
								<div class="form-group">
									<div class="form-inline">
										<div class="col-sm-4">
											<form:label path="mail" class="control-label" style="min-width: 125px;">Correo: </form:label>
											<form:input type="text" class="form-control" path="mail" placeholder="Correo" />
										</div>
										<div class="col-sm-4">
											<form:label path="localidad" class="control-label" style="min-width: 125px;">Localidad: </form:label>
											<form:input type="text" class="form-control" path="localidad" placeholder="Localidad" />
										</div>
										<div class="col-sm-4">
											<form:label path="biblioteca" class="control-label" style="min-width: 125px;">Biblioteca: </form:label>
											<form:input type="text" class="form-control" path="biblioteca" placeholder="biblioteca" />
										</div>
									</div>
									<div class="col-sm-4,row text-right" style="padding-top:8%;padding-right: 15%">
										<a class="btn btn-warning" id="clean">Limpiar</a>
										<input type="submit" class="btn btn-primary" id="search" value="Buscar" />
									</div>
								</div>
							</div>
						</form:form>
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
									<th>Id de usuario</th>
									<th>NIF/Pasaporte</th>
									<th>Nombre</th>
									<th>Apellidos</th>
									<th>Correo electr�nico</th>
									<th>Tel�fono</th>
									<th>Biblioteca</th>
									<th>Fecha de alta</th>
									<th style="font-size: 28px; color: red; text-align: center; " title="Observaciones">!</th>
									<th style="width: 105px;"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${usuariosExternos}" var="user" >
									<tr>
										<td>${user.identificador}</td>
										<td>${user.nifPasaporte}</td>
										<td>${user.nombre}</td>
										<td>${user.apellido1} ${user.apellido2}</td>
										<td>${user.mail}</td>
										<td>${user.telefono}</td>
										<td>${user.biblioteca}</td>
										<td><fmt:formatDate pattern="dd-MM-yyyy" value="${user.createTime}" /></td>
										<td>
											<c:if test="${not empty user.observaciones}">
												<img alt="Obs."
													src="<c:url value="/resources/img/eye-icon.png" />" 
													width="20px"
													height="20px"
													title="${user.observaciones}">
											</c:if>
										</td>
										<td>
											<a class="btn btn-primary"
												data-toggle="modal" data-target="#modify-user-modal"
												onClick="showModifyModal('${user.identificador}');return false;">
												Modificar
											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
<!-- 						<ul class="pagination"> -->
<!-- 							<li><a href="#">Ant</a></li> -->
<!-- 							<li><a href="#">1</a></li> -->
<!-- 							<li><a href="#">2</a></li> -->
<!-- 							<li><a href="#">3</a></li> -->
<!-- 							<li><a href="#">4</a></li> -->
<!-- 							<li><a href="#">5</a></li> -->
<!-- 							<li><a href="#">Sig</a></li> -->
<!-- 						</ul> -->
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>