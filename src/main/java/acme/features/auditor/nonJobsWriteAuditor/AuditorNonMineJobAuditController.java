
package acme.features.auditor.nonJobsWriteAuditor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/auditor/non-job/")
public class AuditorNonMineJobAuditController extends AbstractController<Auditor, Job> {

	@Autowired
	AuditorNonMineJobAuditListService	listService;

	@Autowired
	AuditorNonMineJobAuditShowService	showService;


	@PostConstruct
	private void inicialise() {
		super.addCustomCommand(CustomCommand.LIST_NON_MINE, BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
