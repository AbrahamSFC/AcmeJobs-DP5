
package acme.features.anonymous.delgadoBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.DelgadoBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousDelgadoBulletinCreateService implements AbstractCreateService<Anonymous, DelgadoBulletin> {

	@Autowired
	AnonymousDelgadoBulletinRepository repository;


	@Override
	public boolean authorise(final Request<DelgadoBulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<DelgadoBulletin> request, final DelgadoBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "numWallet", "initiative");
	}

	@Override
	public void bind(final Request<DelgadoBulletin> request, final DelgadoBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public DelgadoBulletin instantiate(final Request<DelgadoBulletin> request) {
		assert request != null;
		DelgadoBulletin result;
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		result = new DelgadoBulletin();
		result.setAuthor("James Pérez");
		result.setNumWallet("3243ad");
		result.setMoment(moment);
		result.setInitiative("Invertir");
		return result;
	}

	@Override
	public void validate(final Request<DelgadoBulletin> request, final DelgadoBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<DelgadoBulletin> request, final DelgadoBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}
}
