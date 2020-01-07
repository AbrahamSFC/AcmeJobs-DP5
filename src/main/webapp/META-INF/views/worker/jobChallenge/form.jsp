<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	
	<acme:form-textbox code="worker.job.form.label.description" path="description"/>
	<acme:form-textbox code="worker.job.form.label.moreInfo" path ="moreInfo"/>

	 	
	
	<acme:form-return code="worker.job.form.button.return"/>  
	
	
</acme:form> 