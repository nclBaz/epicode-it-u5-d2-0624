package riccardogulin.u5d2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import riccardogulin.u5d2.entities.BackendStudent;

@SpringBootApplication
public class U5d2Application {

	public static void main(String[] args) {
		SpringApplication.run(U5d2Application.class, args);

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(U5d2Application.class);

		BackendStudent bs = context.getBean(BackendStudent.class);
		System.out.println(bs);

		context.close();
	}

}
