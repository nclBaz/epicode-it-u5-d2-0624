package riccardogulin.u5d2.entities;

public class Interviewer {
	private Student student;

/*	public Interviewer() { // ACCOPPIAMENTO MOLTO FORTE. Da evitare!
		this.student = new BackendStudent("Aldo", "Baglio");
	}

	public Interviewer(BackendStudent student) { // ACCOPPIAMENTO FORTE. Se possibile meglio evitarlo!
		this.student = student;
	}*/

	public Interviewer(Student student) { // ACCOPPIAMENTO DEBOLE. Lo vogliamo!
		this.student = student;
	}

	public void askQuestion() {
		System.out.println("Ciao " + this.student.getName() + ", per favore rispondi alla seguente domanda...blabblblba");
		this.student.answerQuestion();
	}
}
