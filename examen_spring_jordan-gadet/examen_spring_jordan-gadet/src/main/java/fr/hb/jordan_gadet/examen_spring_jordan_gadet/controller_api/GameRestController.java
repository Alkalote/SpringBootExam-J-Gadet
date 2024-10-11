package fr.hb.jordan_gadet.examen_spring_jordan_gadet.controller_api;

import fr.hb.jordan_gadet.examen_spring_jordan_gadet.dto.GameCreateDTO;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity.Game;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.jsonview.JsonViews;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.service.GameService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/game")
public class GameRestController {

    private GameService Service;

    @GetMapping
    @JsonView(JsonViews.GameList.class)
    public List<Game> list() {
        return Service.list();
    }

    @PostMapping
    public Game create(@Valid @RequestBody GameCreateDTO dto) {
        return Service.create(dto);
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.GameShow.class)
    public Game show(@PathVariable String id) {
        return Service.findOneById(id);
    }


}