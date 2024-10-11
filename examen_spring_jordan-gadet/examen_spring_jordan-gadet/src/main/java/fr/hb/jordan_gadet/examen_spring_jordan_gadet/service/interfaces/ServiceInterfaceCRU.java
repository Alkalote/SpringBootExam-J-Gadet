package fr.hb.jordan_gadet.examen_spring_jordan_gadet.service.interfaces;

public interface ServiceInterfaceCRU<T, L, C, U>{

    T create(C o);

    T update(U o, L id);

    T findOneById(L id);
}
