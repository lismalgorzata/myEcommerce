package pl.mlis.sales;

import javax.swing.plaf.synth.SynthLookAndFeel;
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
    /*public PaymentData acceptOffer(String customerId) {
        Offer offer = getCurrentOffer(customerId);

        Reservation reservation;
        return
    }*/
}