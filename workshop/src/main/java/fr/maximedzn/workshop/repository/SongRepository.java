package fr.maximedzn.workshop.repository;

import fr.maximedzn.workshop.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SongRepository extends JpaRepository<Song,Long> {
}
