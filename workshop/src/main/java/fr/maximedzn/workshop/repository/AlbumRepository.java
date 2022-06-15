package fr.maximedzn.workshop.repository;

import fr.maximedzn.workshop.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AlbumRepository extends JpaRepository<Album,Long> {
}
