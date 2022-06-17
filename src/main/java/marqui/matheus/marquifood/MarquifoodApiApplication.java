package marqui.matheus.marquifood;

import marqui.matheus.marquifood.infrastructure.repository.CustomJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class MarquifoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarquifoodApiApplication.class, args);
	}

}
