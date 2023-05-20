package pl.mlis.sales;

import pl.mlis.productcatalog.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<String,ProductDetails> products;

    public Cart() {
        this.products = new HashMap<>();
    }
    public static Cart empty(){
        return new Cart();
    }

    public void add(ProductDetails product) {
        product.increaseQuantity();
        products.put(product.getProductId(), product);
    }

    public int itemsCount() {
        return products.size();
    }
}
