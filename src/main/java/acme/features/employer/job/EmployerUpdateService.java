
package acme.features.employer.job;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Descriptor;
import acme.entities.jobs.Duty;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.entities.spam.Spam;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerUpdateService implements AbstractUpdateService<Employer, Job> {

	@Autowired
	EmployerJobRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "status", "title", "deadline", "salary", "description", "moreInfo");

	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;

		Job res;
		int id;

		id = request.getModel().getInteger("id");
		res = this.repository.findOneJobById(id);
		return res;
	}

	@Override
	public void validate(final Request<Job> request, final Job entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		Spam spam = this.repository.findAllSpam().stream().collect(Collectors.toList()).get(0);
		Stream<String> spamWords = Stream.of(spam.getSpamWords().split(","));

		String title = (String) request.getModel().getAttribute("title");
		Double spamWordsTitle = (double) spamWords.filter(x -> title.contains(x)).count();
		errors.state(request, spamWordsTitle < spam.getUmbral(), "title", "employer.job.titleSpam");

		if (request.getModel().getAttribute("status").equals("PUBLISHED")) {

			Descriptor descriptor = this.repository.findAllDescriptorById(entity.getId());
			Collection<Duty> duties = this.repository.findAllDescriptorById(descriptor.getId()).getDuties();
			Double dutiesPercentage = duties.stream().mapToDouble(x -> x.getPercentage()).sum();
			errors.state(request, dutiesPercentage == 100, "status", "employer.job.dutiesNot100");

		}
		Boolean status = false;
		if (request.getModel().getAttribute("status").equals("PUBLISHED")) {
			status = true;

		}
		errors.state(request, status, "status", "employer.job.statusIncorrect");

	}

	@Override
	public void update(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;

		if (request.getModel().getAttribute("status").equals("PUBLISHED")) {
			entity.setFinalMode(true);
		}

		this.repository.save(entity);

	}

}
