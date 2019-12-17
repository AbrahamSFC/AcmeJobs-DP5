
package acme.features.employer.duty;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Duty;
import acme.entities.roles.Employer;
import acme.entities.spam.Spam;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerUpdateService implements AbstractUpdateService<Employer, Duty> {

	@Autowired
	EmployerDutyRepository repository;


	@Override
	public boolean authorise(final Request<Duty> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Duty> request, final Duty entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "tilte", "description", "percentage");

	}

	@Override
	public Duty findOne(final Request<Duty> request) {
		assert request != null;

		Duty res;
		int id;

		id = request.getModel().getInteger("id");
		res = this.repository.findOneDutyById(id);
		return res;
	}

	@Override
	public void validate(final Request<Duty> request, final Duty entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		Spam spam = this.repository.findAllSpam().stream().collect(Collectors.toList()).get(0);
		Stream<String> spamWords = Stream.of(spam.getSpamWords().split(","));

		String title = (String) request.getModel().getAttribute("title");
		Double spamWordsTitle = (double) spamWords.filter(x -> title.contains(x)).count();
		errors.state(request, spamWordsTitle < spam.getUmbral(), "title", "employer.Duty.titleSpam");
		//
		//		if (request.getModel().getAttribute("status").equals("PUBLISHED")) {
		//
		//			String descriptor = (String) request.getModel().getAttribute("descriptor.description");
		//			Collection<Duty> duties = (Collection<Duty>) request.getModel().getAttribute("descriptor.duties");
		//			Double dutiesPercentage = duties.stream().mapToDouble(x -> x.getPercentage()).sum();
		//			errors.state(request, dutiesPercentage == 100, "status", "employer.Duty.dutiesNot100");
		//
		//		}
		Boolean status = request.getModel().getAttribute("status").equals("PUBLISHED") || request.getModel().getAttribute("status").equals("DRAFT");
		errors.state(request, status, "status", "employer.Duty.statusIncorrect");

	}

	@Override
	public void update(final Request<Duty> request, final Duty entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
