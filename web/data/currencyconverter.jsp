<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<body>
	<select class="custom-select currencies-select" id="inputGroupSelect01">
		<option selected>Please select a currency</option>
		<s:iterator value="ratestable">
			<option value="currencyCode"><s:property value="currencyName"/></option>
		</s:iterator>
	</select>
</body>
