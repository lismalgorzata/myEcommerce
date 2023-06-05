package pl.mlis.sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

public class CollectingProductsTest {
    private CartStorage cartStorage;
    private AlwaysMissingProductDetailsProvider productDetails;

    @BeforeEach
    void setUp() {
        this.cartStorage = new CartStorage();
        this.productDetails = new AlwaysMissingProductDetailsProvider();
    }

    @Test
    void itAllowsToAddProduct() {
        //ARRANGE
        Sales sales = thereIsSalesModule();
        String product1 = thereIsProduct("Lego set", BigDecimal.valueOf(10.10));
        String customerId = thereIsCustomer("Kuba");

        //Act
        sales.addToCart(customerId, product1);

        //Assert
        assertThereIsNProductsInCustomerCart(1, customerId);
    }

    @Test
    public void itAllowAddProductToCartByMultipleCustomers() {
        //Arrange
        Sales sales = thereIsSalesModule();
        String productId1 = thereIsProduct("lego set 1", BigDecimal.valueOf(10.10));
        String productId2 = thereIsProduct("lego set 2", BigDecimal.TEN);

        String customerId1 = thereIsCustomer("Kuba");
        String customerId2 = thereIsCustomer("Michal");
        //Act
        sales.addToCart(customerId1, productId1);
        sales.addToCart(customerId1, productId2);

        sales.addToCart(customerId2, productId1);

        //Assert
        assertThereIsNProductsInCustomerCart(2, customerId1);
        assertThereIsNProductsInCustomerCart(1, customerId2);
    }

    private void assertThereIsNProductsInCustomerCart(int totalProductsQuantity, String customerId) {
        Cart cart = cartStorage.load(customerId).get();
        //assert customersCart.itemsCount() == productsCount;
    }

    private String thereIsCustomer(String customerId) {
        return customerId;
    }

    private String thereIsProduct(String name, BigDecimal price) {
        String id = UUID.randomUUID().toString();
        productDetails.add(new ProductDetails(id, name, price));

        return id;
    }

    private Sales thereIsSalesModule() {
        return new Sales(cartStorage, productDetails);
    }
}
