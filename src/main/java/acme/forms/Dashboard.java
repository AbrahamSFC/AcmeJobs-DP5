
package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	private static final long	serialVersionUID	= 1L;

	//Atributos
	Double						ratioJobsWithJobChallenges;
	Double						ratioJobChallengesWithApplicationAnswer;
	Double						ratioApplicationsWithApplicationsAnswerWithPassword;
	Double						avgJobsEmployer;
	Double						avgApplicationsEmployer;
	Double						avgApplicationsWorker;

}
