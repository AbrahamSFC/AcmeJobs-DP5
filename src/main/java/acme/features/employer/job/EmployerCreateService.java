
package acme.features.employer.job;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Descriptor;
import acme.entities.jobs.Duty;
import acme.entities.jobs.Job;
import acme.entities.jobs.JobStatus;
import acme.entities.roles.Employer;
import acme.entities.spam.Spam;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerCreateService implements AbstractCreateService<Employer, Job> {

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
		model.setAttribute("descriptor", entity.getDescriptor());

	}

	@Override
	public Job instantiate(final Request<Job> request) {
		assert request != null;
		Job res;
		res = new Job();
		Descriptor descriptor = new Descriptor();
		Collection<Duty> duties = new ArrayList<>();
		descriptor.setDuties(duties);
		Principal principal;
		Employer employer;
		int userAccountId;

		principal = request.getPrincipal();
		userAccountId = principal.getActiveRoleId();
		employer = this.repository.findOneEmployerByUserAccount(userAccountId);
		res.setEmployer(employer);
		res.setDescriptor(descriptor);
		res.setStatus(JobStatus.DRAFT);
		res.setFinalMode(false);
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
	}

	@Override
	public void create(final Request<Job> request, final Job entity) {
		assert request != null;
		assert entity != null;
		for (Duty a : entity.getDescriptor().getDuties()) {
			this.repository.save(a);
		}
		this.repository.save(entity.getDescriptor());
		this.repository.save(entity);

	}

}
