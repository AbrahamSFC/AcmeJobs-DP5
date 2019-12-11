
package acme.features.auditor.jobsWriteAuditor;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorMineJobAuditRepository extends AbstractRepository {

	@Query("select a.job from AuditRecord a where a.auditor.id = ?1")
	Collection<Job> jobsMineAuditor(int id);

	@Query("select a.job from AuditRecord a where a.job.id = ?1")
	Job findOne(int id);
}
