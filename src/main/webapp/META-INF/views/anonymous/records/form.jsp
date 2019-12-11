<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form readonly="true">
	<acme:form-textbox code="anonymous.records.form.label.company" path="companyIncorporated"/> 
	<acme:form-textbox code="anonymous.records.form.label.sector" path="sector"/>
	<acme:form-textbox code="anonymous.records.form.label.CEO" path = "CEO"/>
	<acme:form-textarea code="anonymous.records.form.label.activities" path="activities"/>
	<acme:form-url code="anonymous.records.form.label.web" path="web"/>
	<acme:form-textbox code="anonymous.records.form.label.phone" path="phone"/>
	<acme:form-textbox code="anonymous.records.form.label.email" path="email"/>
	<acme:form-textbox code="anonymous.records.form.label.stars" path="stars"/>
	
	<acme:form-return code="anonymous.records.form.button.return"/> 
	
</acme:form>