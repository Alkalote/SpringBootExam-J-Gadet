package fr.hb.jordan_gadet.examen_spring_jordan_gadet.controller_api;

import fr.hb.jordan_gadet.examen_spring_jordan_gadet.dto.CoordinateCreateDTO;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity.Coordinate;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.jsonview.JsonViews;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.service.CoordinateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/coordinate")
public class CoordinateRestController {

    private CoordinateService Service;


    @PostMapping
    @JsonView(JsonViews.CoordianteShow.class)
    public Coordinate create(@Valid @RequestBody CoordinateCreateDTO dto) {
        return Service.create(dto);
    }



}