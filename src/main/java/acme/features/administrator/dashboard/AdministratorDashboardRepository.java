
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

	@Query("select 1.0 * count(a)/(select count(b) from Job b) from JobChallenge a")
	Double getRatioJobsWithJobChallenges();

	@Query("select 1.0 * count(a)/(select count(b) from JobChallenge b) from ApplicationAnswer a")
	Double getRatioJobChallengesWithApplicationAnswer();

	@Query("select 1.0 * count(a)/(select count(b) from Applications b) from ApplicationAnswer a where a.password!=''")
	Double getRatioApplicationsWithApplicationsAnswerWithPassword();
}
