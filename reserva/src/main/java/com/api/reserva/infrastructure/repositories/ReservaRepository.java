package com.api.reserva.infrastructure.repositories;

import com.api.reserva.infrastructure.entities.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


public interface ReservaRepository extends JpaRepository<ReservaEntity, String>, ReservaRepositoryQueries, JpaSpecificationExecutor<ReservaEntity> {
}
