package org.training.turkcell.msorder.integration.notify.models;

import lombok.Builder;
import lombok.Data;

@Data
public class NotifyMessage {
    private String messageTxt;
    private String orig;
    private String dest;
    private Long schedule;

    public NotifyMessage() {
    }

    @Builder(setterPrefix = "with")
    public NotifyMessage(final String messageTxtParam,
                         final String origParam,
                         final String destParam,
                         final Long scheduleParam) {
        messageTxt = messageTxtParam;
        orig       = origParam;
        dest       = destParam;
        schedule   = scheduleParam;
    }
}
