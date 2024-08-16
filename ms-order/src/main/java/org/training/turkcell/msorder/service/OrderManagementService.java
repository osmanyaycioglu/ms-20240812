package org.training.turkcell.msorder.service;

import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.training.turkcell.msorder.integration.notify.SendNotifyMessage;
import org.training.turkcell.msorder.integration.notify.models.NotifyMessage;
import org.training.turkcell.msorder.integration.payment.PaymentIntegration;
import org.training.turkcell.msorder.integration.payment.models.PaymentResponse;
import org.training.turkcell.msorder.service.models.Order;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderManagementService {
    private final PaymentIntegration paymentIntegration;
    private final SendNotifyMessage  sendNotifyMessage;

    public String place(Order orderParam) {
        orderParam.setOrderId(UUID.randomUUID()
                                  .toString());
        orderParam.setCustomerId(1001L);
        PaymentResponse payLoc = paymentIntegration.pay(orderParam);
        System.out.println("reponse from : " + payLoc.getOrig());
        if (payLoc.getSuccess()) {
            return payLoc.getOrderId();
        } else {
            throw new IllegalStateException("Payment Failed");
        }

    }

    public String place2(Order orderParam) {
        orderParam.setOrderId(UUID.randomUUID()
                                  .toString());
        orderParam.setCustomerId(1001L);
        PaymentResponse payLoc = paymentIntegration.pay2(orderParam);
        System.out.println("reponse from : " + payLoc.getOrig());
        if (payLoc.getSuccess()) {
            return payLoc.getOrderId();
        } else {
            throw new IllegalStateException("Payment Failed");
        }

    }

    public String place3(Order orderParam) {
        orderParam.setOrderId(UUID.randomUUID()
                                  .toString());
        orderParam.setCustomerId(1001L);
        PaymentResponse payLoc = paymentIntegration.pay3(orderParam);
        System.out.println("reponse from : " + payLoc.getOrig());
        if (payLoc.getSuccess()) {
            sendNotifyMessage.sendSMS(NotifyMessage.builder()
                                                   .withMessageTxtParam("siparişiniz alındı. id : "
                                                                        + orderParam.getOrderId())
                                                   .withDestParam(orderParam.getPhoneNumber())
                                                   .withOrigParam("RESTAURANT")
                                                   .withScheduleParam(0L)
                                                   .build());
            return payLoc.getOrderId();
        } else {
            throw new IllegalStateException("Payment Failed");
        }

    }

    @PreDestroy
    public void method() {
        System.out.println("Kapanma kodu");
        // resource close
    }
}
