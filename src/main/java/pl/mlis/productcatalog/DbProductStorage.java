package pl.mlis.productcatalog;
import java.util.*;

public class DbProductStorage implements ProductStorage {
    @Override
    public List<Product> allProducts() {

        return null ; // db.sql("select * from products");
    }

    @Override
    public void add(Product newProduct) {

    }

    @Override
    public Product loadById(String productId) {
        return null;
    }

    @Override
    public List<Product> allPublishedProducts() {
        return null;
    }
}