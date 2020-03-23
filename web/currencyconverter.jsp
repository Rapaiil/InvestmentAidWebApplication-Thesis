<%@ taglib prefix="s" uri="/struts-tags" %>
<body>
	<div class="form-inline d-flex justify-content-center">
		<div class="input-group currency-converter pr-3">
			<input type="text" class="form-control">
			<div class="input-group-append">
				<span class="input-group-text">0.00</span>
			</div>
		</div>
		<select class="custom-select currencies-select" id="inputGroupSelect01">
			<option selected>Please select a currency</option>
			<s:iterator value="ratestable">
				<option value="currencyCode"><s:property value="currencyName"/></option>
			</s:iterator>
  		</select>		
	</div>
	<div class="d-flex justify-content-center m-3">
		<button type="button" class="btn btn-outline-secondary"><i class="fa fa-exchange" aria-hidden="true"></i></button>
	</div>
	<div class="form-inline d-flex justify-content-center">
     	<div class="input-group currency-converter pr-3">
			<input type="text" class="form-control" disabled>
			<div class="input-group-append">
			    <span class="input-group-text">0.00</span>
			</div>
		</div>
		<select class="custom-select currencies-select" id="inputGroupSelect01">
			<option selected>Please select a currency</option>
			<s:iterator value="ratestable">
				<option value="currencyCode"><s:property value="currencyName"/></option>
			</s:iterator>
  		</select>
	</div>
</body>
