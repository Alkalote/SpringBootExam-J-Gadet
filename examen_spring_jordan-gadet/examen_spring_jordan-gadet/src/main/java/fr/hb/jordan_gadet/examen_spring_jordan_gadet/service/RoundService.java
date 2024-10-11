package fr.hb.jordan_gadet.examen_spring_jordan_gadet.service;

import fr.hb.jordan_gadet.examen_spring_jordan_gadet.dto.RoundCreateDTO;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity.Coordinate;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity.Round;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.exception.UpgradedEntityNotFoundException;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.repository.CoordinateRepository;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.repository.GameRepository;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.repository.RoundRepository;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.service.interfaces.ServiceInterfaceCR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;


@Service
@AllArgsConstructor
public class RoundService implements ServiceInterfaceCR<Round, Long, RoundCreateDTO> {

    private RoundRepository repository;
    private GameService gameService;
    private CoordinateRepository coordinateRepository;

    @Override
    public Round create(RoundCreateDTO o) {

        Round r = new Round();
        r.setCreatedAt(LocalDateTime.now());
        r.setGame(gameService.findOneById(o.getGameId()));

        Random random = new Random();
        List<Coordinate> coordinates = coordinateRepository.findAll();
        Coordinate coordinate = coordinates.get(random.nextInt(0, (coordinates.size() - 1)));

        r.setOrigin(coordinate);

        return repository.saveAndFlush(r);
    }

    @Override
    public Round findOneById(Long id) {
        return repository.findById(id).orElseThrow(UpgradedEntityNotFoundException::new);
    }
}