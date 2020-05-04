var jsonrates;

$(document).ready(function() {
	$.ajax({
		type: "post",
		url: "retrieverates",
		success: function(response) {
			jsonrates = response;
		}
	});
});

function isFloating(event) {
	if((event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
	    event.preventDefault();
	  }
}

function convertAmount() {
	var y = $('#currencyconv_textbox1').val();
	y = y*2.2;
	$('#currencyconv_textbox2').val(y);
}