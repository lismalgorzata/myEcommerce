package pl.mlis.sales;

import pl.mlis.payu.Buyer;
import java.math.BigDecimal;
import java.util.Optional;

public class Sales {
    private CartStorage cartStorage;
    private ProductDetailsProvider productDetailsProvider;
    public Sales(CartStorage cartStorage, ProductDetailsProvider productDetailsProvider) {
        this.cartStorage=cartStorage;
        this.productDetailsProvider=productDetailsProvider;
    }

    public void addToCart(String customerId, String productId) {
        Cart customerCart = loadCartForCustomer(customerId)
                .orElse(Cart.empty());

        ProductDetails product = loadProductDetails(productId)
                .orElseThrow(() -> new NoSuchProductException());

        customerCart.add(product);

        cartStorage.save(customerId, customerCart);
    }

    private Optional<ProductDetails> loadProductDetails(String productId) {
        return productDetailsProvider.loadForProduct(productId);
    }

    private Optional<Cart> loadCartForCustomer(String customerId) {
        return cartStorage.load(customerId);
    }

    public Offer getCurrentOffer(String customer) {
        return new Offer();
    }
    public PaymentData acceptOffer(String customerId) {
        Offer offer = getCurrentOffer(customerId);

        OrderCreateRequest orderCreateRequest = new OrderCreateRequest();
        BigDecimal totalAmountAsGrosze = offer.getTotal().multiply(BigDecimal.valueOf(100));
        orderCreateRequest.setBuyer(new Buyer()
                .setFirstName(request.email)
        );

        return new PaymentData(response.getRedirectUri());
    }
}

// addToBasket mamy wiec trzeba wyslac imie nazwisko email na inny endpoint