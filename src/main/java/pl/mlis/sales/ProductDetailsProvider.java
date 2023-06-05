package pl.mlis.sales;

import java.util.Optional;

public interface ProductDetailsProvider {
    Optional<ProductDetails> loadForProduct(String productId);
}

