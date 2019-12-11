
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select avg(select count(a) from Job a where a.employer.id=e.id) from Employer e")
	Double getAverageJobsPerEmployer();

	@Query("select avg(select count(a) from Applications a where a.job.employer.id=e.id) from Employer e")
	Double getAverageApplicationsPerEmployer();

	@Query("select avg(select count(a) from Applications a where a.worker.id=w.id) from Worker w")
	Double getAverageApplicationsPerWorker();
}
