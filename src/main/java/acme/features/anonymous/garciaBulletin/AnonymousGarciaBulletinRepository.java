
package acme.features.anonymous.garciaBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.GarciaBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousGarciaBulletinRepository extends AbstractRepository {

	@Query("select s from GarciaBulletin s")
	Collection<GarciaBulletin> findMany();

}
