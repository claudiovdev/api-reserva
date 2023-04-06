package com.api.reserva.domain.services.impl;

import com.api.reserva.domain.domainModels.UsuarioDomain;
import com.api.reserva.domain.gateway.UsuarioGateway;
import com.api.reserva.domain.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioGateway usuarioGateway;

    @Override
    public List<UsuarioDomain> listarUsuariosPorCurso(String reservaId) {
        return usuarioGateway.listarUsuariosPorCurso(reservaId);
    }
}
