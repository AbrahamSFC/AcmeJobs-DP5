/*
 * AuthenticatedConsumerCreateService.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.employer.applications;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Applications;
import acme.entities.roles.Employer;
import acme.features.worker.application.WorkerApplicationRepository;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class EmployerApplicationListMineService implements AbstractListService<Employer, Applications> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private WorkerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Applications> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Applications> request, final Applications entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "moment", "status");

	}

	@Override
	public Collection<Applications> findMany(final Request<Applications> request) {
		assert request != null;
		Collection<Applications> result;

		Principal principal;

		principal = request.getPrincipal();
		result = this.repository.findManyByEmployerId(principal.getActiveRoleId());
		return result;
	}

}
