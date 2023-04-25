package pl.mlis.productcatalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductCatalogHTTPTest {
    @LocalServerPort
    int port;
    //inicjalizacja konstruktora resttemplata // konstrukor,setter,reflekscja <- przekazywanie zmiennych z zewnątrz
    @Autowired
    TestRestTemplate http;

    @Test
    void itLoadsIndex() {
        var url = String.format("http://localhost:%s", port);
        //o co chce zapytac? ENTITY- WSZYSTKO ;;; OBJECT- NAGLOWEK
        ResponseEntity<String> response = http.getForEntity(url, String.class);//CTRL+NAJAZD- CO ZWRACA

        assert response.getStatusCode().equals(HttpStatus.OK); //OK WIEC GIT????????

    }

    @Test
    void itLoadsProducts() {
        var url = String.format("http://localhost:%s", port);
        ResponseEntity<String> response = http.getForEntity(url, String.class);

        assert response.getStatusCode().equals(HttpStatus.OK);

    }
}
