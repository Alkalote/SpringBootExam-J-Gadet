package fr.hb.jordan_gadet.examen_spring_jordan_gadet.service.interfaces;

import java.util.List;

public interface ServiceListInterfaceCR <T, L, C> extends ServiceInterfaceCR<T, L, C>{

    List<?> list();

}
