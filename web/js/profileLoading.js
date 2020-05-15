var jsonrecord;

$(document).ready(function(){
	loadAccountDetails();
});

function loadAccountDetails() {
	$.ajax({
		type: "post",
		url: "retrieveaccount",
		success: function(response) {
			var jsonstr = JSON.stringify(response);
			jsonrecord = JSON.parse(jsonstr);
			
			$('#fn').val(jsonrecord.account.user_firstName);
			$('#ln').val(jsonrecord.account.user_lastName);
			$('#bd').val(jsonrecord.account.user_birthday);
			$('#tn').val(jsonrecord.account.user_telno);
			$('#cn').val(jsonrecord.account.user_cellno);
			$('#occ').val(jsonrecord.account.user_occupation);
			$('#com').val(jsonrecord.account.user_company);
			$('#ea').val(jsonrecord.account.user_email);
		}
	});
}