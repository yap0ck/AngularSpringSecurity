package be.bstorm.formation.demosecurite.dal.repositories;

import be.bstorm.formation.demosecurite.dal.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
