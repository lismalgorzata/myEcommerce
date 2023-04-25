package pl.mlis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.mlis.productcatalog.HashMapProductStorage;
import pl.mlis.productcatalog.ProductCatalog;

import java.math.BigDecimal;

@SpringBootApplication //main uruchamiający aplikacje
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean //identyfikacja naszej customowej klasy, ktora bedziemy wykorzystywac pozniej
    ProductCatalog createProductCatalog() {
        ProductCatalog productCatalog =  new ProductCatalog(new HashMapProductStorage());
        String product1 = productCatalog.addProduct("My ebook", "nice one");
        productCatalog.assignImage(product1, "images/ebook.jpeg");
        productCatalog.changePrice(product1, BigDecimal.valueOf(20.20));
        productCatalog.publishProduct(product1);

        String product2 = productCatalog.addProduct("Other ebook", "also a nice one");
        productCatalog.assignImage(product2, "images/ebook2.jpeg");
        productCatalog.changePrice(product2, BigDecimal.valueOf(22.22));
        productCatalog.publishProduct(product2);

        return productCatalog;

        //await fetch("/api/products")
        //response = await fetch("/api/products")
        //await response.json()
        //fetch("/api/products").then(r=>r.json())
        //fetch("/api/products").then(r=>r.json()).then(data => console.log(data)
        //curl localhost:8080/api/products
    }
}
