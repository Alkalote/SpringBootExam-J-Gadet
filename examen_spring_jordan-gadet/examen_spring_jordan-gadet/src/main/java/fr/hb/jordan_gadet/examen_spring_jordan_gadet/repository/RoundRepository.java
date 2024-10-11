package fr.hb.jordan_gadet.examen_spring_jordan_gadet.repository;

import fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity.Round;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoundRepository extends JpaRepository<Round, Long> {


}