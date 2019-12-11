
package acme.features.administrator.investorRecords;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investorRecords.InvestorRecords;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorInvestorRecordsListService implements AbstractListService<Administrator, InvestorRecords> {

	@Autowired
	private AdministratorInvestorRecordsRepository repository;


	@Override
	public boolean authorise(final Request<InvestorRecords> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<InvestorRecords> request, final InvestorRecords entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "investingStatements");

	}

	@Override
	public Collection<InvestorRecords> findMany(final Request<InvestorRecords> request) {
		assert request != null;
		Collection<InvestorRecords> result;
		result = this.repository.findManyAll();
		return result;
	}

}
