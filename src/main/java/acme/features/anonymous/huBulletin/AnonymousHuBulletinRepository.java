
package acme.features.anonymous.huBulletin;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bulletins.HuBulletin;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousHuBulletinRepository extends AbstractRepository {

	@Query("select s from HuBulletin s")
	Collection<HuBulletin> findMany();

}
