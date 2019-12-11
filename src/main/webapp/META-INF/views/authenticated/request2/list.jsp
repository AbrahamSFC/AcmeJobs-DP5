<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:list>
	<acme:list-column code="authenticated.request2.list.label.title" path="title" width="40%" />
	<acme:list-column code="authenticated.request2.list.label.moment" path="moment" width="20%"/>
	<acme:list-column code="authenticated.request2.list.label.deadline" path="deadline" width="40%" />
	<acme:list-column code="authenticated.request2.list.label.reward" path="reward" width="40%" />

</acme:list>