/**
 * 
 */
activePage = "alta";

jQuery(document).ready(function(){
	var foto = $("#foto").val();
	console.log(foto);
	if (foto != null){
		var reader  = new FileReader();
		reader.onloadend = function () {
			previewFoto(reader.result);
		}

		if (foto) {
			reader.readAsDataURL(foto);
		} else {
			previewFoto("");
		}
	}
});

function previewFoto(dataUrl){
	$("#fotoPreview").src(dataUrl);
}