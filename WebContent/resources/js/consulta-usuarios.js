/**
 * 
 */
activePage = "consulta-usuarios";
jQuery(document).ready(function(){
});

function showModifyModal(identificador){
	$("#modifyUserFrame").prop("src","alta?userIdentificador="+identificador);
}