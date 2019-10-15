package com.codematrix.flight.repositories;

import com.codematrix.flight.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
    Provider findByCode(String code);
}
