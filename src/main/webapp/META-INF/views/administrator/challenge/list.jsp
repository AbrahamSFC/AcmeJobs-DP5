<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="administrator.challenge.list.label.title" path="title" width="20%" />
	<acme:list-column code="administrator.challenge.list.label.description" path="description" width="40%"/>
</acme:list>
<acme:form>
	<acme:form-return code="administrator.challenge.list.button.create" action="/administrator/challenge/create"/>
</acme:form>