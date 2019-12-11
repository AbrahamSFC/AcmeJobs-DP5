
package acme.features.administrator.chart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Chart;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorChartShowService implements AbstractShowService<Administrator, Chart> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AdministratorChartRepository repository;

	// AbstractCreateService<Administrator, Consumer> ---------------------------


	@Override
	public boolean authorise(final Request<Chart> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Chart> request, final Chart entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ratioPendingApplication", "ratioAcceptedApplication", "ratioRejectedApplication");
		request.unbind(entity, model, "ratioDraftJob", "ratioPublishedJob");

	}

	@Override
	public Chart findOne(final Request<Chart> request) {
		assert request != null;

		Chart result = new Chart();

		result.setRatioAcceptedApplication(this.repository.getRatioAcceptedApplications());
		result.setRatioPendingApplication(this.repository.getRatioPendingApplications());
		result.setRatioRejectedApplication(this.repository.getRatioRejectedApplications());

		result.setRatioDraftJob(this.repository.getRatioDraftJob());
		result.setRatioPublishedJob(this.repository.getRatioPublishedJob());

		return result;
	}

}
