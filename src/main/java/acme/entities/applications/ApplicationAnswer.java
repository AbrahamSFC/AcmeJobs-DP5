
package acme.entities.applications;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ApplicationAnswer extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	private String				XXX4;

	@Pattern(regexp = "^((?=.*[a-zA-Z]){3,}(?=.*d)(?=.*[,.;:'()[/]{}!?¿¡]).{5,})?$")
	private String				password;

	@OneToOne(optional = true)
	private Applications		application;

}
