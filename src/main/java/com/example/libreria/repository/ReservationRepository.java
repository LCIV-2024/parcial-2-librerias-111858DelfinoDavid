package com.example.libreria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.libreria.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    // TODO: Implementar los métodos de la reserva
    
    // Buscar reservas por ID de usuario
    List<Reservation> findByUserId(Long userId);
    
    // Buscar reservas por estado
    List<Reservation> findByStatus(Reservation.ReservationStatus status);
    
    // Buscar reservas vencidas (fecha esperada pasada y estado ACTIVE)
    @Query("SELECT r FROM Reservation r WHERE r.expectedReturnDate < CURRENT_DATE AND r.status = 'ACTIVE'")
    List<Reservation> findOverdueReservations();
}