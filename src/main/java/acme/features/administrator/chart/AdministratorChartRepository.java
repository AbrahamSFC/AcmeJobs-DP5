
package acme.features.administrator.chart;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorChartRepository extends AbstractRepository {

	@Query("select 1.0 * count(a)/(select count(b) from Applications b) from Applications a where a.status=acme.entities.applications.Status.PENDING")
	Double getRatioPendingApplications();

	@Query("select 1.0 * count(a)/(select count(b) from Applications b) from Applications a where a.status=acme.entities.applications.Status.ACCEPTED")
	Double getRatioAcceptedApplications();

	@Query("select 1.0 * count(a)/(select count(b) from Applications b) from Applications a where a.status=acme.entities.applications.Status.REJECTED")
	Double getRatioRejectedApplications();

	@Query("select 1.0 * count(a)/(select count(b) from Job b) from Job a where a.status=acme.entities.jobs.JobStatus.DRAFT")
	Double getRatioDraftJob();

	@Query("select 1.0 * count(a)/(select count(b) from Job b) from Job a where a.status=acme.entities.jobs.JobStatus.PUBLISHED")
	Double getRatioPublishedJob();

	@Query("select 1.0 * count(a)/(select count(b) from Applications b) from Applications a where a.status=acme.entities.applications.Status.PENDING")
	Double getRatioPendingApplications4weeks();

	@Query("select 1.0 * count(a)/(select count(b) from Applications b) from Applications a where a.status=acme.entities.applications.Status.ACCEPTED")
	Double getRatioAcceptedApplications4weeks();

	@Query("select 1.0 * count(a)/(select count(b) from Applications b) from Applications a where a.status=acme.entities.applications.Status.REJECTED")
	Double getRatioRejectedApplications4weeks();

}
