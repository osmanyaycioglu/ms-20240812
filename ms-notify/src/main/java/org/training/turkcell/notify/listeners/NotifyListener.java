package org.training.turkcell.notify.listeners;

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
            value = @Queue(value = "sms-queue", autoDelete = "false", durable = "true"),
            exchange = @Exchange(value = "notify-exchange",
                                autoDelete = "false",
                                durable = "true",
                                type = ExchangeTypes.DIRECT),
            key = "sms-notification")
    )
    public void handleSMS(String msg) {
        System.out.println("Received SMS : " + msg);
    }

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = "email-queue", autoDelete = "false", durable = "true"),
            exchange = @Exchange(value = "notify-exchange",
                    autoDelete = "false",
                    durable = "true",
                    type = ExchangeTypes.DIRECT),
            key = "email-notification")
    )
    public void handleEMAIL(String msg) {
        System.out.println("Received EMAIL : " + msg);

    }

}
