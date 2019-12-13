<%--
- menu.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this  software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java" import="acme.framework.helpers.PrincipalHelper,acme.entities.roles.Provider,acme.entities.roles.Consumer"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:menu-bar code="master.menu.home">
	<acme:menu-left>
		<acme:menu-option code="master.menu.anonymous" access="isAnonymous()">
			<acme:menu-suboption code="master.menu.anonymous.abraham-favourite-link" action="https://www.youtube.com/channel/UCvosUrZ7hXpzAyobhfztg4w"/>
			<acme:menu-suboption code="master.menu.anonymous.antonio-favourite-link" action="http://trending-map.appspot.com/"/>
			<acme:menu-suboption code="master.menu.anonymous.chao-favourite-link" action="https://www.youtube.com/watch?v=gFfGLgMqQRI"/>
			<acme:menu-suboption code="master.menu.anonymous.martin-favourite-link" action="https://musescore.com"/>
			<acme:menu-suboption code="master.menu.anonymous.david-favourite-link" action="https://www.youtube.com/watch?v=vvH04rcXPck&feature=youtu.be"/>
			<acme:menu-suboption code="master.menu.anonymous.jose-favourite-link" action="https://www.binance.com/es"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.list-shouts" action = "/anonymous/shout/list"/>
			<acme:menu-suboption code="master.menu.anonymous.shout" action ="/anonymous/shout/create"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.anonymous.announcement-list" action="/anonymous/announcement/list"/>
			<acme:menu-suboption code="master.menu.anonymous.investorRecords-list" action="/anonymous/investor-records/list"/>
			<acme:menu-suboption code="master.menu.anonymous.records-list" action="/anonymous/records/list"/>
			<acme:menu-suboption code="master.menu.anonymous.topInvestorRecords-list" action="/anonymous/top-investor-records/list"/>
			<acme:menu-suboption code="master.menu.anonymous.topRecords-list" action="/anonymous/top-records/list"/>
			
			<acme:menu-option code="master.menu.anonymous.bulletins" access="isAnonymous()">
				<acme:menu-suboption code="master.menu.anonymous.fernandez-create" action="/anonymous/fernandez-bulletin/create"/>
				<acme:menu-suboption code="master.menu.anonymous.fernandez-list" action="/anonymous/fernandez-bulletin/list"/>
				<acme:menu-suboption code="master.menu.anonymous.guerrero-create" action="/anonymous/guerrero-bulletin/create"/>
				<acme:menu-suboption code="master.menu.anonymous.guerrero-list" action="/anonymous/guerrero-bulletin/list"/>
				<acme:menu-suboption code="master.menu.anonymous.garcia-create" action="/anonymous/garcia-bulletin/create"/>
				<acme:menu-suboption code="master.menu.anonymous.garcia-list" action="/anonymous/garcia-bulletin/list"/>
      	   <acme:menu-suboption code="master.menu.anonymous.hu-create" action="/anonymous/hu-bulletin/create"/>
				<acme:menu-suboption code="master.menu.anonymous.hu-list" action="/anonymous/hu-bulletin/list"/>
				<acme:menu-suboption code="master.menu.anonymous.soto-create" action="/anonymous/soto-bulletin/create"/>
				<acme:menu-suboption code="master.menu.anonymous.soto-list" action="/anonymous/soto-bulletin/list"/>
				<acme:menu-suboption code="master.menu.anonymous.delgado-create" action="/anonymous/delgado-bulletin/create"/>
				<acme:menu-suboption code="master.menu.anonymous.delgado-list" action="/anonymous/delgado-bulletin/list"/>
				
				
			</acme:menu-option>

		</acme:menu-option>
		
		<acme:menu-option code="master.menu.authenticated" access="hasRole('Authenticated')">
			<acme:menu-suboption code="master.menu.authenticated.announcement-list" action="/authenticated/announcement/list"/>
      		<acme:menu-suboption code="master.menu.authenticated.request2-list" action="/authenticated/request2/list"/>
			<acme:menu-suboption code="master.menu.authenticated.offer-list" action="/authenticated/offer/list"/>
      		<acme:menu-suboption code="master.menu.authenticated.investorRecords-list" action="/authenticated/investor-records/list"/>
      		<acme:menu-suboption code="master.menu.authenticated.challenge-list" action="/authenticated/challenge/list"/>
	  		<acme:menu-suboption code="master.menu.authenticated.records-list" action="/authenticated/records/list"/>
	  		<acme:menu-suboption code="master.menu.authenticated.job-list" action="/authenticated/job/list"/>
	  		<acme:menu-suboption code="master.menu.authenticated.list-message-thread" action="/authenticated/message-thread/list"/>
		
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.administrator" access="hasRole('Administrator')">
			<acme:menu-suboption code="master.menu.administrator.user-accounts" action="/administrator/user-account/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.shutdown" action="/master/shutdown"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.announcement-list" action="/administrator/announcement/list"/>
			<acme:menu-suboption code="master.menu.administrator.records-list" action="/administrator/records/list"/>
			<acme:menu-suboption code="master.menu.administrator.investorRecords-list" action="/administrator/investor-records/list"/>
			<acme:menu-suboption code="master.menu.administrator.challenge" action="/administrator/challenge/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.commercialBanner" action="/administrator/commercial-banner/list" />
			<acme:menu-suboption code="master.menu.administrator.noncommercialBanner" action="/administrator/non-commercial-banner/list" />
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.spam-list" action="/administrator/spam/list"/>
			<acme:menu-separator/>
			<acme:menu-suboption code="master.menu.administrator.dashboard" action="/administrator/dashboard/show"/>
			<acme:menu-suboption code="master.menu.administrator.chart" action="/administrator/chart/show"/>
			
		</acme:menu-option>

		<acme:menu-option code="master.menu.provider" access="hasRole('Provider')">
			<acme:menu-suboption code="master.menu.provider.request2" 
			action="/provider/request2/create"/>
		</acme:menu-option>

		<acme:menu-option code="master.menu.consumer" access="hasRole('Consumer')">
			<acme:menu-suboption code="master.menu.consumer.offer-create" action="/consumer/offer/create"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.employer" access="hasRole('Employer')">
			<acme:menu-suboption code="master.menu.employer.job-list" action="/employer/job/list-mine"/>

			<acme:menu-suboption code="master.menu.employer.applications-list" action="/employer/applications/list-applications"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.sponsor" access="hasRole('Sponsor')">
			<acme:menu-suboption code="master.menu.sponsor.commercial-banner-list" action="/sponsor/commercial-banner/list-mine"/>
			<acme:menu-suboption code="master.menu.sponsor.commercial-non-banner-list" action="/sponsor/non-commercial-banner/list-mine"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.worker" access="hasRole('Worker')">
			<acme:menu-suboption code="master.menu.worker.job-list" action="/worker/job/list-mine"/>
			
			<acme:menu-suboption code="master.menu.worker.applications-list" action="/worker/applications/list-mine"/>
		</acme:menu-option>
		
		<acme:menu-option code="master.menu.auditor" access="hasRole('Auditor')">
			<acme:menu-suboption code="master.menu.auditor.mineJobs-list" action="/auditor/job/LIST_MINE_JOBS"/>
			<acme:menu-suboption code="master.menu.auditor.nonMineJobs-list" action="/auditor/non-job/LIST_NON_MINE"/>
		
		</acme:menu-option>
		
	</acme:menu-left>

	<acme:menu-right>
		<acme:menu-option code="master.menu.sign-up" action="/anonymous/user-account/create" access="isAnonymous()"/>
		<acme:menu-option code="master.menu.sign-in" action="/master/sign-in" access="isAnonymous()"/>

		<acme:menu-option code="master.menu.user-account" access="isAuthenticated()">
			<acme:menu-suboption code="master.menu.user-account.general-data" action="/authenticated/user-account/update"/>
			<acme:menu-suboption code="master.menu.user-account.become-provider" action="/authenticated/provider/create" access="!hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.provider" action="/authenticated/provider/update" access="hasRole('Provider')"/>
			<acme:menu-suboption code="master.menu.user-account.become-consumer" action="/authenticated/consumer/create" access="!hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.consumer" action="/authenticated/consumer/update" access="hasRole('Consumer')"/>
			<acme:menu-suboption code="master.menu.user-account.become-employer" action="/authenticated/employer/create" access="!hasRole('Employer')"/>
			<acme:menu-suboption code="master.menu.user-account.employer" action="/authenticated/employer/update" access="hasRole('Employer')"/>
			<acme:menu-suboption code="master.menu.user-account.become-worker" action="/authenticated/worker/create" access="!hasRole('Worker')"/>
			<acme:menu-suboption code="master.menu.user-account.worker" action="/authenticated/worker/update" access="hasRole('Worker')"/>

			<acme:menu-suboption code="master.menu.user-account.become-sponsor" action="/authenticated/sponsor/create" access="!hasRole('Sponsor')"/>
			<acme:menu-suboption code="master.menu.user-account.sponsor" action="/authenticated/sponsor/update" access="hasRole('Sponsor')"/>
			
			<acme:menu-suboption code="master.menu.user-account.become-auditor" action="/authenticated/auditor/create" access="!hasRole('Auditor')"/>
			<acme:menu-suboption code="master.menu.user-account.auditor" action="/authenticated/auditor/update" access="hasRole('Auditor')"/>

		</acme:menu-option>

		

		<acme:menu-option code="master.menu.sign-out" action="/master/sign-out" access="isAuthenticated()"/>
	</acme:menu-right>
</acme:menu-bar>

