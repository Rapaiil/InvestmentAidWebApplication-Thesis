var jsonrates;
var def_zero = 0;

initRates();

function isFloating(event) {
	if((event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
	    event.preventDefault();
	  }
}

function convertAmount() {
	if($('#inputGroupSelect01').val() == "-1" || $('#currencyconv_textbox1').val().length === 0) {
		$('#currencyconv_textbox2').val(def_zero);
	} else {
		var code = $('#inputGroupSelect01').val();
		var inputvalue = $('#currencyconv_textbox1').val();
		var rate = 0.0;
		var convertedvalue = 0.0;
		
		for(var i=0; i<54; i++) {
			var currCode = jsonrates.ratestable[i].currencyCode;
			if(currCode == code) {
				rate = jsonrates.ratestable[i].rateForPhp;
				break;
			}
		}
		
		convertedvalue = (Math.round((inputvalue * rate) * 100) / 100).toFixed(2);
		$('#currencyconv_textbox2').val(convertedvalue);
	}
}

function initRates() {
	$.ajax({
		type: "post",
		url: "retrieverates",
		success: function(response) {
			var jsonstr = JSON.stringify(response);
			jsonrates = JSON.parse(jsonstr);
		}
	});
}