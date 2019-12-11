
package acme.features.anonymous.huBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.HuBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousHuBulletinListService implements AbstractListService<Anonymous, HuBulletin> {

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

		request.unbind(entity, model, "moment", "grade", "author", "description");
	}

	@Override
	public Collection<HuBulletin> findMany(final Request<HuBulletin> request) {
		assert request != null;
		Collection<HuBulletin> result;
		result = this.repository.findMany();

		return result;
	}

}
