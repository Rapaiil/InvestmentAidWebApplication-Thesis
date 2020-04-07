$(function(){
	$("#fn").change(function(){
		var id 		= $(this).attr("id");
		alert(id);
		ValidateInput.validate(id);
	});
	$("#ln").change(function(){
		var id 		= $(this).attr("id");
		ValidateInput.validate(id);
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
				errmsg.css("display","block");
				errmsg.css("font-size","12px");
			}
		}
	});
	$("#tn").change(function(){
		var email 	= $.trim($("#tn").val());	
		var errmsg 	= $("#ltn");
	});
	$("#mn").change(function(){
		var email 	= $.trim($("#mn").val());	
		var errmsg 	= $("#lmn");
	});
});

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

ValidateInput = {
		validate: function(input){
			var data 		= $.trim($("#"+input).val());
			var errmsg 	= $("#l"+input);
			alert(data);
			alert(errmsg);
			
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