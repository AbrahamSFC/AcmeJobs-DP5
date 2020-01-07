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

package acme.features.worker.answer;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.ApplicationAnswer;
import acme.entities.spam.Spam;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerAnswerRepository extends AbstractRepository {

	@Query("select a from ApplicationAnswer a where a.id = ?1")
	ApplicationAnswer findOneById(int id);

	@Query("select a from Spam a ")
	Collection<Spam> findAllSpam();

	@Query("select a from ApplicationAnswer a where a.id = ?1")
	Collection<ApplicationAnswer> findManyByWorkerId(int id);
}
