package com.sergioarboleda.reto_cabin.service;

import com.sergioarboleda.reto_cabin.repository.RepositorioReservaciones;
import com.sergioarboleda.reto_cabin.model.Reservaciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosReservaciones {

    @Autowired
    private RepositorioReservaciones reporeserva;

    public List<Reservaciones> getAll() {
        return reporeserva.getAll();
    }

    public Optional<Reservaciones> getReservation(int reservationId) {
        return reporeserva.getReservation(reservationId);
    }

    public Reservaciones save(Reservaciones reservation) {
        if (reservation.getIdReservation() == null) {
            return reporeserva.save(reservation);
        } else {
            Optional<Reservaciones> e = reporeserva.getReservation(reservation.getIdReservation());
            if (e.isEmpty()) {
                return reporeserva.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservaciones update(Reservaciones reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservaciones> e = reporeserva.getReservation(reservation.getIdReservation());
            if (!e.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());
                }
                reporeserva.save(e.get());
                return e.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            reporeserva.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
