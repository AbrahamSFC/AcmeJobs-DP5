
package acme.features.anonymous.huBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.HuBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousHuBulletinCreateService implements AbstractCreateService<Anonymous, HuBulletin> {

	@Autowired
	AnonymousHuBulletinRepository repository;


	@Override
	public boolean authorise(final Request<HuBulletin> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<HuBulletin> request, final HuBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "grade", "author", "description");
	}

	@Override
	public void bind(final Request<HuBulletin> request, final HuBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public HuBulletin instantiate(final Request<HuBulletin> request) {
		assert request != null;
		HuBulletin result;
		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		result = new HuBulletin();
		result.setAuthor("Chao");
		result.setDescription("Persona disciplinada para trabajar a cualquier franja horaria");
		result.setMoment(moment);
		result.setGrade("Matemáticas");
		return result;
	}

	@Override
	public void validate(final Request<HuBulletin> request, final HuBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<HuBulletin> request, final HuBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);

	}
}
