
package acme.features.anonymous.delgadoBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.DelgadoBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousDelgadoBulletinRepository extends AbstractRepository {

	@Query("select s from DelgadoBulletin s")
	Collection<DelgadoBulletin> findMany();

}
