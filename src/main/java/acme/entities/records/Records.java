
package acme.entities.records;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Records extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	public String				company;

	@NotBlank
	private String				sector;

	@NotBlank
	private String				CEO;

	@NotBlank
	private String				activities;

	@URL
	private String				web;

	@NotBlank
	@Pattern(regexp = "([+][^0][\\d]{0,2})?[ ]?([(][\\d]{0,4}[)])?[ ]?([\\d]{6,10})$")
	private String				phone;

	@Email
	@NotBlank
	private String				email;

	@NotNull
	public Boolean				incorporated;

	@Range(min = 0, max = 5)
	private Double				stars;


	public String getCompanyIncorporated() {

		StringBuilder res = new StringBuilder();
		res.append(this.company);

		if (this.incorporated == true) {

			res.append(", Inc.");

		} else {

			res.append(", LLC");

		}
		return res.toString();

	}
}
