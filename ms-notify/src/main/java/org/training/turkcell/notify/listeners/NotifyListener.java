package org.training.turkcell.notify.listeners;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
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

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = "email-fan-queue", autoDelete = "false", durable = "true"),
            exchange = @Exchange(value = "notify-fan-exchange",
                    autoDelete = "false",
                    durable = "true",
                    type = ExchangeTypes.FANOUT))
    )
    public void handleEMAIL2(String msg) {
        System.out.println("Received FAN EMAIL : " + msg);

    }

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = "sms-fan-queue", autoDelete = "false", durable = "true"),
            exchange = @Exchange(value = "notify-fan-exchange",
                    autoDelete = "false",
                    durable = "true",
                    type = ExchangeTypes.FANOUT))
    )
    public void handleSMS2(String msg) {
        System.out.println("Received FAN SMS : " + msg);

    }

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = "europe-sms-queue", autoDelete = "false", durable = "true"),
            exchange = @Exchange(value = "notify-topic-exchange",
                    autoDelete = "false",
                    durable = "true",
                    type = ExchangeTypes.TOPIC),
            key = "sms.*.eu.#")
    )
    public void handleSMSEUROPE(NotifyMessage msg) {
        System.out.println("Received EUROPE SMS : " + msg);
    }

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = "all-sms-queue", autoDelete = "false", durable = "true"),
            exchange = @Exchange(value = "notify-topic-exchange",
                    autoDelete = "false",
                    durable = "true",
                    type = ExchangeTypes.TOPIC),
            key = "sms.#")
    )
    @SendTo("notify-response-exchange/sms-response")
    public String handleALLSMS(NotifyMessage msg) {
        System.out.println("Received ALL SMS : " + msg);
        return "Message sent to : " + msg.getDest();
    }

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = "adv-sms-queue", autoDelete = "false", durable = "true"),
            exchange = @Exchange(value = "notify-topic-exchange",
                    autoDelete = "false",
                    durable = "true",
                    type = ExchangeTypes.TOPIC),
            key = "sms.adv.#")
    )
    public void handleADVSMS(NotifyMessage msg) {
        System.out.println("Received ADV SMS : " + msg);
    }

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue(value = "all-messages-queue", autoDelete = "false", durable = "true"),
            exchange = @Exchange(value = "notify-topic-exchange",
                    autoDelete = "false",
                    durable = "true",
                    type = ExchangeTypes.TOPIC),
            key = "#")
    )
    public void handleALLMESSAGES(NotifyMessage msg) {
        System.out.println("Received ALL MESSAGES : " + msg);
    }

}
