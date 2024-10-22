package riccardogulin.u5d2.entities;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@ToString
public class Interviewer {
	// FIELD INJECTION
	// Se non uso il costruttore con parametri (ad es. voglio avere solo quello vuoto) posso mettere @Autowired direttamente su un attributo
	// Così facendo, Spring sa che all'avvio dell'applicazione dovrà andare a cercare nel context un Bean compatibile e lo inietterà
	// N.B. Se non ho il costruttore e non metto @Autowired student sarà NULL!!!
	// @Autowired
	private Student student;
	private String name;
	private String surname;

/*	public Interviewer() { // ACCOPPIAMENTO MOLTO FORTE. Da evitare!
		this.student = new BackendStudent("Aldo", "Baglio");
	}

	public Interviewer(BackendStudent student) { // ACCOPPIAMENTO FORTE. Se possibile meglio evitarlo!
		this.student = student;
	}*/

	// CONSTRUCTOR INJECTION
	// @Autowired. Qua è OPZIONALE. Nel senso che anche se non lo mettiamo Spring comunque inietterà la dipendenza
	public Interviewer(@Qualifier("aldo") Student student,
	                   @Qualifier("getName") String name,
	                   @Qualifier("pg_password") String surname) { // ACCOPPIAMENTO DEBOLE. Lo vogliamo!
		this.student = student;
		this.name = name;
		this.surname = surname;
	}

	public void askQuestion() {
		System.out.println("Ciao sono " + this.name + " " + this.surname);
		System.out.println("Ciao " + this.student.getName() + ", per favore rispondi alla seguente domanda...blabblblba");
		this.student.answerQuestion();
	}
}
