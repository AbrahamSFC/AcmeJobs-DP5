
package acme.features.administrator.records;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.records.Records;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/records/")
public class AdministratorRecordsController extends AbstractController<Administrator, Records> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AdministratorRecordsListService		listService;

	@Autowired
	private AdministratorRecordsShowService		showService;

	@Autowired
	private AdministratorRecordsCreateService	createService;

	@Autowired
	private AdministratorRecordsUpdateService	updateService;

	@Autowired
	private AdministratorRecordsDeleteService	deleteService;


	// Constructors -----------------------------------------------------------

	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}

}
