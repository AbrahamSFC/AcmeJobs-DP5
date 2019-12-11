
<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form readonly="true">
	
	<acme:form-textbox code="authenticated.investorRecords.form.label.name" path="name"/> 
	<acme:form-textbox code="authenticated.investorRecords.form.label.sector" path="sector"/>
	<acme:form-money code="authenticated.investorRecords.form.label.investingStatements" path = "investingStatements"/>
	<acme:form-double code="authenticated.investorRecords.form.label.ratings" path="ratings"/>
	
	<acme:form-return code="authenticated.investorRecords.form.button.return"/> 
</acme:form>