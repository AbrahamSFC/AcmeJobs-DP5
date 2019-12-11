<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>



	
	<acme:form-textbox  code="administrator.records.form.label.company" path="company"/>
	
	<acme:form-textbox code="administrator.records.form.label.sector" path="sector"/>
	<acme:form-textbox code="administrator.records.form.label.CEO" path = "CEO"/>
	<acme:form-textarea code="administrator.records.form.label.activities" path="activities"/>
	<acme:form-url code="administrator.records.form.label.web" path="web"/>
	<acme:form-checkbox code="administrator.records.form.label.incorporated" path="incorporated"/>
	<acme:form-textbox code="administrator.records.form.label.phone" path="phone"/>
	<acme:form-textbox code="administrator.records.form.label.email" path="email"/>
	<acme:form-textbox code="administrator.records.form.label.stars" path="stars"/>
	
	<acme:form-submit test ="${command == 'show'}"
		code="administrator.records.form.button.update"
	 	action="/administrator/records/update"/>
	 	
	<acme:form-submit test ="${command == 'show'}"
		code="administrator.records.form.button.delete"
	 	action="/administrator/records/delete"/>
	<acme:form-submit test ="${command == 'create'}"
		code="administrator.records.form.button.create"	
	 	action="/administrator/records/create"  	/>
	 
	<acme:form-submit test ="${command == 'update'}"
		code="administrator.records.form.button.update"
	 	action="/administrator/records/update"/>
	<acme:form-submit test ="${command == 'delete'}"
		code="administrator.records.form.button.delete"
	 	action="/administrator/records/delete"/>
	
	
	
	
	<acme:form-return code="anonymous.records.form.button.return"/> 
	
</acme:form>