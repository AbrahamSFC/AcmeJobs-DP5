
package acme.entities.auditorRequest;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import acme.framework.entities.DomainEntity;
import acme.framework.entities.UserAccount;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = {
	@Index(columnList = "accepted")
})
public class AuditorRequest extends DomainEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	private boolean				accepted;

	@NotNull
	@Valid
	@OneToOne(optional = false)
	private UserAccount			user;

}
