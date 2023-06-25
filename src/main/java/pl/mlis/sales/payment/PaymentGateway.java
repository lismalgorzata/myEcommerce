package pl.mlis.sales.payment;

public interface PaymentGateway {
    PaymentData register(RegisterPaymentRequest request);
}
