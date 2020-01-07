
package acme.features.worker.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.ApplicationAnswer;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerAnswerShowService implements AbstractShowService<Worker, ApplicationAnswer> {

	@Autowired
	WorkerAnswerRepository repository;


	@Override
	public boolean authorise(final Request<ApplicationAnswer> request) {
		assert request != null;

		boolean result;
		int applicationId;
		ApplicationAnswer application;
		Worker worker;
		Principal principal;

		applicationId = request.getModel().getInteger("id");
		application = this.repository.findOneById(applicationId);
		worker = application.getApplication().getWorker();
		principal = request.getPrincipal();

		result = worker.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<ApplicationAnswer> request, final ApplicationAnswer entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "XXX4");

	}

	@Override
	public ApplicationAnswer findOne(final Request<ApplicationAnswer> request) {
		assert request != null;

		ApplicationAnswer result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
