
<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form readonly="true">
	<acme:form-textbox code="authenticated.request2.form.label.title" path="title"/>
	<acme:form-textbox code="authenticated.request2.form.label.ticker" path="ticker"/> 
	<acme:form-moment code="authenticated.request2.form.label.moment" path="moment"/>
	<acme:form-moment code="authenticated.request2.form.label.deadline" path = "deadline"/>
	<acme:form-textarea code="authenticated.request2.form.label.text" path="text"/>
	<acme:form-money code="authenticated.request2.form.label.reward" path="reward"/>
	<acme:form-return code="authenticated.request2.form.button.return"/> 
	
</acme:form>