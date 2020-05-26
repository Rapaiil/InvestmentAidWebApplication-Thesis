var fundtype;
var jsonfundobj;

function deleteAll() {
	$('#fund-name option').remove();
}

function getFundList() {
	fundtype = $('input[type="radio"][name="fundType"]:checked').val();
	
	if(fundtype == "mfRadioValue") {
		$.ajax({
			type: "post",
			url: "retrievemffunds",
			success: function(response) {
				var jsonstr = JSON.stringify(response);
				jsonfundobj = JSON.parse(jsonstr);
				
				deleteAll();
				var len = Object.keys(jsonfundobj.fundList).length;
				
				for(var i=0; i<len; i++) {
					$('#fund-name').append("<option value='" + jsonfundobj.fundList[i].fundNumber + "'>" + jsonfundobj.fundList[i].fundName + "</option> ");
				}
			}
		});
	} else if(fundtype == "uitfRadioValue") {
		$.ajax({
			type: "post",
			url: "retrieveuitffunds",
			success: function(response) {
				var jsonstr = JSON.stringify(response);
				jsonfundobj = JSON.parse(jsonstr);
				
				deleteAll();
				var len = Object.keys(jsonfundobj.fundList).length;
				
				for(var i=0; i<len; i++) {
					$('#fund-name').append("<option value='" + jsonfundobj.fundList[i].fundNumber + "'>" + jsonfundobj.fundList[i].fundName + "</option> ");
				}
			}
		});
	} 
}

function isFloating(event) {
	if((event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
	    event.preventDefault();
	  }
}