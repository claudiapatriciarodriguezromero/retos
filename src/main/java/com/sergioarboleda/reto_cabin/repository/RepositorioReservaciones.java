package com.sergioarboleda.reto_cabin.repository;

import com.sergioarboleda.reto_cabin.crud.InterfaceReservaciones;
import com.sergioarboleda.reto_cabin.model.Reservaciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservaciones {

    @Autowired
    private InterfaceReservaciones inreservaciones;

    public List<Reservaciones> getAll() {
        return (List<Reservaciones>) inreservaciones.findAll();
    }

    public Optional<Reservaciones> getReservation(int id) {
        return inreservaciones.findById(id);
    }

    public Reservaciones save(Reservaciones reservation) {
        return inreservaciones.save(reservation);
    }

    public void delete(Reservaciones reservation) {
        inreservaciones.delete(reservation);
    }
}
