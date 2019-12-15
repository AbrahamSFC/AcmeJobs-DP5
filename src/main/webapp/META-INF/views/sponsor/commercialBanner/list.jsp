<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="sponsor.commercialBanner.form.label.picture" path="picture" width="10%" />
	<acme:list-column code="sponsor.commercialBanner.form.label.slogan" path="slogan" width="10%"/>
</acme:list>

<acme:form>
	<acme:form-return code="sponsor.commercialBanner.form.button.create" action="/sponsor/commercial-banner/create"/>
</acme:form>
