package org.example.paymentservice_stripe.service;


import com.stripe.Stripe;
import com.stripe.exception.StripeException;

public interface PaymentService {
    String  doPayment(String email, String phone, Long amount, String orderId) throws StripeException;
}
