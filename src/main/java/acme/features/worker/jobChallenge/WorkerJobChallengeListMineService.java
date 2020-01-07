
package acme.features.worker.jobChallenge;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.JobChallenge;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class WorkerJobChallengeListMineService implements AbstractListService<Worker, JobChallenge> {

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
		model.setAttribute("id", entity.getJob().getId());
	}

	@Override
	public Collection<JobChallenge> findMany(final Request<JobChallenge> request) {
		assert request != null;

		Collection<JobChallenge> result;

		Integer id;
		id = new Integer(request.getModel().getInteger("id"));
		System.out.println(id);
		result = this.repository.findManyJobs(id);
		System.out.println(result);
		return result;
	}

}
