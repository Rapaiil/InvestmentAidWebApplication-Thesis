document.getElementById('editAccount').onclick = function() {
    document.getElementById('name').removeAttribute('readonly');
    document.getElementById('telNum').removeAttribute('readonly');
    document.getElementById('mobileNum').removeAttribute('readonly');
    document.getElementById('emailAdd').removeAttribute('readonly');
    document.getElementById('birthday').removeAttribute('readonly');
    document.getElementById('occupation').removeAttribute('readonly');
    document.getElementById('company').removeAttribute('readonly');
    
    document.getElementById('editAccount').style.visibility = "hidden";
    document.getElementById('lastname').style.visibility = "visible";
    
    document.getElementById('actionbuttons').innerHTML = 
    	"<div class='text-center'>" +
    	"	<a type='button' href='#' id='save' onclick='save()' class='btn btn-primary text-uppercase account-btn'>Save</a>" +
    	"	<a type='button' href='#' id='cancel' onclick='cancel()' class='btn btn-primary text-uppercase account-btn bg-danger'>Cancel</a>" +
    	"</div>"
};

function save(){
	document.getElementById('name').readOnly = true;
    document.getElementById('telNum').readOnly = true;
    document.getElementById('mobileNum').readOnly = true;
    document.getElementById('emailAdd').readOnly = true;
    document.getElementById('birthday').readOnly = true;
    document.getElementById('occupation').readOnly = true;
    document.getElementById('company').readOnly = true;
    
    document.getElementById('editAccount').style.visibility = "visible";
    
    document.getElementById('nameError').style.visibility = "hidden";
    document.getElementById('telNumError').style.visibility = "hidden";
    document.getElementById('mobileNumError').style.visibility = "hidden";
    document.getElementById('emailAddError').style.visibility = "hidden";
    document.getElementById('occupationError').style.visibility = "hidden";
    document.getElementById('companyError').style.visibility = "hidden";
    
    document.getElementById('lastname').style.visibility = "hidden";
    
    document.getElementById('actionbuttons').innerHTML = "";
}

function cancel(){
	document.getElementById('name').readOnly = true;
    document.getElementById('telNum').readOnly = true;
    document.getElementById('mobileNum').readOnly = true;
    document.getElementById('emailAdd').readOnly = true;
    document.getElementById('birthday').readOnly = true;
    document.getElementById('occupation').readOnly = true;
    document.getElementById('company').readOnly = true;
    
    document.getElementById('editAccount').style.visibility = "visible";
    
    document.getElementById('nameError').style.visibility = "hidden";
    document.getElementById('telNumError').style.visibility = "hidden";
    document.getElementById('mobileNumError').style.visibility = "hidden";
    document.getElementById('emailAddError').style.visibility = "hidden";
    document.getElementById('occupationError').style.visibility = "hidden";
    document.getElementById('companyError').style.visibility = "hidden";
    
    document.getElementById('lastname').style.visibility = "hidden";
    
    document.getElementById('actionbuttons').innerHTML = "";
}

/*function validate(){
	var fName = document.getElementById('firstName');
	var lName = document.getElementById('lastName');
	var telNumber = document.getElementById('telNum');
	var mobNumber= document.getElementById('mobileNum');
	var email = document.getElementById('emailAdd');
	
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	
	if(fName.value.length == 0){
		document.getElementById('fNameError').style.visibility = "visible";
	}else{
		document.getElementById('fNameError').style.visibility = "hidden";
	}
	
	if(lName.value.length == 0){
		document.getElementById('lNameError').style.visibility = "visible";
	}else{
		document.getElementById('lNameError').style.visibility = "hidden";
	}
	
	if(telNumber.value.length == 0){
		document.getElementById('telNumError').style.visibility = "visible";
	}else{
		document.getElementById('telNumError').style.visibility = "hidden";
	}
	
	if(mobNumber.value.length == 0){
		document.getElementById('mobileNumError').style.visibility = "visible";
	}else{
		document.getElementById('mobileNumError').style.visibility = "hidden";
	}
	
	if(email.value.length == 0){
			document.getElementById('emailAddError').style.visibility = "visible";
	}else{
		document.getElementById('emailAddError').style.visibility = "hidden";
	}
}*/