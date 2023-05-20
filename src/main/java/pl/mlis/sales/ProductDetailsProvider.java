package pl.mlis.sales;

import pl.mlis.productcatalog.HashMapProductStorage;
import pl.mlis.productcatalog.ProductCatalog;

import java.util.Optional;

public class ProductDetailsProvider {
    public Optional<ProductDetails> loadCartForProduct(String productId) {
        ProductCatalog productCatalog = new ProductCatalog(new HashMapProductStorage());
        ProductDetails productDetails = new ProductDetails(productCatalog.loadById(productId).getId(), productCatalog.loadById(productId).getName(), productCatalog.loadById(productId).getPrice());
        return Optional.of(productDetails);
    }
}
