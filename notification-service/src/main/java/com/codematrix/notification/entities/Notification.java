package com.codematrix.notification.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public abstract class Notification {
    protected Long sentAt;
    protected String content;
}
