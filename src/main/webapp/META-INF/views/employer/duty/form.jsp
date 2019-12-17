<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="false">
	
	<acme:form-textbox code="employer.job.form.label.reference" path="title"/>
	<acme:form-textbox code="employer.job.form.label.title" path ="description"/>
	<acme:form-textbox code="employer.job.form.label.status" path ="percentage"/>
    <acme:form-return code="employer.job.form.button.return" />
    <acme:form-submit test="${command == 'show'}" code="employer.job.form.button.update" action="/employer/job/update" />
    <acme:form-submit test="${command == 'show'}" code="employer.job.form.button.delete" action="/employer/job/delete" />
    <acme:form-submit test="${command == 'create'}" code="employer.job.form.button.create" action="/employer/job/create" />
    <acme:form-submit test="${command == 'update'}" code="employer.job.form.button.update" action="/employer/job/update" />
    <acme:form-submit test="${command == 'delete'}" code="employer.job.form.button.delete" action="/employer/job/delete" />


	
	
 
	
	
</acme:form>