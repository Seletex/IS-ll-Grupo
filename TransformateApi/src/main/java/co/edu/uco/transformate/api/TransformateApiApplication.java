package co.edu.uco.transformate.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan("co.edu.uco.transformate.api.model")
public class TransformateApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransformateApiApplication.class, args); 
	}

}
