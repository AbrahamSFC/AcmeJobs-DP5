
package acme.features.auditor.nonJobsWriteAuditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class AuditorNonMineJobAuditShowService implements AbstractShowService<Auditor, Job> {

	@Autowired
	AuditorNonMineJobAuditRepository repository;


	@Override
	public boolean authorise(final Request<Job> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Job> request, final Job entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("duties", entity.getDescriptor().getDuties());

		request.unbind(entity, model, "reference", "status", "title", "deadline", "salary", "descriptor.description", "moreInfo");
	}

	@Override
	public Job findOne(final Request<Job> request) {
		assert request != null;
		Job res = this.repository.findOne(request.getModel().getInteger("id"));
		return res;
	}

}
