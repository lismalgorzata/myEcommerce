package pl.mlis.productcatalog;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {

    // Business
    // Technical
    private ProductStorage productStorage;

    public ProductCatalog(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public List<Product> allProducts() {
        return productStorage.allProducts();
    }


//SELLER
    public String addProduct(String name, String desc) {
        Product newProduct = new Product(
                UUID.randomUUID(),
                name,
                desc
        );

        productStorage.add(newProduct);

        return newProduct.getId();
    }

    public void changePrice(String productId, BigDecimal newPrice) {
        Product product = loadById(productId);

        product.changePrice(newPrice);
    }

    public void assignImage(String productId, String imageKey) {
        Product product = loadById(productId);

        product.setImage(imageKey);
    }

    public void publishProduct(String productId) {
        Product loaded = loadById(productId);

        if (loaded.getImage() == null) {
            throw new ProductCannotBePublishedException();
        }

        if (loaded.getPrice() == null) {
            throw new ProductCannotBePublishedException();
        }

        loaded.setOnline(true);
    }

    public List<Product> allPublishedProducts() {
        return productStorage.allPublishedProducts();
    }

    public Product loadById(String productId) {
        //Optional.ofNullable(null)
        return productStorage.loadById(productId);
    }
}
