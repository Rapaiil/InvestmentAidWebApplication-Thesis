var fundtype;
var jsonfundobj;

function deleteAll() {
	$('#fund-name option').remove();
}

function getFundList() {
	var fundtype = $('input[type="radio"][name="customRadioInline1"]:checked').val();
	
	if(fundtype == "mfRadioValue") {
		$.ajax({
			type: "post",
			url: "retrievemffunds",
			success: function(response) {
				var jsonstr = JSON.stringify(response);
				jsonfundobj = JSON.parse(jsonstr);
				
				deleteAll();
				var len = Object.keys(jsonfundobj.mfFundList).length;
				
				for(var i=0; i<len; i++) {
					$('#fund-name').append("<option value='" + jsonfundobj.mfFundList[i].fundNumber + "'>" + jsonfundobj.mfFundList[i].fundName + "</option> ");
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
				var len = Object.keys(jsonfundobj.uitfFundList).length;
				
				for(var i=0; i<len; i++) {
					$('#fund-name').append("<option value='" + jsonfundobj.uitfFundList[i].fundNumber + "'>" + jsonfundobj.uitfFundList[i].fundName + "</option> ");
				}
			}
		});
	} 
}