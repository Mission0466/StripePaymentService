package org.example.paymentservice_stripe.service;


import com.stripe.Stripe;
import com.stripe.StripeClient;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import org.example.paymentservice_stripe.config.StripeConfig;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service("stripe")
public class StripePaymentServiceImpl implements PaymentService{

    private StripeClient stripeClient;
    private  StripeConfig stripeConfig;

    @Autowired
    public StripePaymentServiceImpl(StripeClient stripeClient, StripeConfig stripeConfig){
        this.stripeClient = stripeClient;
        this.stripeConfig = stripeConfig;
    }
    @Override
    public String doPayment(String email, String phone, Long amount, String orderId) throws StripeException {
        try {
            JSONObject paymentLinkRequest = new JSONObject();
            paymentLinkRequest.put("amount", amount);
            paymentLinkRequest.put("currency", "INR");
            paymentLinkRequest.put("receipt", orderId);

            JSONObject customer = new JSONObject();
            customer.put("email", email);
            customer.put("phone", phone);
            paymentLinkRequest.put("customer", customer);

            JSONObject notify = new JSONObject();
            notify.put("sms", true);
            notify.put("email", true);

            paymentLinkRequest.put("notify", notify);

            paymentLinkRequest.put("callback_url", "https://domain.com/stripeWebHook");
            paymentLinkRequest.put("callback_method", "post");

            HashMap<String, Object> params = new HashMap<>(paymentLinkRequest.toMap());
            Stripe.apiKey = stripeConfig.getStripeKeySecret();

            PaymentLink response = PaymentLink.create(params);
            return response.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
}
