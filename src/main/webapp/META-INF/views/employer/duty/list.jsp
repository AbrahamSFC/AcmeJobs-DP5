<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="employer.duty.list.label.title" path="title" width="10%" />
	<acme:list-column code="employer.duty.list.label.description" path="description" width="10%"/>
	<acme:list-column code="employer.duty.list.label.percentage" path="percentage" width="80%"/>
	

 

</acme:list>
	<acme:form-return code="employer.duty.form.button.return" />
	
