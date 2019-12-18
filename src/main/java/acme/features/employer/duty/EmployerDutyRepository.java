
package acme.features.employer.duty;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Descriptor;
import acme.entities.jobs.Duty;
import acme.entities.jobs.Job;
import acme.entities.spam.Spam;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerDutyRepository extends AbstractRepository {

	@Query("select a from Spam a ")
	Collection<Spam> findAllSpam();

	@Query("select a from Job a where a.id = ?1")
	Job findOneJobById(int id);

	@Query("select a from Descriptor b join b.duties a where b.id =?1")
	Collection<Duty> findAllDutiesByDescriptor(int descriptorId);

	@Query("select a from Descriptor a where a.id =?1")
	Descriptor findDescriptorById(int descId);

	@Query("select a from Duty a where a.id = ?1")
	Duty findOneById(int id);

	@Query("select a from Duty a")
	Collection<Duty> findManyAll();
}
