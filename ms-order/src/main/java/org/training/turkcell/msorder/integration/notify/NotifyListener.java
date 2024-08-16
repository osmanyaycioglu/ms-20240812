package org.training.turkcell.msorder.integration.notify;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotifyListener {

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = "sms-response-queue", autoDelete = "false", durable = "true"),
            exchange = @Exchange(value = "notify-response-exchange",
                    autoDelete = "false",
                    durable = "true",
                    type = ExchangeTypes.DIRECT),
            key = "sms-response")
    )
    public void handleSMS(String msg) {
        System.out.println("Send SMS Response : " + msg);
    }

}

