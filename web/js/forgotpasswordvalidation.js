$(function(){
	
	$("#ea").change(function(){
		var email 			= $.trim($("#ea").val());
		var isEmailValid 	= ValidateEmail.validate(email);
		var errmsg			= $("#lea");
		alert("Email: " + email);
		alert("Valid: " + isEmailValid);
		
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
				errmsg.css("visibility","visible");
				errmsg.css("color", "red");
				errmsg.css("display","block");
				errmsg.css("font-size","12px");
			}
		}
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