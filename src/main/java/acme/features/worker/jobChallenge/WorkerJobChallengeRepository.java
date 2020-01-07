
package acme.features.worker.jobChallenge;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.JobChallenge;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerJobChallengeRepository extends AbstractRepository {

	@Query("select a from Job a where a.id = ?1")
	JobChallenge findOneJobById(int id);

	@Query("select a from JobChallenge a where a.job.id=?1")
	Collection<JobChallenge> findManyJobs(int id);

}
