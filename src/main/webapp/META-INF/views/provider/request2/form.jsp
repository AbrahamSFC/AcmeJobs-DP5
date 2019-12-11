
<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>
	
	<acme:form-textbox code="provider.request2.form.label.title" path="title"/>
	<acme:form-textbox code="provider.request2.form.label.ticker" path="ticker" placeholder="Rabcd-12345"/> 
	<acme:form-moment code="provider.request2.form.label.deadline" path ="deadline"/>
	<acme:form-textarea code="provider.request2.form.label.text" path="text"/>
	<acme:form-money code="provider.request2.form.label.reward" path="reward"/>
	<acme:form-checkbox code="provider.request2.form.label.confirm"  path="confirm"/>
	<acme:form-submit test="${command == 'create' }"
	 code="provider.request2.form.button.create"
	 action="/provider/request2/create" />
	<acme:form-return code="provider.request2.form.button.return"/> 
	
</acme:form>