package com.api.reserva.infrastructure.implemantations;

import com.api.reserva.domain.domainModels.ReservaDomain;
import com.api.reserva.domain.gateway.ReservaGatway;
import com.api.reserva.infrastructure.entities.ReservaEntity;
import com.api.reserva.infrastructure.mappers.ReservaMapper;
import com.api.reserva.infrastructure.repositories.ReservaRepository;
import com.api.reserva.infrastructure.spec.SpecificationTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservaDataProvider implements ReservaGatway {

    @Autowired
    ReservaRepository reservaRepository;

    @Autowired
    ReservaMapper mapper;

    @Override
    public ReservaDomain cadastrar(ReservaDomain reservaDomain) {
        ReservaEntity reservaEntity = mapper.toEntity(reservaDomain);
        reservaDomain = mapper.toDomain(reservaRepository.save(reservaEntity));
        return reservaDomain;
    }



    @Override
    public List<ReservaDomain> listar() {
        List<ReservaEntity> reservaEntityList = reservaRepository.findAll();
        return mapper.toListDomain(reservaEntityList);
    }

    @Override
    public List<ReservaDomain> listarReservasPorUsuarioId(String usuarioId) {
        return mapper.toListDomain(reservaRepository.findAll(SpecificationTemplate.reservaUsuarioId(usuarioId)));
    }
}
