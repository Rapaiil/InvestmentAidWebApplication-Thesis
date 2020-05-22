$(function(){
	$("#fn").change(function(){
		var fName = $.trim($("#fn").val());
		var isFNameValid = ValidateName.validate(fName);
		var errmsg = $("#lfn");
		if(fName == ""){
			errmsg.html("This field is required");
			errmsg.css("color", "red");
			errmsg.css("visibility","visible");
		}
		else{
			if(isFNameValid){
				errmsg.html("");
				errmsg.css("color", "black");
				errmsg.css("visibility","hidden");
			}
			else{
				errmsg.html("Please enter a valid name");
				errmsg.css("color", "red");
				errmsg.css("visibility","visible");
				errmsg.css("font-size","12px");
			}
		}
	});
	$("#ln").change(function(){
		var lName = $.trim($("#ln").val());
		var isLNameValid = ValidateName.validate(lName);
		var errmsg = $("#lln");
		if(lName == ""){
			errmsg.html("This field is required");
			errmsg.css("color", "red");
			errmsg.css("visibility","visible");
		}
		else{
			if(isLNameValid){
				errmsg.html("");
				errmsg.css("color", "black");
				errmsg.css("visibility","hidden");
			}
			else{
				errmsg.html("Please enter a valid name");
				errmsg.css("color", "red");
				errmsg.css("visibility","visible");
				errmsg.css("font-size","12px");
			}
		}
	});
	$("#occ").change(function(){
		var id 		= $(this).attr("id");
		ValidateInput.validate(id);
	});
	$("#com").change(function(){
		var id 		= $(this).attr("id");
		ValidateInput.validate(id);
	});
	$("#ea").change(function(){
		var email 	= $.trim($("#ea").val());
		var isEmailValid 	= ValidateEmail.validate(email);
		var errmsg 	= $("#lea");
		if(email == ""){
			errmsg.html("This field is required");
			errmsg.css("color", "red");
			errmsg.css("visibility","visible");
		}
		else{
			if(isEmailValid){
				errmsg.html("");
				errmsg.css("color", "black");
				errmsg.css("visibility","hidden");
			}
			else{
				errmsg.html("Please enter a valid email");
				errmsg.css("color", "red");
				errmsg.css("visibility","visible");
				errmsg.css("font-size","12px");
			}
		}
	});
	$("#tn").change(function(){
		var tn 	= $.trim($("#tn").val());
		tn = tn.replace(/ +/g, "");
		var isTelNoValid = ValidateTelNo.validate(tn);
		var errmsg 	= $("#ltn");
		if(tn == ""){
			errmsg.html("This field is required");
			errmsg.css("color", "red");
			errmsg.css("visibility","visible");
		}
		else{
			if(isTelNoValid){
				errmsg.html("");
				errmsg.css("color", "black");
				errmsg.css("visibility","hidden");
			}
			else{
				errmsg.html("Please enter a valid telephone number");
				errmsg.css("color", "red");
				errmsg.css("visibility","visible");
				errmsg.css("font-size","12px");
			}
		}
	});
	$("#cn").change(function(){
		var cn 	= $.trim($("#cn").val());
		cn = cn.replace(/ +/g, "");
		var isCelNoValid = ValidateCelNo.validate(cn);
		var errmsg 	= $("#lcn");
		if(cn == ""){
			errmsg.html("This field is required");
			errmsg.css("color", "red");
			errmsg.css("visibility","visible");
		}
		else{
			if(isCelNoValid){
				errmsg.html("");
				errmsg.css("color", "black");
				errmsg.css("visibility","hidden");
			}
			else{
				errmsg.html("Please enter a valid cellphone number");
				errmsg.css("color", "red");
				errmsg.css("visibility","visible");
				errmsg.css("font-size","12px");
			}
		}
	});
});

ValidateName = {
		validate: function(input){
			if(/^[A-Za-z_-]*$/.test(input.trim())){
					return true;
			}
			else{
				return false;
			}
		}
}

ValidateEmail = {
		validate: function(input){
			if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(input.trim())){
				return true;
			}
			else{
				return false;
			}
		}
}

ValidateTelNo = {
		validate: function(input){
			// /^(\d{2})\d{8}$/
			// ^\d+$
			// ^[0-9]+$
			if((/^(\d{2})(\d{8})$/.test(input.trim()))){
				return true;
			}
			else{
				return false;
			}
		}
}

ValidateCelNo = {
		validate: function(input){
			if(/^(09|\+639|639)\d{9}$/.test(input.trim())){
				return true;
			}
			else{
				return false;
			}
		}
}

ValidateInput = {
		validate: function(input){
			var data 		= $.trim($("#"+input).val());
			var errmsg 	= $("#l"+input);
			//alert(data);
			//alert(errmsg);
			
			if(data == ""){
				errmsg.html("This field is required");
				errmsg.css("color", "red");
				errmsg.css("visibility","visible");
			}
			else{
				errmsg.html("");
				errmsg.css("color", "green");
				errmsg.css("visibility","hidden");
			}
		}
}