package fr.hb.jordan_gadet.examen_spring_jordan_gadet.service.interfaces;

public interface DTOMapperInterface<T, L> {

    T toObject(L dto);

    L toDTO(T object);

}
