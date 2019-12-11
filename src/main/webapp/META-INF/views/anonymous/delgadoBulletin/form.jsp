
<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form readonly="false">
	<acme:form-textbox code="anonymous.bulletin.form.label.author" path="author"/> 
	<acme:form-textarea code="anonymous.bulletin.form.label.numWallet" path="numWallet"/>
	<acme:form-textarea code="anonymous.bulletin.form.label.initiative" path = "initiative"/>
	<acme:form-submit code="anonymous.bulletin.form.button.create" action="/anonymous/delgado-bulletin/create"/>
	<acme:form-return code="anonymous.bulletin.form.button.return"/> 
	
</acme:form>