
package acme.features.administrator.spam;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.spam.Spam;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorSpamRepository extends AbstractRepository {

	@Query("select a from Spam a where a.id = ?1")
	Spam findOneById(int id);

	@Query("select a from Spam a")
	Collection<Spam> findManyAll();

}
