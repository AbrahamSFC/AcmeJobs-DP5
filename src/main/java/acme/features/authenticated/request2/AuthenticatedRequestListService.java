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

package acme.features.authenticated.request2;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.requests2.Request2;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedRequestListService implements AbstractListService<Authenticated, Request2> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedRequestRepository repository;


	@Override
	public boolean authorise(final Request<Request2> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Request2> request, final Request2 entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "deadline", "reward");

	}

	@Override
	public Collection<Request2> findMany(final Request<Request2> request) {
		assert request != null;
		Collection<Request2> result;
		result = this.repository.findManyAll();
		return result;
	}

}
