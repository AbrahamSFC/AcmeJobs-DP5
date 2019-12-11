
package acme.entities.challenge;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Challenge extends DomainEntity {

	/**
	 * + title: String {NotBlank}
	 * + deadline: Date {Temporal(TIMESTAMP),Future }
	 * + description: String {NotBlank}
	 * + goal: Set {Length(3,3)}
	 * + reward: Set {Length(3,3)}
	 */
	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Future
	private Date				deadline;

	@NotBlank
	private String				description;

	@NotBlank
	private String				goalGold;

	@NotBlank
	private String				goalSilver;

	@NotBlank
	private String				goalBronze;

	@NotBlank
	private String				rewardGold;

	@NotBlank
	private String				rewardSilver;

	@NotBlank
	private String				rewardBronze;

}
