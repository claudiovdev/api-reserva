package com.api.reserva.domain.services;

import com.api.reserva.domain.domainModels.UsuarioDomain;


import java.util.List;

public interface UsuarioService {

    List<UsuarioDomain> listarUsuariosPorCurso(String reservaId);
}
