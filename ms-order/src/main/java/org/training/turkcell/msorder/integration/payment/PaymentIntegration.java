package org.training.turkcell.msorder.integration.payment;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.training.turkcell.msorder.integration.payment.models.PaymentRequest;
import org.training.turkcell.msorder.integration.payment.models.PaymentResponse;
import org.training.turkcell.msorder.service.models.Order;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentIntegration {
    private final RestTemplate restTemplate;
    private final EurekaClient eurekaClient;
    private final PaymentFeignInt paymentFeignInt;

    public PaymentResponse pay(Order orderParam) {
        PaymentRequest paymentRequestLoc = new PaymentRequest();
        paymentRequestLoc.setAmount(new BigDecimal(orderParam.getAmount()));
        paymentRequestLoc.setCustomerId(orderParam.getCustomerId());
        paymentRequestLoc.setOrderId(orderParam.getOrderId());
        return restTemplate.postForObject("http://PAYMENT/api/v1/payment/process/pay",
                                          paymentRequestLoc,
                                          PaymentResponse.class);
    }

    private long counter = 0;

    public PaymentResponse pay2(Order orderParam) {
        Application        applicationLoc = eurekaClient.getApplication("PAYMENT");
        List<InstanceInfo> instancesLoc   = applicationLoc.getInstances();
        counter++;
        InstanceInfo instanceInfoLoc = instancesLoc.get((int) (counter % instancesLoc.size()));

        PaymentRequest paymentRequestLoc = new PaymentRequest();
        paymentRequestLoc.setAmount(new BigDecimal(orderParam.getAmount()));
        paymentRequestLoc.setCustomerId(orderParam.getCustomerId());
        paymentRequestLoc.setOrderId(orderParam.getOrderId());
        RestTemplate restTemplateLoc = new RestTemplate();
        return restTemplateLoc.postForObject("http://"
                                             + instanceInfoLoc.getIPAddr()
                                             + ":"
                                             + instanceInfoLoc.getPort()
                                             + "/api/v1/payment/process/pay",
                                             paymentRequestLoc,
                                             PaymentResponse.class);
    }

    public PaymentResponse pay3(Order orderParam) {
        PaymentRequest paymentRequestLoc = new PaymentRequest();
        paymentRequestLoc.setAmount(new BigDecimal(orderParam.getAmount()));
        paymentRequestLoc.setCustomerId(orderParam.getCustomerId());
        paymentRequestLoc.setOrderId(orderParam.getOrderId());
        return paymentFeignInt.pay(paymentRequestLoc);
    }

}
