package fr.hb.jordan_gadet.examen_spring_jordan_gadet.repository;

import fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail (String username);

}