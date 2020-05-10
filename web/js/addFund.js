function getType() {
	var fundType = $('#customRadioInline1').val();
	
	if(fundType == "mfRad") {
		alert("You chose Mutual Fund.");
	} else if(fundType == "uitfRad") {
		alert("You chose Unit Investment Trust Fund.");
	} else {
		alert("Nothingness!");
	}
}