
package acme.features.administrator.records;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.records.Records;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorRecordsCreateService implements AbstractCreateService<Administrator, Records> {

	@Autowired
	AdministratorRecordsRepository repository;


	@Override
	public boolean authorise(final Request<Records> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Records> request, final Records entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Records> request, final Records entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "company", "sector", "CEO", "activities", "web", "phone", "email", "stars", "incorporated");

	}

	@Override
	public Records instantiate(final Request<Records> request) {
		Records res;
		res = new Records();
		return res;
	}

	@Override
	public void validate(final Request<Records> request, final Records entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<Records> request, final Records entity) {
		this.repository.save(entity);

	}

}
