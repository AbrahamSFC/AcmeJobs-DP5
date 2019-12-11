<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.records.list.label.company" path="companyIncorporated" width="20%"/>
	<acme:list-column code="authenticated.records.list.label.sector" path="sector" width="20%" />
	<acme:list-column code="authenticated.records.list.label.web" path="web" width="20%" />
	
	
	
</acme:list>