<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	
	<acme:form-textbox code="employer.job.form.label.reference" path="reference"/>
	<acme:form-textbox code="employer.job.form.label.title" path ="title"/>
	<acme:form-textbox code="employer.job.form.label.status" path ="status"/>
	<acme:form-moment code="employer.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="employer.job.form.label.salary" path="salary"/>
	<acme:form-url code="employer.job.form.label.moreInfo" path="moreInfo"/>
	<acme:form-textarea code="employer.job.form.label.description" path="description"/>
		<acme:form-textbox code ="authenticated.job.form.label.descriptor.description" path ="descriptor.description"/>

	<jstl:forEach var="duty" items="${duties}">
			<acme:form-panel code="employer.job.form.panel.descriptor.duties">
				<acme:print value="${duty.title}"/> <br/>
				<acme:print value="${duty.description}"/><br/>
				<acme:print value="${duty.percentage}"/> % <br/>
				<br/>
			</acme:form-panel>
		</jstl:forEach>
	
	
 
	<acme:form-return code="employer.offer.form.button.return"/>  
	
</acme:form>