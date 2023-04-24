package pl.mlis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.mlis.productcatalog.HashMapProductStorage;
import pl.mlis.productcatalog.ProductCatalog;

@SpringBootApplication //main uruchamiający aplikacje
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean //identyfikacja nasza customowa klase, ktora bedziemy wykorzystywac pozniej
    ProductCatalog createProductCatalog() {
         ProductCatalog productCatalog = new ProductCatalog(new HashMapProductStorage());
         return productCatalog;
    }
}
