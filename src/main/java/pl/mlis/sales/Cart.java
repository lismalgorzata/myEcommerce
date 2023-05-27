package pl.mlis.sales;

import pl.mlis.productcatalog.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<ProductDetailsProvider,Integer> products;
    public Cart() {
        this.products = new HashMap<>();
    }
    public static Cart empty(){
        return new Cart();
    }

    public void add(ProductDetailsProvider product) {
        products.put(product, 1);
    }

    public int itemsCount() {
        return products.size();
    }
}
