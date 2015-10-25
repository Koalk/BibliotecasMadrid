/**
 * 
 */

function login(){
	user = $("#user").val();
	pass = $("#pass").val();
	if (askForLogin(user,pass)){
		window.location = "consulta-usuarios.html";	
	}
}

function askForLogin(user,pass){return true;}