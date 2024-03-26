package org.example.paymentservice_stripe.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiatePaymentRequestDTO {
    private String email;
    private String phoneNumber;
    private Long amount;
    private String orderId;
}
