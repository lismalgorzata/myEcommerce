package pl.mlis.sales;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlwaysMissingProductDetailsProvider implements ProductDetailsProvider {

    List<ProductDetails> productDetails;
    public AlwaysMissingProductDetailsProvider() {
        this.productDetails = new ArrayList<>();
    }

    public Optional<ProductDetails> load(String productId) {
        return productDetails.stream().filter(p -> p.getProductId().equals(productId)).findFirst();
    }

    public void add(ProductDetails details) {
        this.productDetails.add(details);
    }

    @Override
    public Optional<ProductDetails> loadForProduct(String productId) {
        return Optional.empty();
    }
}