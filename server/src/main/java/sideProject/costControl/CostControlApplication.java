package sideProject.costControl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CostControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(CostControlApplication.class, args);
	}

}
