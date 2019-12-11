
package acme.features.anonymous.topRecords;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.records.Records;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/top-records/")
public class AnonymousTopRecordsController extends AbstractController<Anonymous, Records> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AnonymousTopRecordsListService	listService;

	@Autowired
	private AnonymousTopRecordsShowService	showService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
