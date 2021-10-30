
package com.sergioarboleda.reto_cabin.crud;

import com.sergioarboleda.reto_cabin.model.Reservaciones;
import org.springframework.data.repository.CrudRepository;


public interface InterfaceReservaciones extends CrudRepository<Reservaciones,Integer>{
    
}
