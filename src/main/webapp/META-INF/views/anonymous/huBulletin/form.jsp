
<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form readonly="false">
	<acme:form-textbox code="anonymous.bulletin.form.label.author" path="author"/> 
	<acme:form-textarea code="anonymous.bulletin.form.label.description" path="description"/>
	<acme:form-textarea code="anonymous.bulletin.form.label.grade" path = "grade"/>
	<acme:form-submit code="anonymous.bulletin.form.button.create" action="/anonymous/hu-bulletin/create"/>
	<acme:form-return code="anonymous.bulletin.form.button.return"/> 
	
</acme:form>