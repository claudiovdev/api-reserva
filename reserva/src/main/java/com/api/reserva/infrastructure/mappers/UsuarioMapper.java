package com.api.reserva.infrastructure.mappers;

import com.api.reserva.domain.domainModels.UsuarioDomain;
import com.api.reserva.infrastructure.entities.UsuarioEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioMapper {

    @Autowired
    ModelMapper mapper;

    public UsuarioEntity toEntity(UsuarioDomain usuarioDomain){
        return mapper.map(usuarioDomain, UsuarioEntity.class);
    }
    public UsuarioDomain toDomain(UsuarioEntity usuarioEntity){
        return mapper.map(usuarioEntity, UsuarioDomain.class);
    }

    public List<UsuarioEntity>ListToEntity(List<UsuarioDomain> usuarioDomains){
        return usuarioDomains.stream().map(usuarioDomain -> toEntity(usuarioDomain)).collect(Collectors.toList());
    }

    public List<UsuarioDomain> ListToDomain(List<UsuarioEntity> usuarioEntityList){
        return usuarioEntityList.stream().map(usuarioEntity -> toDomain(usuarioEntity)).collect(Collectors.toList());
    }


}
