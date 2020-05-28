var jsonobj;

$(document).ready(function() {
	getTPV();
});

function getTPV() {
	$.ajax({
		type: "post",
		url: "gettpv",
		success: function(response) {
			if(jQuery.isEmpty(response) || (typeof response == undefined)) {
				$('.net').append("<h1>&#8369;0.00</h1>" +
						"<small>Total Portfolio Value</small>");
			} else {
				var jsonstr = JSON.stringify(response);
				jsonobj = JSON.parse(jsonstr);
				
				console.log(jsonobj);
			}
			
		}
	});
}