
package acme.entities.jobs;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class JobChallenge extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Length(max = 10)
	private String				description;

	@URL
	private String				moreInfo;

	@NotNull
	@Valid
	@OneToOne(optional = true)
	private Job					job;

}
