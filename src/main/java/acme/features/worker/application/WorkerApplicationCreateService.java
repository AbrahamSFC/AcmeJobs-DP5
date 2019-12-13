
package acme.features.worker.application;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Applications;
import acme.entities.applications.Status;
import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class WorkerApplicationCreateService implements AbstractCreateService<Worker, Applications> {

	@Autowired
	private WorkerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Applications> request) {
		assert request != null;
		Job job = this.repository.findJobById(request.getModel().getInteger("id"));
		//Date deadline = job.getDeadline();
		//Date date = new Date();

		//Boolean restriccion = deadline.after(date);

		Date deadline2 = job.getDeadline();
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		Date minDeadline = calendar.getTime();
		Boolean res = deadline2.after(minDeadline);

		return res;
	}

	@Override
	public void bind(final Request<Applications> request, final Applications entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "moment", "status");

	}

	@Override
	public void unbind(final Request<Applications> request, final Applications entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "reference", "moment", "status", "statement", "skills", "qualifications");
		model.setAttribute("id", entity.getJob().getId());
	}

	@Override
	public Applications instantiate(final Request<Applications> request) {
		Applications result;
		result = new Applications();

		Integer id;
		id = new Integer(request.getModel().getInteger("id"));
		result.setJob(this.repository.findJobById(id));

		result.setWorker(this.repository.findWorkerById(request.getPrincipal().getActiveRoleId()));

		return result;
	}

	@Override
	public void validate(final Request<Applications> request, final Applications entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("reference")) {
			Applications reference = this.repository.findJobByReference(entity.getReference());
			errors.state(request, reference == null, "reference", "worker.applications.error.unique-reference");
		}
	}

	@Override
	public void create(final Request<Applications> request, final Applications entity) {
		assert request != null;
		assert entity != null;
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);

		entity.setStatus(Status.PENDING);

		this.repository.save(entity);

	}

}
