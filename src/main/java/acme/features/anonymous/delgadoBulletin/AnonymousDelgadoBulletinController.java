
package acme.features.anonymous.delgadoBulletin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.bulletins.DelgadoBulletin;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Anonymous;

@Controller
@RequestMapping("/anonymous/delgado-bulletin/")
public class AnonymousDelgadoBulletinController extends AbstractController<Anonymous, DelgadoBulletin> {

	@Autowired
	private AnonymousDelgadoBulletinListService	listService;

	@Autowired
	private AnonymousDelgadoBulletinCreateService	createService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}

}
