package pl.mlis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.mlis.productcatalog.HashMapProductStorage;
import pl.mlis.sales.ProductCatalogDetailsProvider;
import pl.mlis.productcatalog.ProductCatalog;
import pl.mlis.sales.*;

import java.math.BigDecimal;

@SpringBootApplication //main uruchamiający aplikacje
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean //identyfikacja naszej customowej klasy, ktora bedziemy wykorzystywac pozniej
    ProductCatalog createProductCatalog() {
        ProductCatalog productCatalog =  new ProductCatalog(new HashMapProductStorage());
        String product1 = productCatalog.addProduct("rakieta", "nice catto");
        productCatalog.assignImage(product1, "images/rakieta.jpeg");
        productCatalog.changePrice(product1, BigDecimal.valueOf(20.20));
        productCatalog.publishProduct(product1);

        String product2 = productCatalog.addProduct("kolejna rakieta", "super nice catto");
        productCatalog.assignImage(product2, "images/rakieta2.jpeg");
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

    @Bean
    Sales createSales(ProductCatalog catalog) {
        return new Sales(
                new CartStorage(),
                new ProductCatalogDetailsProvider(catalog));
    }
}
