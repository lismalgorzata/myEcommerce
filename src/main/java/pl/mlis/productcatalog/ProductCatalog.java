package pl.mlis.productcatalog;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {
    private ProductStorage productStorage;

    public ProductCatalog(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public List<Product> allProducts() {
        return productStorage.allProducts();
    }


//SELLER
    public String addProduct(String name, String desc, String image, Boolean isPublished, BigDecimal price, String color, int x, int y) {
        Product newProduct = new Product(
                UUID.randomUUID(),
                name,
                desc,
                image,
                isPublished,
                price,
                color,
                x,
                y
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
        Product product = loadById(productId);

        if (product.getImage() == null) {
            throw new ProductCannotBePublishedException();
        }

        if (product.getPrice() == null) {
            throw new ProductCannotBePublishedException();
        }

        product.setOnline(true);
    }

    public List<Product> allPublishedProducts() {
        return productStorage.allPublishedProducts();
    }

    public Product loadById(String productId) {
        return productStorage.loadById(productId);
    }
}
