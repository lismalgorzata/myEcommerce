package pl.mlis.productcatalog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class ProductCatalogControler {
    private ProductCatalog catalog;

    ProductCatalogControler(ProductCatalog catalog) {
        this.catalog = catalog;
    }
    @GetMapping("/api/products")
    List<Product> allProducts() {
       return catalog.allPublishedProducts();
    }
}
