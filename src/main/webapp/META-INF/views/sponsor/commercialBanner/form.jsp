<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	
	<acme:form-textbox code="sponsor.commercialBanner.form.label.picture" path="picture"/>
	<acme:form-textbox code="sponsor.commercialBanner.form.label.slogan" path ="slogan"/>
	<acme:form-moment code="sponsor.commercialBanner.form.label.targetURL" path="targetURL"/>
	<acme:form-money code="sponsor.commercialBanner.form.label.creditCard" path="creditCard"/>
	
 
	<acme:form-return code="sponsor.commercialBanner.form.button.return"/>  
	
</acme:form>