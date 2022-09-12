package com.co.udea.mintic.developersFive.repository;

import com.co.udea.mintic.developersFive.domain.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMovimientoDinero extends JpaRepository<MovimientoDinero, Long> {
}
