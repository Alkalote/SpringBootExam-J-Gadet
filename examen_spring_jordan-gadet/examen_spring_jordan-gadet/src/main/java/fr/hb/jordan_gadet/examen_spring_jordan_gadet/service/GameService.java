package fr.hb.jordan_gadet.examen_spring_jordan_gadet.service;

import fr.hb.jordan_gadet.examen_spring_jordan_gadet.dto.GameCreateDTO;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity.Game;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.exception.UpgradedEntityNotFoundException;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.repository.GameRepository;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.service.interfaces.ServiceListInterfaceCR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class GameService implements ServiceListInterfaceCR<Game, String, GameCreateDTO> {

    private GameRepository repository;
    private MapService mapService;
    private UserService userService;

    @Override
    public List<Game> list() {
        return repository.findAll();
    }

    @Override
    public Game create(GameCreateDTO o) {

       Game g = new Game();

       g.setMap(mapService.findOneById(o.getMapId()));
       g.setUser(userService.findOneById(o.getUserId()));
       g.setHasPan(o.getHasPan());
       g.setHasMove(o.getHasMove());
       g.setHasZoom(o.getHasZoom());
       g.setMaximumTime(o.getMaximumTime());
       g.setNbRounds(o.getRound());
       g.setCreatedAt(LocalDateTime.now());

        return repository.saveAndFlush(g);
    }

    @Override
    public Game findOneById(String id) {
        return repository.findById(id).orElseThrow(UpgradedEntityNotFoundException::new);
    }
}