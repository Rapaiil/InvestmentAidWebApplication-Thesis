$(function(){
	$("#fbn").change(function(){
		var val = $.trim($("#fbn").val());
		var isValid = ValidateName.validate(val);
		var errmsg = $("#lfbn");
		
		if(val == "" || val == null){
			errmsg.html("This field is required");
			errmsg.css("color", "red");
			errmsg.css("visibility","visible");
		}
		else{
			if(isValid){
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
	$("#fbe").change(function(){
		var val = $.trim($("#fbe").val());
		var isValid = ValidateEmail.validate(val);
		var errmsg = $("#lfbe");

		if(val == "" || val == null){
			errmsg.html("This field is required");
			errmsg.css("color", "red");
			errmsg.css("visibility","visible");
		}
		else{
			if(isValid){
				errmsg.html("");
				errmsg.css("color", "black");
				errmsg.css("visibility","hidden");
			}
			else{
				errmsg.html("Please enter a valid email address");
				errmsg.css("color", "red");
				errmsg.css("visibility","visible");
				errmsg.css("font-size","12px");
			}
		}
	});
	$("#fbm").change(function(){
		var val = $.trim($("#fbm").val());
		var isValid = ValidateName.validate(val);
		var errmsg = $("#lfbm");
		
		if(val == "" || val == null){
			errmsg.html("This field is required");
			errmsg.css("color", "red");
			errmsg.css("visibility","visible");
		}
		else{
			errmsg.html("");
			errmsg.css("color", "black");
			errmsg.css("visibility","hidden");
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