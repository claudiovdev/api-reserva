package com.api.reserva.infrastructure.repositories;

import com.api.reserva.infrastructure.entities.ReservaEntity;
import com.api.reserva.infrastructure.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String>, JpaSpecificationExecutor<UsuarioEntity> {
}
