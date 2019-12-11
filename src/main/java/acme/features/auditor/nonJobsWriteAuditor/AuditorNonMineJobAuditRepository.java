
package acme.features.auditor.nonJobsWriteAuditor;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorNonMineJobAuditRepository extends AbstractRepository {

	@Query("select j from Job j where j.id not in(select a.job.id from AuditRecord a where a.auditor.id = ?1)")
	Collection<Job> jobsAuditorHasNotWrittenAudit(int id);

	@Query("select j from Job j where j.id = ?1")
	Job findOne(int id);

}
