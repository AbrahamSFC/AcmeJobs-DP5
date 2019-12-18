<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	
	<acme:form-textbox code="worker.job.form.label.reference" path="reference"/>
	<acme:form-textbox code="worker.job.form.label.title" path ="title"/>
	<acme:form-textbox code="worker.job.form.label.status" path ="status"/>
	<acme:form-moment readonly="true" code="worker.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="worker.job.form.label.salary" path="salary"/>
	<acme:form-url code="worker.job.form.label.moreInfo" path="moreInfo"/>
	<acme:form-textarea code="worker.job.form.label.description" path="description"/>
	<acme:form-textbox code ="worker.job.form.label.descriptor.description" path ="descriptor.description"/>

	
	<jstl:forEach var="duty" items="${duties}">
			<acme:form-panel code="worker.job.form.panel.descriptor.duties">
				<acme:print value="${duty.title}"/> <br/>
				<acme:print value="${duty.description}"/><br/>
				<acme:print value="${duty.percentage}"/> % <br/>
				<br/>
			</acme:form-panel>
		</jstl:forEach>

	
 	
	
	<acme:form-return code="worker.job.form.button.return"/>  
	<acme:form-submit code="worker.job.form.button.create" method="get" 
	action="/worker/applications/create?id=${id}" />
	
</acme:form>