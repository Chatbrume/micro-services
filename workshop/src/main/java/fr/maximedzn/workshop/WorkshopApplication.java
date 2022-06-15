package fr.maximedzn.workshop;

import fr.maximedzn.workshop.domain.Album;
import fr.maximedzn.workshop.domain.Artist;
import fr.maximedzn.workshop.domain.Song;
import fr.maximedzn.workshop.enums.ArtistStyle;
import fr.maximedzn.workshop.repository.AlbumRepository;
import fr.maximedzn.workshop.repository.ArtistRepository;
import fr.maximedzn.workshop.repository.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

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
			Artist artist = Artist.builder()
					.artistStyle(ArtistStyle.CLASSIQUE)
					.firstName("maxime")
					.lastName("dazin")
					.nickName("maximeDzN")
					.birthDate(sdf.parse("02/08/1999"))
					.nationality("Français")
					.build();
			Album album = Album.builder().name("Super mega dingz").releasedAt(new Date()).build();
			Song song = Song.builder().name("EP 1").duration(120).build();
			album.setSongs(new HashSet<>(List.of(song)));
			artist.setAlbum(new HashSet<>(List.of(album)));
			song.setAlbum(album);
			album.setArtist(artist);
			artistRepository.save(artist);

		};
	}
}
