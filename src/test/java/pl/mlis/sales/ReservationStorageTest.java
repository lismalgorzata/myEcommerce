package pl.mlis.sales;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootTest
public class ReservationStorageTest {
    @Autowired
    ReservationRepository reservationRepository;
    @Test
    void insert() {
        String id = UUID.randomUUID().toString();
        Reservation reservation = new Reservation(
                id,
                BigDecimal.TEN,
                "payment");
        reservationRepository.save(reservation);

    }

    @Test
    void select() {
        String id = UUID.randomUUID().toString();
        Reservation reservation = new Reservation(
                id,
                BigDecimal.TEN,
                "payment");
        reservationRepository.save(reservation);

        Reservation loaded = reservationRepository.findById(id).get();
    }
}
