package fr.hb.jordan_gadet.examen_spring_jordan_gadet.service;

import fr.hb.jordan_gadet.examen_spring_jordan_gadet.dto.MapCreateDTO;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity.Map;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.exception.UpgradedEntityNotFoundException;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.repository.MapRepository;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.service.interfaces.ServiceListInterfaceCRU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Service
@AllArgsConstructor
public class MapService implements ServiceListInterfaceCRU<Map, Long, MapCreateDTO, MapCreateDTO> {

    private MapRepository repository;

    @Override
    public List<Map> list() {
        return repository.findAll();
    }

    @Override
    public Map create(MapCreateDTO o) {

        Map m = new Map();
        m.setName(o.getName());
        m.setCreatedAt(LocalDateTime.now());

        return repository.saveAndFlush(m);
    }

    @Override
    public Map update(MapCreateDTO o, Long id) {
        Map m = findOneById(id);
        m.setName(o.getName());
        m.setCreatedAt(LocalDateTime.now());

        return repository.saveAndFlush(m);
    }

    @Override
    public Map findOneById(Long id) {
        return repository.findById(id).orElseThrow(UpgradedEntityNotFoundException::new);
    }
}