<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	
	<acme:form-textbox code="sponsor.nonCommercialBanner.form.label.picture" path="picture"/>
	<acme:form-textbox code="sponsor.nonCommercialBanner.form.label.slogan" path ="slogan"/>
	<acme:form-moment code="sponsor.nonCommercialBanner.form.label.targetURL" path="targetURL"/>
	<acme:form-money code="sponsor.nonCommercialBanner.form.label.jingle" path="jingle"/>
	
 
	<acme:form-return code="sponsor.nonCommercialBanner.form.button.return"/>  
	
</acme:form>