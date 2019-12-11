
<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	
	<acme:form-textbox code="consumer.offer.form.label.title" path="title"/>
	<acme:form-moment code="consumer.offer.form.label.deadline" path ="deadline"/>
	<acme:form-textarea code="consumer.offer.form.label.text" path="text"/>
	<acme:form-money code="consumer.offer.form.label.minMoney" path="minMoney"/>
	<acme:form-money code="consumer.offer.form.label.maxMoney" path="maxMoney"/>
	<acme:form-textbox code="consumer.offer.form.label.ticker" path="ticker" placeholder="Oabcd-12345"/>
	
	<acme:form-checkbox code="consumer.offer.form.label.confirm"  path="confirm"/>
	
	<acme:form-submit test="${command=='create'}" code="consumer.offer.form.button.create"
			 action="/consumer/offer/create" />
 
	<acme:form-return code="consumer.offer.form.button.return"/>  
	
</acme:form>