package pl.mlis.sales.reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mlis.sales.reservation.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}
