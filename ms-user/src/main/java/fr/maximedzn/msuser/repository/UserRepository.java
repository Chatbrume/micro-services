package fr.maximedzn.msuser.repository;

import fr.maximedzn.msuser.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByUsername(String username);

}
