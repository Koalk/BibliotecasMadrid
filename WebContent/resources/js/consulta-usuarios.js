/**
 * 
 */
activePage = "consulta-usuarios";
jQuery(document).ready(function(){
});

function showModifyModal(identificador){
	console.log("Mostrando pantalla de modificación para "+identificador);
	$("#modal-body").load("alta?userIdentificador="+identificador);
}