/**
 * 
 */
activePage = "consulta-usuarios";
jQuery(document).ready(function(){
	if (window.self !== window.top){
		window.parent.location = self.location;
	}
});

function showModifyModal(identificador){
	$("#modifyUserFrame").prop("src","alta?userIdentificador="+identificador);
}