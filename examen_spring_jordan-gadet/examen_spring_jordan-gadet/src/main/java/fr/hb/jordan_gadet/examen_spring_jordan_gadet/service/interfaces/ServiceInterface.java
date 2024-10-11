package fr.hb.jordan_gadet.examen_spring_jordan_gadet.service.interfaces;

public interface ServiceInterface<T, L, C, U> {

    T create(C o);

    T update(U o, L id);

    Boolean delete(L o);

    T findOneById(L id);

}
