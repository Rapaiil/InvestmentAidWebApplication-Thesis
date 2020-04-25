$("og").inputFilter(function(value) {
	/*var num = $(this).val();
	var x = $("#inputGroupSelect01 option:selected").text();
	$("tg").val(num);*/
	return /^-?\d*[.,]?\d{0,2}$/.test(value);
});

(function($) {
	  $.fn.inputFilter = function(inputFilter) {
	    return this.on("input keydown keyup mousedown mouseup select contextmenu drop", function() {
	      if (inputFilter(this.value)) {
	        this.oldValue = this.value;
	        this.oldSelectionStart = this.selectionStart;
	        this.oldSelectionEnd = this.selectionEnd;
	      } else if (this.hasOwnProperty("oldValue")) {
	        this.value = this.oldValue;
	        this.setSelectionRange(this.oldSelectionStart, this.oldSelectionEnd);
	      } else {
	        this.value = "";
	      }
	    });
	  };
	}(jQuery));
