<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<s:if test="rpModel==null">
	<h5 class="text-center">Know your risk profile below!</h5>
</s:if>
<s:else>
	<s:push value="rpModel">
		<h5>You are a/an <b><s:property value="riskProfileResult" /></b> Investor</h5>
	    <br/>
	    <p><b>Investment Objective: <s:property value="riskProfileObjectives" /></b></p>
	    <p><b>Investment Horizon: <s:property value="riskProfileHorizon" /></b></p>
	    <p><b>Characteristics: <s:property value="riskProfileDesc" /></b></p>
	</s:push>
</s:else>