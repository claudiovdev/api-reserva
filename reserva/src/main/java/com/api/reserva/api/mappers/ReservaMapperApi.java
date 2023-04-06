package com.api.reserva.api.mappers;

import com.api.reserva.api.models.request.ReservaModelRequest;
import com.api.reserva.api.models.response.ReservaModelResponse;
import com.api.reserva.domain.domainModels.ReservaDomain;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservaMapperApi {

    @Autowired
    ModelMapper mapper;

    public ReservaDomain toDomain(ReservaModelRequest reservaModelRequest) {
        ReservaDomain reservaDomain = mapper.map(reservaModelRequest, ReservaDomain.class);
        return  reservaDomain;
    }

    public ReservaModelResponse toResponse(ReservaDomain reservaDomain) {
        ReservaModelResponse reservaModelReponse = mapper.map(reservaDomain, ReservaModelResponse.class);
        return reservaModelReponse;
    }

    public List<ReservaModelResponse> listaToResponse(List<ReservaDomain> reservaDomainList){
       return  reservaDomainList.stream().map(reservaDomain -> toResponse(reservaDomain)).collect(Collectors.toList());
    }
}
