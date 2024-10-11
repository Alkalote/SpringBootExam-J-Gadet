package fr.hb.jordan_gadet.examen_spring_jordan_gadet.service.interfaces;

public interface ServiceInterfaceCR<T, L, C>{

    T create(C o);

    T findOneById(L id);

}
