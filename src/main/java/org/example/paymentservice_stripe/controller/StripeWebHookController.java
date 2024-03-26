package org.example.paymentservice_stripe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StripeWebHookController {

    @PostMapping("/")
    public ResponseEntity acceptWebHookRequest(){
        return null;
    }
}
