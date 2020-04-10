<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

	<div class="form-inline d-flex justify-content-center">
    	<div class="input-group currency-converter pr-3">
		  <input type="text" class="form-control">
		</div>
		<select class="custom-select currencies-select" id="inputGroupSelect01">
			<option selected>Please select a currency</option>
			<s:iterator value="ratestable">
				<option value="%{#status.index}"><s:property value="currencyName"/></option>
			</s:iterator>
		</select>
	</div>
	<div class="d-flex justify-content-center m-3">
		<button type="button" class="btn btn-outline-secondary"><i class="fa fa-exchange" aria-hidden="true"></i></button>
	</div>
	<div class="form-inline d-flex justify-content-center">
     			<div class="input-group currency-converter pr-3">
			  <input type="text" class="form-control" disabled>
		</div>
		<select class="custom-select currencies-select" id="inputGroupSelect01">
			<option selected>Please select a currency</option>
			<s:iterator value="ratestable">
				<option value="currencyCode"><s:property value="currencyName"/></option>
			</s:iterator>
  		</select>
	</div>