
<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="worker.applications.form.label.reference" path="reference"/> 
	<acme:form-moment code="worker.applications.form.label.moment" path = "moment"/>
	<acme:form-textbox code="worker.applications.form.label.status" path="status"/>
	<acme:form-textarea code="worker.applications.form.label.statement" path="statement"/>
	<acme:form-textarea code="worker.applications.form.label.skills" path="skills"/>
	<acme:form-textarea code="worker.applications.form.label.qualification" path="qualifications"/>
	
	<acme:form-return code="administrator.announcement.form.button.return"/> 
	
</acme:form>