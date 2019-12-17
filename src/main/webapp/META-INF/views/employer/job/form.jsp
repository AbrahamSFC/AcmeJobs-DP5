<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="false">
	
	<acme:form-textbox code="employer.job.form.label.reference" path="reference"/>
	<acme:form-textbox code="employer.job.form.label.title" path ="title"/>
	<acme:form-textbox code="employer.job.form.label.status" path ="status"/>
	<acme:form-moment code="employer.job.form.label.deadline" path="deadline"/>
	<acme:form-money code="employer.job.form.label.salary" path="salary"/>
	<acme:form-url code="employer.job.form.label.moreInfo" path="moreInfo"/>
	<acme:form-textarea code="employer.job.form.label.description" path="description"/>
		<acme:form-textbox code ="authenticated.job.form.label.descriptor.description" path ="descriptor.description"/>

 <jstl:forEach var="duty" items="${duties}">
   <acme:form-textbox code="employer.job.form.label.descriptor.duties.title" path ="duty.title"/><br/>
   <acme:form-textbox code="employer.job.form.label.descriptor.duties.description" path ="duty.description"/><br/>
   <acme:form-textbox code="employer.job.form.label.descriptor.duties.percentage" path ="duty.percentage"/><br/>
  </jstl:forEach>
  <jstl:if test="${not empty descriptor}">
  <acme:form-submit method="get" code="employer.job.form.button.duty" action="/employer/duty/list?descriptor_id=${descriptorId }"/>
		
	</jstl:if>

    <acme:form-return code="employer.job.form.button.return" />
    <acme:form-submit test="${command == 'show'}" code="employer.job.form.button.update" action="/employer/job/update" />
    <acme:form-submit test="${command == 'show'}" code="employer.job.form.button.delete" action="/employer/job/delete" />
    <acme:form-submit test="${command == 'create'}" code="employer.job.form.button.create" action="/employer/job/create" />
    <acme:form-submit test="${command == 'update'}" code="employer.job.form.button.update" action="/employer/job/update" />
    <acme:form-submit test="${command == 'delete'}" code="employer.job.form.button.delete" action="/employer/job/delete" />


	
	
 
	
	
</acme:form>