package main.java.pt.deti.ies.moviesv2.repository.moviesv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan(basePackages = "main.java.pt.deti.ies.moviesv2.repository.moviesv2.entity")
public class MoviesV2Application {

	public static void main(String[] args) {
		SpringApplication.run(MoviesV2Application.class, args);
	}

}
