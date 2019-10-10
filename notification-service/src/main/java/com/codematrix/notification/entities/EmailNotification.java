package com.codematrix.notification.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailNotification extends Notification {
    private String emailFrom;
    private String emailTo;
    private String subject;
}
