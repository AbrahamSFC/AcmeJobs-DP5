
package acme.features.anonymous.delgadoBulletin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.DelgadoBulletin;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousDelgadoBulletinListService implements AbstractListService<Anonymous, DelgadoBulletin> {

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

		request.unbind(entity, model, "moment", "author", "numWallet", "initiative");
	}

	@Override
	public Collection<DelgadoBulletin> findMany(final Request<DelgadoBulletin> request) {
		assert request != null;
		Collection<DelgadoBulletin> result;
		result = this.repository.findMany();

		return result;
	}

}
