package org.example.paymentservice_stripe.config;

import com.stripe.Stripe;
import com.stripe.StripeClient;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {

    @Value("${stripe.key.id}")
    private String stripeKeyId;

    @Value("${stripe.key.secret}")
    private String stripeKeySecret;

    @Bean
    public StripeClient createStripeClient() throws StripeException {  // implement stripe maveen dependency in order to get work with exceptions
        return new StripeClient(stripeKeyId);
    }

    public String getStripeKeySecret(){
        return stripeKeySecret;
    }
}
