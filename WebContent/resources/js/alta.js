/**
 * 
 */
activePage = "alta";
fromController = true;
jQuery(document).ready(function(){
	setWebcam();
	$("#takePictureButton").click(function(){takePicture(); return false;});
	$("#newPictureButton").click(function(){switchCamPreview(true); return false;});
	previewFoto();
	fromController = false;
});

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
//		var blobData = dataURItoBlob(dataUrl);
		$("#foto").val(imageData);
		previewFoto();
	});
	return false;
}

function switchCamPreview(toOn){
	if (toOn){
		$("#newPictureButton").hide();
		$("#takePictureButton").show();
		$("#fotoPreview").hide();
		$("#camContainer").show();
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
		$("#camContainer").hide();
	}
	return false;
}

function previewFoto(){
	if ($("#foto").val()){
		var foto = $("#foto").val();
//		var reader  = new FileReader();
//		reader.onloadend = function () {
//			$("#fotoPreview").attr("src",reader.result);
//		}

		if (foto) {
//			if (fromController){
				
//				var blob = new Blob([foto], {type:"image/jpeg"})
//				reader.readAsDataURL(blob);
//			}
//			else {
				$("#fotoPreview").attr("src","data:image/jpeg;base64,"+foto);
//			}
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