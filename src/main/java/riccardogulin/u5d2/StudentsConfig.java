package riccardogulin.u5d2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import riccardogulin.u5d2.entities.BackendStudent;
import riccardogulin.u5d2.entities.FrontendStudent;
import riccardogulin.u5d2.entities.FullstackStudent;

@Configuration
@PropertySource("application.properties")
// Annotazione fondamentale se vogliamo leggere i valori direttamente da application properties tramite @Value
public class StudentsConfig {

	// Siccome nel main non posso utilizzare @Value, se voglio usare un valore definito all'interno di application.properties
	// posso crearmi un Bean che "esporti" tale valore. Poi nel main posso fare un .getBean() per ottenerlo
	@Bean(name = "pg_password")
	public String getPGPassword(@Value("${postgres.password}") String pgPassword) {
		return pgPassword;
	}

	@Bean
	public int getAge() {
		return 20;
	}

	@Bean
	@Primary
	public String getName() {
		return "Ajeje";
	}

	@Bean(name = "aldo")
	@Scope("prototype")
	public FullstackStudent getFSStudent() {
		return new FullstackStudent("Aldo", "Baglio");
	}

	@Bean
	public FrontendStudent getFEStudent() {
		return new FrontendStudent("Giovanni", "Storti");
	}

	@Bean(name = "giacomo")
	@Primary // Annotazione per risolvere le ambiguità. Ogni qualvolta ci sia un dubbio su
	// quale Student scegliere, verrà scelto questo (una sorta di default)
	public BackendStudent getBEStudent(@Value("${admin.name}") String name) {
		return new BackendStudent(name, "Poretti");
	}

	/*
	@Bean
	public Interviewer getInterviewer(Student student) {
		return new Interviewer(student);
	}*/

}
