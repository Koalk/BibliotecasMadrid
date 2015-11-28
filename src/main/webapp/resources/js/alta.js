/**
 * 
 */
activePage = "alta";
jQuery(document).ready(function(){
	setWebcam();
	$("#takePictureButton").click(function(){takePicture(); return false;});
	$("#newPictureButton").click(function(){switchCamPreview(true); return false;});
	if ($("#foto").val() && $("#foto").val().indexOf(".jpg")>=0){
		getDataUri($("#foto").val(), setFotoDataUrl);
	}
	else {
		previewFoto();
	}
	if ($("#identificadorField").val() && $('#allErrors').children().length == 0){
		$("#contentDiv").css("padding-top","10px")
		$("#altaForm :input").prop("disabled", true);
		$("#takePictureButton").hide();
		$("#newPictureButton").hide();
		$("#modifyButton").click(function(){enableForm();return false;});
		$("#saveButton").prop("disabled",true);
		$("#modifyButton").prop("disabled",false);
		$("#discardButton").hide();
	}
	else if ($("#identificadorField").val() && $('#allErrors').children().length != 0){
		$("#contentDiv").css("padding-top","10px")
		$("#discardButton").hide();
		$("#modifyButton").hide();
	}
	else {
		$("#modifyButton").hide();
		$("#discardButton").prop("href","consulta-usuarios");
	}
});

function enableForm(){
	$("#altaForm :input").prop("disabled", false);
	$("#modifyButton").hide();
	$("#newPictureButton").show();
	previewFoto();
}

function setFotoDataUrl(dataUri){
	$("#foto").val(dataUri);
	previewFoto();
}

function setWebcam(){
	Webcam.set({
		// live preview size
		width: 320,
		height: 240,

		// device capture size
		dest_width: 640,
		dest_height: 480,

		// final cropped size
		crop_width: 480,
		crop_height: 480,

		// flip horizontal (mirror mode)
		flip_horiz: true
	});
	return false;
}

function takePicture(){
	Webcam.snap(function(dataUrl){
		var imageData = dataUrl.replace(/^data\:image\/\w+\;base64\,/, '');
		$("#foto").val(imageData);
		previewFoto();
	});
	return false;
}

function switchCamPreview(toOn){
	if (toOn){
		var identificador = $("#identificadorField").val();
		if (identificador){
			$("#newPictureButton").hide();
			$("#takePictureButton").show();
		}
		$("#fotoPreview").hide();
		$("#camContainer").show();
		$("#camPreview").show();
		Webcam.attach("#camPreview");
		$("#foto").val(null);
	}
	else {
		var identificador = $("#identificadorField").val();
		if (!identificador){
			$("#newPictureButton").show();
			$("#takePictureButton").hide();
		}
		$("#fotoPreview").show();
		$("#camPreview").hide();
		$("#camContainer").hide();
	}
	return false;
}

function previewFoto(){
	if ($("#foto").val()){
		var foto = $("#foto").val();

		if (foto) {
			$("#fotoPreview").attr("src","data:image/jpeg;base64,"+foto);
			switchCamPreview(false);

		} else {
			$("#fotoPreview").attr("src","");
			switchCamPreview(true);
		}
	}
	else {
		switchCamPreview(true);
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

function getDataUri(url, callback) {
	var image = new Image();

	image.onload = function () {
		var canvas = document.createElement('canvas');
		canvas.width = this.naturalWidth; // or 'width' if you want a special/scaled size
		canvas.height = this.naturalHeight; // or 'height' if you want a special/scaled size

		canvas.getContext('2d').drawImage(this, 0, 0);

		// Get raw image data
		callback(canvas.toDataURL('image/png').replace(/^data:image\/(png|jpg);base64,/, ''));
	};

	image.src = url;
}