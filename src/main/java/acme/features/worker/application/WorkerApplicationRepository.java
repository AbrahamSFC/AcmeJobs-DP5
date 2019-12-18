/*
 * AuthenticatedConsumerRepository.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.worker.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Applications;
import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.entities.spam.Spam;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerApplicationRepository extends AbstractRepository {

	@Query("select a from Applications a where a.id = ?1")
	Applications findOneById(int id);

	@Query("select a from Spam a ")
	Collection<Spam> findAllSpam();

	@Query("select a from Applications a")
	Collection<Applications> findAllApplications();

	@Query("select a from Applications a where a.worker.id=?1")
	Collection<Applications> findManyByWorkerId(int workerId);

	@Query("select a from Applications a where a.job.employer.id=?1")
	Collection<Applications> findManyByEmployerId(int employerId);

	@Query("select a from Job a where a.id=?1")
	Job findJobById(int id);

	@Query("select a from Applications a where a.reference=?1")
	Applications findJobByReference(String reference);

	@Query("select a from Worker a where a.id=?1")
	Worker findWorkerById(int id);
}
