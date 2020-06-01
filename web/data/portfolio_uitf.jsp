<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<s:if test="%{uitfList==null}">
	<tr>
		<td></td>
	</tr>
</s:if>
<s:else>
	<s:iterator value="uitfList">
		<tr>
		    <td><s:property value="fundName"/></td>
		    <td><s:property value="fundClassification"/></td>
		    <td><s:property value="fundAmount"/></td>
		    <td><s:property value="fundNav"/></td>
		    <td><s:property value="fundNumOfUnitsShares"/></td>
		    <td><s:property value="fundPrice"/></td>
		    <s:set var="pct" value="pctGainLoss" />
			<td><s:property value="pctGainLoss"/>% &nbsp; <s:if test="%{#pct>0}"><i class="fas fa-caret-up"></i></s:if> <s:else><i class="fas fa-caret-down"></i></s:else></td>
			<s:set var="fundid" value="fundId" />
			<td><a href="<s:url action="promptedit">
				<s:param name="fundId" value="fundId" />
				<s:param name="fundName" value="fundName" />
				</s:url>">Edit</a>&nbsp;
				<a href="<s:url action="deletefund">
				<s:param name="fundId" value="fundId" /></s:url>">Delete</a></td>
		</tr>
	</s:iterator>
	
	<!-- DELETE MODAL -->    
	    <!-- Modal -->
	    <div class="modal fade" id="deleteFundModal" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
	        <div class="modal-dialog" role="document">
	            <div class="modal-content">
	                <div class="modal-header">
	                    <h5 class="modal-title">Delete Investment</h5>
	                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                            <span aria-hidden="true">&times;</span>
	                        </button>
	                </div>
	                <div class="modal-body">
	                    <p>Would you like to delete [Fund]?</p>
	                </div>
	                <div class="modal-footer">
	                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
	                    <button type="button" class="btn btn-primary btn-confirm">Confirm</button>
	                </div>
	            </div>
	        </div>
	    </div>
</s:else>
