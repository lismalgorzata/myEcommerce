package pl.mlis.sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class CollectingProductsTest {
    private CartStorage cartStorage;
    private ProductDetailsProvider productDetailsProvider;

    @BeforeEach
    void setup() {
        cartStorage = new CartStorage();
        productDetailsProvider = new ProductDetailsProvider();
    }

    @Test
    void itAllowsToCollectProductToCart(){
        //Arrange
        Sales sales = thereIsSalesModule();
        String productId = thereIsProduct();
        String customer = thereIsCustomer("Gocha");
        //Act
        sales.addToCart(customer, productId);
        //Assert
        assertThereIsNProductsInCustomersCart(customer, 1);

    }

    private void assertThereIsNProductsInCustomersCart(String customerId, int productsCount) {
        Cart customersCart = cartStorage.load(customerId).get();
        assert customersCart.itemsCount() == productsCount;
    }

    private String thereIsCustomer(String customerId) {
        return customerId;
    }

    private String thereIsProduct() {
        return UUID.randomUUID().toString();
    }

    private Sales thereIsSalesModule() {
        return new Sales(cartStorage,productDetailsProvider);
    }
}
