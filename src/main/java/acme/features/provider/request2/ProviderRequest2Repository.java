
package acme.features.provider.request2;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.requests2.Request2;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ProviderRequest2Repository extends AbstractRepository {

	@Query("select a from Request2 a where a.id = ?1")
	Request2 findOneById(int id);

	@Query("select a from Request2 a where a.deadline>CURRENT_TIMESTAMP")
	Collection<Request2> findMany();

	@Query("select a from Request2 a where a.ticker = ?1")
	Request2 findOneByTicker(String ticker);

}
