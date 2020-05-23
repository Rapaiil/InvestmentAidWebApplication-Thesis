function startTimer(duration, display) {
    var timer = duration, minutes, seconds;
    setInterval(function () {
        minutes = parseInt(timer / 60, 10)
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) {
            document.getElementById("time").innerHTML = "<s:form action='resendotp' method='post'><s:submit value='RESEND OTP'/></s:form>";
        }
    }, 1000);
}

window.onload = function () {
    var minuteCountdown = 60 * 1,
        display = document.querySelector('#time');
    startTimer(minuteCountdown, display);
};