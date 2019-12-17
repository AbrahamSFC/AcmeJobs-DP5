
package acme.features.employer.job;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

		request.unbind(entity, model, "reference", "status", "title", "deadline", "salary", "description", "moreInfo", "descriptor.description");

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

		if (!errors.hasErrors("deadline")) {
			Date deadline = entity.getDeadline();
			Calendar calendar = new GregorianCalendar();
			calendar.add(Calendar.DAY_OF_MONTH, 0);
			Date minDeadline = calendar.getTime();
			Boolean restriccion = deadline.after(minDeadline);
			errors.state(request, restriccion, "deadline", "employer.job.error.must-be-after");
		}

		if (!errors.hasErrors("salary")) {
			Boolean okSalary = entity.getSalary().getCurrency().equals("EUR");
			errors.state(request, okSalary, "salary", "employer.job.error.incorrect-currency");
		}

		Spam spam = this.repository.findAllSpam().stream().collect(Collectors.toList()).get(0);
		Stream<String> spamWords = Stream.of(spam.getSpamWords().split(","));

		String title = (String) request.getModel().getAttribute("title");
		Double spamWordsTitle = (double) spamWords.filter(x -> title.contains(x)).count();
		errors.state(request, spamWordsTitle < spam.getUmbral(), "title", "employer.job.titleSpam");
		//
		//		if (request.getModel().getAttribute("status").equals("PUBLISHED")) {
		//
		//			String descriptor = (String) request.getModel().getAttribute("descriptor.description");
		//			Collection<Duty> duties = (Collection<Duty>) request.getModel().getAttribute("descriptor.duties");
		//			Double dutiesPercentage = duties.stream().mapToDouble(x -> x.getPercentage()).sum();
		//			errors.state(request, dutiesPercentage == 100, "status", "employer.job.dutiesNot100");
		//
		//		}
		Boolean status = request.getModel().getAttribute("status").equals("PUBLISHED") || request.getModel().getAttribute("status").equals("DRAFT");
		errors.state(request, status, "status", "employer.job.statusIncorrect");

	}

	@Override
	public void update(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;

		if (request.getModel().getAttribute("status").equals("PUBLISHED")) {
			entity.setFinalMode(true);
		}
		for (Duty a : entity.getDescriptor().getDuties()) {
			this.repository.save(a);
		}
		this.repository.save(entity.getDescriptor());
		this.repository.save(entity);

	}

}
