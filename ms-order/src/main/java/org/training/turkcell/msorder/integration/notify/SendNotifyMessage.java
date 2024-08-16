package org.training.turkcell.msorder.integration.notify;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.training.turkcell.msorder.integration.notify.models.NotifyMessage;

@Service
@RequiredArgsConstructor
public class SendNotifyMessage {
    private final RabbitTemplate rabbitTemplate;

    public void sendSMS(NotifyMessage notifyMessageParam) {
        rabbitTemplate.convertAndSend("notify-topic-exchange",
                                      "sms.notify.eu.east.tr",
                                      notifyMessageParam);
    }

    public void sendEMAIL(NotifyMessage notifyMessageParam) {
        rabbitTemplate.convertAndSend("notify-topic-exchange",
                                      "email.notify.eu.east.tr",
                                      notifyMessageParam);
    }

}
