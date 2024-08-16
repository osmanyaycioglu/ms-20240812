package org.training.turkcell.notify.listeners;

import lombok.Data;

@Data
public class NotifyMessage {
    private String messageTxt;
    private String orig;
    private String dest;
    private Long schedule;
}
