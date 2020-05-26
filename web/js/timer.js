function startTimer(duration, display) {
    var timer = duration, minutes, seconds;
    setInterval(function () {
        minutes = parseInt(timer / 60, 10)
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer == 0) {
        	document.getElementById("time").style.display = "none";
        	$("#resendotp").append("<s:submit class='btn btn-link btnResend' onclick='resendOTP()' value='RESEND OTP' />");
        }
    }, 1000);
}

function resendOTP() {
	$.ajax({
		type: "post",
		url: "resendotp",
		success: function(response) {
			console.log("OTP re-sent!");
		}
	});
}

window.onload = function () {
    var minuteCountdown = 60 * 1,
        display = document.querySelector('#time');
    startTimer(minuteCountdown, display);
};