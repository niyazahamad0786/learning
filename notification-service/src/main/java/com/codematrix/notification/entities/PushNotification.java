package com.codematrix.notification.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PushNotification extends Notification {
    private String from;
    private String to;
    private String heading;
}
