package org.training.turkcell.msorder.integration.payment.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {
    private String orderId;
    private BigDecimal amount;
    private Long customerId;
}
