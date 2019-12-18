<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>

	<jstl:if test="${command == 'create' && hasRequest && !isAccepted}">
		<acme:message code="authenticated.auditor.form.waiting"/><br/><br/>
		
	</jstl:if>
	
	<jstl:if test="${command == 'create' && !hasRequest}">
		<acme:message code="authenticated.auditor.form.need-approval"/><br/><br/>
		<acme:form-submit code="authenticated.auditor.form.button.create-request" action="/authenticated/auditor-request/create"/>
		
	</jstl:if>
	
	<jstl:if test="${command == 'create' && hasRequest && isAccepted}">
		<acme:message code="authenticated.auditor.form.accepted"/><br/><br/>
		<acme:form-textbox code="authenticated.auditor.form.label.firm" path="firm"/>
		<acme:form-textbox code="authenticated.auditor.form.label.responsabilityStatement" path="responsabilityStatement"/>
		<acme:form-submit  code="authenticated.auditor.form.button.create" action="/authenticated/auditor/create"/>
		
	</jstl:if>
	
	<jstl:if test="${command == 'update'}">
		<acme:form-textbox code="authenticated.auditor.form.label.firm" path="firm"/>
		<acme:form-textbox code="authenticated.auditor.form.label.responsabilityStatement" path="responsabilityStatement"/>
	</jstl:if>
	
	<acme:form-submit test="${command == 'update'}" code="authenticated.auditor.form.button.update" action="/authenticated/auditor/update"/>
	<acme:form-return code="authenticated.auditor.form.button.return"/>
</acme:form>