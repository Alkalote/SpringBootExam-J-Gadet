package fr.hb.jordan_gadet.examen_spring_jordan_gadet.repository;

import fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {


}