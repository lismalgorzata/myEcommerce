package pl.mlis.sales;

import pl.mlis.productcatalog.HashMapProductStorage;
import pl.mlis.productcatalog.ProductCatalog;

import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

public class ProductDetailsProvider {
    private String id;
    private String name;
    private String desc;
    private BigDecimal price;
    private ProductDetails product;

    public ProductDetailsProvider() {

    }

    public ProductDetailsProvider(String id, String name, String desc, BigDecimal price) {
        this.product = new ProductDetails(id, name, price, desc);
        /*product.setProductId(id);
        product.setName(name);
        product.setDesc(desc);
        product.setPrice(price);
         */
    }

    public String loadProductId() {
        return this.product.getProductId();
    }

    public String loadProductName() {
        return this.product.getName();
    }

    public String loadDescription() {
        return this.product.getDescription();
    }

    public BigDecimal loadPrice() {
        return this.product.getPrice();
    }

    public Optional<ProductDetailsProvider> loadCartForProduct(String productId) {
        return Optional.of(new ProductDetailsProvider());


    }
}
