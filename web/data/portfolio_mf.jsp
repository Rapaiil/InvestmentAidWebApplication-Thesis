<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="%{mfList==null}">
	<tr>
		<td></td>
	</tr>
</s:if>
<s:else>
	<s:iterator value="mfList">
		<tr>
		    <td><s:property value="fundName"/></td>
		    <td><s:property value="fundClassification"/></td>
		    <td><s:property value="fundAmount"/></td>
		    <td><s:property value="fundNav"/></td>
		    <td><s:property value="fundNumOfUnitsShares"/></td>
		    <td><s:property value="fundPrice"/></td>
		    <s:set var="pct" value="pctGainLoss" />
		    <td><s:property value="pctGainLoss"/>% &nbsp; <s:if test="%{#pct>0}"><i class="fas fa-caret-up"></i></s:if> <s:else><i class="fas fa-caret-down"></i></s:else></td>
		</tr>
	</s:iterator>
</s:else>

