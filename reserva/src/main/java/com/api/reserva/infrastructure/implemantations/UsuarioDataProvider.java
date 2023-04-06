package com.api.reserva.infrastructure.implemantations;

import com.api.reserva.domain.domainModels.UsuarioDomain;
import com.api.reserva.domain.gateway.UsuarioGateway;
import com.api.reserva.infrastructure.entities.UsuarioEntity;
import com.api.reserva.infrastructure.mappers.UsuarioMapper;
import com.api.reserva.infrastructure.repositories.UsuarioRepository;
import com.api.reserva.infrastructure.spec.SpecificationTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioDataProvider implements UsuarioGateway {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioMapper mapper;

    @Override
    public List<UsuarioDomain> listarUsuariosPorCurso(String reservaId) {
        List<UsuarioEntity> usuarioEntityList = usuarioRepository.findAll(SpecificationTemplate.usuarioReservaId(reservaId));
        return mapper.ListToDomain(usuarioEntityList);
    }

    @Override
    public UsuarioDomain salvar(UsuarioDomain usuarioDomain) {
        UsuarioEntity usuario = usuarioRepository.save(mapper.toEntity(usuarioDomain));
        return mapper.toDomain(usuario);
    }
}
