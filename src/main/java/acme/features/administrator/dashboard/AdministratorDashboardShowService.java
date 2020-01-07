
package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AdministratorDashboardRepository repository;

	// AbstractCreateService<Administrator, Consumer> ---------------------------


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ratioJobsWithJobChallenges", "ratioJobChallengesWithApplicationAnswer");
		request.unbind(entity, model, "ratioApplicationsWithApplicationsAnswerWithPassword", "avgJobsEmployer");
		request.unbind(entity, model, "avgApplicationsEmployer", "avgApplicationsWorker");
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result = new Dashboard();
		result.setRatioJobsWithJobChallenges(this.repository.getRatioJobsWithJobChallenges());
		result.setRatioJobChallengesWithApplicationAnswer(this.repository.getRatioJobChallengesWithApplicationAnswer());
		result.setRatioApplicationsWithApplicationsAnswerWithPassword(this.repository.getRatioApplicationsWithApplicationsAnswerWithPassword());
		result.setAvgJobsEmployer(this.repository.getAverageJobsPerEmployer());
		result.setAvgApplicationsEmployer(this.repository.getAverageApplicationsPerEmployer());
		result.setAvgApplicationsWorker(this.repository.getAverageApplicationsPerWorker());

		return result;
	}

}
