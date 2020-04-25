<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

	<div class="form-inline d-flex justify-content-center">
    	<div class="input-group currency-converter pr-3">
		  <input type="text" class="form-control" id="og">
		</div>
		<s:select class="custom-select currencies-select" id="inputGroupSelect01"
				  list="ratestable"
				  listKey="currencyCode"
				  listValue="currencyName"
				  headerKey="-1" headerValue="--Select Currency--" />
	</div>
	<div class="d-flex justify-content-center m-3">
		<!-- <button type="button" class="btn btn-outline-secondary"><i class="fa fa-exchange" aria-hidden="true"></i></button> -->
	</div>
	<div class="form-inline d-flex justify-content-center">
     	<div class="input-group currency-converter pr-3">
			  <input type="text" class="form-control" id="tg" disabled>
		</div>
		<select class="custom-select philippine-convert" id="inputGroupSelect02" style="width: 208px;">
			<option value="PHP" selected>Philippine Peso</option>
		</select>
	</div>