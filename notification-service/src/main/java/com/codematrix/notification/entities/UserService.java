package com.codematrix.notification.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserService extends BaseEntity {

    @JsonProperty("user")
    private Long userId;

    @JsonProperty("servicePurchased")
    private Long serviceId;
}
