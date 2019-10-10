package com.codematrix.flight.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name = "airports", indexes = @Index(name = "airport_code", columnList = "code", unique = true))
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Airport extends BaseEntity {

    @NonNull
    private String code;

    @NonNull
    private String name;
}
