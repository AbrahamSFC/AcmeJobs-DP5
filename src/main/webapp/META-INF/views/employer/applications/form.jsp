
<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form >
	<acme:form-textbox readonly="true" code="worker.applications.form.label.reference" path="reference"/> 
	<acme:form-moment readonly="true" code="worker.applications.form.label.moment" path = "moment"/>
	<acme:form-select code="worker.applications.form.label.status"  path="status">
	<acme:form-option code="worker.applications.form.label.status.rejected"  value="REJECTED" />
	<acme:form-option code="worker.applications.form.label.status.accepted"  value="ACCEPTED" />
	<acme:form-option code="worker.applications.form.label.status.pending"  value="PENDING" />
	</acme:form-select>
	<acme:form-textarea readonly="true" code="worker.applications.form.label.statement" path="statement"/>
	<acme:form-textarea readonly="true" code="worker.applications.form.label.skills" path="skills"/>
	<acme:form-textarea readonly="true" code="worker.applications.form.label.qualification" path="qualifications"/>
	<acme:form-textarea  code="worker.applications.form.label.rejectReason" path="rejectReason"/>
	
	<acme:form-return code="administrator.announcement.form.button.return"/> 
	 
	<acme:form-submit test="${command == 'show'}" code="employer.job.form.button.update" action="/employer/applications/update" />
	<acme:form-submit test="${command == 'update'}" code="employer.job.form.button.update" action="/employer/applications/update" />
	
</acme:form>