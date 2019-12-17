<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="employer.job.list.label.reference" path="title" width="10%" />
	<acme:list-column code="employer.job.list.label.deadline" path="description" width="10%"/>
	<acme:list-column code="employer.job.list.label.title" path="percentage" width="80%"/>
	
	


</acme:list>

	<acme:form>
	<acme:form-return
		code="administrator.records.list.button.create"
	 	action="/employer/job/create"/>
</acme:form>