
package acme.features.worker.jobChallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.JobChallenge;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerJobChallengeShowService implements AbstractShowService<Worker, JobChallenge> {

	@Autowired
	WorkerJobChallengeRepository repository;


	@Override
	public boolean authorise(final Request<JobChallenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<JobChallenge> request, final JobChallenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "description", "moreInfo");

	}

	@Override
	public JobChallenge findOne(final Request<JobChallenge> request) {
		assert request != null;

		JobChallenge result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneJobById(id);

		return result;
	}

}
