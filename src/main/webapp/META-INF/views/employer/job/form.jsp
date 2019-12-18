<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%
	String idDesc = String.format("%d", request.getAttribute("descriptorId"));
	request.setAttribute("idDesc", idDesc);
	%>

<acme:form readonly="false">

	<c:choose>
 		<c:when test="${command == 'create'}">
 			<acme:form-textbox code="employer.job.form.label.reference" path="reference"/>
			<acme:form-textbox code="employer.job.form.label.title" path ="title"/>
			<acme:form-textbox code="employer.job.form.label.status" path ="status"/>
			<acme:form-moment code="employer.job.form.label.deadline" path="deadline"/>
			<acme:form-money code="employer.job.form.label.salary" path="salary"/>
			<acme:form-url code="employer.job.form.label.moreInfo" path="moreInfo"/>
			<acme:form-textarea code="employer.job.form.label.description" path="description"/>
			<acme:form-textbox code ="authenticated.job.form.label.descriptor.description" path ="descriptor.description"/>
    		<acme:form-submit test="${command == 'create'}" code="employer.job.form.button.create" action="/employer/job/create" />
  		</c:when>
  		<c:otherwise>
      		 
  			<c:choose>
 				<c:when test="${finalMode == false}">
 					<acme:form-textbox code="employer.job.form.label.reference" path="reference"/>
					<acme:form-textbox code="employer.job.form.label.title" path ="title"/>
					<acme:form-textbox code="employer.job.form.label.status" path ="status"/>
					<acme:form-moment code="employer.job.form.label.deadline" path="deadline"/>
					<acme:form-money code="employer.job.form.label.salary" path="salary"/>
					<acme:form-url code="employer.job.form.label.moreInfo" path="moreInfo"/>
					<acme:form-textarea code="employer.job.form.label.description" path="description"/>
					<acme:form-textbox code ="authenticated.job.form.label.descriptor.description" path ="descriptor.description"/>
    				<acme:form-checkbox code="employer.job.form.label.finalMode" path="finalMode"/> 
    				<acme:form-submit test="${command == 'show'}" code="employer.job.form.button.update" action="/employer/job/update" />
    				<acme:form-submit test="${command == 'show'}" code="employer.job.form.button.delete" action="/employer/job/delete" />
    				<acme:form-submit test="${command == 'create'}" code="employer.job.form.button.create" action="/employer/job/create" />
    				<acme:form-submit test="${command == 'update'}" code="employer.job.form.button.update" action="/employer/job/update" />
    				<acme:form-submit test="${command == 'delete'}" code="employer.job.form.button.delete" action="/employer/job/delete" />
  					<acme:form-submit method="get" code="employer.job.form.button.duty" action="/employer/duty/list?descriptor_id=${idDesc}"/>
					<acme:form-submit method ="get" code="employer.job.form.button.duty.create" action="/employer/duty/create?descriptor_id=${idDesc}"/>
  				</c:when>
  				<c:otherwise>
  				<c:choose>
 					<c:when test="${command == 'update'}">
  					<acme:form-textbox  code="employer.job.form.label.reference" path="reference"/>
					<acme:form-textbox  code="employer.job.form.label.title" path ="title"/>
					<acme:form-textbox  code="employer.job.form.label.status" path ="status"/>
					<acme:form-moment  code="employer.job.form.label.deadline" path="deadline"/>
					<acme:form-money  code="employer.job.form.label.salary" path="salary"/>
					<acme:form-url  code="employer.job.form.label.moreInfo" path="moreInfo"/>
					<acme:form-textarea  code="employer.job.form.label.description" path="description"/>
					<acme:form-textbox code ="authenticated.job.form.label.descriptor.description" path ="descriptor.description"/>
    				<acme:form-checkbox code="employer.job.form.label.finalMode" path="finalMode"/> 
    				<acme:form-submit test="${command == 'show'}" code="employer.job.form.button.delete" action="/employer/job/delete" />
    				<acme:form-submit test="${command == 'create'}" code="employer.job.form.button.create" action="/employer/job/create" />
    				<acme:form-submit test="${command == 'delete'}" code="employer.job.form.button.delete" action="/employer/job/delete" />
					<acme:form-submit test="${command == 'update'}" code="employer.job.form.button.update" action="/employer/job/update" />
					  					
  					</c:when>
  					<c:otherwise>
 					<acme:form-textbox readonly="true" code="employer.job.form.label.reference" path="reference"/>
					<acme:form-textbox readonly="true" code="employer.job.form.label.title" path ="title"/>
					<acme:form-textbox readonly="true" code="employer.job.form.label.status" path ="status"/>
					<acme:form-moment readonly="true" code="employer.job.form.label.deadline" path="deadline"/>
					<acme:form-money readonly="true" code="employer.job.form.label.salary" path="salary"/>
					<acme:form-url readonly="true" code="employer.job.form.label.moreInfo" path="moreInfo"/>
					<acme:form-textarea readonly="true" code="employer.job.form.label.description" path="description"/>
					<acme:form-textbox readonly="true" code ="authenticated.job.form.label.descriptor.description" path ="descriptor.description"/>
    				<acme:form-submit test="${command == 'show'}" code="employer.job.form.button.delete" action="/employer/job/delete" />
    				<acme:form-submit test="${command == 'create'}" code="employer.job.form.button.create" action="/employer/job/create" />
    				<acme:form-submit test="${command == 'delete'}" code="employer.job.form.button.delete" action="/employer/job/delete" />
  					
  					</c:otherwise>
  					</c:choose>
  				</c:otherwise>
  			</c:choose>
  		</c:otherwise>
  	</c:choose>
  	
  	
  	
  	
  	
  	
    <acme:form-return code="employer.job.form.button.return" />
    	
</acme:form>