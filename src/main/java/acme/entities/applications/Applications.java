
package acme.entities.applications;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import acme.entities.jobs.Job;
import acme.entities.roles.Worker;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Applications extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	//@Pattern(regexp = "^[a-zA-Z]{4}-[a-zA-Z]{4}:[a-zA-Z]{4}")
	@NotBlank
	@Column(unique = true)
	@Length(min = 5, max = 15)
	private String				reference;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

	@Enumerated(value = EnumType.STRING)
	private Status				status;

	@NotBlank
	private String				statement;

	@NotNull
	private String				skills;
	@NotNull
	private String				qualifications;

	//Relationships

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Worker				worker;

	@Valid
	@ManyToOne(optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Job					job;

}
