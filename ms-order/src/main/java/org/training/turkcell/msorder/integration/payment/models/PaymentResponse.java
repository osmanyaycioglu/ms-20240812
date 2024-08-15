package org.training.turkcell.msorder.integration.payment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {
    private String orderId;
    private Boolean success;
    private String paymentUUID;
    private String orig;
}
