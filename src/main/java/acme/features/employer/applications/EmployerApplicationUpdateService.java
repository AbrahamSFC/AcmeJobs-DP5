
package acme.features.employer.applications;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Applications;
import acme.entities.roles.Employer;
import acme.entities.spam.Spam;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerApplicationUpdateService implements AbstractUpdateService<Employer, Applications> {

	@Autowired
	EmployerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Applications> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Applications> request, final Applications entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment", "reference", "statement", "skills", "qualifications");
	}

	@Override
	public void unbind(final Request<Applications> request, final Applications entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "moment", "status", "statement", "skills", "qualifications");

	}

	@Override
	public Applications findOne(final Request<Applications> request) {
		assert request != null;

		Applications res;
		int id;

		id = request.getModel().getInteger("id");
		res = this.repository.findOneApplicationById(id);
		return res;
	}

	@Override
	public void validate(final Request<Applications> request, final Applications entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		Spam spam = this.repository.findAllSpam().stream().collect(Collectors.toList()).get(0);
		Stream<String> spamWords = Stream.of(spam.getSpamWords().split(","));

		String statement = (String) request.getModel().getAttribute("statement");
		Double spamWordsTitle = (double) spamWords.filter(x -> statement.contains(x)).count();
		errors.state(request, spamWordsTitle < spam.getUmbral(), "statement", "employer.job.statementSpam");

		Boolean rejected = true;
		if (request.getModel().getAttribute("status").equals("REJECTED") && (request.getModel().getAttribute("rejectReason") == null || request.getModel().getAttribute("rejectReason") == "")) {
			rejected = false;

		}

		errors.state(request, rejected, "status", "employer.applications.invalid-rejected-reason");

	}

	@Override
	public void update(final Request<Applications> request, final Applications entity) {
		assert request != null;
		assert entity != null;

		if (request.getModel().getAttribute("status").equals("ACCEPTED") || request.getModel().getAttribute("status").equals("REJECTED")) {
			entity.setFinalMode(true);
		}

		this.repository.save(entity);

	}

}
