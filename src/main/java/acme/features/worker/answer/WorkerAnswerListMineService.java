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

package acme.features.worker.answer;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.ApplicationAnswer;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class WorkerAnswerListMineService implements AbstractListService<Worker, ApplicationAnswer> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private WorkerAnswerRepository repository;


	@Override
	public boolean authorise(final Request<ApplicationAnswer> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<ApplicationAnswer> request, final ApplicationAnswer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "XXX4");

	}

	@Override
	public Collection<ApplicationAnswer> findMany(final Request<ApplicationAnswer> request) {
		assert request != null;
		Collection<ApplicationAnswer> result;

		Principal principal;

		principal = request.getPrincipal();
		result = this.repository.findManyByWorkerId(principal.getActiveRoleId());
		return result;
	}

}
