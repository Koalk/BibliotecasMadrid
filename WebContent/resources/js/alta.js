/**
 * 
 */
activePage = "alta";

jQuery(document).ready(function(){
	setWebcam();
	$("#takePictureButton").click(function(){takePicture(); return false;});
	$("#newPictureButton").click(function(){switchCamPreview(true); return false;});
	previewFoto();
});

function setWebcam(){
	Webcam.set({
		// live preview size
		width: 290,
		height: 350,

		// final size
		dest_width: 290,
		dest_height: 350,

		// flip horizontal (mirror mode)
		flip_horiz: true
	});
	return false;
}

function takePicture(){
	Webcam.snap(function(dataUrl){
//		var imageData = dataUrl.replace(/^data\:image\/\w+\;base64\,/, '');
		$("#foto").val(dataURItoBlob(dataUrl));
		previewFoto();
	});
	return false;
}

function switchCamPreview(toOn){
	if (toOn){
		$("#newPictureButton").hide();
		$("#takePictureButton").show();
		$("#fotoPreview").hide();
		$("#camPreview").show();
		Webcam.attach("#camPreview");
		$("#foto").val(null);
	}
	else {
		$("#newPictureButton").show();
		$("#takePictureButton").hide();
		$("#fotoPreview").show();
		Webcam.reset();
		$("#camPreview").hide();
	}
	return false;
}

function previewFoto(){
	if ($("#foto").val() != null){
		var foto = new Blob($("#foto").val());
		var reader  = new FileReader();
		reader.onloadend = function () {
			$("#fotoPreview").attr("src",dataUrl);
			switchCamPreview(false);
		}

		if (foto) {
			reader.readAsDataURL(foto);
		} else {
			$("#fotoPreview").attr("src","");
			switchCamPreview(true);
		}
	}
	return false;
}

function dataURItoBlob(dataURI) {
	// convert base64/URLEncoded data component to raw binary data held in a string
	var byteString;
	if (dataURI.split(',')[0].indexOf('base64') >= 0)
		byteString = atob(dataURI.split(',')[1]);
	else
		byteString = unescape(dataURI.split(',')[1]);

	// separate out the mime component
	var mimeString = dataURI.split(',')[0].split(':')[1].split(';')[0];

	// write the bytes of the string to a typed array
	var ia = new Uint8Array(byteString.length);
	for (var i = 0; i < byteString.length; i++) {
		ia[i] = byteString.charCodeAt(i);
	}

	return new Blob([ia], {type:mimeString});
}