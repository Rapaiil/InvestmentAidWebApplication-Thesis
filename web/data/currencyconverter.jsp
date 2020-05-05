<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="d-md-inline-flex">
	<div class="form-inline d-flex justify-content-center">
		<s:select class="custom-select currencies-select" id="inputGroupSelect01"
				  list="ratestable"
				  listKey="currencyCode"
				  listValue="currencyName"
				  onchange="convertAmount()"
				  headerKey="-1" headerValue="-- SELECT CURRENCY --" />
		
    	<div class="input-group currency-converter">
		  <input type="text" class="form-control" id="currencyconv_textbox1" onkeypress="isFloating(event)" onkeyup="convertAmount()">
		</div>
	</div>
	<div class="d-flex justify-content-center m-3">
		
		<i class="fa fa-arrow-right desktop-visible" aria-hidden="true"></i>
		<i class="fa fa-arrow-down mobile-tablet-visible" aria-hidden="true"></i>
	</div>
	<div class="form-inline d-flex justify-content-center">
		<select class="custom-select philippine-convert" id="inputGroupSelect02" style="width: 208px;">
			<option value="PHP" selected>PHILIPPINE PESO</option>
		</select>
     	<div class="input-group currency-converter">
			  <input type="text" class="form-control" id="currencyconv_textbox2" disabled>
		</div>
	</div>
</div>