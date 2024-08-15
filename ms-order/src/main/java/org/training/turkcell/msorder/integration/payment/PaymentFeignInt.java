package org.training.turkcell.msorder.integration.payment;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.training.turkcell.msorder.integration.payment.models.PaymentRequest;
import org.training.turkcell.msorder.integration.payment.models.PaymentResponse;

@FeignClient(value = "PAYMENT", contextId = "c10")
public interface PaymentFeignInt {

    @PostMapping("/api/v1/payment/process/pay")
    public PaymentResponse pay(@RequestBody PaymentRequest paymentRequestParam);

}
