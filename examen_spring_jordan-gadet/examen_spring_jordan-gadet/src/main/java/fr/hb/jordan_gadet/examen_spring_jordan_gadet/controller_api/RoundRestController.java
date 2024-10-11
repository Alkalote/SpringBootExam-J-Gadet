package fr.hb.jordan_gadet.examen_spring_jordan_gadet.controller_api;

import fr.hb.jordan_gadet.examen_spring_jordan_gadet.dto.RoundCreateDTO;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity.Round;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.jsonview.JsonViews;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.service.RoundService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/round")
public class RoundRestController {

    private RoundService Service;

    @PostMapping
    @JsonView(JsonViews.RoundShow.class)
    public Round create(@Valid @RequestBody RoundCreateDTO dto) {
        return Service.create(dto);
    }


}