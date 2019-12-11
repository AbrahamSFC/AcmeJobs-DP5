
package acme.features.anonymous.sotoBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.SotoBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousSotoBulletinCreateService implements AbstractCreateService<Anonymous, SotoBulletin> {

	@Autowired
	AnonymousSotoBulletinRepository repository;


	@Override
	public boolean authorise(final Request<SotoBulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<SotoBulletin> request, final SotoBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "song", "author", "description");
	}

	@Override
	public void bind(final Request<SotoBulletin> request, final SotoBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public SotoBulletin instantiate(final Request<SotoBulletin> request) {
		assert request != null;
		SotoBulletin result;
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		result = new SotoBulletin();
		result.setAuthor("David");
		result.setDescription("Me gusta la música de los 70");
		result.setMoment(moment);
		result.setSong("Bohemian Rhapsody");
		return result;
	}

	@Override
	public void validate(final Request<SotoBulletin> request, final SotoBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<SotoBulletin> request, final SotoBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}
}
