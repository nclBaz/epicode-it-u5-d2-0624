package riccardogulin.u5d2.dao;

import org.springframework.stereotype.Component;

@Component
public class StudentsDAO {
	public void save() {
		System.out.println("Studente salvato!");
	}

	public void findById() {
		System.out.println("Studente trovato!");
	}
}
