
package acme.features.anonymous.sotoBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.SotoBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousSotoBulletinRepository extends AbstractRepository {

	@Query("select s from SotoBulletin s")
	Collection<SotoBulletin> findMany();

}
