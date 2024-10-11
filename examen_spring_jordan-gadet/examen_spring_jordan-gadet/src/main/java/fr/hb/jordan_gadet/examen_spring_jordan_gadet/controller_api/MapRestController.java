package fr.hb.jordan_gadet.examen_spring_jordan_gadet.controller_api;

import fr.hb.jordan_gadet.examen_spring_jordan_gadet.dto.MapCreateDTO;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity.Map;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.jsonview.JsonViews;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.service.MapService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/map")
public class MapRestController {

    private MapService Service;

    @GetMapping
    @JsonView(JsonViews.MapList.class)
    public List<Map> list() {
        return Service.list();
    }

    @PostMapping
    public Map create(@Valid @RequestBody MapCreateDTO dto) {
        return Service.create(dto);
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.MapShow.class)
    public Map show(@PathVariable Long id) {
        return Service.findOneById(id);
    }

    @PutMapping("/{id}")
    public Map update(@Valid @RequestBody MapCreateDTO dto, @PathVariable Long id) {
        return Service.update(dto, id);
    }


}