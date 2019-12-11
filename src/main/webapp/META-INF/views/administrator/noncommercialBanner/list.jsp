<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.noncommercialBanner.list.label.picture" path="picture" width="40%"/> 
</acme:list>


<acme:form>
	<acme:form-return code="administrator.noncommercialBanner.form.button.create" action="/administrator/non-commercial-banner/create"/>
</acme:form>

