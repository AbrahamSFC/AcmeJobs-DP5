
package acme.features.anonymous.sotoBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.SotoBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousSotoBulletinListService implements AbstractListService<Anonymous, SotoBulletin> {

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

		request.unbind(entity, model, "moment", "song", "author", "description");
	}

	@Override
	public Collection<SotoBulletin> findMany(final Request<SotoBulletin> request) {
		assert request != null;
		Collection<SotoBulletin> result;
		result = this.repository.findMany();

		return result;
	}

}
