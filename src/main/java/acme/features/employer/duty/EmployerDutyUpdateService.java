
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
public class EmployerDutyUpdateService implements AbstractUpdateService<Employer, Duty> {

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
		res = this.repository.findOneById(id);
		return res;
	}

	@Override
	public void validate(final Request<Duty> request, final Duty entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		if (!errors.hasErrors("title")) {
			Spam spam = this.repository.findAllSpam().stream().collect(Collectors.toList()).get(0);
			Stream<String> spamWords = Stream.of(spam.getSpamWords().split(","));
			String title = (String) request.getModel().getAttribute("title");
			Double spamWordsTitle = (double) spamWords.filter(x -> title.toLowerCase().contains(x)).count();
			errors.state(request, spamWordsTitle < spam.getUmbral(), "title", "employer.duty.error.spam");
		}

		if (!errors.hasErrors("description")) {
			Spam spam = this.repository.findAllSpam().stream().collect(Collectors.toList()).get(0);
			Stream<String> spamWords = Stream.of(spam.getSpamWords().split(","));
			String title = (String) request.getModel().getAttribute("description");
			Double spamWordsTitle = (double) spamWords.filter(x -> title.toLowerCase().contains(x)).count();
			errors.state(request, spamWordsTitle < spam.getUmbral(), "description", "employer.duty.error.spam");
		}

		if (!errors.hasErrors("percentage")) {
			Spam spam = this.repository.findAllSpam().stream().collect(Collectors.toList()).get(0);
			Stream<String> spamWords = Stream.of(spam.getSpamWords().split(","));
			String title = (String) request.getModel().getAttribute("percentage");
			Double spamWordsTitle = (double) spamWords.filter(x -> title.toLowerCase().contains(x)).count();
			errors.state(request, spamWordsTitle < spam.getUmbral(), "percentage", "employer.duty.error.spam");
		}

		if (!errors.hasErrors("percentage")) {
			Boolean workloadTotal = entity.getPercentage() <= 100.0;
			errors.state(request, workloadTotal, "percentage", "employer.duty.error.maxWorkload");
		}

		if (!errors.hasErrors("percentage")) {
			Boolean workloadTotal = entity.getPercentage() > 0.0;
			errors.state(request, workloadTotal, "percentage", "employer.duty.error.minWorkload");
		}
	}

	@Override
	public void update(final Request<Duty> request, final Duty entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
