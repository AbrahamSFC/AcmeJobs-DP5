
<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>
	<acme:print value="${user}"/>
	<acme:message code="administrator.auditor-request.text"/><br/><br/>
	<acme:form-submit test="${command == 'show'}" code="administrator.auditor-request.form.button.accept" action="/administrator/auditor-request/accept"/>
	<acme:form-return code="administrator.auditor-request.form.button.return"/>
</acme:form>