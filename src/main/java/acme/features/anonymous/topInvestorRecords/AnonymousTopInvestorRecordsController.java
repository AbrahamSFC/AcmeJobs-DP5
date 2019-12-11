
package acme.features.anonymous.topInvestorRecords;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.investorRecords.InvestorRecords;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/top-investor-records/")
public class AnonymousTopInvestorRecordsController extends AbstractController<Anonymous, InvestorRecords> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AnonymousTopInvestorRecordsListService	listService;

	@Autowired
	private AnonymousTopInvestorRecordsShowService	showService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
