package com.api.reserva.infrastructure.mappers;

import com.api.reserva.domain.domainModels.ReservaDomain;
import com.api.reserva.infrastructure.entities.ReservaEntity;
import com.api.reserva.infrastructure.enums.StatusReserva;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ReservaMapper {

    @Autowired
    ModelMapper mapper;


    public ReservaEntity toEntity(ReservaDomain reservaDomain) {
        ReservaEntity reservaEntity = mapper.map(reservaDomain, ReservaEntity.class);
        reservaEntity.setReservaId(UUID.randomUUID().toString());
        reservaEntity.setStatus(StatusReserva.ATIVO);
        return  reservaEntity;
    }

    public ReservaDomain toDomain(ReservaEntity reservaEntity) {
        ReservaDomain reservaDomain = mapper.map(reservaEntity, ReservaDomain.class);
        return  reservaDomain;
    }

    public List<ReservaDomain> toListDomain(List<ReservaEntity> reservaEntityList) {
        return reservaEntityList.stream().map(reservaEntity -> toDomain(reservaEntity)).collect(Collectors.toList());
    }
}
