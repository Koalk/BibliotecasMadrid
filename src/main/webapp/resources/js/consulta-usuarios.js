/**
 * 
 */
activePage = "consulta-usuarios";
jQuery(document).ready(function(){
	if (window.self !== window.top){
		window.parent.location = self.location;
	}
	$("#clean").click(function(){cleanAll();return null;});
});

function showModifyModal(identificador){
	$("#modifyUserFrame").prop("src","alta?userIdentificador="+identificador);
}

function cleanAll(){
	$("form input[type=text]").val("");
}