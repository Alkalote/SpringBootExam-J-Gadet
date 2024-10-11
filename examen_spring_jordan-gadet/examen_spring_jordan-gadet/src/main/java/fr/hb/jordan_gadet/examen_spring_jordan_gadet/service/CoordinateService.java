package fr.hb.jordan_gadet.examen_spring_jordan_gadet.service;

import fr.hb.jordan_gadet.examen_spring_jordan_gadet.dto.CoordinateCreateDTO;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.entity.Coordinate;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.exception.UpgradedEntityNotFoundException;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.repository.CoordinateRepository;
import fr.hb.jordan_gadet.examen_spring_jordan_gadet.service.interfaces.ServiceInterfaceCR;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CoordinateService implements ServiceInterfaceCR<Coordinate, Long, CoordinateCreateDTO> {

    private CoordinateRepository repository;

    @Override
    public Coordinate create(CoordinateCreateDTO o) {

        Coordinate coo = new Coordinate();
        coo.setLatitude(o.getLatitude());
        coo.setLongitude(o.getLongitude());

        return repository.saveAndFlush(coo);
    }

    @Override
    public Coordinate findOneById(Long id) {
        return repository.findById(id).orElseThrow(UpgradedEntityNotFoundException::new);
    }
}