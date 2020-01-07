/*
 * AuthenticatedConsumerController.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.worker.answer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.applications.ApplicationAnswer;
import acme.entities.roles.Worker;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/worker/answer/")
public class WorkerAnswerController extends AbstractController<Worker, ApplicationAnswer> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private WorkerAnswerListMineService	listMineService;

	@Autowired
	private WorkerAnswerShowService		showService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listMineService);
		//super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.employerListMineService);

		//super.addCustomCommand(CustomCommand.EMPLOYER_LIST_MINE, BasicCommand.LIST, this.employerListMineService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

	}

}
