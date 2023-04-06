package com.api.reserva.api.mappers;

import com.api.reserva.api.models.response.UsuarioModelResponse;
import com.api.reserva.domain.domainModels.UsuarioDomain;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapperApi {

    @Autowired
    ModelMapper mapper;

    public List<UsuarioModelResponse> toModelResponse(List<UsuarioDomain> usuarioDomains){
        return usuarioDomains.stream().map(usuarioDomain -> toResponse(usuarioDomain)).collect(Collectors.toList());
    }

    public UsuarioModelResponse toResponse(UsuarioDomain usuarioDomain) {
        UsuarioModelResponse usuario = mapper.map(usuarioDomain, UsuarioModelResponse.class);
        return usuario;
    }
}
