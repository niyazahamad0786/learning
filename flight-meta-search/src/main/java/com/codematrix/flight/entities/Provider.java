package com.codematrix.flight.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "providers")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Provider extends BaseEntity {

    @NonNull
    private String code;

    @NonNull
    private String name;
}
