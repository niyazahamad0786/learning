package com.codematrix.notification.entities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SMSNotification extends Notification {
    private Integer mobileFrom;
    private Integer mobileTo;
}
