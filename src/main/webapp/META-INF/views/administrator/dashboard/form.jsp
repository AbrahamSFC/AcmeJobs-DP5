<%@page language="java" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form readonly="true">
	<acme:form-double code="administrator.dashboard.form.label.jobs" path="ratioJobsWithJobChallenges"/>
	<acme:form-double code="administrator.dashboard.form.label.jobsChallenge" path="ratioJobChallengesWithApplicationAnswer"/>
	<acme:form-double code="administrator.dashboard.form.label.Applications" path="ratioApplicationsWithApplicationsAnswerWithPassword"/>	
	<acme:form-double code="administrator.dashboard.form.label.avgJobsEmployer" path="avgJobsEmployer"/>
	<acme:form-double code="administrator.dashboard.form.label.avgApplicationsEmployer" path="avgApplicationsEmployer"/>
	<acme:form-double code="administrator.dashboard.form.label.avgApplicationsWorker" path="avgApplicationsWorker"/>

</acme:form>
	 
	