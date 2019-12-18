
package acme.features.auditor.auditsJob;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.AuditRecord;
import acme.entities.jobs.Job;
import acme.entities.roles.Auditor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuditorAuditsJobRepository extends AbstractRepository {

	@Query("select a from AuditRecord a where a.job.id = ?1")
	Collection<AuditRecord> findAuditsRecords(int id);

	@Query("select a from AuditRecord a where a.id = ?1")
	AuditRecord findOne(int id);

	@Query("select a from Job a where a.id=?1")
	Job findJobById(int id);

	@Query("select a from Auditor a where a.id=?1")
	Auditor findAuditorById(int id);

}
