package com.codematrix.notification.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(onConstructor = @__({@JsonCreator}))
public class Package extends BaseEntity {
    private Long totalSms = 0L;
    private Long totalEmail = 0L;
    private Long totalPush = 0L;
}
