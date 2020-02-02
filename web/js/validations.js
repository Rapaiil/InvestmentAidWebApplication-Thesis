$(function(){
	//Email
	$("#ea").change(function(){
		alert("Triggered #ea on change");
		var email 			= $.trim($("#ea").val());
		var isEmailValid 	= ValidateEmail.validate(email);
		var errmsg			= $("#lea");
		
		if(isEmailValid){
			errmsg.html("");
			errmsg.css("color", "black");
			errmsg.css("display","none");
		}
		else{
			errmsg.html("Please enter a valid email");
			errmsg.css("color", "red");
			errmsg.css("display","block");
		}
	});
	
	//Password
	$("#p,#cp").change(function(){
		alert("Triggered #p and #cp on change");
		var password 			= $.trim($("#p").val());
		var confirmPassword		= $.trim($("#cp").val());
		var isPasswordValid 	= ValidatePassword.validate(password);
		var errmsg				= $("#lp");
		
		if(isPasswordValid){
			var isPasswordMatch = ValidatePassword.match(password,confirmPassword);
			if(isPasswordMatch){
				errmsg.html("Passwords Match");
				errmsg.css("color", "green");
				errmsg.css("display","block");
			}
			else{
				errmsg.html("Passwords doesn't match");
				errmsg.css("color", "red");
				errmsg.css("display","block");
			}
			//errmsg.html("");
			//errmsg.css("color", "black");
			//errmsg.css("display","none");
		}
		else{
			errmsg.html("Please make sure your password contains a mix of at least 1 uppercase, 1 lowercase and 1 numerical characters");
			errmsg.css("color", "red");
			errmsg.css("display","block");
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

ValidatePassword = {
		validate: function(input){
			if (/(?=^.{8,}$)(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s)[0-9a-zA-Z!@#$%^&*()]*$/.test(input.trim())){
				return true;
			}
			else{
				return false;
			}
		},
		
		match: function(input1, input2){
			if(input1 == input2){
				return true;
			}
			else{
				return false;
			}
		}
}