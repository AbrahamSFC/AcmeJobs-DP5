<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.commercialBanner.list.label.picture" path="picture" width="40%"/> 
</acme:list>


<acme:form>
	<acme:form-return code="administrator.commercialBanner.form.button.create" action="/administrator/commercial-banner/create"/>
</acme:form>

