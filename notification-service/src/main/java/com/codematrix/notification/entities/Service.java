package com.codematrix.notification.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Service extends BaseEntity {
    
    @JsonProperty("package")
    private Long offeredPackage;
    private BigDecimal price;
    private Integer validity;
}
