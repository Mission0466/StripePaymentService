package org.example.paymentservice_stripe.controller;


import com.stripe.exception.StripeException;
import org.example.paymentservice_stripe.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.example.paymentservice_stripe.dtos.InitiatePaymentRequestDTO;

@RestController
public class PaymentController {

    private PaymentService stripePaymentService;

    @Autowired
    public PaymentController(@Qualifier("stripe") PaymentService stripePaymentService)
    {
        this.stripePaymentService = stripePaymentService;
    }

    @PostMapping("/payment")
    public String intiatePayment(@RequestBody InitiatePaymentRequestDTO requestDto) throws StripeException {

        return stripePaymentService.doPayment(requestDto.getEmail(), requestDto.getPhoneNumber(), requestDto.getAmount(), requestDto.getOrderId());

    }


}
