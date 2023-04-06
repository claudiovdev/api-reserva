package com.api.reserva.domain.gateway;

import com.api.reserva.domain.domainModels.UsuarioDomain;

import java.util.List;

public interface UsuarioGateway {
    List<UsuarioDomain> listarUsuariosPorCurso(String reservaId);

    UsuarioDomain salvar(UsuarioDomain usuarioDomain);
}
