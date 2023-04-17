package pl.mlis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.mlis.productcatalog.HashMapProductStorage;
import pl.mlis.productcatalog.ProductCatalog;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    ProductCatalog createProductCatalog() {
         ProductCatalog productCatalog = new ProductCatalog(new HashMapProductStorage());
         return productCatalog;
    }
}
