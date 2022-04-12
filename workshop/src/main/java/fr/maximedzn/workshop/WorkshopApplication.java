package fr.maximedzn.workshop;

import fr.maximedzn.workshop.domain.Artist;
import fr.maximedzn.workshop.enums.ArtistStyle;
import fr.maximedzn.workshop.repository.ArtistRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableDiscoveryClient
@SpringBootApplication
public class WorkshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ArtistRepository artistRepository, RepositoryRestConfiguration repositoryRestConfiguration){
		return args -> {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			artistRepository.save(Artist.builder()
					.artistStyle(ArtistStyle.CLASSIQUE)
							.firstName("maxime")
							.lastName("dazin")
							.nickName("maximeDzN")
							.birthDate(sdf.parse("02/08/1999"))
					.build());
		};
	}
}
