package riccardogulin.u5d2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import riccardogulin.u5d2.dao.StudentsDAO;

// I Runner devono avere due caratteristiche:
// - implementare l'interfaccia CommandLineRunner
// - essere dei @Component
@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	private StudentsDAO studentsDAO;

	@Override
	public void run(String... args) throws Exception {
		// Questo metodo verrà eseguito all'avvio dell'applicazione prima di eseguire il main
		// I Runner sono quindi utili per ad esempio setup iniziali dell'applicazione, come ad esempio inserimento di dati nel db
		System.out.println("CIAO DAL RUNNER");

		studentsDAO.save();
		studentsDAO.findById();
	}
}
