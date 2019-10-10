package com.codematrix.notification.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseEntity {
    protected Long id;
    protected Boolean isActive;
    protected Boolean isDeleted;
    protected Long createdAt;
    protected Long updatedAt;
    protected String createdBy;
}
