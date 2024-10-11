package fr.hb.jordan_gadet.examen_spring_jordan_gadet.service.interfaces;

import java.util.List;

public interface ServiceListInterfaceCRU <T, L, C, U> extends ServiceInterfaceCRU<T, L, C, U>  {

    List<?> list();

}
