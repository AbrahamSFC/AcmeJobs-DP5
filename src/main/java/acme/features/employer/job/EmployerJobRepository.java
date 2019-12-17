
package acme.features.employer.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Applications;
import acme.entities.jobs.Descriptor;
import acme.entities.jobs.Duty;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.entities.spam.Spam;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerJobRepository extends AbstractRepository {

	@Query("select a from Job a where a.id = ?1")
	Job findOneJobById(int id);

	@Query("select a from Job a where a.employer.id=?1")
	Collection<Job> findManyByEmployerId(int employerId);

	@Query("select a from Employer a where a.id=?1")
	Employer findOneEmployerByUserAccount(int userId);

	@Query("select a from Spam a ")
	Collection<Spam> findAllSpam();

	@Query("select a from Descriptor a where a.id =?1 ")
	Descriptor findDescriptorById(int descriptorId);
	//

	@Query("select a from Duty a where a.id =?1 ")
	Collection<Duty> findAllDutiesByDescriptor(int dutyId);

	@Query("select a from Applications a where a.job.id=?1")
	Collection<Applications> findApplicationsByJobId(int jobId);

}
